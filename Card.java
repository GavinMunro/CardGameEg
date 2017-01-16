package com.tci.card.game; 

import com.tci.card.game.Suit;

public class Card {
    public int faceVal;
    public Suit suit;

    public Card(int n, Suit s) {
    	// Ace has value 14, not 1
    	if (n >= 2 && n <= 14) {
    		this.faceVal = n;
    		this.suit = s;
    	}
    }
}

