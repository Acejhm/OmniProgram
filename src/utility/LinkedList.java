package utility;

/**
 * This is a custom implementation of a LinkedList.
 * @author Jackson Murrell on Oct 13, 2015
 * @param <T> Functions as a generic marker to specify that a variable IS-A type T.
 * 
 */
public class LinkedList <T extends Comparable>
{
	//Class-wide variables such as the head node reference
	//and the amount of items in the list.
	private Node head;
	private int listCount;
	
	/**
	 * Constructor which creates the head node with no initial data.
	 * The listCount is set to 0.
	 */
	public LinkedList()
	{
		head = new Node(null);
		listCount = 0;
	}
	/**
	 * Constructor which creates the head node with a specified value.
	 * The listCount is set to 1.
	 * @param input The data to store in the head node.
	 */
	public LinkedList(T input)
	{
		head = new Node(input);
		listCount = 1;
	}
	/**
	 * Appends the data to the end of the list.
	 * @return void
	 * @param data The information to be stored
	 */
	public void append(T data)
	{
		//Create the new Node with the desired data.
		Node temp = new Node(data);

		Node current = iterate(listCount-1);
		//Set the last node's "next" reference to be the new node.
		current.setNext(temp);
		
		//Increment listCount.
		listCount++;
	}
	/**
	 * Inserts the data at the specified index.
	 * @return boolean True if the node was added successfully, false if not.
	 * @param data The information to be stored.
	 * @param index The location in the list to store the data.
	 */
	public boolean addAt(T data, int index)
	{		
		Node current = iterate(index);
		
		if(current == null)
		{
			return false;
		}
		//Set the new Node's "next" value to be the current node's "next" value,
		//and creates the new Node with the desired data.
		Node temp = new Node(data, current.getNext());
		
		//Set the current node's "next" value to be the new node.
		current.setNext(temp);
		
		//Increment listCount.
		listCount++;
		return true;
	}
	/**
	 * Returns the data value at the specified target index.
	 * @return Object
	 * @param index The list location of the data to return.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T getDataAt(int index)
	{	
		Node current = iterate(index);
		
		//Once the index has been reached, return the data at that point.
		return (T) current.getData();
	}
	/**
	 * Removes the node at the specified list element.
	 * @return boolean Whether or not the node was removed successfully.
	 * @param index The target node to remove.
	 * @return
	 */
	public boolean removeAt(int index)
	{
		Node current = iterate(index);
		
		if(current == null)
		{
			return false;
		}
		//This will get the object reference for the next node, and then retrieve that node's next value.
		//Essentially, it is "skipping over" the target node.
		current.setNext(current.getNext().getNext());
		
		//The node itself is not actually deleted in code.
		//Since it isn't being referenced by anything, it is considered "garbage" and is eventually 
		//destroyed by the JVM's garbage collector.
		
		//Decrement listCount
		listCount--;
		return true;
	}
	public boolean removeValue(T value)
	{
		Node current = iterate(value);
		
		if(current == null)
		{
			return false;
		}
		//This will get the object reference for the next node, and then retrieve that node's next value.
		//Essentially, it is "skipping over" the target node.
		current.setNext(current.getNext().getNext());
		return false;
	}
	public void removeAll()
	{
		head.setNext(null);
	}
	/**
	 * 
	 * @return int The size of the LinkedList.
	 */
	public int size()
	{
		return listCount;
	}
	/**
	 * Check whether or not the LinkedList is empty.
	 * @return boolean True if it is empty, false if it is not.
	 */
	public boolean isEmpty()
	{
		if(head == null && head.getNext() == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * This iterates through the LinkedList until it hits the end or the target index.
	 * @return Node A reference to the target node at the index.  If some sort of error occurred, or there is no reference, it returns null.
	 * @param index The target location of a node.
	 */
	private Node iterate(int index)
	{
		try
		{
			if(index <= 0)
			{
				return null;
			}
			Node current = head;
			//Iterate through the whole list until you arrive at the target index.
			for(int i = 1; i < index; i++)
			{
				if(current.hasNext())
					return null;
				
				current = current.getNext();
			}
			return current;
		}
		catch(IndexOutOfBoundsException exception)
		{
			return null;
		}
	}
	/**
	 * 
	 * @return Node
	 */
	private Node iterate(T value)
	{
		try
		{
			Node current = head;
			
			//Iterate through the whole list until you arrive at the target index.
			while(current.hasNext())
			{
				if(value.compareTo(current.getData()) == 0)
				{
					return current;
				}
			}
			return null;
			
		}
		catch(IndexOutOfBoundsException exception)
		{
			return null;
		}
	}
	private class Node <T>
	{
		//The reference to the next node in the link/chain.
		Node next;
		
		//A variable carrying type "T" data.
		T data;
		
		/**
		 * Sets the next value to null, and initializes data.
		 * @param data The information to store in the node.
		 */
		public Node(T data)
		{
			next = null;
			this.data = data;
		}
		
		/**
		 * Checks whether or not the node has a next value.
		 * @return boolean
		 */
		public boolean hasNext() 
		{
			if(next == null)
				return true;
			else
				return false;
		}

		/**
		 * Sets the next value to a specific node, and initializes data.
		 * @param data The information to store in the node.
		 * @param next The node to set as the next node.
		 */
		public Node(T data, Node next)
		{
			this.next = next;
			this.data = data;
		}
		
		// these methods should be self-explanatory
		public T getData()
		{
			return data;
		}
		
		public void setData(T _data)
		{
			data = _data;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node _next)
		{
			next = _next;
		}
	}
}
