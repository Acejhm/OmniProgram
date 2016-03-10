package utility.dataStorage;

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
/**
 * Called when there is nothing for the stack to pop and a pop request was made.
 * @author Jackson Murrell on Dec 8, 2015
 */
class EmptyStackException extends RuntimeException
{     
	private static final long serialVersionUID = -5177094122437368003L;

	public EmptyStackException()
	{
		super("There is nothing in the stack to pop.");
	}
}
class ParserException extends IllegalArgumentException
{
	private static final long serialVersionUID = 883194048637454680L;

	public ParserException()
	{
		super("Parser received an invalid value.");
	}
	public ParserException(String message)
	{
		super(message);
	}
}
