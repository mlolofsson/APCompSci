
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		String[] userWords = intro(userInput);
		translate(userWords);

	}

	public static String[] intro(Scanner userInput) {
		System.out.println("Enter a word to be translated into Pig Latin!");
		String line = userInput.nextLine();
		String[] userWords = null;// = new String[1000];
		if(line != null){
			userWords = line.split(" ");
		}
		return userWords;
	}

	public static void translate(String [] userWords) {
		String firstLetter = null;
		String rest = null;
		String finalWord = null;
		for (int n= 0; n< userWords.length; n++){
		for(int i = 0; i < userWords[n].length(); i++){
			firstLetter = userWords[n].substring(0, 1);
			rest = userWords[n].substring(1);
			finalWord = rest + firstLetter + "ay";

		}
		if (vowel(firstLetter, userWords)){
			finalWord = userWords[n] + "yay";
			System.out.print(finalWord + " ");
		}
		else 
			System.out.print(finalWord + " ");
		}

	}

	public static boolean vowel(String firstLetter, String[] userWords) {
		if (firstLetter.equalsIgnoreCase("a") || firstLetter.equalsIgnoreCase("e") || firstLetter.equalsIgnoreCase("i")
				|| firstLetter.equalsIgnoreCase("o") || firstLetter.equalsIgnoreCase("u")) {
			return true;
		}
		return false;
	}

}

