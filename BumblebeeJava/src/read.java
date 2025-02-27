import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * @author Kathleen Snyder
 *
 */
public class read extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public read() {
        commandPhrases.add("read");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){
        String output = "";
        String fileName = "";
        for(int j=1; j<input.length; j++){
            if(j == input.length-1)
                fileName = fileName.concat(input[j]);
            else
                fileName = fileName.concat(input[j] + " ");
        }

        try {
            FileReader reader = new FileReader(fileName + ".txt");

                int i;
                while ((i = reader.read()) != -1) {
                    output+= Character.toString((char)i);
                }
            reader.close();
        } catch(FileNotFoundException e) {
        	return "no file called " + fileName + " could be read";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //System.out.println(output);
		return output;
    }
}
