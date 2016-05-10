package model;

import java.io.File;

public class Card implements Comparable<Card>{
	public enum Suit{
		HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS
	}
	
	public enum Face{
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
	private String picloc ="/images";
	private String picextension=".png";
	
	public Card(Face f, Suit s){
		this.face=f;
		this.suit=s;
		this.picFile=new File(picloc+"/"+s.name()+"_"+f.name()+picextension);
		
		
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





	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return this.getFace().compareTo(o.getFace());
	}
	@Override
	public String toString(){
		return this.face.toString()+"_"+suit.toString();
	}
	
	
}
