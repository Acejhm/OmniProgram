package applications;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import utility.MathExtended;
import utility.MathParser;
import utility.dataStorage.GenericLinkedQueue;
import utility.dataStorage.PriorityGenericQueue;

public class Calculator 
{
	public static void main(String[] args)
	{
		
		PriorityGenericQueue<Integer> queue = new PriorityGenericQueue<Integer>();
		
		System.out.println("Queueing 0, priority 0");
		queue.enqueue(0, 0);
		System.out.println("Queueing 1, priority 1");
		queue.enqueue(1, 1);
		queue.printQueue();
		System.out.println("Queueing -1, priority -1");
		queue.enqueue(-1, -1);
		queue.printQueue();
		System.out.println("Queueing 2, priority 2");
		queue.enqueue(2, 2);
		queue.printQueue();
		System.out.println("Queueing 3, priority 1");
		queue.enqueue(1, 3);
		queue.printQueue();
		System.out.println("Queueing 4, priority 0");
		queue.enqueue(0, 4);
		queue.printQueue();
		
	}
}
