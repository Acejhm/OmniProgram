package applications;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import utility.MathExtended;

public class Calculator 
{
	public static void main(String[] args)
	{
		int n = 4;
		int a = 16;
		int b = 10;
		int k = 0;
		double deltaX = MathExtended.deltaX(a, b, n);
		double[] gridPoints = MathExtended.gridPoints(deltaX, n, a);
		
		System.out.println("Sum is: " + MathExtended.summation(k, n));
	}
}
