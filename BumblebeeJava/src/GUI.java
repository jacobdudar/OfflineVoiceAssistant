import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
/**
 * @author Ian Zichko-Geithner
 * @author Jacob Dudar
 */
public class GUI {

	private JFrame frame;
	private static JTextArea inputField = new JTextArea();
	private static JTextArea outputField = new JTextArea();
	private static JTextArea dataManager=new JTextArea();
	private static JRadioButton privacyButton=new JRadioButton();
	private static JRadioButton privacyButton2=new JRadioButton();
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
			
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Process vosk = Runtime.getRuntime().exec("python anotherdemo.py");
					GUI window = new GUI();
					window.frame.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while(true) {	
			Scanner input = new Scanner(System.in);
			String output = null;

			do {
				try {
					input = new Scanner(new BufferedReader(new FileReader("test.txt")));
					
					output = "";
					while(input.hasNext()) {
						output += input.nextLine() + '\n';
					}
					input.close();
					File toDelete = new File("test.txt");
					toDelete.delete();
					
					//string manipulation of output	
					output = output.substring(14, output.lastIndexOf('\"'));
					System.out.println("input: " + output);
					
				} catch(FileNotFoundException e ) {
					Thread.sleep(1000);
				}
			} while(output == null);
			
			stateMachine run;
			try {
				run = new stateMachine(output);
				String speech = run.outPut(run.match());
				outputField.setText(speech);
				inputField.setText(output);
				stateMachine.textToSpeech.setVoice("dfki-poppy-hsmm");
				stateMachine.textToSpeech.speak(speech, 1.5f, false, true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ButtonGroup Buttons=new ButtonGroup();
		Buttons.add(privacyButton);
		Buttons.add(privacyButton2);
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Input:");
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Output:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 104, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 3, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		frame.getContentPane().add(lblNewLabel_1);
		
		inputField.setLineWrap(true);
		springLayout.putConstraint(SpringLayout.WEST, inputField, 6, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, inputField, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, inputField);
		springLayout.putConstraint(SpringLayout.NORTH, inputField, 11, SpringLayout.NORTH, frame.getContentPane());
		inputField.setWrapStyleWord(true);
		inputField.setEditable(false);
		inputField.setForeground(new Color(255, 255, 255));
		inputField.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(inputField);
		
		outputField.setWrapStyleWord(true);
		outputField.setLineWrap(true);
		springLayout.putConstraint(SpringLayout.SOUTH, inputField, -6, SpringLayout.NORTH, outputField);
		outputField.setBackground(new Color(0, 0, 0));
		outputField.setForeground(new Color(255, 255, 255));
		springLayout.putConstraint(SpringLayout.NORTH, outputField, 128, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, outputField, 6, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, outputField, -24, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, outputField, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(outputField);
		
		/*
		JLabel dataLabel=new JLabel("Data Manager");
		springLayout.putConstraint(SpringLayout.SOUTH, outputField, -6, SpringLayout.NORTH, dataLabel);
		springLayout.putConstraint(SpringLayout.NORTH, dataLabel, 210, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, dataLabel, 3, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		frame.getContentPane().add(dataLabel);
		
		dataManager.setWrapStyleWord(true);
		dataManager.setLineWrap(true);
		dataManager.setBackground(new Color(0,0,0));
		dataManager.setForeground(new Color(255,255,255));
		springLayout.putConstraint(SpringLayout.NORTH, dataManager, 30, SpringLayout.NORTH, dataLabel);
		springLayout.putConstraint(SpringLayout.WEST, dataManager, -10, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, dataManager, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(springLayout.SOUTH, dataManager, -50, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(dataManager);
		
		JLabel privacyButtonLabel=new JLabel("Privacy ON (may turn off some commands)");
		springLayout.putConstraint(SpringLayout.NORTH, privacyButtonLabel, 10, SpringLayout.SOUTH, dataManager);
		frame.getContentPane().add(privacyButtonLabel);
		privacyButton.setBackground(null);
		springLayout.putConstraint(SpringLayout.WEST, privacyButton, 10, SpringLayout.EAST, privacyButtonLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, privacyButton, 4, SpringLayout.SOUTH, privacyButtonLabel);
		frame.getContentPane().add(privacyButton);
		
		
		JLabel privacyButtonLabel2=new JLabel("Privacy OFF (Will allow access to the internet)");
		springLayout.putConstraint(SpringLayout.NORTH, privacyButtonLabel2, 10, SpringLayout.SOUTH, privacyButtonLabel);
		privacyButton2.setBackground(null);
		springLayout.putConstraint(SpringLayout.WEST, privacyButton2, 10, SpringLayout.EAST, privacyButtonLabel2);
		springLayout.putConstraint(SpringLayout.SOUTH, privacyButton2, 4, SpringLayout.SOUTH, privacyButtonLabel2);
		frame.getContentPane().add(privacyButtonLabel2);
		frame.getContentPane().add(privacyButton2);
		*/
		
	}
}