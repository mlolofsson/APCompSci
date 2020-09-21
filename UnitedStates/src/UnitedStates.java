
/*
 * Name: Michelle Olofsson
 * Lab: States 
 * Block: H
 * Description: Write a menu driven program that maintains a list of the states in alphabetical order 
 * using Java's List interface. 
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UnitedStates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read in list

		ArrayList<String> states = new ArrayList<String>();
		Scanner in = null;
		String pathname = "StateNames.txt";
		File file = new File(pathname);
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("***Cannot open " + pathname + "***");
			System.exit(1); // quit program
		}
		while (in.hasNext()) {
			String word = in.nextLine();
			word = word.trim(); 
			insertItem(word, states);
		}
		
		displayList(states); 
		
		Scanner input = new Scanner(System.in);

		System.out.println("\nWelcome to States. Here are your options: ");
		System.out.println("\n(1) Print out list");
		System.out.println("(2) Add name of a state");
		System.out.println("(3) Remove a state");
		System.out.println("(4) Output list, writing into existing file");
		System.out.println("(5) Quit program");
		
		
		
		String answer = "0"; 
		do {

			System.out.print("\nChoose an option: ");
			answer = input.nextLine(); 

			
			switch (answer) {
			case "1":	System.out.print("\nCurrent list of states: ");
					displayList(states); 
					break; 
			case "2": System.out.print("\nWhat state would you like to add? ");
					String word = input.nextLine(); 
					insertItem(word, states); 
					System.out.println("Task complete.");
					break; 
			case "3":	System.out.print("\nWhat state would you like to remove? ");
					String word2 = input.nextLine();
					removeItem(word2, states);
					System.out.println("Task complete.");
					break; 
			case "4": saveList(states);
					System.out.print("\nCheck file 'StateNames.txt' for state list.\n"); 
					break;
			case "5": System.exit(1);
					break;
			}

		} while (answer != "5");
	}

	public static void displayList(ArrayList<String> states) {
		System.out.print("\n\n");
		for (String s : states) {
			System.out.println(s);
		}
	}

	public static void insertItem(String word, ArrayList<String> states) {
		if(states.isEmpty()) {
			states.add(word);
			return;
		}
		for (int i = 0; i < states.size(); i++) {
			int index = states.indexOf(states.get(i));
			if (word.compareTo(states.get(i)) < 0) { // if word is less than 
				states.add(index, word); // add before word compared to
				return; // exit loop
			} 
			else if(word.compareTo(states.get(i)) == 0) { // if word is equal to
				return; // exit loop 
			}
		}
		states.add(word); // add to end if greater than everything 
	}

	public static void removeItem(String word, ArrayList<String> states) {
		if(!states.remove(word)) {
			System.out.println("\n" + word + " is not in the list.");
		}
	}

	public static void saveList(ArrayList<String> states) {
		String pathname = "StateNames.txt";
		File file = new File(pathname);
		PrintWriter output = null; 
		try {
			output = new PrintWriter(file);
		}
		catch(FileNotFoundException ex) {
			System.out.println("Cannot create " + pathname);
			System.exit(1);
		}
		
		for(String s : states) {
			output.println(s);
		}
		
		output.close();
	}

	public static void quit() {

	}
}
