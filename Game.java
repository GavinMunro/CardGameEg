package com.tci.card.game;

import com.tci.card.game.Card;
import com.tci.card.game.Deck;
import com.tci.card.game.Player;

import java.util.ArrayList; //Collection;

public class Game {

	// The players are kept in an ordered list so that the first 
	// in the list can be the "player to the dealer's right" or 
	// whatever is the order in which cards should be dealt.
	public ArrayList<Player> players;
	private final int nc = 3;  // In this game, each player gets 3 cards
	private Card c;
	
    // This method deals out n cards to each of the players
    private void deal(Deck d) {
    	int p = players.size();
    	
    	for (int i=1; i<=nc; i++) {
    		for (int j=0; j<p; j++) { 
    			c = d.cards.pop();
    			players.get(j).hand.add(c);	
    		}
    	}
    }
    
    public Player winner() {
    	int max = 0;
    	Player wins = null;
    	for (Player p : players) {
    		for (Card c: p.hand) {
    			if (c.faceVal > max) {max = c.faceVal; wins = p;}
    		}
    	} // We only need to compare one max across all players hands
    	return wins;
    }
    
	public void showHands() {
		for (Player p : players) {
			// Show hand
			for (Card c : p.hand ) {
				System.out.printf(c.toString(), " "); // TODO html ouput
			}
			System.out.print("\n");
		}
		// Some cleanup required afterwards - cards go back in deck
		
	}
	
	public void displayWinner() {
		Player theWinner = winner();  //html output goes below 
		System.out.printf("And the winner is: ", theWinner.name, "!\n");
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		Deck deck = new Deck();  // note: constructed in order
		deck.shuffle();  // It's traditional to start with a shuffle
		
		// players join
		// On event [New Player]
		String nom = "Player No.?";   // html input goes here
		Player p = new Player(nom);
		game.players.add(p);
		
		game.deal(deck);
		game.showHands();
		
		// On event [Play New Hand]
		// shuffle deck
		deck = new Deck();  // All cards put back in deck
		deck.shuffle();
		game.deal(deck);
		game.showHands();
		game.displayWinner();
		
		// On event [End Game]
	    // store stuff in DB and log off
	    // pause AWS DB instance - take snapshot?
	}

}
