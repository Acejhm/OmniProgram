package games.adventure.gui;

//Since this is the backend code for the GUI, it is 
//neccessary to have these import statements.
import javax.swing.*;

import games.adventure.enemies.ManageEnemies;
import games.adventure.player.Player;

import java.awt.GridLayout;
import java.awt.event.*;

/**To do:
 * Add while loop to allow user to go back to previous screen
 * Add graphics for each character
 * Add random name generator
 * Add difficulty scaling
 * Add save data
 * Finish commenting code
 * Solve suppressed warnings annotations
 * Add tooltips.
 * 
 * @version 0.1
 * @author Jackson Murrell
 * 
 */
@SuppressWarnings("serial")
public class CharacterSetupGUI extends JFrame implements ActionListener
{
	//Various constants to be used later.
	final short WINDOW_HEIGHT = 300;
	final short WINDOW_WIDTH = 500;
	final byte NAME_FIELD_SIZE = 10;
	final String INTRO_TEXT = "<html><center>Welcome to \"Adventures in Auraxia\"!<p><p>Please enter your hero's name below, "
			+ "choose your class,<br>and then select your difficulty.</center>";
	//The default difficulty
	public String difficultyName = "Normal";
	
	//This will be determined later, and will be either a 1, 2, 3, or 4.
	//The default difficulty is 3, or normal.
	byte difficultyNumber = 3;
	
	boolean proceed = false;
	
	public static String[] characterClassesArray = {"Mage", "Archer", "Knight", "Rogue"};
	
	//These classes are instantiated to reference methods used in the battle windows.
	//Player playerClass;
	//Enemies enemiesClass = new Enemies(playerClass);
	ButtonGroup difficultyGroup = new ButtonGroup();
	
	JPanel mainPanel, textPanel, setupPanel, buttonPanel, difficultyPanel;
	
	@SuppressWarnings("rawtypes")
	JComboBox characterSelector;
	
	JTextField playerName;
	
	JLabel textLabel;
	
	JButton quit, next;
	
	JRadioButton easyDifficulty, normalDifficulty, hardDifficulty, ultimateDifficulty;
	
	//The constructor will create all the needed components, and initialize the actual window.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CharacterSetupGUI()
	{	
		//Several methods to set up basic stats for the window
		super("Adventures in Auraxia");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Initializing panels.
		mainPanel = new JPanel();
		textPanel = new JPanel();
		setupPanel = new JPanel();
		buttonPanel = new JPanel();
		difficultyPanel = new JPanel();
		
		//Text field to get the player's hero name.
		playerName = new JTextField(NAME_FIELD_SIZE);
		
		//The label to be used for displaying various information.
		textLabel = new JLabel(INTRO_TEXT, JLabel.RIGHT);
		
		//A combo box that is initialized with the class names found in Character Classes.
		characterSelector = new JComboBox(characterClassesArray);
		characterSelector.setEditable(false);
		characterSelector.addActionListener(this);
		
		quit = new JButton("Quit");
		quit.addActionListener(this);
		
		next = new JButton("Continue");
		next.addActionListener(this);
		
		easyDifficulty = new JRadioButton("Easy");
		easyDifficulty.addActionListener(this);
		easyDifficulty.setActionCommand("Easy");
		
		normalDifficulty = new JRadioButton("Normal");
		normalDifficulty.addActionListener(this);
		normalDifficulty.setSelected(true);
		normalDifficulty.setActionCommand("Normal");
		
		hardDifficulty = new JRadioButton("Hard");
		hardDifficulty.addActionListener(this);
		hardDifficulty.setActionCommand("Hard");
		
		ultimateDifficulty = new JRadioButton("Ultimate");
		ultimateDifficulty.addActionListener(this);
		ultimateDifficulty.setActionCommand("Ultimate");
		
		difficultyGroup.add(easyDifficulty);
		difficultyGroup.add(normalDifficulty);
		difficultyGroup.add(hardDifficulty);
		difficultyGroup.add(ultimateDifficulty);
		
		difficultyPanel.add(easyDifficulty);
		difficultyPanel.add(normalDifficulty);
		difficultyPanel.add(hardDifficulty);
		difficultyPanel.add(ultimateDifficulty);
		difficultyPanel.setLayout(new GridLayout(1,3));
		
		textPanel.add(textLabel);
		
		setupPanel.add(playerName);
		setupPanel.add(characterSelector);
		setupPanel.add(difficultyPanel);
		setupPanel.setLayout(new GridLayout(3,1));
		
		buttonPanel.add(next);
		buttonPanel.add(quit);
		
		mainPanel.add(textPanel);
		mainPanel.add(setupPanel);
		mainPanel.add(buttonPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		add(mainPanel);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == next)
		{
			Player playerClass = new Player(difficultyNumber, difficultyName, playerName.getText(), (String) characterSelector.getSelectedItem());
			
				mainPanel.remove(setupPanel);
				
				quit.setText("Go Back");
				next.setText("Begin Adventure");
				
			
				textLabel.setText("<html><center>Your hero, " + playerClass.getPlayerName() + ", is about to set off on an<br>adventure into the land of Auraxia as a " + 
									playerClass.getPlayerClass() + ".<br>Because you chose " + difficultyName + ", your maxium health is set to " + playerClass.getMAX_HEALTH() + ".<br>Good luck!</center>");	
				if(proceed == true)
				{
					setVisible(false);
					new EnemySelectorGUI(playerClass);
				}
				proceed = true;
		}
		else if(e.getSource() == easyDifficulty)
		{
			difficultyNumber = 4; 
			difficultyName = "Easy";
		}
		else if(e.getSource() == hardDifficulty) 
		{
			difficultyNumber = 2; 
			difficultyName = "Hard";
		}
		else if(e.getSource() == ultimateDifficulty)
		{
			difficultyNumber = 1;
			difficultyName = "Ultimate";
		}
		else if(e.getSource() == quit)
			System.exit(0);
	}
}