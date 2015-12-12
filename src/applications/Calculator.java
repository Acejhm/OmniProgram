package applications;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import utility.GenericLinkedQueue;
import utility.MathExtended;
import utility.MathParser;

public class Calculator 
{
	public static void main(String[] args)
	{
		GenericLinkedQueue <Double> numbersQueue = new GenericLinkedQueue <Double>();
		int n = 4;
		int a = 16;
		int b = 10;
		int k = 0;
		double deltaX = MathExtended.deltaX(a, b, n);
		double[] gridPoints = MathExtended.gridPoints(deltaX, n, a);
		
		numbersQueue.enqueue(3.0);
		System.out.println("size: " + numbersQueue.getSize());
		numbersQueue.enqueue(6.0);
		System.out.println("size: " + numbersQueue.getSize());
		numbersQueue.enqueue(4.5);
		System.out.println("size: " + numbersQueue.getSize());
		numbersQueue.dequeue();
		System.out.println("size: " + numbersQueue.getSize());
		numbersQueue.dequeue();
		System.out.println("size: " + numbersQueue.getSize());
		numbersQueue.dequeue();
		System.out.println("size: " + numbersQueue.getSize());
		
		System.out.println("Sum is: " + MathParser.parse("3+1"));
		
	}
}
