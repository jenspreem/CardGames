package model;

import java.util.ArrayList;

public class Hand {
	protected ArrayList<Card> cards = new ArrayList<Card>();
	

	
	public void drawCard(Deck d){
		this.cards.add(d.draw());
	}
	
	protected void  addCard(Card c){
		//just for tests really
		this.cards.add(c);
	}
	public ArrayList<Card> getCardsDrawn(){
		return cards;
	}
	
	public void sort(){
		this.cards.sort(null);
	}
	
	public void replaceCard(Deck d, int i){
		this.cards.set(i, d.draw());
	}

}
