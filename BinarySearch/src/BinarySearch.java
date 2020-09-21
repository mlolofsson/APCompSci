
/* Name: Michelle Olofsson
 * Lab: Binary Search 
 * Block: H
 * Description: Use the array class to do a binary search, and create your own binary search. 
 */

import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		// set size of array to random number between 20 and 50
		int min = 20, max = 50;
		Random random = new Random();
		int arraySize;
		arraySize = min + random.nextInt((max - min) + 1); // add one because you need numbers 0-30
		int[] array = new int[arraySize];

		// create random array

		System.out.println("\nOriginal array of " + arraySize + " elements: ");
		for (int i = 0; i < arraySize; i++) { // set array
			Random array2 = new Random();
			array[i] = array2.nextInt(99 - 0 + 1); // randomly assign each place a number 0-100
		}
		for (int i = 0; i < arraySize; i++) {
			if ((i + 1) % 10 == 0) { // if number is last in row
				System.out.printf("%5d", array[i]);
				System.out.println();
			} else
				System.out.printf("%5d", array[i]);
		}

		// sort array

		Arrays.sort(array);
		System.out.println("\nSorted array of " + arraySize + " elements: ");
		for (int i = 0; i < arraySize; i++) {
			if ((i + 1) % 10 == 0) { // if number is last in row
				System.out.printf("%5d", array[i]);
				System.out.println();
			} else
				System.out.printf("%5d", array[i]);
		}

		// built-in binary search
		System.out.println("\nBuilt-in Binary Search: ");
		for (int j = 0; j < 2; j++) {
			boolean found = false;
			System.out.print("\nWhat entry? ");
			int target = input.nextInt();

			for (int i = 0; i < array.length; i++) {
				if (array[i] == target) {
					found = true;
				}
			}
			int pos = Arrays.binarySearch(array, target); // finds position

			System.out.printf("     status: ");

			if (found == true) {
				System.out.print("found at index " + pos + ".");
			} else {
				System.out.print("not found.");
			}
		}

		// my binary search
		System.out.println("\nMy Binary Search:");
		for (int j = 0; j < 2; j++) {
			boolean found = false;
			System.out.print("\nWhat entry? ");
			int target = input.nextInt();
			for (int i = 0; i < array.length; i++) {
				if (array[i] == target) {
					found = true;
				}
			}
			
			int probes = 0; 
			boolean flag = true; // if flag = true, then return position
			int pos = myBinarySearch(array, 0, array.length-1, target, flag, probes);
			
			
			flag = false; // if flag = false, return # of probes
			probes = myBinarySearch(array, 0, array.length-1, target, flag, probes);
			
			System.out.print("     status: ");

			if (found == true) {
				System.out.print("found at index " + pos + " after " + probes + " probes.");
			} else {
				System.out.print("not found after " + probes + " probes.");
			}
		}

	}

	public static int myBinarySearch(int[] array, int start, int end, int target, boolean flag, int probes) {
		int middle = start + (end - start) / 2;

		if (array[middle]==target) {
			probes++; 
			int pos = middle;
			if(flag) {
			return pos;
			}
			else {
				return probes;	
			}
		}

		else if (target > array[middle]) {
			probes++; 
			start = middle; // because nothing below is right
			return myBinarySearch(array, start, end, target, flag, probes);
		}
		else { // (target < array[middle]) 
			probes++; 
			end = middle; // because nothing above middle is right
			return myBinarySearch(array, start, end, target, flag, probes);
		}
	}

}
