package utility.equationparser;

import utility.dataStorage.PriorityGenericQueue;

/**
 * @author Jackson Murrell on Dec 5, 2015
 */
public class MathParser
{
	private static final char WHITE_SPACE = ' ', LEFT_PARENTHESIS = '(', RIGHT_PARENTHESIS = ')';
	
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
		
		//variableToken = variable;
		String newEquation = eatWhiteSpace(equation);
		PriorityGenericQueue<Character> queue = queueForSolving(newEquation, complexity(newEquation));
		
		StringBuilder builder = new StringBuilder();
		while(queue.getSize() != 0)
		{
			builder.append(queue.dequeue());
		}
		System.out.println("Queue for Solving String: " + builder.toString());
		
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
	private static void convertToPostFix(String equation)
	{
		PriorityGenericQueue<Character> queue = new PriorityGenericQueue<Character>();
		char character = equation.charAt(0);
		final byte BASE_PRIORITY = 0;
		
		for(int index = 0; index < equation.length(); index++)
		{
			switch(character)
			{
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			{
				queue.enqueue(character, BASE_PRIORITY);
				break;
			}
			}
		}
		
	}
	/**
	 * 
	 * @param equation
	 * @return PriorityQueue<String>
	 */
	private static PriorityGenericQueue<Character> queueForSolving(String equation, int complexity)
	{
		
		final byte BASE_PRIORITY = 0;
		
		char character;
		int index = 0;
		final int LENGTH = equation.length();
		
		while(index < LENGTH)
		{
			character = equation.charAt(index);
			//System.out.println("Character: " + character);
			switch(character)
			{
			case '(': 
			{
				index++;
				character = equation.charAt(index);
				do
				{
					System.out.println("Character in while: " + character + " Index: " + index);
					System.out.println("Complexity value: " + complexity);
					//queue.enqueue(character, complexity);
					index++;
					character = equation.charAt(index);
				}
				while(character != ')');
				complexity--;
				break;
			}
			default: 
			{
				//queue.enqueue(equation.charAt(index), BASE_PRIORITY);
				index++;
				break;
			}
			}
		}
		//return queue;
		return null;
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
