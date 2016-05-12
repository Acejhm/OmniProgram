package applications.chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Jackson Murrell on Jan 20, 2016
 * This file contains several implemented classes to use as Runnable objects for the server threads.
 */
class InputRunnable implements Runnable
{
	private Socket socket;
	
	public InputRunnable(Socket socket)
	{
		this.socket = socket;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
//		try
//		{
//			//input = new DataInputStream(socket.getInputStream());
//			
//			//while(keepRunning  == true)
//			{ 
//			//	input.readUTF();
//			}	
//		}
//		//catch(IOException e)
//		{
//    	//	e.printStackTrace();
//	    }
	}
}
class OutputRunnable implements Runnable
{
	private Socket socket;
	
	public OutputRunnable(Socket socket)
	{
		this.socket = socket;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
//		try
//		{
//			output = new DataOutputStream(socket.getOutputStream());
//			while(keepRunning  == true)
//			{ 
//				output.writeUTF("");
//			}	
//		}
//		catch(IOException e)
//		{
//    		e.printStackTrace();
//	    }
	}
}
