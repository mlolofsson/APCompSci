import java.util.*; 

/*
 * Name: Michelle Olofsson 
 * Lab: Cipher
 * Block: H
 * Description: Use multiple classes to decode a text file. 
 */

public class Record2 implements Comparable<Record2> {

	private char letter;
	private char newLetter;
	private int frequency;

	public Record2() { // constructors are called record
		letter = ' ';
		frequency = 0;
	}

	public Record2(char inputL) {
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

	public int compareTo(Record2 r) {
		if (frequency > r.getFrequency())
			return -1; // means frequency is bigger than
		else if (frequency < r.getFrequency())
			return 1;
		else
			return 0;
	}

}

class OriginalCompare implements Comparator{
	public int compare(Object emp1, Object emp2) {
		char emp1Letter = ((Record2)emp1).getLetter();
		char emp2Letter = ((Record2)emp2).getLetter(); 
		
		if(emp1Letter > emp2Letter)
			return 1; 
		else if(emp1Letter < emp2Letter)
			return -1; 
		else
			return 0; 
	}
}

class NewCompare implements Comparator{
	public int compare(Object emp1, Object emp2) {
		char emp1New = ((Record2)emp1).getNewLetter();
		char emp2New = ((Record2)emp2).getNewLetter();
		
		if(emp1New > emp2New)
			return 1; 
		else if(emp1New < emp2New)
			return -1; 
		else 
			return 0; 
	}
}
