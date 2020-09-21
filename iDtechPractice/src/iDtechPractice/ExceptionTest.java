package iDtechPractice;

import java.util.InputMismatchException;
import java.util.Scanner;
 
 
public class ExceptionTest {
 
	static Scanner input = new Scanner(System.in);
	
    public static void main(String[] args) {
        
        float userMoney = 0;
        float userHealth = 0;
        
        try{
        	// TODO Handle the error that occurs when the user doesn't enter a number.
        	System.out.println("Enter the amount of money your character has:");
            userMoney = input.nextFloat();
        }catch(InputMismatchException e){
        	System.out.println("Error, that is not a number. I'm going to assume you meant to say 0");
        	userMoney = 0;
        }
        System.out.println("Great, you have " + userMoney + " money now.\n\n");
        try{
        	//userHealth = askForNumber();
        }catch(InputMismatchException e) {
        	input.nextLine();
        	System.out.println("That's not a number, your health is set to the default 20.");
        	userHealth = 20;
        }
        System.out.println("You have " + userMoney + " money and " + userHealth + " health.");
    }
    
    static float askforNumber() throws InputMismatchException{
    	System.out.print("Enter a float: ");
    	return input.nextFloat();
    }
 
}
