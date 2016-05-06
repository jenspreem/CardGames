package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import static model.Card.*;

public class Deck {
	private LinkedList<Card> cards = new LinkedList<Card>();
	
	public Deck(){
		fill();
	}
	
	public void fill(){
		for (Suit s: Suit.values()){
			for (Face f:Face.values()){
				cards.add(new Card(f,s));
			}
		}
	}
	
	public void shuffle(){
		
		long seed = System.nanoTime();
		Collections.shuffle(cards, new Random(seed));
		
	}
	
	public Card draw(){
		return cards.poll();
	  
	}

}
