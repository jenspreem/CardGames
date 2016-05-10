package model;

public class BModel {
	private Hand hum_player;
	private Hand ai_player;
	private Deck deck;
	
	
	public BModel(){
		hum_player=new Hand();
		ai_player=new Hand();
		deck=new Deck();
		deck.shuffle();
	}
	
	public BpointStatus getAiScore(){
	return ai_player.getbScore();
	}
	
	public BpointStatus getHumScore(){
	return hum_player.getbScore();
	}
	
	public void ai_draw(){
		ai_player.drawCard(deck);
	}
	public void hum_draw(){
		hum_player.drawCard(deck);
	}
	
	
	public Hand getAiHand(){
		return ai_player;
	}
	
	public Hand getHumHand(){
		return hum_player;
	}
	
}
	
	
	


