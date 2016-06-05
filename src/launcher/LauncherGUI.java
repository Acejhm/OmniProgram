package launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.*;
import launcher.menus.LauncherMenu;
import utility.BaseMenu;

public class LauncherGUI extends JFrame
{
	private JPanel mainPanel, textPanel, clockPanel;
	private JLabel label, clock;
	private ApplicationPanel applicationPanel;
	private GamePanel gamePanel;
	
	private Calendar calendar = Calendar.getInstance();
	private final short WINDOW_HEIGHT = 300;
	private final short WINDOW_WIDTH = 750;
	
	private Timer timer;
	
	public LauncherGUI(boolean applicationDefault, boolean widgetsOn)
	{
		setTitle("Omni-Program Launcher");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        
        mainPanel = new JPanel();
        textPanel = new JPanel();
        clockPanel = new JPanel();
        applicationPanel = new ApplicationPanel(this);
        gamePanel = new GamePanel(this);
        
        label = new JLabel("Welcome to the Omni-Program Launcher!  Please select the application or game you wish to run.");
        label.setFont(new Font("Arial", Font.ITALIC, 15));
        
        clock = new JLabel("" + calendar.getTime());
        clock.setFont(new Font("Arial", Font.PLAIN, 20));
        clock.setHorizontalAlignment(SwingUtilities.LEFT);
        
        clock.setBorder(BorderFactory.createRaisedBevelBorder());
        
        clockPanel.add(clock);
        textPanel.add(label);
        mainPanel.add(textPanel);
        
        if(applicationDefault)
        	mainPanel.add(applicationPanel);
        else
        	mainPanel.add(gamePanel);
        
        if(widgetsOn)
        	addClock();

       setJMenuBar(new LauncherMenu(this, true));
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        add(mainPanel);
        
        setVisible(true);
	}
	
	public void switchToApplications()
	{
		mainPanel.remove(gamePanel);
		mainPanel.remove(clockPanel);
		mainPanel.add(applicationPanel);
		mainPanel.add(clockPanel);
		repaint();
		SwingUtilities.updateComponentTreeUI(this);
		setVisible(true);
	}
	public void switchToGames()
	{
		mainPanel.remove(applicationPanel);
		mainPanel.remove(clockPanel);
		mainPanel.add(gamePanel);
		mainPanel.add(clockPanel);
		repaint();
		SwingUtilities.updateComponentTreeUI(this);
		setVisible(true);
	}
	public void addClock()
	{
		mainPanel.add(clockPanel);
		timer = new Timer(500, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				calendar = Calendar.getInstance();
				clock.setText("" + calendar.getTime());
				clock.repaint();
			}
		});
		timer.start();
		SwingUtilities.updateComponentTreeUI(this);
	}
	public void removeClock()
	{
		timer.stop();
		mainPanel.remove(clockPanel);
		SwingUtilities.updateComponentTreeUI(this);
	}
	public void addLabel()
	{
		Component[] component = mainPanel.getComponents();
		for(int i = 0; i < component.length; i++)
		{
			mainPanel.remove(component[i]);
		}
		mainPanel.add(textPanel);
		for(int i = 0; i < component.length; i++)
		{
			mainPanel.add(component[i]);
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
	public void removeLabel()
	{
		mainPanel.remove(textPanel);
		SwingUtilities.updateComponentTreeUI(this);
	}
	@Override
	public void dispose() 
	{
		timer.stop();
		super.dispose();
	}
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				new LauncherGUI(true, true);
			}
		});
	}
}