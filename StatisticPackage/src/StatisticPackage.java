
/*
 * Name: Michelle Olofsson
 * Block: H
 * Lab: Statistic package
 * Description: To learn about the built-in array, sort data in ascending order and calculate statistical features in a menu-driven program.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StatisticPackage {

	public static void main(String[] args) {
		// TODO

		String pathName = "textfile.txt";
		File file = new File(pathName);
		Scanner input = null;

		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.print("Error, cannot open " + pathName + ".");
			System.exit(1);
		}
		int total = input.nextInt();
		int[] numbers = new int[total];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}
		// sort and print
		printNumbers(numbers);

		// menu
		menu(numbers);

	}

	public static void menu(int numbers[]) {
		Scanner in = new Scanner(System.in);
		double mean = 0;
		double deviation = 0;
		int median = 0;
		int range = 0;
		String answer;
		System.out.println("\n\nWelcome to this statistics program.");
		System.out.println("The commands are; mean, median," + " range, mode, stddev, and quit.");
		do {
			System.out.print("\nEnter a command: ");
			answer = in.nextLine();
			switch (answer) {
			case "mean":
				mean = findMean(numbers);
				System.out.println("The mean is " + mean + ".");
				break;
			case "median":
				median = findMedian(numbers);
				System.out.println("The median is " + median + ".");
				break;
			case "range":
				range = findRange(numbers);
				System.out.println("The range is " + range + ".");
				break;
			case "mode":
				findMode(numbers);
				break;
			case "stddev":
				deviation = standardDeviation(numbers, mean);
				System.out.println("The standard deviation is " + deviation + ".");
				break;
			}
		} while (!answer.equals("quit"));

	}

	public static void printNumbers(int numbers[]) {
		int temp, j;
		for (int i = 1; i < numbers.length; i++) {
			temp = numbers[i]; // store value so that it isn't overided
			j = i - 1;

			while (j >= 0 && numbers[j] > temp) {
				numbers[j + 1] = numbers[j]; // switch places
				j = j - 1;
			}
			numbers[j + 1] = temp;
		}

		System.out.println("Numbers from smallest to largest: ");
		for (int i = 0; i < numbers.length; i++)
			if (i % 10 == 0)
				System.out.print("\n" + numbers[i] + " ");
			else
				System.out.print(numbers[i] + " ");
	}

	public static double findMean(int numbers[]) {
		double sum = 0;
		for (int i = 0; i < numbers.length; i++)
			sum = sum + numbers[i];

		double mean = sum / numbers.length;

		return mean;
	}

	public static int findMedian(int numbers[]) {
		int median = 0;
		int x;
		int y;
		if (numbers.length / 2 != 0) {
			x = numbers.length / 2 - 1;
			median = numbers[x];
		} else {
			x = numbers.length / 2 - 1;
			y = numbers.length / 2 + 1;
			median = (numbers[x] + numbers[y]) / 2;
		}
		return median;
	}

	public static int findRange(int numbers[]) {
		int smallest = numbers[0];
		int largest = numbers[numbers.length - 1];
		int range = largest - smallest;
		return range;
	}

	public static void findMode(int numbers[]) {
		int value = 0, counter = 1, maxcount1 = 0, mode1 = 0;
		int maxcount2 = 0, mode2 = 0;
		int oldvalue = numbers[0];
		for (int x = 1; x < numbers.length; x++) {
			if (numbers[x] == oldvalue) {
				counter++;
				if (counter > maxcount1) {

					maxcount1 = counter;
					mode1 = numbers[x];
				} else if (counter == maxcount1) {
					maxcount2 = counter;
					mode2 = numbers[x];
				}
			} else {
				oldvalue = numbers[x];
				counter = 1;
			}

		}

		if (maxcount2 == maxcount1) {
			System.out.println("The modes are " + mode1 + " and " + mode2 + ".");
		} else {
			System.out.println("The mode is " + mode1 + ".");
		}

	}

	public static double standardDeviation(int numbers[], double mean) {
		double sum = 0, deviation;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + (numbers[i] - mean) * (numbers[i] - mean);
		}

		deviation = sum / (numbers.length - 1);
		deviation = Math.sqrt(deviation);

		return deviation;
	}
}
