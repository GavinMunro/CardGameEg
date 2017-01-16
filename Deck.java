package com.tci.card.game;

import java.sql.Array;
import java.util.Collection;
import java.util.Stack;
import java.util.Random;

import com.tci.card.game.Suit;
import com.tci.card.game.Card;
import com.tci.card.game.Player;


public class Deck {
    
	// I want use a stack so deal() cards can use pop()
	public Stack<Card> cards;  //Stack<Card> cards;
    //private Card[] list;
    
    // Declare as class variable so that it is not re-seeded every call
    private static Random random = new Random();
    
    // Constructor for the deck of cards
    Deck(){
    	int i;
    	for (Suit s : Suit.values()){
    		for (i=1; i<=14; i++ )  {
    			Card c = new Card(i, s);
    			this.cards.push(c);
    }	}	}
    
    // Assuming a Deck d that may or not be in order
    public void shuffle() {
    	int i; // We'll need another for loop
        Card[] arrCards1 = (Card[]) this.cards.toArray();
        Card[] arrCards2 = (Card[]) this.cards.toArray();
        // make sure array 
        assert arrCards1.length == 52;
        Stack<Card> newDeck = new Stack<Card>();
        for (i=0; i<=51; i++) {
        	int rn = random.nextInt(52);
        	Card tc = arrCards1[rn];  // Select a card at random from 1
        	arrCards2[i] = tc;     // Overwrite card in the new order
        }
        for (i=0; i<=51; i++) {
        	newDeck.push(arrCards2[i]);
        }
        this.cards = newDeck;
    }

    
    @Override
    public String toString(){
    	String repr = null;
    	// TODO implement a string representation of the deck
    	// eg. "3H 8C 14S ..."
    	return repr;
    }
    
    
}
