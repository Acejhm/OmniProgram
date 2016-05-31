package utility.equationparser;

import java.util.PriorityQueue;

import utility.dataStorage.PriorityGenericQueue;

/**
 * @author Jackson Murrell on Dec 5, 2015
 */
public class MathParser
{
	private static final char WHITE_SPACE = ' ';
	private enum FunctionTokens
	{
		sin, cos, tan, cot, sec, csc
	}
	/**
	 * 
	 * @param equation
	 * @return double
	 */
	public static String evaluate(String equation)
	{
		return eatWhiteSpace(equation);
	}
	/**
	 * 
	 * @param equation
	 * @return PriorityQueue<String>
	 */
	private PriorityGenericQueue<String> tokenize(String equation)
	{
		PriorityGenericQueue<String> queue = new PriorityGenericQueue<String>();
		
		char character;
		int index = 0;
		
		while(index < equation.length())
		{
			character = equation.charAt(index);
			switch(character)
			{
			case '(': 
			{
				while(character != ')')
				{
					character = equation.charAt(index);
					
					index++;
				}
			}
			}
		}
		return queue;
	}
	/**
	 * This is simply a utility method that re-creates the given string
	 * without any white space.
	 * @param equation The string/equation to eat the whitespace from.
	 * @return String A string/equation without any whitespace.
	 */
	private static String eatWhiteSpace(String equation)
	{
		StringBuilder stringBuilder = new StringBuilder();
		char character;
		
		for(int index = 0; index < equation.length(); index++)
		{
			character = equation.charAt(index);
			
			if(equation.charAt(index) != WHITE_SPACE)
				stringBuilder.append(character);
		}
		return stringBuilder.toString();
	}
	/**
	 * @param tokenize
	 * @return
	 * @return double
	 */
	private double solve(PriorityGenericQueue<String> tokenize)
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
