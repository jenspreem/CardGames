package model;

import java.util.Set;

import model.PokerEvaluator.Combo;


public class PModel {
	private PokerHand hum_player;
	private PokerHand ai_player;
	private Deck deck;
	
	
	public PModel(){
		hum_player=new PokerHand();
		ai_player=new PokerHand();
		deck=new Deck();
		deck.shuffle();
	}
	
	public Combo getAiScore(){
	return ai_player.getScore();
	}
	
	public Combo getHumScore(){
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
	
	
	public PokerHand getAiHand(){
		return ai_player;
	}
	
	public PokerHand getHumHand(){
		return hum_player;
	}
	
	public void hum_replace(Set<Integer> ia){
		for (int i: ia){
		hum_player.replaceCard(deck, i);
		}
	}
	
	public void ai_replace(Set<Integer> ia){
		for (int i: ia){
		ai_player.replaceCard(deck, i);
		}
	}
	
	public void ai_replace(int i ){
		
		ai_player.replaceCard(deck, i);
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
	
	
	
