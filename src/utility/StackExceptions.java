package utility;

/**
 * Called when there is nothing for the stack to pop and a pop request was made.
 * @author Jackson Murrell on Dec 8, 2015
 */
class EmptyStackException extends RuntimeException
{     
	public EmptyStackException()
	{
		super("There is nothing in the stack to pop.");
	}
}
