package launcher.menus;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import launcher.LauncherGUI;
import utility.BaseMenu;
import utility.ConfigFile;
import utility.ReadConfig;

/**
 * @author Jackson Murrell onClock Nov 7, 2015
 */
public class LauncherMenu extends BaseMenu implements ActionListener
{
	private JMenuItem onClock, offClock, onLabel, offLabel;
	private JMenu widgets, clock, text;
	private LauncherGUI launcherGUI;
	private ReadConfig config;
	
	public LauncherMenu(LauncherGUI gui, boolean widgetsOn)
	{
		super(gui);
		
		launcherGUI = gui;
		
		this.config = config;
		
		onClock = new JMenuItem("On");
		onClock.addActionListener(this);
		offClock = new JMenuItem("Off");
		offClock.addActionListener(this);
		onLabel = new JMenuItem("On");
		onLabel.addActionListener(this);
		offLabel = new JMenuItem("Off");
		offLabel.addActionListener(this);
		
		if(config.readPropertyBool(ReadConfig.WIDGETS))
		{
			onClock.setEnabled(false);
			offClock.setEnabled(true);
			onLabel.setEnabled(false);
			offLabel.setEnabled(true);
		}
		else
		{
			onClock.setEnabled(true);
			offClock.setEnabled(false);
			onLabel.setEnabled(true);
			offLabel.setEnabled(false);
		}
		widgets = new JMenu("Widgets");
		clock = new JMenu("Clock");
		text = new JMenu("Text");

		widgets.add(clock);
		widgets.add(text);
		text.add(onLabel);
		text.add(offLabel);
		clock.add(onClock);
		clock.add(offClock);
		settings.add(widgets);
	}
	@Override
	public void customActions(ActionEvent action)
	{
		if(action.getSource() == onClock)
		{
			launcherGUI.addClock();
			onClock.setEnabled(false);
			offClock.setEnabled(true);
		}
		else if(action.getSource() == offClock)
		{
			launcherGUI.removeClock();
			offClock.setEnabled(false);
			onClock.setEnabled(true);
		}
		else if(action.getSource() == onLabel)
		{
			launcherGUI.addLabel();
			offLabel.setEnabled(true);
			onLabel.setEnabled(false);
		}
		else if(action.getSource() == offLabel)
		{
			launcherGUI.removeLabel();
			offLabel.setEnabled(false);
			onLabel.setEnabled(true);
		}
	}
	public void showHelpMenu()
	{
		JOptionPane.showMessageDialog(parentFrame, "Select the program you would like to launch.  It will open in a new window.\nJava version: " + System.getProperty("java.version"));
	}
}