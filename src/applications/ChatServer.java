package applications;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author Jackson Murrell on Jan 11, 2016
 */
public class ChatServer extends Thread
{
	private ServerSocket serverSocket;
	private boolean keepRunning = true;
	private static final short PORT = 1337;

	 public static void main(String [] args)
	   {
	      Thread t = new ChatServer();
		  t.start();
	   }
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		try
        {
			serverSocket = new ServerSocket(PORT);
           System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
    	   Socket server = serverSocket.accept();
    	   System.out.println("Just connected to "
                   + server.getRemoteSocketAddress());
             DataInputStream input = new DataInputStream(server.getInputStream());
             DataOutputStream output = new DataOutputStream(server.getOutputStream());
           while(keepRunning  == true)
           { 
               output.writeUTF(input.readUTF());
           }
           server.close();
        }catch(SocketTimeoutException exception)
        {
           System.out.println("Socket timed out!");
        }catch(IOException e)
        {
           e.printStackTrace();
        }
	}
}
