package model;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static model.Card.Face.*;
import org.junit.Before;
import org.junit.Test;
import model.Card.Face;
import model.Card.Suit;
import static model.Card.Suit.*;


public class CardTest {
	List<Card> cardlist = new ArrayList<Card>();
	List<Face> faces = new ArrayList<Face>(Arrays.asList(ACE,EIGHT,NINE,TWO,KING));
	List<Suit> suits = new ArrayList<Suit>(Arrays.asList(SPADES,HEARTS,SPADES,DIAMONDS,CLUBS));

	
	@Before
	public void initialize(){
		
		for (int i = 0; i < faces.size(); i++){
			cardlist.add(i, new Card(faces.get(i),suits.get(i)));
		}

	}

	@Test
	public void testGetFace() {
		
		for (int i = 0; i < faces.size(); i++){
			assertEquals(cardlist.get(i).getFace(),faces.get(i));

		}

	}

	@Test
	public void testSetFace() {
		cardlist.get(0).setFace(FIVE);
		assertEquals(cardlist.get(0).getFace(),FIVE);

	}

	@Test
	public void testGetSuit() {
		for (int i = 0; i < suits.size(); i++){
			assertEquals(cardlist.get(i).getSuit(),suits.get(i));

		}
	}

	@Test
	public void testSetSuit() {
		cardlist.get(0).setSuit(HEARTS);
		assertEquals(cardlist.get(0).getSuit(),HEARTS);
		cardlist.get(0).setSuit(DIAMONDS);
		assertEquals(cardlist.get(0).getSuit(),DIAMONDS);

	
	}




	@Test
	public void testCompareTo() {
		assert(cardlist.get(0).compareTo(cardlist.get(1))>0);
		assertEquals(cardlist.get(1).compareTo(cardlist.get(1)),0);
		assert(cardlist.get(1).compareTo(cardlist.get(4))<0);

		
	}
	@Test
	public void testPicfileLocationGetandSet(){

		assertEquals(cardlist.get(0).getPicFile().getPath(),"./images/SPADES_ACE.png");
		assertEquals(cardlist.get(1).getPicFile().getPath(),"./images/HEARTS_EIGHT.png");
		
		assertEquals(cardlist.get(2).getPicFile().getPath(),"./images/SPADES_NINE.png");
		cardlist.get(1).setPicFile(new File("AYY-LMAO"));
		assertEquals(cardlist.get(1).getPicFile().getPath(),"AYY-LMAO");



	}

}
