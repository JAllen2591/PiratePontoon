package piratePontoon2;


public class Cards {
	
// Making an enum for the suits	
public enum Suits {
	HEARTS("Hearts"), DIAMONDS("Diamonds"), SPADES("Spades"), CLUBS("Clubs");
	
	private final String suitName;
	Suits(String suitName) {
		this.suitName = suitName;
	}

	// Prints suit name
	public String getSuitName() {
		return suitName;
	}
	
	
}


// Making an enum for the ranks, and adding a value
public enum Ranks  {
	ACE(1, "Ace"), DEUCE(2, "Deuce"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six"), 
	SEVEN(7, "Seven"), EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten"),
	JACK(10, "Jack"), QUEEN(10, "Queen"), KING(10, "King");
	
	
	
	private int rankValue;
	private String rankName;
	
	Ranks (int rankValue, String rankName){
		this.rankValue = rankValue;
		this.rankName = rankName;
	}
	
	
	//Returns a string of the rank value
	public String getRankName() {
		return rankName;
	}
	
	//Returns rank value
	public int getRankValue() {
		return rankValue;
	}
	

}


private Suits suit;
private Ranks rank;


//Constructor for Cards
public Cards(Ranks rank, Suits suit) {
	this.suit = suit;
	this.rank = rank;
}

//Getter for rank value
public int getValue() {
	return rank.getRankValue();
}

// Prints the card 
public String toString() {
	return rank.getRankName() + " of " + suit.getSuitName();
}


}
