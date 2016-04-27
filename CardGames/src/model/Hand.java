package model;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public void addCard(Card card){
		this.cards.add(card);
	}
	
	public void sortHand(){
		this.cards.sort(null);
	}

}
