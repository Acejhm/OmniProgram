package utility;

import java.util.ArrayList;

/**
 * @author Jackson Murrell on Oct 16, 2015
 */
public final class MathExtended
{
	final char PI_SYMBOL = '\u03C0';
	public static boolean isPrime(int input)
	{
		int divisor = 2;
		do
		{
			if((input % divisor) == 0)
				return false;
			divisor++;
		}
		while(divisor < input);
		return true;
	}
	public static ArrayList factor(int input)
	{
		int divisor = 2;
		int[] array;
		ArrayList <Integer> output = new ArrayList<Integer>();
		do
		{
			if((input % divisor) == 0)
			{
				output.add(divisor);
			}
			divisor++;
		}
		while(divisor < input);
		return output;
	}
	/**
	 * 
	 * @param a First point
	 * @param b Second point
	 * @param n The number of iterations/rectangles
	 * @return double
	 */
	public static double deltaX(double a, double b, int n)
	{
		return (b-a)/n;
	}
	/**
	 * 
	 * @param a First point
	 * @param b Second point
	 * @param n The number of iterations/rectangles
	 * @return double
	 */
	public static double leftRiemannSum(double a, double b, int n)
	{
		double deltaX = deltaX(a,b,n);
		double[] gridPoints = new double[n+1];
		double answer = 0;
		for(int i = 0; i <= n; i++)
		{
			gridPoints[i] = a+(i*deltaX);
		}
		for(int i = 0; i < n; i++)
		{
			answer += deltaX*equation(gridPoints[i]);
		}
		return answer;	
	}
	/**
	 * 
	 * @param a First point
	 * @param b Second point
	 * @param n The number of iterations/rectangles
	 * @return double
	 */
	public static double rightRiemannSum(double a, double b, int n)
	{
		double deltaX = deltaX(a,b,n);
		double[] gridPoints = new double[n+1];
		double answer = 0;
		for(int i = 0; i <= n; i++)
		{
			gridPoints[i] = a+(i*deltaX);
		}
		for(int i = 1; i <= n; i++)
		{
			answer += deltaX*equation(gridPoints[i]);
		}
		return answer;
	}
	/**
	 * 
	 * @param a First point
	 * @param b Second point
	 * @param n The number of iterations/rectangles
	 * @return double
	 */
	public static double midPointRiemannSum(double a, double b, int n)
	{
		double deltaX = deltaX(a,b,n);
		double[] gridPoints = new double[n+1];
		double answer = 0;
		for(int i = 0; i <= n; i++)
		{
			gridPoints[i] = a+(i*deltaX);
		}
		for(int i = 0; i < n; i++)
		{
			answer += deltaX*equation((gridPoints[i]+gridPoints[i+1])/2);
		}
		return answer;
	}
	/**
	 * 
	 * @param a First point
	 * @param b Second point
	 * @param n The number of iterations/rectangles
	 * @return double
	 */
	public static double[] gridPoints(double a, double b, int n)
	{
		double deltaX = deltaX(a,b,n);
		double[] gridPoints = new double[n+1];
		for(int i = 0; i <= n; i++)
		{
			gridPoints[i] = a+(i*deltaX);
		}
		return gridPoints;
	}
	public static double summation(double k, int n)
	{
		double answer = 0;
		
		while(k <= n)
		{
			System.out.println("K: " + k);
			answer += Math.sin(k*Math.PI/2);
			k++;
			System.out.println("Answer: " + answer);
		}
		return answer;
	}
	/**
	 * @param d
	 * @return
	 * @return int
	 */
	public static double equation(double x)
	{
		return (x+1);
	}
}
