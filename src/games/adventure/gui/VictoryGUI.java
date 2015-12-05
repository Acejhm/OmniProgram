package games.adventure.gui;

import javax.swing.*;

import games.adventure.enemies.Enemies;
import games.adventure.player.Player;

/**
 * @author Jackson Murrell on Oct 25, 2015
 */
public class VictoryGUI extends JFrame
{
	private static final int WINDOW_HEIGHT = 400;
	private static final int WINDOW_WIDTH = 400;
	
	JTextArea text;
	JPanel mainPanel, textPanel;
	private Enemies currentEnemy;
	private Player player;
	
	public VictoryGUI(Enemies currentEnemy, Player player)
	{
		super("Adventures in Auraxia");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.currentEnemy = currentEnemy;
		this.player = player;
		
		text = new JTextArea("You have defeated the \"" + currentEnemy.getName() + "\" and have been\n"
				             + "awarded with " + player.getXPGain(currentEnemy) + " experience and "
				             + player.getGoldGain(currentEnemy) + " gold.");
		
		mainPanel = new JPanel();
		textPanel = new JPanel();
		
		textPanel.add(text);
		mainPanel.add(textPanel);
		add(mainPanel);
		setVisible(true);
	}
}