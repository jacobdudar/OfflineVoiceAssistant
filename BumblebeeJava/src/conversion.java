import java.util.ArrayList;
/**
 * @author Kaijie Ma
 *
 */


public class conversion extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public conversion() {
        commandPhrases.add("conversion");
    }
    private static String outPut = "";
    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String conver(String[] input){
        int j = 0;

        for(j=0; j<input.length; j++){
            if(input[j].equals("conversion")){
                break;
            }
        }

        for(int i=j+1; i<input.length; i++) {
            if (input[i].equals("one inch")) {
                return ("2.54 cm");
            }
            if (input[i].equals("one feet")) {
                return ("0.3048 m");
            }
            if (input[i].equals("one mile")) {
                return ("1.6093 Km");
            }
            if (input[i].equals("one pound")) {
                return ("0.4536 Kg");
            }
            if (input[i].equals("one ounce")) {
                return ("45.359 Kg");
            }

        }
        return "Try again";
    }


}
