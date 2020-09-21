import java.util.*; 

/*
 * Name: Michelle Olofsson 
 * Lab: Cipher
 * Block: H
 * Description: Use multiple classes to decode a text file. 
 */

public class Record implements Comparable<Record> {

	private char letter;
	private char newLetter;
	private int frequency;

	public Record() { // constructors are called record
		letter = ' ';
		frequency = 0;
	}

	public Record(char inputL) {
		letter = inputL;
		frequency = 0;
	}
	
	public char setNewLet(char replace) {
		newLetter = replace; 
		return newLetter;
	}

	public void increaseFrequency() {
		frequency++;
	}

	public int getFrequency() {
		return frequency;
	}

	public char getLetter() {
		return letter;
	}
	
	public char getNewLetter() {
		return newLetter; 
	}

	public int compareTo(Record r) {
		if (frequency > r.getFrequency())
			return -1; // means frequency is bigger than
		else if (frequency < r.getFrequency())
			return 1;
		else
			return 0;
	}

}


