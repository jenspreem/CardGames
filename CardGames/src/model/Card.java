package model;

import java.io.File;

public class Card {
	public enum Face{
		HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS
	}
	
	public enum Suit{
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE
	}
	
	private Face face;
	private Suit suit;
	private File picFile;
	private String picloc ="./images";
	
	public Card(Face f, Suit s){
		this.face=f;
		this.suit=s;
		this.picFile=new File(picloc+"/"+s.name()+"/"+f.name());
		
		
	}
	
	
	
	
	
	public Face getFace() {
		return face;
	}
	public void setFace(Face face) {
		this.face = face;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public File getPicFile() {
		return picFile;
	}
	public void setPicFile(File picFile) {
		this.picFile = picFile;
	}
	
	
	
}
