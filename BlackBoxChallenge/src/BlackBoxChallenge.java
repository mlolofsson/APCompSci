/*
 * Name: Michelle Olofsson 
 * Block: H
 * Lab: Black Box Challenge 
 * Description: Create a black box game. 
 */

import java.util.Random;
import java.util.Scanner;

public class BlackBoxChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[10][10];
		
		// CREATE BOARD
		Random getOne = new Random();
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				board[row][col] = '.';
			}
		}
		int row, col;
		// create 10 random mirrors
		for (int i = 0; i < 10; i++) {
				row = getOne.nextInt(10);
				col = getOne.nextInt(10);
			int slash = getOne.nextInt(2);
			if (slash == 1) {
				board[row][col] = '/';
			} else {
				board[row][col] = '\\';
			}
		}
		
		// mirror status
		String[][] mirrorStatus = new String[10][10]; 
		for(int i=0; i<10; i++) { // row
			for(int j=0; j<10; j++) { // col
				mirrorStatus[i][j] = "notfound"; 
			} 
		}
		
		int shotNum = 0, right=0, wrong=0;
		printBoard(board, mirrorStatus, false, shotNum, right, wrong);
		
		menu(board, mirrorStatus, shotNum, right, wrong);

	}

	public static void menu(char board[][], String mirrorStatus[][], int shotNum, int right, int wrong) {
		Scanner input = new Scanner(System.in);
		int answer = 0;

		System.out.println("\nChoose: ");
		System.out.println("(0) Shoot a Laser");
		System.out.println("(1) Guess at a mirror location");
		System.out.println("(2) Quit the game");
		do {
			System.out.print("\n\nEnter choice: ");
			answer = input.nextInt();

			switch (answer) {
			case 0: // shoot a laser 
				
				int laserShot = 0; 
				System.out.print("\nChoose a laser to shoot: ");
				int laserNum = input.nextInt();
				// FIND WHERE STARTING POINT IS FOR LASER
				if (laserNum / 10 == 0) { //bottom
					int row = 9;
					int col = laserNum;
					char direction = 'n';
					laserShot = laser(board, row, col, direction);
				} else if (laserNum / 10 == 1) { //left
					int row = (9- (laserNum-10)); 
					int col = 0;
					char direction = 'e'; 
					laserShot = laser(board, row, col, direction);
				} else if (laserNum / 10 == 2) { //right
					int row = 0; 
					int col = laserNum-20;
					char direction = 's'; 
					laserShot = laser(board, row, col, direction); 
				} else { //right
					int row = laserNum-30; 
					int col = 9; 
					char direction = 'w'; 
					laserShot = laser(board, row, col, direction);
				}
				shotNum++; //increase number of shots taken
				printBoard(board, mirrorStatus, false, shotNum, right, wrong); 
				System.out.print("\nThe output laser is " + laserShot);
				break;
			case 1: // find a mirror
				boolean mirror; 
				int row=0, col=0; 
				
				System.out.print("Choose a location (enter two lasers): ");
				int laser1 = input.nextInt(); 
				int laser2 = input.nextInt(); 
				// FIND LOCATION OF MIRROR GUESS
				if (laser1 / 10 == 0) { //check if first laser is on the bottom
					col = laser1; 
					if(laser2/10==1) { //left
						 row = 9 - (laser2-10);
					}
					else if(laser2/10==3) { //right
						 row = laser2-30; 
					}
					mirror = findMirrors(board, row, col, mirrorStatus);
				}
				else if (laser1 / 10 == 1) { //check if first laser is on the left
					row = 9 - (laser1-10);
					if(laser2/10==2) { //top
						 col = laser2-20; 
					}
					else if(laser2/10==0) { //bottom
						 col = laser2; 
					}
					mirror = findMirrors(board, row, col, mirrorStatus);
				} 
				else if (laser1 / 10 == 2) { //check if first laser is on the top
					col = laser1-20; 
					if(laser2/10==1) { //left
						 row = 9 - (laser2-10); 
					}
					else if(laser2/10==3) { //right
						 row = laser2-30;  
					}
					mirror = findMirrors(board, row, col, mirrorStatus);
				} else { //check if first laser is on the right 
					row = laser1-30; 
					if(laser2/10==2) { //top
						 col = laser2-20; 
					}
					else if(laser2/10==0) { //bottom
						 col = laser2;  
					}
					mirror = findMirrors(board, row, col, mirrorStatus);
				}
	
				
				if(mirror==true) {
					right++; 
					printBoard(board, mirrorStatus, false, shotNum, right, wrong); 
					System.out.print("\nYou found a mirror!");
				}
				else {
					wrong++; 
					printBoard(board, mirrorStatus, false, shotNum, right, wrong); 
					System.out.print("\nThere is no mirror in position " + laser1 + " " + laser2 + "."); 
				}
					break;
			}
			
			int counter=0; 
			// check if they won 
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
				if(mirrorStatus[i][j].equals("found")) {
					counter++; 
				}
				} 
			}
			
			if(counter==10) {
				System.out.print("\n\nYay! You found all the mirrors!!! You WIN!"); 
			}
		} while (answer != 2);
	}

	public static boolean findMirrors(char board[][], int row, int col, String mirrorStatus[][]) {
		if(board[row][col] =='.') {
			return false; 
		}
		else {
			mirrorStatus[row][col] = "found"; 
			return true; 
		}
	}
	public static int laser(char board[][], int row, int col, char direction) { // n=north, s=south, w=west, e=east
		if (direction == 'w') {
			if (col == -1) { // base case is when the edge is reached
				return (9 - row) + 10;
			} else {
				if (board[row][col] == '/') {
					direction = 's'; // direction switches to 2 because laser is bounced to the right
					return laser(board, row + 1, col, direction); // call function
				} else if (board[row][col] == '\\') {
					direction = 'n'; // direction switches to 0 because laser is bounced to the left
					return laser(board, row - 1, col, direction); // call function
				} else {
					direction = 'w'; // direction does not change because no mirror
					return laser(board, row, col-1, direction); // call function
				}
				
			}
		} else if (direction == 'n') {
			if (row == -1) { // base case is when the edge is reached
				return col + 20;
			} else {
				if (board[row][col] == '/') {
					direction = 'e'; // direction switches because laser is bounced to the right
					return laser(board, row, col+1, direction); // call function
				} else if (board[row][col] == '\\') {
					direction = 'w'; // direction switches because laser is bounced to the left
					return laser(board, row, col-1, direction); 
				} else {
					direction = 'n'; // direction does not change because no mirror
					return laser(board, row - 1, col, direction); // call function
				}
				
			}
		}

		else if (direction == 'e') {
			if (col == 10) { // base case is when the edge is reached
				return row + 30;
			} else {
				if (board[row][col] == '/') {
					direction = 'n'; // direction switches because laser is bounced to the right
					return laser(board, row - 1, col, direction); // call function
				} else if (board[row][col] == '\\') {
					direction = 's'; // direction switches because laser is bounced to the left
					return laser(board, row + 1, col, direction); // call function
				} else {
					direction = 'e'; // direction does not change because no mirror
					return laser(board, row, col + 1, direction); // call function
				}
				
			}
		} else { // south
			if (row == 10) { // base case is when the edge is reached
				return col;
			} else {
				if (board[row][col] == '/') {
					direction = 'w'; // direction switches because laser is bounced to the right
					return laser(board, row, col - 1, direction); // call function
				} else if (board[row][col] == '\\') {
					direction = 'e'; // direction switches because laser is bounced to the left
					return laser(board, row, col + 1, direction); // call function
				} else {
					direction = 's'; // direction does not change because no mirror
					return laser(board, row + 1, col, direction); // call function
				}
				
			}
		}

	}

	

	public static void printBoard(char board[][], String mirrorStatus[][], boolean yes, int shotNum, int right, int wrong) {
		int row = 0;
		System.out.print("\n  ");
		for (int i = 20; i < 30; i++) { // prints top numbers on board
			System.out.print(i);
		}
		int rightNum = 30;
		for (int i = 19; i > 9; i--) { // prints out every row in the board, including the numbers
			System.out.print("\n" + i + " ");
			int col=0;
			for (int j = 0; j < 10; j++) { // prints numbers on the right
				if(yes == true) { // testing to be able to see all mirrors
					if(col>9) {
						
					}
					else if(board[row][col] != '.') {
						System.out.print(board[row][col] + " ");
					}
					else { 
						System.out.print(". ");
					}
				}
				else {
				if(mirrorStatus[row][col].equals("found")) { // only prints mirrors that were already found 
					System.out.print(board[row][col] + " ");
				} 
				
				else {
					System.out.print(". ");
				}
				}
				col++;
			}
			System.out.print(rightNum);
			rightNum++; // next time it will print the number after in the right column
			row++;
		}
		System.out.print("\n  ");
		for (int i = 0; i < 10; i++) {
			System.out.print(" " + i);
		}
		System.out.print("\n\nYour game statistics: ");
		System.out.print("\n  laser shots = " + shotNum); 
		System.out.print("\n  correct mirror guesses = " + right);
		System.out.println("\n  incorrect mirror guesses = " + wrong);
	}
}
