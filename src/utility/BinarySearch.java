
package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author Jackson Murrell
 */
public class BinarySearch 
{
	/**
    The search method performs a binary search on an array
    of type T. The array is searched for the number passed to
    value. If the number is found, its array subscript is
    returned. Otherwise, -1 is returned indicating the
    "value" was not found in the array.
    @param array The array to search.
    @param value The value to search for.
    @param ignoreCase Whether or not to ignoreCase in the event that T[] array is of type String[]
    @return int The position of the array in which the value was found.  -1 means the value wasn't found.
 */
	public static <T extends Comparable> int binarySearch(T[] array, T value, boolean ignoreCase)
	{
		//If the array in question is a string, case can matter for searching.
		//This string array will be used as a comparison to determine if
		//the T[] array is of type String[].
		String[] testString = new String[0];
		
		// First array element.
		int first = 0;      
	 
		//Last array element.
		int last = array.length-1; 
	      
		// Mid point of  the search.  This will get progressively smaller
		// as the loop continues.
		int middle = last/2;      
		
		// Position of the found value in the array.  A returned value of -1 will mean that
		// the value was not found at all.
		int position = -1;
		
		// Flag to stop the loop once the value has been found.
		boolean found = false;
		
		//Tests whether or not the array given is a string, otherwise, case won't matter.
		if(array.getClass() == testString.getClass())
		{
			// If the case is not-important, then search and ignore case.
			if(ignoreCase == true)
			{
				// This loop will repeatedly search for the value either until it is found or,
				// the whole array has been searched.
				while (!found && first <= last)
				{
					// If value is found at the midpoint, "raise the flag" and set the 
					// position equal to the middle.
					if (((String) array[middle]).compareToIgnoreCase((String) value) == 0)
					{
						found = true;
						position = middle;
					}
					// If the value to search for is less than the item in the middle,
					// examine the lower half.
					else if (((String) array[middle]).compareToIgnoreCase((String) value) > 0)
					{
						last = middle - 1;
					}
					// If the value to search for is less than the item in the middle,
					// examine the upper half.
					else
			    	{
						first = middle + 1;
			    	}
					// Calculate  the mid point again based off the new first and last values.
					middle = (first + last) / 2;
				}
			}
			// If the case does matter, search without ignoring case.
			else
			{
				// This loop will repeatedly search for the value either until it is found or,
				// the whole array has been searched.
				while (!found && first <= last)
				{
					// If value is found at the midpoint, "raise the flag" and set the 
					// position equal to the middle.
					if (array[middle].equals(value))
					{
						found = true;
						position = middle;
					}
					// If the value to search for is less than the item in the middle,
					// examine the lower half.
					else if (array[middle].compareTo(value) > 0)
					{
						last = middle - 1;
					}
					// If the value to search for is greater than the item in the middle,
					// examine the upper half.
					else
			    	{
						first = middle + 1;
			    	}
					// Calculate  the mid point again based off the new first and last values.
					middle = (first + last) / 2;
				}
			}
		}
		else
		{
			// This loop will repeatedly search for the value either until it is found or,
			// the whole array has been searched.
			while (!found && first <= last)
			{
				// If value is found at the midpoint, "raise the flag" and set the 
				// position equal to the middle.
				if (array[middle].compareTo(value) == 0)
				{
					found = true;
					position = middle;
				}
				// If the value to search for is less than the item in the middle,
				// examine the lower half.
				else if (array[middle].compareTo(value) < 0)
				{
					last = middle - 1;
				}
				// If the value to search for is greater than the item in the middle,
				// examine the upper half.
				else
		    	{
					first = middle + 1;
		    	}
				// Calculate  the mid point again based off the new first and last values.
				middle = (first + last) / 2;
			}
		}
		// Return the position of the item, or -1
		// if it was not found.
		return position;
		}
	/**
    The search method performs a binary search on an array
    of type T. The array is searched for the number passed to
    "value". If the number is found, its array subscript is
    returned. Otherwise, -1 is returned indicating the
    value was not found in the array.
    @param array The array to search.
    @param value The value to search for.
    @return int The position of the array in which the value was found.  -1 means the value wasn't found.
 */
	public static <T extends Comparable> int binarySearch(T[] array, T value)
	{
		// First array element.
		int first = 0;      
	 
		//Last array element.
		int last = array.length-1; 
	      
		// Mid point of  the search.  This will get progressively smaller
		// as the loop continues.
		int middle = last/2;      
		
		// Position of the found value in the array.  A returned value of -1 will mean that
		// the value was not found at all.
		int position = -1;
		
		// Flag to stop the loop once the value has been found.
		boolean found = false;
		
		// This loop will repeatedly search for the value either until it is found or,
		// the whole array has been searched.
		while (!found && first <= last)
		{
			// If value is found at the midpoint, "raise the flag" and set the 
			// position equal to the middle.
			if (array[middle].compareTo(value) == 0)
			{
				found = true;
				position = middle;
			}
			// If the value to search for is less than the item in the middle,
			// examine the lower half.
			else if (array[middle].compareTo(value) < 0)
			{
				last = middle - 1;
			}
			// If the value to search for is greater than the item in the middle,
			// examine the upper half.
			else
	    	{
				first = middle + 1;
	    	}
			// Calculate  the mid point again based off the new first and last values.
			middle = (first + last) / 2;
		}
		// Return the position of the item, or -1
		// if it was not found.
		return position;
	}
	/**
    The search method performs a binary search on a file.
    The file is searched for the number passed to
    "value". If the number is found, its line number is
    returned. Otherwise, -1 is returned indicating the
    value was not found in the file or that the file 
    could not be found.
    @param file The file to search.
    @param value The value to search for as a String.
    @param configFile Whether or not the file given should be treated as a configuration file.  If true, only the first string is read per line, if false, the whole line is read.
    @parm ignoreCase Determines if the case should be ignore in the search.
    @return long The position of the array in which the value was found.  -1 means the value wasn't found.
 */
	public static long binarySearch(File filePath, String value, boolean configFile, boolean ignoreCase) throws FileNotFoundException, IOException
	{
		RandomAccessFile file = null;
		long first; 
		long last;
		long middle;
		long position;
		
		try
		{
			file = new RandomAccessFile(filePath, "rw");
			first = 0;
			last = file.length();
			middle = last/2;
			position = file.getFilePointer();
			
			if(configFile == true)
			{
				if(ignoreCase == true)
				{
					if(file.readUTF().compareToIgnoreCase(value) == 0)
					{
						position = file.getFilePointer();
						file.close();
						return position;
					}
					while(first <= last)
					{
						file.seek(middle);
						if(file.readUTF().compareToIgnoreCase(value) == 0)
						{
							position = file.getFilePointer();
							file.close();
							return position;
						}
						else if(file.readUTF().compareToIgnoreCase(value) > 0)
						{
							last = middle - 1;
						}
						else
						{
							first = middle + 1;
						}
						middle = (first + last) / 2;
					}
				}
				else
				{
					if(file.readUTF().compareTo(value) == 0)
					{
						position = file.getFilePointer();
						file.close();
						return position;
					}
					while(first <= last)
					{
						file.seek(middle);
						if(file.readUTF().compareTo(value) == 0)
						{
							position = file.getFilePointer();
							file.close();
							return position;
						}
						else if(file.readUTF().compareTo(value) > 0)
						{
							last = middle - 1;
						}
						else
						{
							first = middle + 1;
						}
						middle = (first + last) / 2;
					}
				}
			}
			else
			{
				if(ignoreCase == true)
				{
					if(file.readLine().compareToIgnoreCase(value) == 0)
					{
						position = file.getFilePointer();
						file.close();
						return position;
					}
					while(first <= last)
					{
						file.seek(middle);
						if(file.readLine().compareToIgnoreCase(value) == 0)
						{
							position = file.getFilePointer();
							file.close();
							return position;
						}
						else if(file.readLine().compareToIgnoreCase(value) > 0)
						{
							last = middle - 1;
						}
						else
						{
							first = middle + 1;
						}
						middle = (first + last) / 2;
					}
				}
				else
				{
					if(file.readLine().compareTo(value) == 0)
					{
						position = file.getFilePointer();
						file.close();
						return position;
					}
					while(first <= last)
					{
						file.seek(middle);
						if(file.readLine().compareTo(value) == 0)
						{
							position = file.getFilePointer();
							file.close();
							return position;
						}
						else if(file.readLine().compareTo(value) > 0)
						{
							last = middle - 1;
						}
						else
						{
							first = middle + 1;
						}
						middle = (first + last) / 2;
					}
				}
			}
			file.close();
			return -1;
		} 
		catch (FileNotFoundException exception)
		{
			file.close();
			return -1;
		} 
		catch (IOException exception)
		{
			exception.printStackTrace();
			file.close();
			return -1;
		}
	}
	
}