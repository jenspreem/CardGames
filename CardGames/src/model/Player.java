package model;

public class Player {
	private Hand hand;
	private int b_score;
	
	private void calcBScore(){
		b_score=BlackjackEvaluator.getScore(hand);
	}
	
	public int getbScore(){
		calcBScore();
		return b_score;
	}

}
