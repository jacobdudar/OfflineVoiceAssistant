import java.util.ArrayList;
/**
 * @author Kaijie Ma
 *
 */
/*
get a  random number between 0 and 6 like a dice
 */

public class number extends commandClass implements commandInterface {
    ArrayList<String> commandPhrases = new ArrayList<String>();

    public number() {
        commandPhrases.add("random number");
    }

    public boolean match(String word){
        return commandPhrases.contains(word);
    }

    public String run(String[] input){

        final double d = Math.random();
        final int i = (int)(d*6)+1;
        String result = "" +i;
        return result;
    }
}
