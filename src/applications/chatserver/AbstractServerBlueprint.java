package applications.chatserver;

import java.net.Socket;

/**
 * @author Jackson Murrell on Jan 20, 2016
 */
public abstract class AbstractServerBlueprint implements Runnable
{
	Socket clientConnection;
	short portNumber;
	String	serverName;

	public AbstractServerBlueprint()
	{
		
	}
}
