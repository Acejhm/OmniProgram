package utility;

/**
 * @author Jackson Murrell on Oct 16, 2015
 */
public class Output 
{
	/**
	 * 
	 * @return void
	 * @param input
	 */
	public <T> void printArray(T[] input)
	{
		for(T i:input)
		{
			System.out.println(i);
		}
	}
}
