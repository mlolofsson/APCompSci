/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card one = new Card("ace", "spade", 11);
		Card two = new Card("2", "diamonds", 2); 
		Card three = new Card("queen", "spade", 10); 
		
		System.out.println(one.toString());
		System.out.println(two.toString());
		System.out.println(three.toString());
		
		/* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
		Card c1 = new Card("ace", "hearts", 1); 
		Card c2 = new Card("ace", "hearts", 1); 
		Card c3 = new Card("ace", "hearts", 2); 
		Card c4 = new Card("ace", "spades", 1); 
		Card c5 = new Card("king", "hearts", 1); 
		Card c6 = new Card("queen", "clubs", 3); 
		
		assert c1.rank().equals("4") : "Wrong rank: " + c1.rank(); 
	
	}
}
