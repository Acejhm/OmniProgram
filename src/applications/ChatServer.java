package applications;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Jackson Murrell on Jan 11, 2016
 */
public class ChatServer implements Runnable
{
	private static final short PORT = 1337;
	private ServerSocket server;
	private Socket socket;

	public ChatServer()
	{
		try
		{
			server = new ServerSocket(PORT);
		} catch (IOException exception)
		{
			exception.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		try
		{
			socket = server.accept();
			System.out.println("Accepted client connection");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
