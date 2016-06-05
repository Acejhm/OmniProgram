package utility.dataStorage;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Jackson Murrell on Mar 1, 2016
 */
public class PriorityGenericQueue <T>
{
	private final byte BASE_PRIORITY = 0;
	private int size;
	private Node<?> first, last;

	public PriorityGenericQueue()
	{
		size = 0;
		first = null;
		last = null;
	}
	public PriorityGenericQueue(T value)
	{
		size = 1;
		first = new Node<T>(value, BASE_PRIORITY, null);
		first.setPrevious(null);
		last = first;
	}
	public PriorityGenericQueue(T value, int priority)
	{
		size = 1;
		first = new Node<T>(value, priority, null);
		first.setPrevious(null);
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
	public void enqueue(T value, int priority)
	{
		if(last != null)
		{
			Node<?> node = new Node<T>(value, priority);
			
			if(priority > first.getPriority())
			{
				node.setNext(first);
				first.setPrevious(node);
				node.setPrevious(null);
				first = node;
			}
			else if(priority < last.getPriority())
			{
				node.setPrevious(last);
				last.setNext(node);
				last = node;
			}
			else
			{
				Node<?> foundNode = findPriority(priority);
				
				if(foundNode.getNext() == null)
				{
					foundNode.setNext(node);
					node.setPrevious(foundNode);
					node.setNext(null);
					last = node;
				}
				else
				{
					node.setPrevious(foundNode);
					node.setNext(foundNode.getNext());
					foundNode.setNext(node);
				}
			}
		}
		else
		{
			last = new Node<T>(value, priority, null);
			last.setPrevious(null);
			first = last;
		}
		size++;
	}
	private Node<?> findPriority(int priority)
	{
		Node<?> node;
		int midpoint = first.getPriority();
		
		if(priority <= midpoint)
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
			while(node.getPriority() >= priority && node.getNext() != null)
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
			this.enqueue(array[i], priority);
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
	public void printQueue(PrintStream printStream)
	{
		Node<?> node = first;
		for(int i = 0; i < size; i++)
		{
			printStream.println("Value: " + node.getValue() + " Priority: " + node.getPriority() + " Size: " + size);
			node = node.getNext();
			if(node == null)
			{
				break;
			}
		}
		printStream.close();
	}
	public String toString(boolean addSpacing)
    {
       StringBuilder stringBuilder = new StringBuilder();
       
       // Walk down the list and append all values
       Node<?> node = first;
       
       if(addSpacing == true)
       {
    	   for(int i = 0; i < size; i++)
           {
               stringBuilder.append(node.getValue() + " ");
               node = node.getNext();
           }
       }
       else
       {
    	   for(int i = 0; i < size; i++)
           {
               stringBuilder.append(node.getValue());
               node = node.getNext();
           }
       }
      
       return stringBuilder.toString();        
    }
	@SuppressWarnings("hiding")
	class Node<T>
	{
		private T value;
		private Node<?> next, previous;
		private int priority;
		
		public Node()
		{
			next = null;
			this.value = null;
			this.priority = 0;
		}
		public Node(T value)
		{
			next = null;
			previous = null;
			this.value = value;
			this.priority = 0;
		}
		public Node(T value, int priority)
		{
			this.value = value;
			this.priority = priority;
		}
		public Node(T value, int priority, Node<?> next)
		{
			this.next = next;
			this.value = value;
			this.priority = priority;
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
		public void setNext(Node<?> next)
		{
			this.next = next;
		}
		public void setPrevious(Node<?> previous)
		{
			this.previous = previous;
		}
		public Node<?> getPrevious()
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
