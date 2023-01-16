package piratePontoon2;

import java.util.Scanner;

//Runs a thread for each player to play
public class InGamePlayer extends Thread {
	
	private Deck deck; //Deck used in game
	private String name; //Name of player

	
	//For calling an instance of a player, includes parameters for deck and player name 
	public InGamePlayer(Deck deck, String name) {
		this.deck = deck;
		this.name = name;
		
	}
	
	
	
	private Scanner scan = new Scanner(System.in);
	
	
//Asks the user if they would like to deal a card or hold 
private String dealOrHold() {
		
		
		String answer = null;
		System.out.println("\n" + name + ", would you like to be dealt another card, or hold?");
		do {
			System.out.println("Please enter either 'deal' or 'hold'.");
			answer = scan.next();
		} while (!answer.equalsIgnoreCase("deal") && !answer.equalsIgnoreCase("hold"));
		
		return answer;
		

	}

//Creating an instance of a player 
Player player1 = new Player();

	//The below run method runs the game for the player to play
	@Override
	public void run() {
		
		System.out.println(name + ", it is now your turn.");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		player1.addCard(deck); //Deals a card
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		player1.addCard(deck);
       

		System.out.println(name + "'s first two cards are: " + player1);
		
		
		while (player1.handValue() < 21) 
		if (dealOrHold().equalsIgnoreCase("deal")) {
			System.out.println("dealing card..");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			player1.addCard(deck);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + "'s current hand is now: " + player1);
			
		} else {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + "'s final hand is: " + player1);
			break;
		}
		if (player1.handValue() > 21) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " has gone bust!");
		} else if (player1.handValue() == 21) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " has 21!");
		}
		
		
		
	}
	
	
	//Returns if a player has gone bust
	public boolean busted() { 
		if (player1.handValue() > 21) {
			return true;
		}
		return false;
	}
	
	//Returns the player hand value 
	public int playerValue() {
		return player1.handValue();
	}
	
	//Returns the name of the player 
	public String name() {
		return name;
	}
}
