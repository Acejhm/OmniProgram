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
	 * Used internally
	 * @param a First point
	 * @param b Second point
	 * @param n The number of iterations/rectangles
	 * @return double
	 */
	private static double deltaX(double a, double b, int n)
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
	 * Used internally
	 * @param a First point
	 * @param b Second point
	 * @param n The number of iterations/rectangles
	 * @return double
	 */
	private static double[] gridPoints(double a, double b, int n)
	{
		double deltaX = deltaX(a,b,n);
		double[] gridPoints = new double[n+1];
		for(int i = 0; i <= n; i++)
		{
			gridPoints[i] = a+(i*deltaX);
		}
		return gridPoints;
	}
	/**
	 * 
	 * @param k The number to increment each time, and the starting number.
	 * @param n The number of times to sum.
	 * @return double
	 */
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
	/**
	 * Currently broken
	 * @param redValue
	 * @param blueValue
	 * @param greenValue
	 * @return String
	 */
	public static String convertRGBtoHexadecimal(short redValue, short blueValue, short greenValue)
	{
		StringBuilder string = new StringBuilder();
		final byte BASE_NUMBER = 16;
		int array[] = {redValue, greenValue, blueValue};
		int value;
		
		for(int i = 0; i < 3; i++)
		{ 
			value = array[i] - ((array[i]/BASE_NUMBER)*(BASE_NUMBER*10));
			
			if(value <= 9 && value >= 0)
			{
				string.append(value);
			}
			else
			{
				switch(value)
				{
				case 10: string.append('A'); break;
				case 11: string.append('B'); break;
				case 12: string.append('C'); break;
				case 13: string.append('D'); break;
				case 14: string.append('E'); break;
				case 15: string.append('F'); break;
				}
			}
			value = value - ((value/BASE_NUMBER)*(BASE_NUMBER*10));
			
			if(value <= 9 && value >= 0)
			{
				string.append(value);
			}
			else
			{
				switch(value)
				{
				case 10: string.append('A'); break;
				case 11: string.append('B'); break;
				case 12: string.append('C'); break;
				case 13: string.append('D'); break;
				case 14: string.append('E'); break;
				case 15: string.append('F'); break;
				}
			}
		}
		
		return string.toString();
	}
}
