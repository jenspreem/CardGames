package model;


public class PModel {
	private Hand hum_player;
	private Hand ai_player;
	private Deck deck;
	
	
	public PModel(){
		hum_player=new PokerHand();
		ai_player=new PokerHand();
		deck=new Deck();
		deck.shuffle();
	}
	
	public PointStatus getAiScore(){
	return ai_player.getScore();
	}
	
	public PointStatus getHumScore(){
	return hum_player.getScore();
	}
	
	public void ai_draw(){
		ai_player.drawCard(deck);
	}
	
	public void ai_draw(int i){
		for (int n=0;n<i;n++){
		ai_player.drawCard(deck);
		}
	} 
	public void hum_draw(){
		hum_player.drawCard(deck);
	}
	public void hum_draw(int i){
		for (int n=0;n<i;n++){
		hum_player.drawCard(deck);
		}
	}
	
	
	public Hand getAiHand(){
		return ai_player;
	}
	
	public Hand getHumHand(){
		return hum_player;
	}
	

	
	public void reset(){
		//why create new BModel instance just replace fields
		//better/worse?
		hum_player=new PokerHand();
		ai_player=new PokerHand();
		deck=new Deck();
		deck.shuffle();
	}
}
	
	
	
