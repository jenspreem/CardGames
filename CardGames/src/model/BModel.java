package model;

public class BModel {
	private Player hum_player;
	private Player ai_player;
	private Deck deck;
	public Player getHum_player() {
		return hum_player;
	}
	
	public BModel(){
		hum_player=new Player();
		ai_player=new Player();
		deck=new Deck();
		deck.shuffle();
	}
	public void setHum_player(Player hum_player) {
		this.hum_player = hum_player;
	}
	public Player getAi_player() {
		return ai_player;
	}
	public void setAi_player(Player ai_player) {
		this.ai_player = ai_player;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
	

}
