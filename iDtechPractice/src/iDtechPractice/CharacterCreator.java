package iDtechPractice;

import java.util.Scanner;

public class CharacterCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner playerInput = new Scanner(System.in);
		String playerName; 
		double playerHealth;
		System.out.println("What is your character's name?");
		playerName = playerInput.nextLine();
		System.out.println("How much helath does " + playerName + " have?" );
		playerHealth = playerInput.nextDouble();
		System.out.println("Welcome " + playerName + " you have " + playerHealth + " HP");
		
	
	}

}