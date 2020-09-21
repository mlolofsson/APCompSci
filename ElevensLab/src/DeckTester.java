/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
		String ranks1[] = {"jack", "queen"};
		String ranks2[] = {"ace", "2", "4"}; 
		String ranks3[] = {"king", "8", "10", "ace"}; 
		
		String suits1[] = {"clubs", "diamonds"}; 
		String suits2[] = {"spades", "clubs", "clubs"};
		String suits3[] = {"diamonds", "diamonds", "hearts", "spades"}; 
		
		int values1[] = {10, 10}; // 21 game
		int values2[] = {11, 2, 4}; 
		int values3[] = {10, 8, 10, 11}; 
		
		Deck one = new Deck(ranks1, suits1, values1); 
		Deck two = new Deck(ranks2, suits2, values2); 
		Deck three = new Deck(ranks3, suits3, values3);
		
		
		Card dealt = one.deal();  
		
		System.out.println("\nDealt card = " + dealt.rank() + " " + dealt.suit() + " " + dealt.pointValue()); 
		
		// ACTIVITY 4
		
		String[] ranks = {"jack", "queen", "king", "8", "2", "4", "6", "ace", "seven"};
		String[] suits = {"spades", "diamonds", "diamonds", "hearts", "hearts", "hearts", "spades", "spades", "hearts"};
		int[] pointValues = {10, 10, 10, 8, 2, 4, 6, 11, 7};
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		/* *** TO BE COMPLETED IN ACTIVITY 4 *** */
		
		d.shuffle();
		
		System.out.print(d.toString());
		
		
		
	}
}
