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
		
		assert c1.rank().equals("ace") : "Wrong rank: " + c1.rank(); 
		assert c1.suit().equals("hearts") : "Wrong suit: " + c1.suit(); 
		assert c1.pointValue() == 1 : "Wrong point value: " + c1.pointValue(); 
		assert c6.rank().equals("queen") : "Wrong rank: " + c6.rank();
		assert c6.suit().equals("clubs") : "Wrong suit: " + c6.suit();
		assert c6.pointValue() == 3: "Wrong point value : "
		+ c6.pointValue();
		
		assert c1.matches(c1) : "Card doesn't match itself: " + c1;
		assert c1.matches(c2) : "Duplicate cards aren't equal: " + c1;
		assert !c1.matches(c3)
		: "Different cards are equal: " + c1 + ", " + c3;
		assert !c1.matches(c4)
		: "Different cards are equal: " + c1 + ", " + c4;
		assert !c1.matches(c5)
		: "Different cards are equal: " + c1 + ", " + c5;
		assert !c1.matches(c6)
		: "Different cards are equal: " + c1 + ", " + c6;
		
		System.out.println("All tests passed!");
	
	}
}
