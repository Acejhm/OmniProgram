package applications.chatclient;

import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

/**
 * @author Jackson Murrell on Nov 26, 2015
 */
public class ChatWindowListener extends WindowAdapter
{
	ChatRoom room;
	public ChatWindowListener(ChatRoom room)
	{
		this.room = room;
	}
	 @Override
	 public void windowClosing(java.awt.event.WindowEvent windowEvent)
	 {
		room.dispose();
		room.client.close();
	 }
	 
}
