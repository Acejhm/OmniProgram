package applications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Jackson Murrell on Jan 7, 2016
 */
public class ChatRoom extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -2817372688296599902L;
	
	protected ChatClient client;
	
	private JTextField input;
	protected JTextArea chatDisplay;
	private JPanel mainPanel, textPanel, buttonPanel;
	private JButton send, exit;
	private Thread clientThread;
	
	private static final short	WINDOW_LENGTH	= 400;
	private static final short	WINDOW_WIDTH	= 400;
	private static final String	TITLE			= "Chat Room";
	private static final short PORT = 8000;
	private static final byte INPUT_COLUMNS = 10;
	private static final byte TEXT_COLUMNS = 10;
	private static final byte TEXT_ROWS = 10;

	public ChatRoom()
	{
		super(TITLE);
		setLocationRelativeTo(null);
		setSize(WINDOW_WIDTH, WINDOW_LENGTH);
		addWindowListener(new ChatWindowListener(this));

		client = new ChatClient(this);
		
		mainPanel = new JPanel();
		textPanel = new JPanel();
		buttonPanel = new JPanel();
		input = new JTextField(INPUT_COLUMNS);
		chatDisplay = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		send = new JButton("Send");
		exit = new JButton("Exit");
		
		send.addActionListener(this);
		exit.addActionListener(this);
		
		textPanel.add(chatDisplay);
		
		buttonPanel.add(exit);
		buttonPanel.add(input);
		buttonPanel.add(send);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		
		mainPanel.add(textPanel);
		mainPanel.add(buttonPanel);
		
		add(mainPanel);
		
		setVisible(true);
		
		clientThread = new Thread(client);
		clientThread.start();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{
		if(action.getSource() == send)
		{
			System.out.println("Sent button pressed");
			client.send(input.getText());
		}
		else if(action.getSource() == exit)
		{
			client.close();
			dispose();
		}
	}
}
