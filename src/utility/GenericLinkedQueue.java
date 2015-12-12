package utility;

/**
 * @author Jackson Murrell on Dec 8, 2015
 */
public class GenericLinkedQueue <T>
{
	private int size;
	private Node<?> first, last;
	
	public GenericLinkedQueue()
	{
		size = 0;
		first = null;
		last = null;
	}
	public GenericLinkedQueue(T value)
	{
		size = 1;
		first = new Node<T>(value);
		last = first;
	}
	public int getSize()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return (size == 0);
	}
	/**
	 * 
	 * @param value The value to add to the queue.
	 * @return void
	 */
	public void enqueue(T value)
	{
		if (last != null)
		{
			Node<T> node = new Node<T>(value);
	        last.setNext(node);
	        last = node;
	    }
		else
	    {
			last = new Node<T>(value);
			first = last;
		}
		size++;
	}
	/**
	 * This will allow you to "cut" in line by adding a value directly to the front of the queue.
	 * @param value
	 * @return void
	 */
	public void priorityEnqueue(T value)
	{
		Node<T> temp = new Node<T>(value, first);
		temp.setNext(first);
		first = temp;
		size++;
	}
	public void enqueueArray(T[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			this.enqueue(array[i]);
		}
	}
	@SuppressWarnings("unchecked")
	public T dequeue()
	{
		T returnValue;
		if(first != null)
		{
			returnValue = (T) first.getValue();
			first = first.getNext();
			size--;
		}
		else
		{
			throw new EmptyQueueException();
		}
		return returnValue;
	}
	@SuppressWarnings("unchecked")
	public T peekFirst()
	{
		if(first != null)
		{
			return (T) first.getValue();
		}
		else
		{
			throw new EmptyQueueException();
		}
	}
	@SuppressWarnings("unchecked")
	public T peekLast()
	{
		if(last != null)
		{
			return (T) last.getValue();
		}
		else
			throw new NullPointerException();
	}
	public String toString()
    {
       StringBuilder stringBuilder = new StringBuilder();
       
       // Walk down the list and append all values
       GenericLinkedQueue<T>.Node<?> p = first;
       while (p != null)
       {
           stringBuilder.append(p.value + " ");
           p = p.next;
       }
       return stringBuilder.toString();        
    }
	/**
	 * 
	 * @author Jackson Murrell on Dec 8, 2015
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	private class Node <T>
	{
		private T value;
		private Node<?> next;
		
		public Node()
		{
			value = null;
			next = null;
		}
		public Node(T value)
		{
			this.value = value;
			next = null;
		}
		public Node(Node<?> next)
		{
			value = null;
			this.next = next;
		}
		public Node(T value, Node<?> next)
		{
			this.value = value;
			this.next = next;
		}
		public void setNext(Node<?> next)
		{
			this.next = next;
		}
		public void setValue(T value)
		{
			this.value = value;
		}
		public T getValue()
		{
			return value;
		}
		public Node<?> getNext()
		{
			return next;
		}
	}
}
