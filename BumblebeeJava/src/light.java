import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Jacob Dudar
 *Requires pyHS100 to be installed using python
 */
public class light extends commandClass implements commandInterface{
	ArrayList<String> commandPhrases = new ArrayList<String>();
	boolean LightLoop=false;
	public light() {
		commandPhrases.add("light");
	}

	@Override
	public boolean match(String token) {
		return commandPhrases.contains(token);
	}
	
	@Override
	/*
	 * This command handles turning the light on/off
	 * it works by parsing either on or off from the command.
	 * Then it builds a new process that uses the pyHS100 library to turn the light on or off
	 * Then it gets the result if it was able to turn the light on or off and returns a message to the user
	 * */
	public String run(String[] command) {
		int x=0;
		String lightcommand="";
		for (int i=0;i<command.length;i++) {
			System.out.println(command[i]);
			if(command[i].equals("on")) {
				lightcommand="on";
			}else if(command[i].equals("off")) {
				lightcommand="off";
			}
			
			
		}
		
		ProcessBuilder processBuilder
		= new ProcessBuilder();

	List<String> builderList = new ArrayList<>();

	// add the list of commands to a list
	builderList.add("cmd.exe");
	builderList.add("/C");
	builderList.add(" pyhs100 --alias test "+lightcommand);//The alias is the name of the smart device in this case "test" is the alias

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
			
			if(line.equals("No device with name test found")){
				return "Cant find that device, check your Connection";
			}
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
		
	
	return "Adjusting light to be "+lightcommand;
		
	}

}

