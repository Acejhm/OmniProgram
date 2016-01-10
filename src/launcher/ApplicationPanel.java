package launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.*;

import applications.Calculator;
import applications.ChatRoom;
import applications.ChatServer;
import applications.ColorChooser;
import applications.Sorter;

public class ApplicationPanel extends JPanel implements ActionListener
{
	JButton games, calculator, sorter, exit, chooser, chat;
	LauncherGUI launcher;
	
	public ApplicationPanel(LauncherGUI launcher)
	{
		this.launcher = launcher;
		games = new JButton("Games");
		exit = new JButton("Exit");
		sorter = new JButton("Sorter");
		calculator = new JButton("Calculator");
		chooser = new JButton("Color Chooser");
		chat = new JButton("Chat Room");
		
		sorter.addActionListener(this);
		calculator.addActionListener(this);
		games.addActionListener(this);
		exit.addActionListener(this);
		chooser.addActionListener(this);
		chat.addActionListener(this);
		
		add(calculator);
		add(chat);
		add(chooser);
		add(sorter);
		add(games);
		add(exit);
	}
	@Override
	public void actionPerformed(ActionEvent action) 
	{
		if(action.getSource() == games)
		{
			launcher.switchToGames();
		}
		else if(action.getSource()  == exit)
		{
			byte option = (byte)JOptionPane.showConfirmDialog(this, "Exit all programs?", "Exit Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
		
			if(option == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
			else if(option == JOptionPane.NO_OPTION)
			{
				launcher.dispose();
			}
		}
		else if(action.getSource() == calculator)
		{	
			new Calculator();
		}
		else if(action.getSource() == sorter)
		{
			try 
			{
				new Sorter();
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == chooser)
		{
			new ColorChooser();
		}
		else if(action.getSource() == chat)
		{
			new ChatRoom();
		}
	}
}