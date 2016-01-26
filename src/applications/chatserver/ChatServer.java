package applications.chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

/**
 * @author Jackson Murrell on Jan 11, 2016
 */
public class ChatServer extends AbstractServerBlueprint
{
	private boolean keepRunning = true;
	
	//This is 10 seconds multiplied by a thousand so it is in milliseconds.
	private static final int DEFAULT_MAXIUM_WAIT = 10*1000;
	private static final int DEFUALT_MAXIUM_CONCURRENT_CONNECTIONS = 20;
	
	private	DataOutputStream output;
	private DataInputStream input;
	private ServerSocket serverSocket;
	private Thread inputThread, outputThread;
	private ArrayList<Client> connectionList;
	
	public ChatServer(short portNumber, String serverName)
	{
		try
		{
			this.portNumber = portNumber;
			this.serverName = serverName;
			serverSocket = new ServerSocket(portNumber);
			connectionList = new ArrayList<Client>();

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
		while(keepRunning == true)
		{
			System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
			Client client = acceptConnection();
			
			if(client == null)
			{
				System.out.println("Error connecting to client.");
			}
			else
			{
				client.start();
				connectionList.add(client);
				System.out.println("Just connected to " + client.getSocket().getLocalSocketAddress());
			}
		}
		close(DEFAULT_MAXIUM_WAIT);
	}
	/**
	 * @return Socket
	 */
	private Client acceptConnection()
	{
		try
		{
			return new Client(serverSocket.accept());
			
		} catch (IOException exception)
		{
			System.out.println("Client couldn't connect.");
			return null;
		}
	}
	public synchronized void close(int maxiumWait)
	{
		try
		{
			input.close();
			output.close();
			clientConnection.close();
			serverSocket.close();
			
		} catch (IOException exception)
		{
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
	}
	public synchronized void sendMessage(String messageToSend)
	{
		for(int index = 0; index < connectionList.size(); index++)
		{
			connectionList.get(index);
		}
	}
	public synchronized void disconnectClient(Client client)
	{
		if(client.getClientID() < 0)
		{
			System.out.println("Error, no clients left to disconnect.");
		}
		else
		{
			int index = (client.getHighestClientCount()-client.getUniqueID()) - connectionList.size();
			connectionList.remove(index);
		}
	}
	
}