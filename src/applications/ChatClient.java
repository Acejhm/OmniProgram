package applications;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Jackson Murrell on Jan 11, 2016
 */
public class ChatClient implements Runnable
{
	private static final String HOST = "localhost";
	private static final short PORT = 1337;
	private static boolean exit = false;
	
	Thread inputThread, outputThread;
	static Socket socket;
	DataInputStream input;
	DataOutputStream output;
	ChatRoom room;
	
	public ChatClient(ChatRoom room)
	{
		this.room = room;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		try
		{
			socket = new Socket(HOST, PORT);
			System.out.println("Connected");
			output = new DataOutputStream(socket.getOutputStream());
			input = new DataInputStream(socket.getInputStream());
			//Loop until exited.
			while(exit == false)
			{
				room.chatDisplay.append(input.readUTF());
			}
		}
		catch (UnknownHostException e)
		{
			System.out.println("Unable to connect to host: " + HOST);
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close()
	{
		try
		{
			exit = false;
			socket.close();
			output.close();
			input.close();
		} catch (IOException exception)
		{
			System.out.println("Error closing socket.");
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
	}
	public void send(String message)
	{
		//Create a new thread so that the client can receive messages while it's sending them.
		Thread thread = new Thread(new Runnable()
		{
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run()
			{
				try
				{
					System.out.println("Writing chars");
					output.writeUTF(message);
				} catch (IOException exception)
				{
					System.out.println("Error attempting to write: " + message + " to the server.");
					exception.printStackTrace();
				}	
			}
		});
		thread.start();
	}
	private void updateDisplay()
	{
		
	}
	
}
