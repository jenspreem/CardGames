package model;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public PointStatus getScore(){
		return new PointStatus(0);
	}
	
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

}
