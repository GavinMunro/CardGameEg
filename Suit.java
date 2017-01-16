package com.tci.card.game;

//A single letter should suffice for the suit of a card
//within the code but the full name of the suit may be 
//useful later for display purposes
public enum Suit {
	
	H ("Hearts"),
	C ("Clubs"),
	D ("Diamonds"),
	S ("Spades");

	// Constructor for the enum
	public String desc;
	
	Suit(String desc) {
		this.desc = desc;   
	}
}