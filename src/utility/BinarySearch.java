
package utility;

/**
 * @author Jackson Murrell
 */
public class BinarySearch 
{
	/**
    The search method performs a binary search on an int
    array. The array is searched for the number passed to
    value. If the number is found, its array subscript is
    returned. Otherwise, -1 is returned indicating the
    value was not found in the array.
    @param <T>
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
 The search method performs a binary search on a String
 array. The array is searched for the String passed to
 value. If the String is found, it's array subscript is
 returned. Otherwise, -1 is returned indicating the
 value was not found in the array.
 @param array The array to search.
 @param value The value to search for.
 @param ignoreCase A boolean to determine whether to ignore case or not.
 @return int The index of the array in which the value was found.  -1 means the value wasn't found.
*/

public static int binarySearch(String[] array, String value, boolean ignoreCase)
{
	// First array element.
	int first = 0;      
 
	//Last array element.
	int last = array.length-1; 
      
	// Mid point of  the search.  This will get progressively smaller
	// as the loop continues.
	int middle = last/2;      
	
	// Position of the found value in the array.  This will be one less than the actual
	// value since the array starts at 0.  A returned value of -1 will mean that
	// the value was not found at all.
	int position = -1;
	
	// Flag to stop the loop once the value has been found.
	boolean found = false;   
	
	// If the case is not-important, then search and ignore case.
	if(ignoreCase == true)
	{
		// This loop will repeatedly search for the value either until it is found or,
		// the whole array has been searched.
		while (!found && first <= last)
		{
			// If value is found at the midpoint, "raise the flag" and set the 
			// position equal to the middle.
			if (array[middle].compareToIgnoreCase(value) == 0)
			{
				found = true;
				position = middle;
			}
			// If the value to search for is less than the item in the middle,
			// examine the lower half.
			else if (array[middle].compareToIgnoreCase(value) > 0)
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
	// Return the position of the item, or -1
	// if it was not found.
	return position;
	}
}
