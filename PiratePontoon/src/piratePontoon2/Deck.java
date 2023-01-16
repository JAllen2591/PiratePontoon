package piratePontoon2;

import java.util.*;

public class Deck { //For calling / creating a deck

    private List<Cards> deck; //Includes all cards

    public Deck() { //For calling / creating a deck
        deck = new ArrayList<Cards>();
        for (Cards.Suits s : Cards.Suits.values()) {
            for (Cards.Ranks r : Cards.Ranks.values()) {
                deck.add(new Cards(r, s));
            }
        }
    }

    
//Returns a card from the deck
    public Cards dealCard() { 
        Cards card = deck.remove(0);
       System.out.println("\nCard Dealt: " + card);
        return card;
    }
    
    
    //Shuffles the deck so that cards are dealt randomly
    public void shuffle() { 
        Collections.shuffle(deck);
    }
    
    //Refreshes the deck so that all dealt cards are returned into the deck
    public void retainCards() {
    	deck.removeAll(deck);
    	 deck = new ArrayList<Cards>();
         for (Cards.Suits s : Cards.Suits.values()) {
             for (Cards.Ranks r : Cards.Ranks.values()) {
                 deck.add(new Cards(r, s));
             }
         }
    }

    //Prints the number of cards left in the deck, used for testing
    public int deckSize() { 
        System.out.println("Deck size: " + deck.size());
        return deck.size();
    }

    //toString of Deck
    public String toString() {
        return "\n" + deck;
    }

   
}