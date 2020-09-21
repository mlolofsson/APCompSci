/* Name: Michelle Olofsson
 * Lab: Sorts Lab
 * Block: H
 * Description: Test different sorting methods 
 */
//********************************************************************
//  Sorts.java       Author:
//
//  A collection of methods for sorting Arrays.
//********************************************************************
import java.util.Random; 
 public class Sorts
{
    
	private static int[] temp;
	
	public static int Insertion(int[] list, int icount, boolean flag)
    {
		for (int n = 1; n < list.length; n++)
		{
			// Save the next element to be inserted:
			
			int listTemp = list[n];
			
			if(!flag) {
				icount++; //count move of list[n] to listTemp
			}
			
			// Going backward from list[n-1], shift elements to the
			//   right until you find an element list[i] <= aTemp:

			int i = n;
			if(i>0 && listTemp >=list[i-1]) { // because later it compares in while loop but only enters if true, still need to count comparisons 
				if(flag) {
					icount++; // count comparison of temp to list
				}
			}
			while (i > 0 && listTemp<list[i-1])
			{
				if(flag) {
				icount++; // count comparison of listTemp to list
				}
				
				list[i] = list[i-1];
				
				if(!flag){
					icount++; // count move of list[i-1] to list[i]
				}
				i--;		
				
			}
			
			// Insert the saved element after a[i]:
			list[i] = listTemp;
			
			if(!flag) {
				icount++; // count move of listTemp to list[i]
			}
			
			// Increment n (accomplished by n++ in the for loop).
		}
        return icount;
    }
	
    
    public static int Selection(int[] list, int scount, boolean flag)
    {
		for (int n = list.length; n > 1; n--)
		{
			// Find the index iMax of the largest element
			//   among list[0], ..., list[n-1]:
			
			int iMax = 0;
			for (int i = 1; i < n; i++)
			{
				if (list[i] > list[iMax]) {
					iMax = i;
					
					
				}
				if(flag) {
					scount++; // count comparison of list[i] to list[iMax]
				}
			}
			
			swap(list, iMax, n-1);
			
			if(!flag) {
				scount=scount+3; // count the 3 moves in swap method above
			}
			
			// int listTemp = list[iMax];
			// list[iMax] = list[n-1];
			// list[n-1] = listTemp;
			
			// Decrement n (accomplished by n-- in the for loop).
		}
        return scount;
    }

    public static int Merge(int[] list, int from, int middle, int to, int mcount, boolean flag)
    {
		temp = new int[list.length];
		int i = from, j = middle + 1, k = from;
		
		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to)
		{
			if (list[i] < list[j])
			{
				if(flag) {
				mcount++; // count comparison of list[i] to list[j]
				}
				
				temp[k] = list[i];   // Or simply temp[k] = a[i++];
				if(!flag) {
					mcount++; // count move of list[i] to temp[k]
				}
				i++;
			}
			else
			{
				if(flag) {
				mcount++; // count comparison of list[i] to list[j]
				}
				
				temp[k] = list[j];
				
				if(!flag) { 
					mcount++; // count move of list[j] to temp[k]
				}
				j++;
			}
			k++;
			
			
		}
		
		// Copy the tail of the first half, if any, into temp:
		while (i <= middle)
		{
			temp[k] = list[i];     // Or simply temp[k++] = a[i++]
			if(!flag) {
				mcount++; // count move of list[i] to temp[k]
			}
			i++;
			k++;
		}
		
		// Copy the tail of the second half, if any, into temp:
		while (j <= to)
		{
			temp[k] = list[j];     // Or simply temp[k++] = a[j++]
			if(!flag) {
				mcount++; // count move of list[j] to temp[k] 
			}
			j++;
			k++;
		}
		
		// Copy temp back into a
		for (k = from; k <= to; k++) {
			list[k] = temp[k];
			if(!flag) {
				mcount++; // count move of temp[k] to list[k]
			}
		}
		return mcount;

    }
    
	
	public static int mergeSort(int[] list, int from, int to, int mcount, boolean flag)
	{
		if (to - from < 2)       // Base case: 1 or 2 elements
		{
			if(to>from && list[to] > list[from]) {

				if(flag) {
					mcount++; // count comparison of list[from] to list[to]
				}
			}
			if (to > from && list[to] < list[from])
			{
				if(flag) {
					mcount++; // count comparison of list[from] to list[to]
				}
				
				int listTemp = list[to];  // swap a[to] and a[from]
				list[to] = list[from];
				list[from] = listTemp;
				
				if(!flag) {
					mcount = mcount+3; // count 3 moves in above swap
				}
			}
		}
		else                     // Recursive case
		{
			int middle = (from + to) / 2;
			mcount = mergeSort(list, from, middle, mcount, flag);
			mcount = mergeSort(list, middle + 1, to, mcount, flag);
			mcount = Merge(list, from, middle, to, mcount, flag);
		}
		return mcount;
	}
	
    public static int QuickSort(int[] list, int from, int to, int qcount, boolean flag)
    {
		if (from >= to) {
			return qcount;
		}
		
		// Choose pivot list[p]:
		int p = from;
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.
		
		// Partition:
		
		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p]) {
				i++;
				if(flag) {
				qcount++; //comparison of list[p] to list[i]
				}
			}
			else if (list[j] >= list[p]) {
				j--;
				if(flag) {
					qcount++; //comparison of list[p] to list[i]
					}
			}
			else
			{
				
				if(flag) {
					qcount++; //comparison of list[p] to list[i]
					}
				swap (list, i, j); 
				if(!flag) {
					qcount = qcount+3; //3 moves happen in above swap
					
				}
				i++;
				j--;
			}
			
		}
		
		// Finish partitioning:
		
		if (p < j)    // place the pivot in its correct position
		{
			
			swap (list, j, p); 
			if(!flag) {
				qcount = qcount+3; //3 moves happen in above swap
				
			}
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p); 
			if(!flag) {
				qcount = qcount+3; //3 moves happen in above swap
				
			}
			p = i;
		}
		
		
		// Sort recursively:
		qcount = QuickSort(list, from, p - 1, qcount, flag);
		qcount = QuickSort(list, p + 1, to, qcount, flag);
		
		
		return qcount; 
	}
    
    public static int QuickMid(int[] list, int from, int to, int qmiddle)
    {
    	if (from >= to)
			return qmiddle;
		
		// Choose pivot list[p]:
		int p = from + (to-from)/2;
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.
		
		// Partition:
		
		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p]) {
				i++;
				qmiddle++; 
			}
			else if (list[j] >= list[p]) {
				j--; 
				qmiddle++; 
			}	
			else
			{
				swap (list, i, j);
				i++;
				j--;
				qmiddle++; 
			}
			
		
		}
		
		// Finish partitioning:
		
		if (p < j)    // place the pivot in its correct position
		{
			 swap (list, j, p);
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
		}
		
		// Sort recursively:
		qmiddle = QuickMid(list, from, p - 1, qmiddle);
		qmiddle = QuickMid(list, p + 1, to, qmiddle);
		
		return qmiddle; 
    }
    
	public static int QuickRandom(int[] list, int from, int to, int qrand)
    {
		if (from >= to)
			return qrand;
		
		// Choose pivot list[p]
		Random random = new Random(); 
		int range = to-from+1; 
		int p = random.nextInt(range) + from; 
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.
		
		// Partition:
		
		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p])
				i++;
			else if (list[j] >= list[p])
				j--;
			else
			{
				swap (list, i, j);
				i++;
				j--;
			}
			qrand++; 
		
		}
		
		// Finish partitioning:
		
		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
		}
		
		// Sort recursively:
		qrand = QuickRandom(list, from, p - 1, qrand);
		qrand = QuickRandom(list, p + 1, to, qrand);
		
		return qrand;  
    }
    
    private static void swap (int[] list, int a, int b)
    {
        int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
		
    }
	
}
