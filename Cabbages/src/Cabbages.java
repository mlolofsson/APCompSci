
/*
 * Name: Michelle Olofsson 
 * Lab: Cabbages 
 * Block: H 
 * Description: Read in a file, store in an array, and grep. 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Cabbages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathname = "Cabbages.txt";
		File file = new File(pathname);
		Scanner user = new Scanner(System.in);
		int count = readAndCount(pathname, file);
		
		// read words and store them, removing punctuation and converting to lower-case
		storeWords(pathname, file, count);

		// grep
		for (int i = 0; i < 3; i++) { // do 3 times
			System.out.println("\nEnter a phrase: ");
			String phrase = user.nextLine();
			grep(file, pathname, count, phrase);
		}

	}

	public static int readAndCount(String pathname, File file) { // part 1
		Scanner input = null;

		// try to open file
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("***Cannot open " + pathname + "***");
			System.exit(1); // quit program
		}

		// read file and find number of words
		int i = 1;
		int count = 1;
		System.out.println("Words found in text -- ");
		String longest = input.next(); // declare first word as longest
		int max = longest.length();
		System.out.println(i + " " + longest);
		while (input.hasNext()) {
			String word = input.next();
			if (word.length() > max) { // change what longest word is if true
				longest = word;
				max = word.length();
			}
			i++;

			if (word.indexOf("--") >= 0 && word.indexOf("--") != word.length() - 2) // word in middle
				count = count + 2;
			else
				count++;
			System.out.println(i + " " + word);
		}
		
		
		System.out.println("The longest word in the text is <" + longest + ">.");

		input.close(); // close scanner
		return count;
	}

	public static void storeWords(String pathname, File file, int count) { // part 2
		Scanner input2 = null;
		// try to open file again
		try {
			input2 = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("***Cannot open " + pathname + "***");
			System.exit(1); // quit program
		}
		System.out.println("\nWords sorted alphabetically with duplicates removed-- ");
		String[] wordArray = new String[count];
		int i = 0;
		String word, word1, word2;
		while (input2.hasNext()) {
			word = input2.next();
			// remove punctuation and convert to lower case
			int length = word.length();
			if (word.indexOf("--") >= 0 && word.indexOf("--") != length - 2) { // in the middle
				int index = word.indexOf("--");
				word1 = word.substring(0, index);
				word1 = removePun(word1);
				wordArray[i] = word1;
				i++; // because there were two words there
				word2 = word.substring(index + 2, length); // 2 for dash
				word2 = removePun(word2);
				wordArray[i] = word2;
				i++;
			} 
			else {
				word = removePun(word); // remove punctuation
				word = removePun(word); // remove punctuation
				word = removePun(word); // use word not array because the word needs to be edited from last time

				wordArray[i] = word;
				i++;
			}

			// i++;
		} // while loop bracket
		Arrays.sort(wordArray);
		int num = 1;
		for (int j = 1; j < wordArray.length; j++) { // remove duplicates
			if (wordArray[j].equals(wordArray[j - 1])) {

			} else {
				wordArray[num] = wordArray[j]; // finds the word after the string of same words and puts the word after
												// instead
				num++;
			}
		}

		i = 0;
		for (int k = 0; k < num; k++) {
			System.out.println(k + " " + wordArray[k]);
		}

		input2.close();
	}

	public static String removePun(String temp) {
		
		char[] punctuation = { ',', '.', ';', ':', '?', '-', '!', '\"', '\'' };

		for (int n = 0; n < punctuation.length; n++) {
			int length = temp.length();
			int pun = temp.indexOf(punctuation[n]);
			char last = temp.charAt(length-1); 
			if (punctuation[n] == last) { // if at end, and works for double char 
				temp = temp.substring(0, length - 1);
				temp = temp.toLowerCase();
			} else if (pun == 0) { // if at beginning
				temp = temp.substring(1, length); // everything after 0th term
				temp = temp.toLowerCase();
			} else {
				temp = temp.toLowerCase();
			}

		}
		return temp;
	}

	public static void grep(File file, String pathname, int count, String phrase) { // part 3
		Scanner input3 = null;
		String line;
		int lineNum = 1;
		String part1 = null, part2 = null;
		int timesFound = 0;
		try {
			input3 = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("***Cannot open " + pathname + "***");
			System.exit(1); // quit program
		}

		while (input3.hasNextLine()) {
			line = input3.nextLine(); 
			int index = line.indexOf(phrase); 
			
			if(index >= 0) { 
				part1 = line.substring(0, index);
				part2 = line.substring(index + phrase.length(), line.length());
				System.out.print("Line " + lineNum + ": ");
				System.out.println(part1 + "<" + phrase + ">" + part2);
				timesFound++;	
			}

			lineNum++;

		}

		if (timesFound == 0) {
			System.out.println("Phrase not found.");
		}

	}

}
