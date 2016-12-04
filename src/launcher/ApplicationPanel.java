package launcher;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import applications.*;

public class ApplicationPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = -1813652528709487354L;

	JButton games, calculator, sorter, exit, chooser, chat, specs;
	LauncherGUI launcher;
	
	public ApplicationPanel(LauncherGUI launcher)
	{
		this.launcher = launcher;
		games = new JButton("Games");
		exit = new JButton("Exit");
		sorter = new JButton("Sorter");
		//calculator = new JButton("Calculator");
		chooser = new JButton("Color Chooser");
		//chat = new JButton("Chat Room");
		specs = new JButton("Computer Specifications");
		
		sorter.addActionListener(this);
		//calculator.addActionListener(this);
		games.addActionListener(this);
		exit.addActionListener(this);
		chooser.addActionListener(this);
		//chat.addActionListener(this);
		specs.addActionListener(this);
		
		//add(calculator);
		//add(chat);
		add(chooser);
		add(specs);
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
			try
			{
				new Calculator();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
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
		else if(action.getSource() == specs)
		{
			new ComputerSpecs();
		}
	}
}