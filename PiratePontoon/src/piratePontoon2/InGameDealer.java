package piratePontoon2;

public class InGameDealer extends Thread{

	
Player dealer = new Player(); //Creates new instance of player used to create the dealer
private Deck deck;


public InGameDealer(Deck deck) { //Constructor for dealer 
	this.deck = deck;
	
}


	//Runs a thread which plays as a dealer
	@Override
	public void run() {
		System.out.println("The dealer will now be repeatedly dealt a card until they have a value of over 16.");
		while (dealer.handValue() < 21) { //change to 21
			System.out.println("Dealing a card...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dealer.addCard(deck);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Dealers current hand is now: " + dealer + ".");
			if (dealer.handValue() > 16  && dealer.handValue() < 22) { //change first to 16
				System.out.println("The dealer's final hand is: " + dealer);
				break;
			} else if (dealer.handValue() > 21) {
				System.out.println("The dealer's final hand is: " + dealer);
				System.out.println("The dealer has gone bust!");
				break;
			}
		} 
		
		
	}
	
	//Returns if dealer has gone bust
	public boolean busted() {
		if (dealer.handValue() > 21) {
			return true;
		}
		return false;
	}
	
	//Returns value of dealers hand 
	public int dealerValue() {
		return dealer.handValue();
	}
}
	
