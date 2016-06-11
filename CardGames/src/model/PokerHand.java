package model;

public class PokerHand extends Hand {
	private PokerEvaluator.Combo point_status;
	
	private void calcScore(){
		point_status=PokerEvaluator.getScore(this);
	}
	
	public PokerEvaluator.Combo getScore(){
		calcScore();
		
		return point_status;
	}
	

}
