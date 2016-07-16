package utility;

import java.util.ArrayList;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

/**
 * @author Jackson Murrell on Oct 16, 2015
 */
public final class MathExtended
{
	final static char PI_SYMBOL = '\u03C0';
	final static double BYTE_CONVERION = 1024.0;
	private static Expression equation = new Expression();
	/**
	 * Converts the given value of bytes into Gigabytes.
	 * @param bytes
	 * @return int1`	
	 */
	public static float bytesToGB(long bytes)
	{
		return (float)(((bytes/BYTE_CONVERION)/BYTE_CONVERION)/BYTE_CONVERION);	
	}
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
	public static double arcLengthXAxis(String function, double a, double b)
	{
		return new Expression("int(sqrt(1+(" + function + ")^2)), x, a, b").calculate();
	}
	/**
	 * Used internally for Riemman Sums
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
	public static void setEquation(String expression)
	{
		equation = new Expression(expression);
	}
	/**
	 * @param d
	 * @return
	 * @return int
	 */
	private static double equation(double xValue)
	{
		Argument x = new Argument("x", xValue);
		equation = new Expression(equation.getExpressionString(), x);
		return equation.calculate();
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
