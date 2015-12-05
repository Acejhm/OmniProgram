package games.adventure.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import games.adventure.enemies.*;
import games.adventure.player.Player;

public class EnemySelectorGUI extends JFrame implements ActionListener
{
	final short WINDOW_HEIGHT = 300;
	final short WINDOW_WIDTH = 500;
	
	Player playerClass;
	
	ManageEnemies enemyClass;
	Enemies currentEnemy;
		
	JPanel mainPanel, buttonPanel, displayPanel;
	
	JButton skeleton, knight, zombie, spider, randomize;
	
	JLabel textLabel;
	
	DecimalFormat formatter = new DecimalFormat("");
	
	public EnemySelectorGUI(Player playerClass)
	{
		super("Adventures in Auraxia");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.playerClass = playerClass;
		
		enemyClass = new ManageEnemies(this.playerClass);
		//Initializing panels.
		mainPanel = new JPanel();
		displayPanel = new JPanel();
		buttonPanel = new JPanel();
		
		skeleton = new JButton("Skeleton");
		skeleton.addActionListener(this);
		
		knight = new JButton("Knight");
		knight.addActionListener(this);
		
		zombie = new JButton("Zombie");
		zombie.addActionListener(this);
		
		spider = new JButton("Spider");
		spider.addActionListener(this);
		
		randomize = new JButton("Randomize");
		randomize.addActionListener(this);
		
		textLabel = new JLabel("Choose the enemy you wish to fight below, " + playerClass.getPlayerName() + ".");

		displayPanel.add(textLabel);
		
		buttonPanel.add(knight);
		buttonPanel.add(skeleton);
		buttonPanel.add(spider);
		buttonPanel.add(zombie);
		buttonPanel.add(randomize);
		
		mainPanel.add(displayPanel);
		mainPanel.add(buttonPanel);
		
		add(mainPanel);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == knight)
		{
			currentEnemy = new Knight(playerClass);
			new BattleGUI(playerClass, currentEnemy);
		}
		if(e.getSource() == skeleton)
		{
			currentEnemy = new Skeleton(playerClass);
			new BattleGUI(playerClass, currentEnemy);
		}
		if(e.getSource() == spider)
		{
			currentEnemy = new Spider(playerClass);
			new BattleGUI(playerClass, currentEnemy);
		}
		if(e.getSource() == zombie)
		{
			currentEnemy = new Zombie(playerClass);
			new BattleGUI(playerClass, currentEnemy);
		}
	
	}
}
