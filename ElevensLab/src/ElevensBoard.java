import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES = 
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


	/**
	 * The cards on this board.
	 */
	private Card[] cards;

	/**
	 * The deck of cards being used to play the current game.
	 */
	private Deck deck;

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
		/*cards = new Card[BOARD_SIZE];
		deck = new Deck(RANKS, SUITS, POINT_VALUES);
		if (I_AM_DEBUGGING) {
			System.out.println(deck);
			System.out.println("----------");
		}
		dealMyCards();*/
	}

	/**
	 * Start a new game by shuffling the deck and
	 * dealing some cards to this board.
	 */
	

	/**
	 * Accesses the size of the board.
	 * Note that this is not the number of cards it contains,
	 * which will be smaller near the end of a winning game.
	 * @return the size of the board
	 */
	

	/**
	 * Determines if the board is empty (has no cards).
	 * @return true if this board is empty; false otherwise.
	 */
	

	/**
	 * Deal a card to the kth position in this board.
	 * If the deck is empty, the kth card is set to null.
	 * @param k the index of the card to be dealt.
	 */
	

	/**
	 * Accesses the deck's size.
	 * @return the number of undealt cards left in the deck.
	 */

	/**
	 * Accesses a card on the board.
	 * @return the card at position k on the board.
	 * @param k is the board position of the card to return.
	 */
	

	/**
	 * Replaces selected cards on the board by dealing new cards.
	 * @param selectedCards is a list of the indices of the
	 *        cards to be replaced.
	 */
	

	/**
	 * Gets the indexes of the actual (non-null) cards on the board.
	 *
	 * @return a List that contains the locations (indexes)
	 *         of the non-null entries on the board.
	 */


	/**
	 * Generates and returns a string representation of this board.
	 * @return the string version of this board.
	 */
	

	/**
	 * Determine whether or not the game has been won,
	 * i.e. neither the board nor the deck has any more cards.
	 * @return true when the current game has been won;
	 *         false otherwise.
	 */
	

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		int numCards = selectedCards.size(); 
		if(numCards==2 && containsPairSum11(selectedCards)) {
			replaceSelectedCards(selectedCards); 
			return true; 
		}
		else if(numCards==3 && containsJQK(selectedCards)) {
			replaceSelectedCards(selectedCards); 
			return true;
		}
		else {
			return false; 
		}
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		List<Integer> indexes = cardIndexes(); 
		if(containsPairSum11(indexes)==true) {
			return true; 
		}
		else if(containsJQK(indexes)==true) {
			return true; 
		}
		else {
			return false; 
		}
	
	}


	/**
	 * Deal cards to this board to start the game.
	 */
	

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		/*int card1 = selectedCards.get(0);
		int card2 = selectedCards.get(1); 
		if(cards[card1].pointValue() + cards[card2].pointValue() == 11) {
			return true; 
		}
		else {
			return false; 
		}*/
		
		
		for(int i=0; i<selectedCards.size(); i++) {
			int pv1 = cardAt(selectedCards.get(i)).pointValue(); 
			for(int j=i+1; j<selectedCards.size(); j++) {
				int pv2 = cardAt(selectedCards.get(j)).pointValue();
				if(pv1+pv2==11) {
					return true; 
				}
			}
		}
		return false; 
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 ***/
		
		int numJ = 0, numQ = 0, numK = 0; 
		
		for(Integer i : selectedCards) {
			if(cardAt(selectedCards.get(i)).rank().equals("jack")) {
				numJ++; 
			}
			else if(cardAt(selectedCards.get(i)).rank().equals("queen")) {
				numQ++; 
			}
			else if(cardAt(selectedCards.get(i)).rank().equals("king")) {
				numK++; 
			}
		}
		
		if(numJ==1 && numQ==1 && numK==1) {
			return true; 
		}
		
		else { 
			return false; 
		}
	}
}
