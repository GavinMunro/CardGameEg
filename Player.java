package com.tci.card.game;

import java.util.Set;

public class Player {
    public String name;
    public Set<Card> hand;
    
    Player(String name) {
    	this.name = name;
    	this.hand = null; // NPE => no hand dealt yet
    }
}
