import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 * @author Kaijie Ma
 *
 */

public class calculate extends commandClass implements commandInterface{
    ArrayList<String> commandPhrases = new ArrayList<String>();
    int daypass=0;
    @Override
	public boolean match(String token) {
		return commandPhrases.contains(token);
	}
    
    
    public calculate() {
        commandPhrases.add("calculate");
    }
    
    public String run(String [] command) {
    Scanner sc = new Scanner(System.in);
System.out.print("Input the first date");
    String str = sc.nextLine();
System.out.print("Input the second date");
    String str1 = sc.nextLine();
    SimpleDateFormat sd = new SimpleDateFormat("MM-dd-yyyy");
    Date d;
	try {
		d = sd.parse(str);
		Date d1 = sd.parse(str1);
	    long l = 0;
	if (d.after(d1)) {
	        l = d.getTime() - d1.getTime();
	    } else {
	        l = d1.getTime() - d.getTime();
	    }
	    long a = 1000 * 60 * 60 * 24;
	    long day = l / a;
	    long week = day / 7;
	    daypass=(int) day;
	System.out.println(day + "days betweeen two dates");
	System.out.println(week + "weeks betweeen two dates");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
return daypass+ " days between the two dates";
}
}
