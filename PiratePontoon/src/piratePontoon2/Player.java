package piratePontoon2;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private Cards cards;
	
	private final List<Cards> hand = new ArrayList<>();
	private int handValue;
	

	//Deals a card from chosen deck
		Cards addCard(Deck deck) {
	
		
		hand.add(deck.dealCard());
		return cards;
		
	}
		
		//Value of the card in the hand
		public int handValue() {
			handValue = 0;
			for (Cards cards : hand ) {
				handValue += cards.getValue();
			}
			return handValue;
		}
		
		//Prints the hand and hand value
		public String toString() {
			return hand.toString() + "\nThis leaves a hand value of: " + handValue();
		}
	
	

	
	
}
