package model;

public class PokerHand extends Hand {
	private PokerEvaluator.Combo point_status;
	
	private void calcScore(){
		point_status=PokerEvaluator.getScore(this);
	}
	
	public PointStatus getScore(){
		calcScore();
		
		return new PointStatus(false,point_status.ordinal());
	}
	

}
