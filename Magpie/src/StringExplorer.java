/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		//String sample = "The quick brown fox jumped over the lazy dog.";
		String sample = "One fish, two fish, red fish, blue fish."; // test findIndex with other parameters
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("fish");
		System.out.println ("sample.indexOf(\"fish\") = " + position);
		
		// Demonstrate output when word is not there
		
		int notFoundPsn = sample.indexOf("slow");
		System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
		
		// version of indexOf with other parameters
		position = sample.indexOf("fish", 5);
		System.out.println("sample.indexOf(\"fish\", 5) = " + position);
		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);
		
		//  Try other methods here:

	}

}
