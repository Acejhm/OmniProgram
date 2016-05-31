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
	public static <T> void printArray(T[] input)
	{
		for(T i:input)
		{
			System.out.println(i);
		}
	}
	public static char[] tokenizeString(String string)
	{
		char[] charArray = new char[string.length()];
		
		for(int i = 0; i < string.length(); i++)
		{
			charArray[i] = string.charAt(i);
		}
		return charArray;
	}
//	public static String[] tokenizeString(String string, String regex)
//	{
//		int minimumLength = regex.length();
//		String[] stringArray;
//		
//		for(int i = 0; i < string.length(); i++)
//		{
//			stringArray[i] = string.(i);
//		}
//		return stringArray;
//	}
}
