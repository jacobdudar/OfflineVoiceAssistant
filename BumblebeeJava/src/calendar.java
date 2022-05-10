import java.util.ArrayList;
import java.util.Arrays;
//import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.text.DateFormat;
import java.lang.String;
import java.lang.*;
import java.util.*;
import java.util.Scanner;
/**
 * 
 * @author Soham
 *
 */
public class calendar extends commandClass implements commandInterface{
  ArrayList<String> commandPhrases = new ArrayList<String>();
  
  public calendar() {
	  commandPhrases.add("calendar");
  }
  
  public boolean match(String reminder) {
	  return commandPhrases.contains(reminder);
  }
 
 public String run(String[] input) {
	 String chosenEvent = " ";
	 String month = " ";
	 String day = " ";
	 String date = " ";
	 Scanner input1 = new Scanner(System.in);
	 Scanner input2 = new Scanner(System.in);
	 Scanner input3 = new Scanner(System.in);
	 Scanner input4 = new Scanner(System.in);
       System.out.println("Enter the event: ");
	 chosenEvent = input1.nextLine();
	 String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	 System.out.println("Enter a specific month for an event: ");
	 month = input2.nextLine();
	 if(month.equals("January")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("February")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("March")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("April")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("May")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("June")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("July")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("August")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("September")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("October")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("November")) {
		 System.out.println("Month is set.");
	 } 
	 if(month.equals("December")) {
		 System.out.println("Month is set.");
	 }
	 System.out.println("\n");
	 String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	 System.out.println("Enter a specific day for an event: ");
	 day = input3.nextLine();
	 if(day.equals("Sunday")) {
		 System.out.println("Day is set.");
	 } 
	 if(day.equals("Monday")) {
		 System.out.println("Day is set.");
	 } 
	 if(day.equals("Tuesday")) {
		 System.out.println("Day is set.");
	 }
	 if(day.equals("Wednesday")) {
		 System.out.println("Day is set.");
	 }
	 if(day.equals("Thursday")) {
		 System.out.println("Day is set.");
	 }
	 if(day.equals("Friday")) {
		 System.out.println("Day is set.");
	 }
	 if(day.equals("Saturday")) {
		 System.out.println("Day is set.");
	 }
	 System.out.println("\n");
	 String[] specificDate = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19","20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	 System.out.println("Enter a specific date for an event: ");
	 date = input4.nextLine();
	 if(date.equals("1")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("2")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("3")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("4")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("5")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("6")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("7")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("8")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("9")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("10")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("11")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("12")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("13")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("14")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("15")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("16")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("17")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("18")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("19")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("20")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("21")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("22")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("23")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("24")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("25")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("26")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("27")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("28")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("29")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("30")) {
		 System.out.println("Date is set.");
	 }
	 if(date.equals("31")) {
		 System.out.println("Date is set.");
	 }
	 return("Your event " + chosenEvent + " is already set for " + day + " of " + month + date);
 }
}