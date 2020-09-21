import java.io.File;
import java.io.FileWriter; 
import java.io.PrintWriter; 
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Name: Michelle Olofsson 
 * Lab: Cipher
 * Block: H
 * Description: Use multiple classes to decode a text file. 
 */

public class Cipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Record[] alphabet = new Record[26];
		char firstL = 'A'; // should this be capitalized?
		System.out.println("Orignial record:");
		for (int i = 0; i < 26; i++) { // set array to alphabet
			int ascii = (int) firstL;
			int newAscii = ascii + 1;
			alphabet[i] = new Record(firstL);
			firstL = (char) newAscii;
			char letter = alphabet[i].getLetter();
			int frequency = alphabet[i].getFrequency();
			System.out.println(letter + " " + frequency);
		}
		readFile(alphabet); // part C
		sortDescending(alphabet); // part D
		setNewLetters(alphabet); // part E
		decode(alphabet); // part E

	}

	public static void readFile(Record[] alphabet) { // PART C
		Scanner input = null;
		String pathname = "Cipher.txt";
		File file = new File(pathname);
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("***Cannot open " + pathname + "***");
			System.exit(1); // quit program
		}
		System.out.println("\nOrignial text in " + pathname + ": \n");
		while (input.hasNextLine()) {
			String line = input.nextLine();
			char[] array = line.toCharArray();
			System.out.println(line);
			for (int j = 0; j < array.length; j++) { // loops through characters in line
				for (int i = 0; i < 26; i++) { // loops through alphabet
					char letter = alphabet[i].getLetter();
					if (array[j] == letter) {
						alphabet[i].increaseFrequency();
						// int frequency = alphabet[i].getFrequency();
					}

				}
			} // outside for loop bracket
		}

		System.out.println("\nFrequencies of letters in " + pathname + ": ");
		for (int i = 0; i < 26; i++) { // print out
			char letter = alphabet[i].getLetter();
			int frequency = alphabet[i].getFrequency();
			System.out.println(letter + " " + frequency);
		}

	}

	public static void sortDescending(Record[] alphabet) { // PART D
		Arrays.sort(alphabet);
		System.out.println("\nSorted by frequency: ");
		for (int i = 0; i < 26; i++) {
			char letter = alphabet[i].getLetter();
			int frequency = alphabet[i].getFrequency();
			System.out.println(letter + " " + frequency);
		}
	}
	
	public static void sortOriginalLetter(Record[] alphabet) { // PART G
		
	}

	public static void setNewLetters(Record[] alphabet) {
		Scanner input = null;
		String pathname = "replace.txt";
		File file = new File(pathname);
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("***Cannot open " + pathname + "***");
			System.exit(1); // quit program
		}
		while (input.hasNextLine()) {
			String line = input.nextLine();
			char[] replacements = line.replaceAll(" ", "").toCharArray();
			System.out.println("\nOld letter and new letter: ");
			for (int i = 0; i < 26; i++) { // loops through alphabet
				char newLet = replacements[i];
				char oldLet = alphabet[i].getLetter();
				alphabet[i].setNewLet(newLet);
				System.out.println(oldLet + " " + newLet);
			}

			// } // outside for loop bracket

		}
	}

	public static void decode(Record[] alphabet) { // PART E
		Scanner input = null;
		String pathname = "Cipher.txt";
		File file = new File(pathname);
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("***Cannot open " + pathname + "***");
			System.exit(1); // quit program
		}
		System.out.println("\nDecoded text:");
		while (input.hasNextLine()) {
			System.out.print("\n");
			String line = input.nextLine();
			char[] lineArray = line.toCharArray();

			for (int j = 0; j < lineArray.length; j++) {
				for (int i = 0; i < 26; i++) {
					char alphLetter = alphabet[i].getLetter();
					if (lineArray[j] == alphLetter) {
						char newLet = alphabet[i].getNewLetter();
						lineArray[j] = newLet;
						i=26; // otherwise it will keep looping through and replacing 
					}
				}
				System.out.print(lineArray[j]);
			}
		}
		
		// find duplicates 
		int numDuplicates = 0;
		for(int k=0; k<26; k++) { // find num of duplicates
			int freq1 = alphabet[k].getFrequency();
			char let1 = alphabet[k].getLetter();
			for(int l=0; l<26; l++) {
				int localIndex = l; 
				int freq2 = alphabet[l].getFrequency();
				char let2 = alphabet[l].getLetter();
				if(freq1==freq2 && localIndex !=k) { // because otherwise it will count itself as a duplicate
					numDuplicates++; 
					l=26;
				}
			}
		}
		
		//System.out.println("\n\nNUMDUP = " + numDuplicates );
		char[] duplicates = new char[numDuplicates]; // put duplicates in an array 
		char[] match = new char[numDuplicates]; // the matching one
		int index=0; // for duplicates
		for(int k=0; k<26; k++) {
			int freq1 = alphabet[k].getFrequency();
			char let1 = alphabet[k].getLetter();
			for(int l=0; l<26; l++) {
				int localIndex = l;
				int freq2 = alphabet[l].getFrequency();
				char let2 = alphabet[l].getLetter();
				if(freq1==freq2 && localIndex !=k) { // don't count itself as duplicate
					duplicates[index] = alphabet[k].getNewLetter(); 
					//freqDuplicates[index] = alphabet[k].getFrequency();
					match[index] = alphabet[l].getNewLetter();
					index++; 
					l=26;
				}
			}
		}
		
		// user modifies for correctness 
		System.out.print("\nThe duplicates are: ");
		for(int m=0; m<numDuplicates; m++) {
			System.out.print("\n" + duplicates[m] + " & " + match[m]);
			m++; // skips duplicates of matches 
		}
		Scanner input2 = new Scanner(System.in);
		System.out.print("\n\nHow many pairs do you want to swap? ");
		int numPairs = input2.nextInt();
		char[] dup1 = new char[numPairs]; 
		char[] dup2 = new char[numPairs];
		for(int i=0; i<numPairs; i++) {
			System.out.print("\nEnter first letter to swap: ");
			char temp1 = input2.next().charAt(0);
			dup1[i] = temp1;
			System.out.print("Enter matching letter: ");
			char temp2 = input2.next().charAt(0);
			dup2[i] = temp2; 
		}
		System.out.print("\n\n");
		/*for(int i=0; i<numPairs; i++) {
			System.out.println("\nDUP1[" + i + "] = " + dup1[i]);
			System.out.println("DUP2[" + i + "] = " + dup2[i]);
		}*/
		
		
		writeNewFile(dup1, dup2, alphabet); 	
	} // uncode method bracket
	
	public static void writeNewFile(char[] dup1, char[] dup2, Record alphabet[]) { // PART F
		String pathname = "Uncoded.txt";
		File file = new File(pathname);
		PrintWriter output = null; 
		try {
			output = new PrintWriter(file);
		}
		catch(FileNotFoundException ex) {
			System.out.println("Cannot create " + pathname);
			System.exit(1);
		}
		 
		Scanner input = null;
		String path2 = "cipher.txt";
		File file2 = new File(path2);
		try {
			input = new Scanner(file2);
		} catch (FileNotFoundException ex) {
			System.out.println("***Cannot open " + path2 + "***");
			System.exit(1); // quit program
		}
		System.out.println("\n\nUNCODED TEXT REMOVED FOR DUPLICATES IS NOW IN NEW FILE CALLED 'Uncoded.txt' ");
		while (input.hasNextLine()) {
			output.println("\n"); // write to file
			String line = input.nextLine();
			char[] lineArray = line.toCharArray();

			for (int j = 0; j < lineArray.length; j++) {
				for (int i = 0; i < 26; i++) {
					char alphLetter = alphabet[i].getLetter();
					
					if (lineArray[j] == alphLetter) { // if it matches alphabet letter 
						char newLet = alphabet[i].getNewLetter();
						for(int k=0; k<dup1.length; k++) { // if 1 of the doubles to switch
							if(newLet == dup1[k]) { // if a dup
								//System.out.print("\nEntered if! @ first lineArray[j] = " + lineArray[j]);
								newLet = dup2[k]; // switch with match
								lineArray[j] = newLet;
								//System.out.print("\nlineArray[j] = " + lineArray[j]);
								i=26; // already found the right one
							}
							else if(newLet == dup2[k]) { // if a dup
								newLet = dup1[k]; // switch with match 
								lineArray[j] = newLet; 
								i=26; // already found the right one
							}
						}
						
						lineArray[j] = newLet;
						i=26; // otherwise it will keep looping through and replacing 
					}
	
				}
				output.print(lineArray[j]);
			}
			
		}
		
		output.close(); 
		
	}

} // class bracket
