
/*
 * Name: Michelle Olofsson
 * Block: H
 * Lab: Simple Algorithms
 * Description: Use primitive data types to execute simple algorithms. 
 */

import java.util.Scanner;

public class SimpleAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// factors method
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int num = input.nextInt();
		factors(num);

		// GCD method
		System.out.print("\n\nEnter 2 integers: ");
		int a = input.nextInt();
		int b = input.nextInt();
		int GCD = GCD(a, b);
		System.out.print("The greatest common divisor is " + GCD + ".");
		
		// prime method
		System.out.print("\n\nEnter an integer: ");
		int num2 =input.nextInt();
		if(prime(num2))
			System.out.print(num2 + " is a prime number.");
		else 
			System.out.print(num2 + " is not a prime number.");

		// count digits method
		System.out.print("\n\nEnter a number: ");
		double num3 = input.nextDouble();
		int digits = countDigits(num3);
		System.out.print("Number of digits to the left of the decial point is " + digits + ".");

		// down digits method
		System.out.print("\n\nEnter a number: ");
		int num4 = input.nextInt();
		downDigits(num4);

		// find digit method
		System.out.print("\nEnter two integers: ");
		int num5 = input.nextInt();
		int n = input.nextInt();
		int foundDigit = findDigit(num5, n);
		System.out.print("The nth digit from the right of the number is " + foundDigit + ".");

		// power method
		System.out.print("\n\nEnter a number: ");
		double base = input.nextDouble();
		System.out.print("Enter an integer: ");
		int exponent = input.nextInt();
		double solution = power(base, exponent);
		System.out.print("The solution is " + solution + ".");

	}

	public static void factors(int num) {
		System.out.print("The factors of " + num + " are: ");
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				if (i == num) {
					System.out.print(i + ".");
				} else {
					System.out.print(i + ", ");
				}
			}
		}
	}

	public static int GCD(int a, int b) {
		int GCD = 0;
		for (int i = 1; i <= a && i <= b; i++) { // loop stops at the lower number
			if (a % i == 0 && b % i == 0) // makes sure that i is a factor of both numbers
				GCD = i; // overrides GCD each time, leaving with GCD at the end
		}

		return GCD;
	}

	public static boolean prime(int num2) {

		for (int i = 2; i < num2; i++) { // loops to look if there are any factors above 1, and less than number
			if (num2 % i == 0)
				return false;
		}

		return true;
	}

	public static int countDigits(double num3) {
		int counter = 0;

		if (num3 < 0)
			num3 = num3 * -1;
		if (num3 < 1) {
			counter = 1;
			return counter;
		} else {
			do {
				num3 = num3 / 10;
				counter++;
			} while (num3 > 1);
		}
		return counter;
	}

	public static void downDigits(int num4) {

		int digits = countDigits((double) num4); // find number of digits in num
		int counter = 1;
		for (int i = 0; i < digits - 1; i++)
			counter = counter * 10; // find greatest multiple of 10 num4 is divisible by 
		for (int x = counter; x > 0; x /= 10) { // keep dividing by 10 to divide the num by the right multiple to find each place value
			int value = num4 / x; // since it is an int only the first value will be left over
			System.out.print(value + "\n");
			num4 = num4 % x; // so that the next time it runs it does the process for the remainder of the
								// number
		}

	}

	public static int findDigit(int num5, int n) {
		int digits = countDigits((double) num5); // find number of digits in num
		int counter = 1;
		int foundDigit = 0;
		int newCount = 0;
		for (int i = 0; i < digits - 1; i++)
			counter = counter * 10;
		if (n > digits)
			return foundDigit;
		else {
				for (int x = counter; x > 0; x /= 10) {
					foundDigit = num5 / x;
					num5 = num5 % x;
					newCount++;
					
					if(newCount > digits-n) // exits loop once the nth digit is stored
						break;
				}
		}
		return foundDigit;
	}

	public static double power(double base, int exponent) {

		double solution = 1;

		if (exponent == 0)
			solution = 1;
		else if (exponent < 0) { 
			for (int i = 0; i < -exponent; i++) { // less than opposite of exponent because exponent is negative
				solution = solution * base;
			}
			solution = 1 / solution;
		} 
		else {
			for (int i = 0; i < exponent; i++) {
				solution = solution * base;
			}
		}
		return solution;
	}

}
