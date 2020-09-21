/*
 * Name: Michelle Olofsson 
 * Lab: Cryptography Final Assignment 
 * Block: H
 * Description: Write a program that uses a code to encrypt and decrypt given text. 
 */
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Grid {

	private String[][] grid;
	private static int numRows = 4;
	private static int numCols = 11;
	private String slashLocation; 
	private String periodLocation; 

	public Grid() { // create standard grid
		grid = new String[numRows][numCols];

		// set up first row
		grid[0][0] = " ";
		for (int i = 1; i < grid[0].length; i++) {
			grid[0][i] = String.valueOf(i - 1);
		}

		int blank1 = 1 + ((int) (Math.random() * 10)); // find random blank spot index in second row
		int blank2 = 1 + ((int) (Math.random() * 10)); // find random blank spot index in second row

		while (blank2 == blank1) { // ensure that indexes are not equal
			blank2 = 1 + ((int) (Math.random() * 10));
		}

		// set up second row
		String[] frequentLets = { "E", "T", "A", "O", "N", "R", "I", "S" };
		grid[1][0] = " "; // do I need this?
		int letIndex = 0;
		for (int i = 1; i < grid[0].length; i++) {
			if (i != blank1 && i != blank2) {
				grid[1][i] = frequentLets[letIndex];
				letIndex++;
			} else {
				grid[1][i] = " ";
			}
		}

		// set up third row
		String[] remainingAlphabet = { "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "P", "Q", "U", "V",
				"W", "X", "Y", "Z" };
		grid[2][0] = String.valueOf(blank1 - 1);
		int alphaIndex = 0;
		for (int i = 1; i < grid[0].length; i++) {
			grid[2][i] = remainingAlphabet[alphaIndex];
			alphaIndex++; // increase every time a letter of alphabet was added
		}

		// set up fourth row

		grid[3][0] = String.valueOf(blank2 - 1);
		int spare1 = 1 + ((int) (Math.random() * 10));
		int spare2 = 1 + ((int) (Math.random() * 10));
		
		slashLocation = grid[3][0] + String.valueOf(spare1-1); 
		periodLocation = grid[3][0] + String.valueOf(spare2-1); 

		while (spare2 == spare1) {
			spare2 = 1 + ((int) (Math.random() * 10));
		}
		for (int i = 1; i < grid[0].length; i++) {
			if (i == spare1) {
				grid[3][i] = "/";
			} else if (i == spare2) {
				grid[3][i] = ".";
			} else {
				grid[3][i] = remainingAlphabet[alphaIndex];
				alphaIndex++;
			}
		}

	}
	
	public Grid(String[][] givenGrid) {
		grid = new String[numRows][numCols];
		for(int r=0; r<numRows; r++) {
			for(int c=0; c<numCols; c++) {
				grid[r][c] = givenGrid[r][c]; 
				if(givenGrid[r][c].equals("/")) {
					slashLocation = grid[r][0] + grid[0][c]; 
				}
				else if(givenGrid[r][c].equals(".")) {
					periodLocation =  grid[r][0] + grid[0][c]; 
				}
			}
		}
	}
	
	public String getSlashLocation() {
		return slashLocation; 
	}
	
	public String getPeriodLocation() {
		return periodLocation; 
	}
	
	public int getCols() {
		return numCols;
	}

	public int getRows() {
		return numRows;
	}

	public String[][] getGrid() {
		return grid;
	}

	public void printGrid() {
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				System.out.printf("%4s", grid[r][c]);
			}
			System.out.print("\n");
		}
	}
	
	public void saveToTextFile(String pathname) { 
		File file = new File(pathname);
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException ex) {
			System.out.println("Cannot create " + pathname);
			System.exit(1);
		}
		for (int r = 0; r < grid.length; r++) { // print all rows and columns 
			for(int c = 0; c < grid[0].length; c++) {
				output.printf("%4s", grid[r][c]); // format
			}
			output.print("\n");
			
		}
		output.close();
	}

}
