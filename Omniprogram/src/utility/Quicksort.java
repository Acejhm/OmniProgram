/**
 * @author Jackson Murrell on Oct 4, 2015
 */
package utility;

/**
 * @author Jackson Murrell
 * @param <T>
 */
public class Quicksort<T extends Comparable>
{
	/**
	 * 
	 * @return void
	 * @param input
	 */
	public void printArray(T[] input)
	{
		for(T i:input)
		{
			System.out.println(i);
		}
	}
	/**
	 * This method recursively calls partition to sort the given array.
	 * @return: void
	 * @param array The String array to be sorted
	 * @param start The starting point for the sort (typically 0)
	 * @param end The ending point for the sort (typically array.length-1)
	 */
	public void quicksort(T[] array, int start, int end)
	{
		//System.out.println("start " + start + " end " +end);
		int pivot;
		
		if(start > end)
		{
			System.out.println("Start " + start + " end " +end);
			printArray(array);
		}
		//This facilitates the "base case" for the recursion.
		else if(start < end)
		{
			//Create the left and right partitions and swap the pivot value.
			pivot = partition(array, start, end);
			
			//Recursively "narrow down" the partitions until the above if statement is true.
			//One side is completed at a time, and once the first side is done, the original
			//call calls the second recursive loop.
			quicksort(array, start, pivot-1);
			quicksort(array, pivot+1, end);
		}
	}
	/**
	 * The partition method selects a pivot value in an array
     * and arranges the array into two sub lists. All the
     * values less than the pivot will be stored in the left
     * sub list and all the values greater than or equal to
     * the pivot will be stored in the right sub list.
	 * @param array The String array to be sorted
	 * @param start The starting point for the partition.
	 * @param end The end point for the partition.
	 * @return The subscript of the pivot once the sort finishes
	 */
	private int partition(T[] array, int start, int end) 
	{
		T pivot; 
		int mid;
		int endOfLeftList;
		
		mid = (start + end)/2;
		
		//printArray(array);
		
		swap(array, start, mid);
		
		pivot = array[start];
		//System.out.println("Pivot: " + pivot);
		endOfLeftList = start;
		
		for(int scan = start +1; scan <= end; scan++)
		{
			if(array[scan].compareTo(pivot) <= 0 )
			{
				endOfLeftList++;
				
				swap(array, endOfLeftList, scan);
				//printArray(array);
			}
		}
		//printArray(array);
		
		swap(array, start, endOfLeftList);
		
		return endOfLeftList;
	}
	   /**
	      The swap method swaps the contents of two elements
	      in an array.
	      @param The array containing the two elements.
	      @param a The subscript of the first element.
	      @param b The subscript of the second element.
	   */ 
	   private void swap(T[] array, int a, int b)
	   {
	      T temp = array[a];
	      array[a] = array[b];
	      array[b] = temp;
	   }
}