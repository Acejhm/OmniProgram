package applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utility.equationparser.MathParser;

public class Calculator 
{
	public Calculator() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("Built string: " + MathParser.evaluate(reader.readLine()));
		
	}
}
