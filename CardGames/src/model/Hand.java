package model;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private BpointStatus point_status;
	
	private void calcBScore(){
		point_status=BlackjackEvaluator.getScore(this);
	}
	
	public BpointStatus getbScore(){
		calcBScore();
		return point_status;
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
