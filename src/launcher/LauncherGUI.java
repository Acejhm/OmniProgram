package launcher;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.*;


import launcher.menus.LauncherMenu;
import utility.ReadConfig;

public class LauncherGUI extends JFrame
{
	private static final long serialVersionUID = 2201843583433517426L;
	
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
        textPanel.add(label);
        clockPanel.add(clock);
        
        if(applicationDefault)
        	mainPanel.add(applicationPanel);
        else
        	mainPanel.add(gamePanel);
        
        if(widgetsOn)
        {
        	addClock();
        	addLabel();
        }
        	

       setJMenuBar(new LauncherMenu(this, widgetsOn));
        
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
		if(timer != null)
			timer.stop();
		
		byte option = (byte)JOptionPane.showConfirmDialog(this, "Exit all programs?", "Exit Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(option == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
		else if(option == JOptionPane.NO_OPTION)
		{
			super.dispose();
		}
	}
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(
		new Runnable()
		{
			@Override
			public void run() 
			{
				ReadConfig reader = new ReadConfig();
				new LauncherGUI(true, reader.readPropertyBool(ReadConfig.WIDGETS));
			}
		});
	}
}