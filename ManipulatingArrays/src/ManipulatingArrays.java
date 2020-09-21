
/*
 * Name: Michelle Olofsson
 * Block: H
 * Lab: Manipulating Arrays
 * Description: To gain proficiency implementing one-dimensional built-in-arrays.
 */
import java.util.Scanner;

public class ManipulatingArrays {

	public static Scanner input = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		System.out.print("Enter array size: ");
		int size = input.nextInt();
		int[] array = new int[size];
		System.out.print("Enter values for each position: ");
		for (int n = 0; n < size; n++) {
			array[n] = input.nextInt();
		}

		menu(array);
	}

	public static void menu(int array[]) {
		System.out.print("\nOptions are: length, search, smallest, rotate, removezeroes, and quit.\n");
		String choice;
		do {
			System.out.print("\nEnter a command: ");
			choice = input.next();
			
			switch (choice) {
			case "length":
				length(array);
				break;
			case "search":
				search(array);
				break;
			case "smallest":
				smallest(array);
				break;
			case "rotate":
				rotate(array);
				break;
			case "removezeroes":
				removeZeroes(array);
				break;
			}
		} while (!choice.equals("quit"));

	}

	public static void length(int array[]) {
		System.out.print("\nsize of array: " + array.length);
		System.out.print("\narray positions: ");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%4d", i);
		}
		System.out.print("\narray entries:   ");
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%4d", array[i]);
		}
		System.out.print("\n");
	}

	public static void search(int array[]) {
		String status = "no";
		int answer = 1;

		do {
			System.out.print("What entry? ");
			int entry = input.nextInt();
			for (int i = 0; i < array.length; i++) {
				if (array[i] == entry) {
					status = "found";

					System.out.print("status: found at position " + i);

				}
			}
			if (!status.equals("found")) {
				System.out.print("status: not found");
			}
			System.out.print("\nanother search (1/0)? ");
			answer = input.nextInt();
		} while (answer == 1);
	}

	public static void smallest(int array[]) {
		int counter = 0, smallest = 0, position = 0;
		System.out.print("\nSmallest element first");
		for (int x = 0; x < array.length; x++) {
			int temp = array[x];
			for (int y = 0; y < array.length; y++) {
				if (array[x] < array[y]) {
					counter++;
					smallest = array[x];
					position = x;
				}
			}
			if (counter == array.length - 1) { // meaning value is smaller than all the rest
				int temp2 = array[0];
				array[0] = smallest;
				array[position] = temp2;
				break;
			} else {
				counter = 0;
			}
		}

		System.out.print("\narray positions: ");
		for (int x = 0; x < array.length; x++) {
			System.out.printf("%4d", x);
		}

		System.out.print("\narray entries:   ");
		for (int x = 0; x < array.length; x++) {
			System.out.printf("%4d", array[x]);
		}
		System.out.print("\n");
	}

	public static void rotate(int array[]) {
		int answer, temp, steps = 0;

		do {
			System.out.print("\nhow many steps? ");
			steps = input.nextInt();
			if (steps > 0) {
				// shift right
				for (int x = 0; x < steps; x++) {
					temp = array[array.length - 1];
					for (int i = array.length - 2; i >= 0; i--) {
						array[i + 1] = array[i];
					}
					array[0] = temp;
				}
			}
			// shift left
			else if (steps < 0) {
				for (int x = steps; x < 0; x++) { // does shift by one until reaches steps
					temp = array[0]; // saves first variable
					for (int i = 1; i <= array.length - 1; i++) { // shifts by one
						array[i - 1] = array[i];
					}
					array[array.length - 1] = temp; // gets around variables on end
				}
			}

			System.out.print("rotated array");
			System.out.print("\narray positions: ");
			for (int x = 0; x < array.length; x++) {
				System.out.printf("%4d", x);
			}

			System.out.print("\narray entries:   ");
			for (int x = 0; x < array.length; x++) {
				System.out.printf("%4d", array[x]);
			}
			System.out.print("\nrotate again (1/0)? ");
			answer = input.nextInt();
		} while (answer == 1); // while loop bracket

	}

	public static void removeZeroes(int array[]) {
		int counter = 0;
		for (int x = 0; x < array.length; x++) {
			if (array[x] != 0) {
				counter++;
			}
		}
		int newSize = counter;
		int x = 0;
		int[] newArray = new int[newSize];

		while (x < newSize) {
			for (int y = 0; y < array.length; y++) {
				if (array[y] != 0) {
					newArray[x] = array[y];
					x++;
				}
			}
		}

		System.out.print("\nsize of array: " + newSize);
		System.out.print("\narray positions: ");
		for (int y = 0; y < newArray.length; y++) {
			System.out.printf("%4d", y);
		}

		System.out.print("\narray entries:   ");
		for (int y = 0; y < newArray.length; y++) {
			System.out.printf("%4d", newArray[y]);
		}
		System.out.print("\n");
	}

}
