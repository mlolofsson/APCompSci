
/*
 * Name: Michelle Olofsson 
 * Block: H
 * Lab: Middle Earth
 * Description: Do calculations in different bases. 
 */
import java.util.Scanner;

public class MiddleEarth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x = 1, num1 = 0, num2 = 0;
		String race = "human", sign = "+";
		do {
			System.out.println("\n\nInput " + x + ":");
			race = input.next();
			num1 = input.nextInt();
			num2 = input.nextInt();
			sign = input.next();

			System.out.println("\nOutput " + x + ": ");
			switch (race) {
			case "human":
				human(num1, num2, sign); // base 10
				break;
			case "wizard":
				wizard(num1, num2, sign); // base 2
				break;
			case "dwarf":
				dwarf(num1, num2, sign); // base 5
				break;
			case "elf":
				elf(num1, num2, sign); // base 8
				break;
			}
			x++;

		} while (x < 11);
	}

	public static int countDigits(int num) {
		int counter = 0;
		do {
			num = num / 10;
			counter++;
		} while (num > 0);
		return counter;
	}

	public static int add(int num1, int num2, int base) {
		int BigCount = 0, temp1, temp2, sum = 0, carry = 0, TotalSum = 0, place = 1;
		int length1 = countDigits(num1);
		int length2 = countDigits(num2);
		if (length1 >= length2) {
			BigCount = length1;
		} else if (length2 > length1) {
			BigCount = length2;
		}
		for (int j = 0; j < BigCount; j++) {
			temp1 = num1 % 10;
			num1 /= 10;
			temp2 = num2 % 10;
			num2 /= 10;
			if ((temp1 + temp2 + carry) < base) {
				sum = temp1 + temp2 + carry;
				carry = 0;
			} else {
				sum = temp1 + temp2 + carry - base;
				carry = 1;
			}
			sum = sum * place;
			TotalSum += sum;
			place *= 10;
		}
		TotalSum+=carry*place;
		return TotalSum;
	}
	
	public static void multiply(int num1, int num2, int base) {
		int temp1, temp2, addPlace=1, product=0, totalP = 0;
		int topNum=0;
		int length1 = countDigits(num1);
		int length2 = countDigits(num2);
		System.out.print("\n" + num1 + "\n* " + num2 + "\n");
		for(int i=0; i<length2+2; i++) { //output right amount of dashes 
			System.out.print("-");
		}
		for (int i = 0; i < length2; i++) {
			topNum = num1; 
			temp2 = num2 % 10;
			num2 /= 10;
			int place = 1; 
			int total=0; //reinitialize
			int carry=0;
			for(int j=0; j<length1; j++) {
				temp1= topNum%10;
				topNum/=10; 
				product=temp1*temp2+carry;
				if(product>=base) {
					carry=product/base;
					product=product%base;
				}
				else
					carry=0; 
				product = product*place;
				total+=product; 
				place*=10;
				 
			}
			//product = temp2 * num1;
			total=total+(carry*place);
			System.out.print("\n" + total);
			totalP = add(totalP, total*addPlace, base);
			addPlace*=10;
		}
		int totalLength = countDigits(totalP);
		System.out.print("\n");
		for(int i=0; i<totalLength; i++) {
			System.out.print("=");
		}
		System.out.print("\n" + totalP);
	}
	
	public static void human(int num1, int num2, String sign) {
		int base = 10, sum;
		int length1 = countDigits(num1);
		int length2 = countDigits(num2);
		if (sign.equals("+")) {
			System.out.print("\n" + num1 + "\n+ " + num2 + "\n");
			sum = num1 + num2;
			for(int i=0; i<length2+2; i++) {
				System.out.print("-");
			}
			System.out.print("\n\n" + sum);
		} else if (sign.equals("*")) {
			multiply(num1, num2, base);
		}
	}

	

	public static void wizard(int num1, int num2, String sign) {
		int base = 2, BigCount = 1, temp1, temp2, sum, carry = 0, TotalSum = 0, place = 1, product, TotalP = 0;
		int length1 = countDigits(num1);
		int length2 = countDigits(num2);
		// addition
		if (sign.equals("+")) {
			System.out.print("\n" + num1 + "\n+ " + num2 + "\n");
			for(int i=0; i<length2+2; i++) { //output right amount of dashes 
				System.out.print("-");
			}
			System.out.print("\n");
			TotalSum = add(num1, num2, base);
			System.out.print("\n" + TotalSum);
		}
		// multiplication
		else if (sign.equals("*")) {
			multiply(num1, num2, base);
		}
	}

	public static void dwarf(int num1, int num2, String sign) {
		int base = 5, TotalSum = 0;
		int length1 = countDigits(num1);
		int length2 = countDigits(num2);
		// addition
		if (sign.equals("+")) {
			System.out.print("\n" + num1 + "\n+ " + num2 + "\n");
			for(int i=0; i<length2+2; i++) { //output right amount of dashes 
				System.out.print("-");
			}
			System.out.print("\n");
			TotalSum = add(num1, num2, base);
			System.out.print("\n" + TotalSum);
		}
		// multiplication
		else if (sign.equals("*")) {
			multiply(num1, num2, base);
		}
	}

	public static void elf(int num1, int num2, String sign) {
		int base = 8, TotalSum = 0;
		int length1 = countDigits(num1);
		int length2 = countDigits(num2);
		// addition
		if (sign.equals("+")) {
			System.out.print("\n" + num1 + "\n+ " + num2 + "\n");
			for(int i=0; i<length2+2; i++) { //output right amount of dashes 
				System.out.print("-");
			}
			System.out.print("\n");
			TotalSum = add(num1, num2, base);
			System.out.print("\n" + TotalSum);
		}
		// multiplication
		else if (sign.equals("*")) {
			multiply(num1, num2, base);
			
		}
	}
}
