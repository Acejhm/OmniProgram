package applications.chatserver;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Jackson Murrell on Jan 18, 2016
 */
public class ChatServerGUI extends JFrame implements ActionListener
{

	private static final long serialVersionUID = -8173589077530348847L;

	private static final short	WINDOW_LENGTH	= 300;
	private static final short	WINDOW_WIDTH	= 400;
	private static final String	TITLE			= "Chat Room Server";
	private static final String	DEFUALT_PORT	= "1337";
	private static final String	DEFUALT_NAME	= "Java Chat";
	private static final byte	FIELD_LENGTH	= 5;
	private static final byte	VERTICAL_SPACE	= 10;
	private static final byte 	MAXIUM_WAIT		= 10;

	private short portNumber;
	private String serverName;
	
	private JPanel mainPanel, buttonPanel, textPanel, fieldPanel, separatorPanel;
	private JButton start, exit;
	private JTextField port, name;
	private JLabel portLabel, nameLabel;
	private JSeparator separator;
	private Thread serverThread;
	private ChatServer server;
	
	public ChatServerGUI()
	{
		super(TITLE);
		setLocationRelativeTo(null);
		setSize(WINDOW_WIDTH, WINDOW_LENGTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		fieldPanel = new JPanel();
		textPanel = new JPanel();
		separatorPanel = new JPanel();
		
		separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
		
		start = new JButton("Start Server");
		start.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		name = new JTextField(DEFUALT_NAME, FIELD_LENGTH);
		port = new JTextField(DEFUALT_PORT, FIELD_LENGTH);
		
		portLabel = new JLabel("Enter the desired port:");
		nameLabel = new JLabel("Enter the desired server name:");
		
		fieldPanel.add(portLabel);
		fieldPanel.add(port);
		fieldPanel.add(nameLabel);		
		fieldPanel.add(name);
		
		fieldPanel.setLayout(new GridLayout(fieldPanel.getComponentCount(),1));
		
		buttonPanel.add(start);
		buttonPanel.add(exit);
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		mainPanel.add(Box.createVerticalStrut(VERTICAL_SPACE));
		mainPanel.add(fieldPanel);
		mainPanel.add(Box.createVerticalStrut(VERTICAL_SPACE));
		mainPanel.add(separator);
		mainPanel.add(Box.createVerticalStrut(VERTICAL_SPACE));
		mainPanel.add(buttonPanel);
		mainPanel.add(Box.createVerticalStrut(VERTICAL_SPACE));
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		add(mainPanel);
		setVisible(true);
	}
	/**
	 * Initialize the GUI.
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				new ChatServerGUI();
			}
		});
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{
		if(action.getSource() == start)
		{
			try
			{
				portNumber = Short.parseShort(port.getText());
				serverName = name.getText();
				server = new ChatServer(portNumber, serverName);
				serverThread = new Thread(server);
			}
			catch(NumberFormatException exception)
			{
				JOptionPane.showMessageDialog(null, "You enetered an invalid character into the \"port\" field.\nOnly numbers are allowed.", "Invalied Character", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(action.getSource() == exit)
		{
			try
			{
				server.close(MAXIUM_WAIT);
				serverThread.join(MAXIUM_WAIT);
			}
			catch(NullPointerException exception)
			{
				//If the server wasn't created first, a NullPointerException will be thrown.
			} catch (InterruptedException exception)
			{
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			dispose();
		}
	}
}