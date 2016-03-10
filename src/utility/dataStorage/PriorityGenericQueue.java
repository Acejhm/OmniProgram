package utility.dataStorage;

/**
 * @author Jackson Murrell on Mar 1, 2016
 */
public class PriorityGenericQueue <T>
{
	private int size;
	private Node<?> first, last;

	public PriorityGenericQueue()
	{
		size = 0;
		first = null;
		last = null;
	}
	public PriorityGenericQueue(int priority, T value)
	{
		size = 1;
		first = new Node(value);
		last = first;
	}
	public int getSize()
	{
		return size;
	}
	public void enqueue(int priority, T value)
	{
		if(last != null)
		{
			Node<?> node = new Node<T>(value, priority);
			
			if(priority > first.getPriority())
			{
				node.setNext(first);
				first = node;
			}
			else if(priority < last.getPriority())
			{
				node.setPrevious(last);
				last = node;
			}
			else
			{
				Node<?> foundNode = findPriority(priority);
				node.setPrevious(foundNode);
				node.setNext(foundNode.getNext());
				foundNode.setNext(node);
			}
		}
		else
		{
			last = new Node<T>(value);
			first = last;
		}
		size++;
	}
	private Node<?> findPriority(int priority)
	{
		Node<?> node;
		
		if(priority <= 0)
		{
			node = last;
			while(node.getPriority() < priority)
			{
				node = node.getPrevious();
			}
		}
		else
		{
			node = first;
			while(node.getPriority() > priority)
			{
				node = node.getNext();
			}
		}
		return node;
	}
	public void enqueueArray(int priority, T[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			this.enqueue(priority, array[i]);
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
	public void printQueue()
	{
		Node<?> node = first;
		for(int i = 0; i < size; i++)
		{
			System.out.println("Value: " + node.getValue() + " Priority: " + node.getPriority() + " Size: " + size);
			node = node.getNext();
			if(node == null)
			{
				break;
			}
		}
		System.out.println("Value: " + last.getValue() + " Priority: " + last.getPriority() + " Size: " + size);
	}
	public String toString()
    {
       StringBuilder stringBuilder = new StringBuilder();
       
       // Walk down the list and append all values
       Node<?> p = first;
       while (p != null)
       {
           stringBuilder.append(p.value + " ");
           p = p.next;
       }
       return stringBuilder.toString();        
    }
	class Node <T>
	{
		private T value;
		private Node<?> next, previous;
		private int priority;
		
		public Node(T value)
		{
			next = null;
			previous = null;
			this.value = value;
			this.priority = 0;
		}
		public Node(T value, int priority)
		{
			this.next = next;
			this.value = value;
			this.priority = priority;
		}
		public Node()
		{
			next = null;
			this.value = null;
			this.priority = 0;
		}
		public void setValue(T value)
		{
			this.value = value;
		}
		public T getValue()
		{
			return value;
		}
		public Node getNext()
		{
			return next;
		}
		public void setNext(Node next)
		{
			this.next = next;
		}
		public void setPrevious(Node previous)
		{
			this.previous = previous;
		}
		public Node getPrevious()
		{
			return previous;
		}
		public void setPriority(int priority)
		{
			this.priority = priority;
		}
		public int getPriority()
		{
			return priority;
		}
	}
}
