package utility;

/**
 * 
 * @author Jackson Murrell on Nov 5, 2015
 * @param <T>
 */
public class LinkedQueue <T extends Comparable>
{
	private Node front, rear;
	private int size;
	
	public LinkedQueue()
	{
		front = null; 
		rear = null;
		size = 0;
	}
	/**
	 * 
	 * @param input
	 */
	public LinkedQueue(T input)
	{
		front = new Node(input);
		rear = front;
		size = 1;
	}

	/**
	 * 
	 * @param value The value to add to the queue.
	 * @return void
	 */
	public void enqueue(T value)
	{
		if (rear != null)
		{
			Node node = new Node(value);
	        rear.setNext(node);
	        rear = node;
	    }
		else
	    {
			rear = new Node(value);
			front = rear;
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
		Node temp = new Node(value, front);
		front = temp;
		size++;
	}
	public int getSize()
	{
		return size;
	}
	/**
	 * 
	 * @return boolean
	 */
	public boolean isEmpty()
    {
        return front == null;
    }
	/**
	 * 
	 * @return T The value of the first "node" in the queue.
	 */
	@SuppressWarnings("unchecked")
	public T peek()
    {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return (T) front.getValue();        
    }
	/**
	 * 
	 * @return T
	 */
	@SuppressWarnings("unchecked")
	public T dequeue()
    {
       if (isEmpty()) 
           throw new EmptyQueueException();
       else
       {
    	   T value = (T) front.getValue();
           front = front.getNext();
           if (front == null) 
        	   rear = null;
           size--;
           return value;
       }
    }
	/**
	 * I started to make a double-linked queue before I realized that, for a queue, that would be kind of pointless.  
	 * I decided to leave the Node class code in anyways, since it being here won't hurt.  Previous will just be a null value.
	 * @author Jackson Murrell on Nov 5, 2015
	 * @param <T>
	 */
	private class Node <T extends Comparable>
	{
		private T value;
        private Node next, previous;
        
        /**
         * 
         * @param value The value, of type T, to store in the node object.
         * @param next The memory location of the next node in the "chain".
         * @param previous The memory location of the previous node in the "chain".
         */
        Node(T value, Node next, Node previous)
        {
            this.value = value; 
            this.next = next;
            this.previous = previous;
        }
        /**
         * 
         * @param value The value, of type T, to store in the node object.
         * @param next The memory location of the next node in the "chain".
         */
        Node(T value, Node next)
        {
        	this.value = value; 
            this.next = next;
            this.previous = null;
        }
        /**
         * 
         * @param value The value, of type T, to store in the node object.
         * @param previous The memory location of the previous node in the "chain".
         */
        Node(Node previous, T value)
        {
        	this.value = value; 
            this.next = null;
            this.previous = previous;
        }
        /**
         * 
         * @param value The value, of type T, to store in the node object.
         */
        Node(T value)
        {
        	this.value = value; 
            this.next = null;
            this.previous = null;
        }
        /**
         * 
         * @return T
         */
		public T getValue()
		{
			return value;
		}
		/**
		 * 
		 * @return Node
		 */
        public Node getNext()
        {
        	return next;
        }
        /**
         * 
         * @param next
         * @return void
         */
        public void setNext(Node next)
        {
        	this.next = next;
        }
        /**
         * 
         * @return Node
         */
        public Node getPrevious()
        {
        	return previous;
        }
        /**
         * 
         * @param previous
         * @return void
         */
        public void setPrevious(Node previous)
        {
        	this.previous = previous;
        }
	}
}
