import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Jacob Dudar
 * Requires pyHS100 to be installed using python
 */
public class color extends commandClass implements commandInterface{
	ArrayList<String> commandPhrases = new ArrayList<String>();
	
	public color() {
		commandPhrases.add("color");
	}

	@Override
	public boolean match(String token) {
		return commandPhrases.contains(token);
	}
	
	@Override
	/*
	 * This command handles turning the light to a color
	 * it works by parsing the color from the command.
	 * Then it builds a new process that uses the pyHS100 library to turn the light to the color picked
	 * Then it gets the result if it was able to turn the light to the color and returns a message to the user
	 * */
	public String run(String[] command) {
		int x=0;
		int y=100;
		String color="";
		for (int i=0;i<command.length;i++) {
			System.out.println(command[i]);
			if(command[i].equals("red")||command[i].equals("read")) {
				x=0;
				color="red";
			}else if(command[i].equals("green")) {
				x=120;
				color="green";
			}else if(command[i].equals("white")) {
				x=0;
				y=0;
				color="white";
			}else if(command[i].equals("blue")||command[i].equals("blow")) {
				x=200;
				color="blue";
			}else if(command[i].equals("purple")) {
				x=280;
				color="purple";
			}else if (command[i].equals("yellow")) {
				x=70;
				color="yellow";
			}else if(command[i].equals("orange")) {
				x=40;
				color="orange";
			}
			
			
		}
		
		ProcessBuilder processBuilder
		= new ProcessBuilder();

	List<String> builderList = new ArrayList<>();

	// add the list of commands to a list
	builderList.add("cmd.exe");
	builderList.add("/C");
	builderList.add(" pyhs100 --alias test hsv "+x+" "+y+" 100");//The alias is the name of the smart device in this case "test" is the alias

	try {
		// Using the list , trigger the command
		processBuilder.command(builderList);
		Process process = processBuilder.start();

		// To read the output list
		BufferedReader reader
			= new BufferedReader(new InputStreamReader(
				process.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		int exitCode = process.waitFor();
		System.out.println("\nExited with error code : "
						+ exitCode);
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	catch (InterruptedException e) {
		e.printStackTrace();
	}
		
		
	return "Adjusting color of the light to be "+color;
		
	}

}

