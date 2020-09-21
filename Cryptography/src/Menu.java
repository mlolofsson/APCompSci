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

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		repeatingMenu();
	}

	public static void repeatingMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nOptions are: ");
		System.out.println("(1) Create a grid ");
		System.out.println("(2) Encrypt file ");
		System.out.println("(3) Decrypt file ");
		System.out.println("(4) Exit program ");

		System.out.print("\nWhat first? ");
		int answer = input.nextInt();
		Grid standard = null;
		do {

			switch (answer) {
			case 1:
				standard = createStandardGrid();
				break;
			case 2:
				if (standard == null) { // check if grid exists
					System.out.print("You must first create the stanadard grid.");
				} else {
					encryptText(input, standard);
				}
				break;
			case 3:
				if (standard==null) {
					System.out.print("You must first create the standard grid.");
				} else {
					decryptText(input, standard);
				}
				break; 
			case 4:
				System.exit(1);
				break; 
			}
			System.out.print("\n\nWhat next? ");
			answer = input.nextInt();
		} while (answer != 4);
	}

	public static Grid createStandardGrid() {
		Grid standard = new Grid(); // create standard grid

		// PRINT STANDARD GRID
		System.out.println("\nStandard grid: ");
		standard.printGrid();

		// SAVE STANDARD GRID TO A TEXT FILE
		String standardPathname = "Standard.txt";
		standard.saveToTextFile(standardPathname);

		return standard;
	}

	public static void encryptText(Scanner input, Grid standard) {
		Grid toCompare = null; // grid that will be used as reference for encrypting
		System.out.print("\nWould you like to load your own grid? (Y/N) ");
		String ans = input.next();
		if (ans.equals("Y")) {
			toCompare = loadGrid(input);
		} else {
			toCompare = standard;
		}
		System.out.println("\nOptions are: ");
		System.out.println("(a) load a file to encrypt");
		System.out.println("(b) enter text to encrypt");
		System.out.print("\nWhat would you like to do? ");
		String response = input.next();
		// Message messToEncrypt = null;

		switch (response) {
		case "a":
			System.out.print("\nWhat is the name of your file? ");
			String pathname = input.next();
			System.out.print(pathname);
			File file = new File(pathname);
			Scanner in = null;
			try {
				in = new Scanner(file);
			} catch (FileNotFoundException ex) {
				System.out.println("***Cannot open " + pathname + "***");
				System.exit(1); // quit program
			}
			while (in.hasNextLine()) { // will there ever be multiple lines?
				// System.out.print("In loop!");
				String line = in.nextLine();
				char[] temp = line.toCharArray();
				String[] array2 = new String[temp.length];
				for (int i = 0; i < temp.length; i++) { // turn into String array
					array2[i] = Character.toString(temp[i]);
					
				}
				Message messToEncrypt1 = new Message(array2); // set message decrypted to array
				messToEncrypt1.encrypt(toCompare, toCompare.getGrid());
				String[] encrypted = messToEncrypt1.getEncrypted();
				// System.out.print("Out of loop!");
				System.out.println("\n\nYour message: ");
				System.out.println("Decrypted: ");
				messToEncrypt1.printDecrypted();
				System.out.println("\nEncrypted: ");
				messToEncrypt1.printEncrypted();

				// SAVE ENCRYPTED TEXT TO NEW FILE
				String encryptedPathname = "Encrypted.txt";
				messToEncrypt1.saveEncryptedToTextFile(encryptedPathname);
			}
			break;
		case "b":
			System.out.print("\nWhat text would you like to encrypt? "); // no spaces...
			String text = input.next();
			char[] text2 = text.toCharArray();
			String[] textArray = new String[text2.length];
			for (int i = 0; i < text.length(); i++) {
				textArray[i] = Character.toString(text2[i]);
			}
			// CREATE MESSAGE OF TEXT TO ENCRYPT
			Message messToEncrypt2 = new Message(textArray);
			// SAVE TO TEXT FILE
			String beforePathname = "GivenToEncrypt.txt";
			File beforeFile = new File(beforePathname);
			PrintWriter output = null;
			try {
				output = new PrintWriter(beforeFile);
			} catch (FileNotFoundException ex) {
				System.out.println("Cannot create " + beforePathname);
				System.exit(1);
			}
			messToEncrypt2.saveDecryptedToTextFile(beforePathname);

			messToEncrypt2.encrypt(toCompare, toCompare.getGrid());
			String[] encrypted = messToEncrypt2.getEncrypted();
			// System.out.print("Out of loop!");
			System.out.println("\n\nYour message: ");
			System.out.println("Decrypted (input): ");
			messToEncrypt2.printDecrypted();
			System.out.println("\nEncrypted: ");
			messToEncrypt2.printEncrypted();

			// SAVE ENCRYPTED TEXT TO NEW FILE
			String encryptedPathname = "Encrypted.txt";
			messToEncrypt2.saveEncryptedToTextFile(encryptedPathname);
			break;
		}
	}

	public static Grid loadGrid(Scanner input) {
		Grid loadedGrid = null; // grid that will be used as reference for encrypting
		System.out.print("What is the name of your file? ");
		String pathname = input.next();
		File file = new File(pathname);
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("***Cannot open " + pathname + "***");
			System.exit(1); // quit program
		}
		String[][] tempArr = new String[4][11];
		int r = 0, c = 0;
		while (in.hasNextLine()) {
			String line = in.nextLine();
			char[] temp = line.toCharArray();
			String[] array2 = new String[temp.length];
			for (int i = 0; i < temp.length; i++) { // turn into String array
				array2[i] = Character.toString(temp[i]);
			}
			for (int x = 0; x < 11; x++) {
				tempArr[r][x] = array2[x]; // set up array with values in grid
			}
			r++;
		}

		loadedGrid = new Grid(tempArr);

		return loadedGrid;
	}

	public static void decryptText(Scanner input, Grid standard) {
		Grid toCompare = null; // grid that will be used as reference for decrypting
		System.out.print("Would you like to load your own grid? (Y/N) ");
		String ans = input.next();
		if (ans.equals("Y")) {
			toCompare = loadGrid(input);
		} else {
			toCompare = standard;
		}

		System.out.println("\nOptions are: ");
		System.out.println("(a) load a file to decrypt");
		System.out.println("(b) enter text to decrypt");
		System.out.print("\nWhat would you like to do? ");
		String response = input.next();

		switch (response) {
		case "a":
			System.out.print("\nWhat is the name of your file? ");
			String pathname = input.next();
			//System.out.print(pathname);
			File file = new File(pathname);
			Scanner in = null;
			try {
				in = new Scanner(file);
			} catch (FileNotFoundException ex) {
				System.out.println("***Cannot open " + pathname + "***");
				System.exit(1); // quit program
			}
			while (in.hasNextLine()) { // will there ever be multiple lines?
				// System.out.print("In loop!");
				String line = in.nextLine();
				char[] chars = line.toCharArray();
				String[] array2 = new String[chars.length/2];
				int tempIndex=0; 
				for (int i = 0; i < chars.length/2; i++) { // turn into String array
					//String temp2 = Character.toString(temp[tempIndex]) + Character.toString(temp[tempIndex+1]);
					//System.out.println("temp2 = " + temp2 + " slashloc =  " + toCompare.getSlashLocation());
					//if(temp2.equals(toCompare.getSlashLocation()) || temp2.equals(toCompare.getPeriodLocation())){
						//tempIndex = tempIndex + 2;  // skip over the slash and periods 
					//}
					//else {
					//array2[i] = temp2;  
					//tempIndex=tempIndex+2; 
					//}
					//System.out.print(array2[i]);
					String temp2 = Character.toString(chars[tempIndex]) + Character.toString(chars[tempIndex+1]);
					if(temp2.equals(toCompare.getSlashLocation())){
						array2[i] = temp2 + Character.toString(chars[tempIndex+2]) + Character.toString(chars[tempIndex+3])
						+ Character.toString(chars[tempIndex+4]); // get slash, number, and period in same slot 
						tempIndex = tempIndex + 5;  // skip over the slash and periods 
						//textArray[i] = Character.toString(text2[tempIndex]);
					}
					
					else {
					array2[i] = temp2;  
					tempIndex=tempIndex+2; 
					}
					if(tempIndex==chars.length) {
						for(int x=i+1; x<chars.length/2; x++) { 
							array2[x] = ""; // set extra positions in array to nothing 
						}
						i=chars.length/2;
					}
				}
				Message messToDecrypt1 = new Message(array2, true); // set message encrypted variable to array
				int length = messToDecrypt1.getLength();
				System.out.print("length= " + length); 
				messToDecrypt1.decrypt(toCompare, toCompare.getGrid());
				String[] decrypted = messToDecrypt1.getDecrypted();
				//messToDecrypt1.printEncrypted();
				/*for(int i=0; i < length; i++) {
					for(int r=0; r<toCompare.getGrid().length; r++) {
						for(int c=0; c<toCompare.getGrid()[0].length; c++) {
							//System.out.print("dfghj");
							String firstDigit = messToDecrypt1.getEncrypted()[i].substring(0, 1); // get first digit of coordinates 
							//System.out.print(firstDigit + " ");
							String secondDigit = messToDecrypt1.getEncrypted()[i].substring(1); // get second digit of coordinates
							//System.out.print(secondDigit + " ");
							if(toCompare.getGrid()[r][0].equals(firstDigit) && toCompare.getGrid()[0][c].equals(secondDigit)) { // if coordinates match
								//System.out.print("here");
								messToDecrypt1.setDecrypted(i, toCompare.getGrid()[r][c]); 
							}
						}
					}
				}*/
				
				// System.out.print("Out of loop!");
				System.out.println("\n\nYour message: ");
				System.out.println("Encrypted (input): ");
				messToDecrypt1.printEncrypted();
				System.out.println("\nDecrypted: ");
				messToDecrypt1.printDecrypted();

				// SAVE ENCRYPTED TEXT TO NEW FILE
				String decryptedPathname = "Decrypted.txt";
				messToDecrypt1.saveDecryptedToTextFile(decryptedPathname);
			}
			break;
		case "b":
			System.out.print("\nWhat text would you like to decrypt? "); // no spaces...
			String t = input.nextLine();
			String text = input.nextLine(); 
			char[] text2 = text.toCharArray();
			String[] textArray = new String[text2.length/2];
			//String[] array2 = new String[temp.length/2];
			int tempIndex=0; 
			
			for (int i = 0; i < text2.length/2; i++) { // turn into String array
				String temp3 = Character.toString(text2[tempIndex]) + Character.toString(text2[tempIndex+1]);
				if(temp3.equals(toCompare.getSlashLocation())){
					textArray[i] = temp3 + Character.toString(text2[tempIndex+2]) + Character.toString(text2[tempIndex+3])
					+ Character.toString(text2[tempIndex+4]); // get slash, number, and period in same slot 
					tempIndex = tempIndex + 5;  // skip over the slash and periods 
					//textArray[i] = Character.toString(text2[tempIndex]);
				}
				
				else {
				textArray[i] = temp3;  
				tempIndex=tempIndex+2; 
				}
				if(tempIndex==text2.length) {
					for(int x=i+1; x<text2.length/2; x++) { 
						textArray[x] = ""; // set extra positions in array to nothing 
					}
					i=text2.length/2;
				}
				//System.out.print("textArray[0] " + textArray[i]);
				//System.out.print(array2[i]);
			}
			//System.out.print("textArray[0] " + textArray[0]);
			// CREATE MESSAGE OF TEXT TO ENCRYPT
			Message messToDecrypt2 = new Message(textArray, true);
			// SAVE TO TEXT FILE
			String beforePathname = "GivenToDecrypt.txt";
			File beforeFile = new File(beforePathname);
			PrintWriter output = null;
			try {
				output = new PrintWriter(beforeFile);
			} catch (FileNotFoundException ex) {
				System.out.println("Cannot create " + beforePathname);
				System.exit(1);
			}
			messToDecrypt2.saveEncryptedToTextFile(beforePathname); // save GivenToDecrypt.txt

			messToDecrypt2.decrypt(toCompare, toCompare.getGrid());
			String[] decrypted = messToDecrypt2.getEncrypted();
			// System.out.print("Out of loop!");
			System.out.println("\n\nYour message: ");
			System.out.println("Encrypted(input): ");
			messToDecrypt2.printEncrypted();
			System.out.println("\nDecrypted: ");
			messToDecrypt2.printDecrypted();

			// SAVE ENCRYPTED TEXT TO NEW FILE
			String decryptedPathname = "Decrypted.txt";
			messToDecrypt2.saveDecryptedToTextFile(decryptedPathname);
			break;
			
		}
	}

}
