package utility;
/**
   These two classes represent exceptions
   thrown by the queue methods.
*/

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * 
 * @author Jackson Murrell on Nov 6, 2015
 */
class QueueOverFlowException extends RuntimeException
{    
	private static String message = "The queue receieved a value when it was full.";
	private static final long serialVersionUID = 4046758945206967105L;

	public QueueOverFlowException()
	{
		super(message);
	}
}
/**
 * 
 * @author Jackson Murrell on Nov 6, 2015
 */
class EmptyQueueException extends RuntimeException
{
	private static String message = "The queue retreieved a value when it was empty.";
	private static final long serialVersionUID = 3564322147061445209L;
	
	public EmptyQueueException()
	{
		super(message);
	}
}