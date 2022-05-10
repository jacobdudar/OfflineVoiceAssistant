import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Random;

/***
 * 
 * Author: Jacob Dudar
 * Requires Windows Media player to be set to default mp3 player
 * requires WMP Keys plugin to be configured 
 * */

public class music extends commandClass implements commandInterface{
ArrayList<String> commandPhrases = new ArrayList<String>();
ArrayList<String> songs = new ArrayList<String>();

public music() {
	
	commandPhrases.add("music");
	
}

public boolean match(String word){
    return commandPhrases.contains(word);
}
//Builds a music list from songs.txt
public void musicList() {
	try {
	      File myObj = new File("songs.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        //System.out.println(data);
	        songs.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
}

@Override
/*
 * Plays or pauses the music player
 * 
 * if pause is selected it inputs the correct pause key bindings
 * 
 * if play is selected a new song is selected from the music list and a new process is made in Windows media player to play the song
 * */
public String run(String[] command) {
	musicList();
	for (int i=0;i<command.length;i++) {
		System.out.println(command[i]);
		
		if(command[i].equals("pause")||command[i].equals("stop")||command[i].equals("unpause")) {
			try {
		        Robot robot = new Robot();
		        
		        // Simulate a key press matching WMP KEYS
		        robot.keyPress(KeyEvent.VK_CONTROL);
		        robot.keyPress(KeyEvent.VK_ALT);
		        robot.keyPress(KeyEvent.VK_P);
		        robot.keyRelease(KeyEvent.VK_CONTROL);
		        robot.keyRelease(KeyEvent.VK_ALT);
		        robot.keyRelease(KeyEvent.VK_P);
		        
		} catch (AWTException e) {
		        e.printStackTrace();
		}
			
				return"stopping the music";
		}else if(command[i].equals("play")) {
		
		Random number=new Random();
		int songID=number.nextInt(songs.size());
		
		ProcessBuilder processBuilder= new ProcessBuilder();

		List<String> builderList = new ArrayList<>();

		// add the list of commands to a list
		builderList.add("cmd.exe");
		builderList.add("/C");
		builderList.add(songs.get(songID));//SONG FILE 
		try {
			// Using the list , trigger the command
			processBuilder.command(builderList);
			Process process = processBuilder.start();

			// To read the output list
			BufferedReader reader= new BufferedReader(new InputStreamReader(
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
		return "playing the music";
		}
		
		
		
		
	}
	
	
	
		
	
	
	
	
return "error";	
}


}