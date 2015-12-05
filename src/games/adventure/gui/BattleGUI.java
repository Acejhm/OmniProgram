package games.adventure.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import games.adventure.enemies.Enemies;
import games.adventure.enemies.ManageEnemies;
import games.adventure.player.Player;

/**To do:
 * Add while loop to allow user to go back to previous screen
 * Add graphics for each character
 * Add random name generator
 * Add difficulty scaling
 * Add save data
 * Finish commenting code
 * Solve suppressed warnings annotations
 * 
 * @version 0.1
 * @author Jackson Murrell
 * @author J. L. Finley
 */
public class BattleGUI extends JFrame implements ActionListener
{
	final short WINDOW_HEIGHT = 300;
	final short WINDOW_WIDTH = 500;
	
	Player playerClass;
	
	ManageEnemies enemyClass;
	Enemies currentEnemy;
		
	JPanel mainPanel, buttonPanel, displayPanel;
	
	JButton basicAttack, heavyAttack, specialAttack, potions;
	
	JLabel playerStatus, enemyStatus;
	
	public BattleGUI(Player playerClass, Enemies currentEnemy)
	{
		super("Adventures in Auraxia");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.playerClass = playerClass;
		this.currentEnemy = currentEnemy;
		
		enemyClass = new ManageEnemies(this.playerClass);
		System.out.println("Inside BattleGUI var enemyClass> " + this.playerClass.getMAX_HEALTH());
		//Initializing panels.
		mainPanel = new JPanel();
		displayPanel = new JPanel();
		buttonPanel = new JPanel();
		
		basicAttack = new JButton("Basic Attack");
		basicAttack.addActionListener(this);
		
		heavyAttack = new JButton("Heavy Attack");
		heavyAttack.addActionListener(this);
		
		specialAttack = new JButton("Special Attack");
		specialAttack.addActionListener(this);
		
		potions = new JButton("Potions");
		potions.addActionListener(this);
		
		playerStatus = new JLabel("Health: " + this.playerClass.getHealth() + "  Mana: " + playerClass.getMAX_MANA());
		enemyStatus = new JLabel("<html><left>Enemy: " + currentEnemy.getName() + "  Health: " + currentEnemy.getHealth() + "</left>");
		
		displayPanel.add(playerStatus);
		displayPanel.add(buttonPanel);
		displayPanel.add(enemyStatus);
		displayPanel.setLayout(new GridLayout(3,1));
		
		buttonPanel.add(potions);
		buttonPanel.add(basicAttack);
		buttonPanel.add(heavyAttack);
		buttonPanel.add(specialAttack);
		
		mainPanel.add(displayPanel);
		
		add(mainPanel);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent action) 
	{
		if(action.getSource() == basicAttack)
		{
			currentEnemy.takeDamage(playerClass.basicAttack());
			JOptionPane.showMessageDialog(null, "You were damaged for: " + 
				      playerClass.damagePlayer(currentEnemy.doDamage()) + " health.");
			enemyStatus.setText("<html><left>Enemy Health: " + currentEnemy.getHealth() + "</left>");
			playerStatus.setText("Health: " + playerClass.getHealth() + "  Mana: " + playerClass.getMAX_MANA());
		}
		else if(action.getSource() == heavyAttack)
		{
			currentEnemy.takeDamage(playerClass.heavyAttack());
			JOptionPane.showMessageDialog(null, "You were damaged for: " + 
									      playerClass.damagePlayer(currentEnemy.doDamage()) + " health.");
			enemyStatus.setText("<html><left>Enemy Health: " + currentEnemy.getHealth() + "</left>");
			playerStatus.setText("Health: " + playerClass.getHealth() + "  Mana: " + playerClass.getMAX_MANA());
		}
		if(currentEnemy.getHealth() == 0)
		{
			new VictoryGUI(currentEnemy, playerClass);
		}
	}
}