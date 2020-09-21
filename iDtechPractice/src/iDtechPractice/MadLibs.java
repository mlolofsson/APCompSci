package iDtechPractice;

import java.util.Scanner; 
public class MadLibs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		String adjective = getUserInput("Enter an adjective: ", userInput);
		String noun = getUserInput("Enter a noun: ", userInput);
		String animal = getUserInput("Enter an animal: ", userInput);
		String noise = getUserInput("Enter a sound: ", userInput);
		intro();
		printMadlib(adjective, noun, animal, noise);
	}
	
	public static void intro(){
		System.out.println("Welcome to Madlibs!");
	}
	
	public static void printMadlib(String adjective, String noun, String animal, String noise){
		System.out.print( adjective + " Macdonald had a noun, E-I-E-I-O\n");
		System.out.print("and on that " + noun + " he had an " + animal + " E-I-E-I-O\n");
		System.out.print("with a " + noise + " here\n");
		System.out.print("and an " + noise + " " + noise + " there,\n");
		System.out.print("here an " + noise + ", there a noise,\n");
		System.out.print("everywhere an " + noise + " " + noise + "\n");
		System.out.print(adjective + "Macdonald had a " + noun + ", E-I-E-I-O.");
	}
	public static String getUserInput(String message, Scanner userInput){
		System.out.print(message);
		return userInput.nextLine();
	}
}
