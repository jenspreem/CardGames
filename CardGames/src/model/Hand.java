package model;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public void addCard(Card card){
		this.cards.add(card);
	}
	
	public Card getCard(int i){
		return this.cards.get(i);
	}
	
	public void sort(){
		this.cards.sort(null);
	}

}
