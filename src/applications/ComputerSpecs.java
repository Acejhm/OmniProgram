package applications;

import java.io.File;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import utility.BaseMenu;
import utility.MathExtended;

/**
 * @author Jackson Murrell on May 10, 2016
 */
public class ComputerSpecs extends JFrame
{
	private static final long serialVersionUID = 5831990538109414355L;
	private static final short	WINDOW_LENGTH	 = 400;
	private static final short	WINDOW_WIDTH	 = 400;
	private static final String	TITLE			 = "Computer Specifications";
	private static final FileSystemView fileView = FileSystemView.getFileSystemView();
	private static final File[] ROOTS 			 = File.listRoots();
	
	private DecimalFormat formatter;
	
	private JLabel os, ram, javaVersion, processors, username;
	private JLabel[] drives;
	private JPanel mainPanel;
	
	public ComputerSpecs()
	{
		super(TITLE);
		setLocationRelativeTo(null);
		setSize(WINDOW_WIDTH, WINDOW_LENGTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		formatter = new DecimalFormat("#,##0.00");
		
		mainPanel = new JPanel();
		os = new JLabel("Operating System: " + System.getProperties().getProperty("os.name"));
		processors = new JLabel("Number of Processor: " + Runtime.getRuntime().availableProcessors());
		ram = new JLabel("Available RAM: " + formatter.format(MathExtended.bytesToGB(Runtime.getRuntime().totalMemory())));
		javaVersion = new JLabel("Java Version: " + System.getProperty("java.version"));
		username = new JLabel("Username: " + System.getProperty("user.name"));
		
		drives = new JLabel[ROOTS.length];
		
		for(int i = 0; i < ROOTS.length; i++)
		{
			drives[i] = new JLabel("Drive " + ROOTS[i].getPath() + "'s Free Memory: "
						+ formatter.format(MathExtended.bytesToGB(ROOTS[i].getFreeSpace())) + "GB");
		}
		mainPanel.add(username);
		mainPanel.add(os);
		mainPanel.add(javaVersion);
		mainPanel.add(processors);
		mainPanel.add(ram);
		for(JLabel label: drives)
		{
			mainPanel.add(label);
		}
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		add(mainPanel);
		
		setJMenuBar(new BaseMenu(this));
		
		setVisible(true);
	}
}
