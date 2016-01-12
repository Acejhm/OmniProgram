package applications;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import launcher.ClockRunnable;

/**
 * @author Jackson Murrell on Jan 11, 2016
 */
public class ChatClient
{
	Socket socket;
	public ChatClient()
	{
		Thread thread = new Thread(new ChatServer());
		thread.start();
		try
		{
			socket = new Socket("localhost", 1337);
			System.out.println("Connected");
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
