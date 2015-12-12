package utility;

import java.util.Arrays;

/**
 * @author Jackson Murrell on Dec 7, 2015
 */
public class GenericStack <T extends Comparable>
{
	private T [] stackBody;
	private int topIndex;
	private int size;
	private final byte INITIAL_CAPACITY = 10;
	private final byte GROWTH_RATE = 2;
	
	public GenericStack()
	{
		stackBody = (T[]) new Object[INITIAL_CAPACITY];
		topIndex = -1;
		size = 0;
	}
	public GenericStack(int capacity)
	{
		stackBody = (T[]) new Object[capacity];
		topIndex = -1;
		size = 0;
	}
	public GenericStack(T value)
	{
		stackBody = (T[]) new Object[INITIAL_CAPACITY];
		push(value);
		topIndex = 0;
		size = 1;
	}
	public GenericStack(int capacity, T value)
	{
		stackBody = (T[]) new Object[capacity];
		push(value);
		topIndex = 0;
		size = 1;
	}
	/**
	 * @return boolean True if empty, false if not.
	 */
	public boolean isEmpty() { return size == 0; }
	   
	/**
	 * 
	 * @return int The current size of the stack.
	 */
	public int size() { return size; }

	/**
	 * 
	 * @param value
	 * @return void
	 */
	public void push(T value) 
	{
		if (topIndex > (size-1))
		{
			stackBody = Arrays.copyOf(stackBody, size*GROWTH_RATE);
		}
	    else
	    {
	    	stackBody[topIndex] = value;
	    	topIndex++;
	    }
	}
	/**
	 * 
	 * @return T
	 */
	   public T pop()
	   {
	       if (isEmpty())
	           throw new EmptyStackException();
	       else
	       {
	          T returnValue = stackBody[topIndex];
	          stackBody[topIndex] = null;
	          topIndex--;
	          return returnValue;
	       }
	   }
}
