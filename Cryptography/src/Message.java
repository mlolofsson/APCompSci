/*
 * Name: Michelle Olofsson 
 * Lab: Cryptography Final Assignment 
 * Block: H
 * Description: Write a program that uses a code to encrypt and decrypt given text. 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Message {
	private String[] decrypted; // words
	private String[] encrypted; // code that corresponds with words
	private int length;

	public Message(String[] decrypted) { // create message with given decrypted
		this.decrypted = decrypted;
		this.length = decrypted.length;
		this.encrypted = new String[length];
	}

	public Message(String[] encrypted, boolean different) { // create message with given encrypted
		this.encrypted = encrypted;
		//System.out.print("Constructor: " + encrypted[0]);
		this.length = encrypted.length;
		this.decrypted = new String[length];
	}

	public void encrypt(Grid grid, String[][] standardGrid) {

		// SET UP ENCRYPTED NUMBERS
		for (int i = 0; i < length; i++) {
			for (int r = 0; r < standardGrid.length; r++) { // loop through standard grid in order to compare
				for (int c = 0; c < standardGrid[0].length; c++) {
					if (standardGrid[r][c].equals(decrypted[i])) {
						// System.out.println(" row and col: " + standard[r][0] + " " + standard[0][c]);
						if(decrypted[i].equals("0") || decrypted[i].equals("1") || decrypted[i].equals("2") || 
								decrypted[i].equals("3") || decrypted[i].equals("4") || decrypted[i].equals("5") ||
								decrypted[i].equals("6") || decrypted[i].equals("7") || decrypted[i].equals("8") || 
								decrypted[i].equals("9")) {
							encrypted[i] = grid.getSlashLocation() + decrypted[i] + grid.getPeriodLocation(); // if decrypted is a number 
						}
						else {
						encrypted[i] = standardGrid[r][0] + standardGrid[0][c]; // create number that represents letter
						}
					}
				}
			}
		}
	}

	public void decrypt(Grid grid, String[][] standardGrid) {
		// SET UP DECRYPTED TEXT 
		for(int i=0; i < length; i++) {
			for(int r=0; r<standardGrid.length; r++) {
				for(int c=0; c<standardGrid[0].length; c++) {
					if(encrypted[i].length()==0) {
						decrypted[i] = "";
					}
					else {
					String firstDigit = encrypted[i].substring(0, 1); // get first digit of coordinates 
					String secondDigit = encrypted[i].substring(1,2); // get second digit of coordinates
					if((firstDigit+secondDigit).equals(grid.getSlashLocation())){ // if it represents a number 
						decrypted[i] = encrypted[i].substring(2, 3); 
					}
					else if(standardGrid[r][0].equals(firstDigit) && standardGrid[0][c].equals(secondDigit)) { // if coordinates match
						decrypted[i] = standardGrid[r][c]; 
					}
					}
				}
			}
		}
	}

	public String[] getDecrypted() {
		return decrypted;
	}

	public String[] getEncrypted() {
		return encrypted;
	}

	public int getLength() {
		return length; 
	}
	public void printEncrypted() {
		for (int i = 0; i < length; i++) {
			System.out.print(encrypted[i]);
		}
	}

	public void printDecrypted() {
		for (int i = 0; i < length; i++) {
			if(decrypted[i]==null) {
				System.out.print("Some of your code did not match the grid.");
			}
			System.out.print(decrypted[i]);
			
		}
	}

	public void saveEncryptedToTextFile(String pathname) {
		File file = new File(pathname);
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException ex) {
			System.out.println("Cannot create " + pathname);
			System.exit(1);
		}
		for (int c = 0; c < length; c++) { // only put encrypted numbers in file
			output.print(encrypted[c]); // format
		}
		output.close();
	}

	public void saveDecryptedToTextFile(String pathname) {
		File file = new File(pathname);
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException ex) {
			System.out.println("Cannot create " + pathname);
			System.exit(1);
		}
		for (int c = 0; c < length; c++) { // only put encrypted numbers in file
			output.print(decrypted[c]); // format
		}
		output.close();
	}
	
	public void setDecrypted(int index, String replace) {
		decrypted[index] = replace; 
	}

}
