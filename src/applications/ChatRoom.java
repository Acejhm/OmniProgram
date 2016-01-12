package applications;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Jackson Murrell on Jan 7, 2016
 */
public class ChatRoom extends JFrame
{
	private static final long serialVersionUID = -2817372688296599902L;
	
	ChatClient client;
	
	private JTextField input;
	private JTextArea chatDisplay;
	private JPanel mainPanel, textPanel;
	
	private static final short	WINDOW_LENGTH	= 400;
	private static final short	WINDOW_WIDTH	= 400;
	private static final String	TITLE			= "Chat Room";
	private static final short PORT = 8000;

	public ChatRoom()
	{
		super(TITLE);
		setLocationRelativeTo(null);
		setSize(WINDOW_WIDTH, WINDOW_LENGTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		client = new ChatClient();
		setVisible(true);
	}
}
