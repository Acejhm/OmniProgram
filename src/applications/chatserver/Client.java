package applications.chatserver;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Jackson Murrell on Jan 20, 2016
 */
public class Client extends Thread
{
	private Socket clientConnection;
	private boolean keepRunning = true;
	private int uniqueID;
	
	private static int clientID = -1;
	private static int highestClientCount = 0;
	
	public Client(Socket clientConnection)
	{
		this.clientConnection = clientConnection;
		uniqueID = ++clientID;
		highestClientCount++;
		setName("Client Thread " + uniqueID);
	}
	public Socket getSocket()
	{
		return clientConnection;
	}
	public int getHighestClientCount()
	{
		return highestClientCount;
	}
	public int getClientID()
	{
		return clientID;
	}
	public int getUniqueID()
	{
		return uniqueID;
	}
	@Override
	public void start()
	{
		System.out.println("Starting Client Thread...");
		while(keepRunning == true)
		{
			
		}
	}
	public void disconnect()
	{
		clientID--;
		try
		{
			clientConnection.close();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
