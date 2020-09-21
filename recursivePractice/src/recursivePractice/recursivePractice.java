package recursivePractice;

import java.util.Scanner;

public class recursivePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer = null; 
		Scanner input = new Scanner(System.in);
		System.out.println("The options in this program are: ");
		System.out.println("a. check if number is power of 3 ");
		System.out.println("b. finds number of factors of 2");
		System.out.println("c. reverse number ");
		System.out.println("d. insert commas");
		System.out.println("e. print letters before"); 
		System.out.println("f. convert from base 10 to 5");
		System.out.println("g. quit program");
		
		
		do {
		System.out.print("\n\nEnter command: ");
		answer = input.next();

		
		
		switch (answer) {
		case "a":
			System.out.print("Enter a number: ");
			int num = input.nextInt();
			boolean result = powerOf3(num);
			if(result==true) {
				System.out.print("\n" + num + " IS a power of 3.");
			}
			else 
				System.out.print("\n" + num + " is NOT a power of 3.");
			break; 
		case "b": 
			System.out.print("Enter a number: ");
			int num1 = input.nextInt();
			int factors = twos(num1); 
			System.out.print("\nnumber of factors of 2 in " + num1 + " = " + factors);
			break; 
		case "c":
			System.out.print("Enter a number: ");
			int num2 = input.nextInt();
			int reversed = reverse(num2);
			System.out.println(num2 + " reversed is " + reversed);
			break; 
		case "d": 
			System.out.print("Enter a number: ");
			int num3 = input.nextInt();
			printWithCommas(num3);
			break; 
		/*case "e": 
			int converted = base5(num); 
			System.out.print("\n" + num + " in base 5 = " + converted);*/
		case "e": 
			System.out.print("Enter a letter: ");
			String let; 
			char letter; 
			//let = input.next(); 
			//letter = let.charAt(0);
			letter = input.next().charAt(0); 
			letters(letter); 
			break;
		case "f": 
			System.out.print("Enter a number: ");
			int num4 = input.nextInt();
			base5(num4);
			break;
		
		}
		}while(!answer.equals("g"));

	}

	public static boolean powerOf3(int num) {
		if (num == 1)
			return true;
		else if (num % 3 != 0)
			return false;
		else
			return powerOf3(num / 3);
	}

	public static int reverse(int num) {
		int num2;
		if (num < 10)
			return num;
		else {
			num2 = num % 10;
			return num2 * getPlace(num) + reverse(num / 10);
		}
	}

	public static int getPlace(int num) {
		int place;
		if (num == 1)
			return 1;
		else {
			place = 10 * getPlace(num / 10);
			return place;
		}
	}
	
	public static void printWithCommas(int num) {
		if(num<1000)
			System.out.print(num);
		else {
			int num2 = num/1000; 
			printWithCommas(num2);
			System.out.print(",");
			int x = num%1000;
			if(x==0)
				System.out.print("000");
			else if(x<10)
				System.out.print("00" + x);
			else if(x<100)
				System.out.print("0" + x);
			else
				System.out.print(x);
		}
	}
	
	public static int twos(int num) {
		if(num%2!=0)
			return 0; 
		else { 
			return 1 + twos(num/2);
		}
	}
	
	public static void base5(int num){
		if(num/5==0)
			System.out.print(num%5);
		else {
			base5(num/5); 
			System.out.print(num%5);
		}
		
	}
		
	public static void letters(char letter) {	
		if(letter =='a') {
			
		}
		else {
			int ascii = (int)letter; 
			int newA = ascii-1;
			char newL = (char)newA;
			letters(newL); 
			System.out.print(newL);
		}	
		
		
	}
}
