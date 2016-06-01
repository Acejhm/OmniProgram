package utility.equationparser;

import java.util.PriorityQueue;

import utility.dataStorage.PriorityGenericQueue;

/**
 * @author Jackson Murrell on Dec 5, 2015
 */
public class MathParser
{
	private static final char WHITE_SPACE = ' ', LEFT_PARENTHESIS = '(', RIGHT_PARENTHESIS = ')';
	
	//Initialize with some value so it can be used.
	//It gets changed in evaluate later.
	private static char variableToken = 0;
	
	private enum FunctionTokens
	{
		sin, cos, tan, cot, sec, csc
	}
	/**
	 * 
	 * @param equation
	 * @return double
	 */
	public static String evaluate(String equation, char variable)
	{
		variableToken = variable;
		String newEquation = eatWhiteSpace(equation);
		System.out.println("Built string: " + newEquation);
		System.out.println("Complexity: " + complexity(newEquation));
		//queueForSolving(newEquation, complexity(newEquation));
		return equation;
	}
	/**
	 * @return int
	 */
	private static int complexity(String equation)
	{
		final int LENGTH = equation.length();
		int leftCount = 0, rightCount = 0, complexity = 0, index = 0;
		char character;
		
		while(index < LENGTH)
		{
			character = equation.charAt(index);
			switch(character)
			{
			case LEFT_PARENTHESIS:
			{
				leftCount++;
				if(leftCount > rightCount)
					complexity++;
				break;
			}
			case RIGHT_PARENTHESIS:
			{
				rightCount++;
				break;
			}
				
			}
			index++;
		}
		return complexity;
	}
	/**
	 * 
	 * @param equation
	 * @return PriorityQueue<String>
	 */
	private static PriorityGenericQueue<Character> queueForSolving(String equation, int complexity)
	{
		PriorityGenericQueue<Character> queue = new PriorityGenericQueue<Character>();
		
		int priority = complexity;
		
		char character;
		int index = 0;
		final int LENGTH = equation.length();
		
		while(index < LENGTH)
		{
			character = equation.charAt(index);
			switch(character)
			{
			case '(': 
			{
				index++;
				while(character != ')')
				{
					character = equation.charAt(index);
					queue.enqueue(complexity, character);
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
