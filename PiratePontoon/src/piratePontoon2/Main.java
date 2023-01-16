package piratePontoon2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {	
	
	public static int drawLoop = 0; //this is for the game logic

	public static void main(String[] args) throws InterruptedException {
		
		
	
		
		
		Deck deck = new Deck(); //Sets a new deck
		deck.shuffle(); //Shuffles the deck
		
		System.out.println("Welcome to Pirate Pontoon!");
		Thread.sleep(500);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many players will be playing?");
	
		
		int numPlayers;
		do {
		
		System.out.println("Please enter a number between 1-4."); //Ensures input is between 1-4
		 numPlayers = scan.nextInt(); 
		} while (numPlayers > 4 || numPlayers < 1);
		
		
	
	
		
		List<InGamePlayer> players = new ArrayList<>(numPlayers); //Ads x no of players
		for (int i = 0; i < numPlayers; ++i) {
			System.out.println("Please type in a name for player " + i);
			
			String name = scan.next();
		    players.add(new InGamePlayer(deck, name));
		}
		
		
		
		
		InGameDealer dealer = new InGameDealer(deck);
		
		Thread.sleep(500);
		System.out.println("The game will now begin, good luck!");
		Thread.sleep(500);
		System.out.println("Loading...");
		Thread.sleep(2000);
		
		for (int i = 0; i < players.size(); ++i) {
			
		    players.get(i).run();
		}
		
		Thread.sleep(500);
		
		System.out.println("It is now the dealer's turn...");
		
		Thread.sleep(1100);
		
		dealer.run();
		
		Thread.sleep(500);
		System.out.println("Determining the winner(s)...");
		Thread.sleep(2000);
		
		logicLoop:
		for (int i = 0; i < players.size(); ++i) {
		

		
		if (dealer.busted() == true && players.get(i).playerValue() <= 21) { //only goes in here if evry1win
			i = -1;
			for (int a = 0; a < numPlayers; ++a) {
		
				if (players.get(++i).playerValue() <= 21) {  //runs the no of player
					
					
					++drawLoop; // works
					
					
				}
				
				
				
				}
			if (drawLoop == 1) {  // If one player wins
			
				i = -1;
				for (int b = 0; b < numPlayers; ++b) {
					
					
					if (players.get(++i).playerValue() <= 21) {
					
						System.out.println(players.get(i).name() + " has won! Congratulations!"); // if one player wins
					}
				}
				break;
				
			}
			
			
			}  if (drawLoop > 1) { //If multiple players win = draw
					i = -1;
				for (int b = 0; b < players.size(); ++b) {
					
					
					if (players.get(++i).playerValue() <= 21) {
						
						System.out.println(players.get(i).name() + " has drawn!"); // if draw
					}
					
				}
				break;
		
			
			
			
			
		}
			
			
			i = -1;
			for (int c = 0; c < numPlayers; ++c) {
				
				i++;
				
				
			if (dealer.busted() == false && players.get(i).busted() == false && players.get(i).playerValue()
					> dealer.dealerValue()) {
				i = -1;
		
				for (int a = 0; a < numPlayers; ++a) {
					
				
					if (players.get(++i).playerValue() <= 21 && players.get(i).playerValue()
							> dealer.dealerValue()) {  
						
						
						
						++drawLoop; // works
						
						
						
					}
					
					
					
					}
				if (drawLoop == 1) {  // If one player wins
					i = -1;
					for (int b = 0; b < numPlayers; ++b) {
				
						
						if (players.get(++i).playerValue() <= 21 && players.get(i).playerValue()
								> dealer.dealerValue()) {
						
							System.out.println(players.get(i).name() + " has won! Congratulations!"); //If 1 player wins
						}
					}
					break logicLoop;
					
				}
				
				if (drawLoop > 1) { //If multiple players win = draw
					i = -1;
				for (int b = 0; b < players.size(); ++b) {
					
					if (players.get(++i).playerValue() <= 21 && players.get(i).playerValue() //If players draw
							> dealer.dealerValue()) {
						System.out.println(players.get(i).name() + " has drawn!"); 
					}
					
				} break logicLoop;
				
				
			
			
			
			
		} 
		} 
			}
			i = 0;
			 if (dealer.busted() == false && dealer.dealerValue() >= players.get(i).playerValue()) { //If dealer beats players
				System.out.println("Dealer wins!");
				break;
				
			} 
			
			if (dealer.busted() == false && players.get(i).playerValue() > 21) { //If dealer beats players
				
				System.out.println("Dealer Wins!");
				break;
				
			} 
			
			else if (dealer.busted() == true && players.get(i).playerValue() > 21) { //If everyone goes bust
				System.out.println("Everyone has gone bust!"); 
			}
		
		} // This is end of for loop for determining winner 
		
		
	}
		
		
}
	


		
		
	
	
	
	

