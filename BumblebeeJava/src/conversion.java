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

    public String run(String[] input){
        int j = 0;
/*
        for(j=0; j<input.length; j++){
            if(input[j].equals("conversion")){
                break;
            }
        }
*/
        for(int i=j; i<input.length; i++) {
            if (input[i].equals("inch")) {
                return ("2 point 54 centimeters");
            }
            if (input[i].equals("feet")) {
                return ("0 point 3048 meters");
            }
            if (input[i].equals("mile")) {
                return ("1 point 6093 Kilometers");
            }
            if (input[i].equals("pound")) {
                return ("0 point 4536 Kilometers");
            }
            if (input[i].equals("ounce")) {
                return ("45 point 359 Kilograms");
            }

        }
        return "Try again";
    }


}
