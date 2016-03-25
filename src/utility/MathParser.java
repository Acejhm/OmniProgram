package utility;

import java.util.PriorityQueue;

import utility.dataStorage.PriorityGenericQueue;

/**
 * @author Jackson Murrell on Dec 5, 2015
 */
public class MathParser
{	
	
	private enum FunctionTokens
	{
		sin, cos, tan, cot, sec, csc
	}
	/**
	 * 
	 * @param equation
	 * @return double
	 */
	public double evaluate(String equation)
	{
		return solve(tokenize(equation));
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
