package launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import games.adventure.gui.CharacterSetupGUI;
import games.pong.AnimationPanel;
import games.pong.PongMainGUI;

public class GamePanel extends JPanel implements ActionListener
{
	JButton pong, adventure, applications, exit;
	LauncherGUI launcher;
	
	public GamePanel(LauncherGUI launcher)
	{
		this.launcher  = launcher;
		
		pong = new JButton("Pong");
		adventure = new JButton("Adventure");
		applications = new JButton("Applications");
		exit = new JButton("Exit");
		
		pong.addActionListener(this);
		adventure.addActionListener(this);
		applications.addActionListener(this);
		exit.addActionListener(this);
		
		add(adventure);
		add(pong);
		add(applications);
		add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent action) 
	{
		if(action.getSource() == pong)
		{
			launcher.setVisible(false);
			try 
			{
				PongMainGUI.main(null);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			launcher.setVisible(true);
		}
		else if(action.getSource() == adventure)
		{
			new CharacterSetupGUI();
		}
		else if(action.getSource() == applications)
			launcher.switchToApplications();
		else if(action.getSource() == exit)
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
	}
}
