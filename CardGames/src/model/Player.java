package model;

public class Player {
	private Hand hand =new Hand();
	private int b_score=0;
	
	private void calcBScore(){
		b_score=BlackjackEvaluator.getScore(hand);
	}
	
	public int getbScore(){
		calcBScore();
		return b_score;
	}

	public Hand getHand() {
		return hand;
	}

	public void drawCard(Deck d){
		this.hand.addCard(d.draw());
	}
	
	public void fillHand(int size, Deck d){
		for (int i=0;i<=size;i++){
			this.hand.addCard(d.draw());
		}
		
	}
	//default for many games full hand=5 cards
	public void fillHand(Deck d){
		fillHand(5,d);
	}
}
