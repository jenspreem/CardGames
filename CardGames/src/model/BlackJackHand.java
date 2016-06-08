package model;

public class BlackJackHand extends Hand {
	private PointStatus point_status;
	
	private void calcScore(){
		point_status=BlackjackEvaluator.getScore(this);
	}
	
	public PointStatus getScore(){
		calcScore();
		return point_status;
	}

}
