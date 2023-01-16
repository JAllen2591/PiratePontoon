package piratePontoon2;

import java.util.List;
import java.util.ArrayList;

public class Hand {
	
	public final List<Cards> hand = new ArrayList<>();
	private Cards cards;
	private int handValue; //To tally the value in the hand 
	
	
	//Deals a card
	public Cards addCard(Deck deck) {
		hand.add(deck.dealCard());
		return cards;
	}
	
	//Getter for the value of the hand
	public int getHandValue() {
		handValue = 0;
		for (Cards cards : hand ) {
			handValue += cards.getValue();
		}
		return handValue;
	}
	
	

	//Prints the current cards stored in the hand 
	public String toString() {
		return "Hand: " + hand;
	}
	
	
	

}
