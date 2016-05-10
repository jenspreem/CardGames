package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Card.Face;
import model.Card.Suit;

public class BlackjackEvaluatorTest {
	ArrayList<Card> cards= new ArrayList<Card>();

	@Before
	public void init(){
		for (Suit s: Suit.values()){
			for (Face f:Face.values()){
				cards.add(new Card(f,s));
			}
		}
	}

	@Test
	public void testGetScore() {

		Hand hand = new Hand();
		hand.addCard(cards.get(12));
		assertEquals(hand.getbScore().points,11);
		assertEquals(hand.getCardsDrawn().get(0).toString(),"ACE_HEARTS");
		assertFalse(hand.getbScore().bust);
		
		hand.addCard(cards.get(24));
		assertEquals(hand.getbScore().points,21);
		assertEquals(hand.getCardsDrawn().get(1).toString(),"KING_DIAMONDS");
		assertFalse(hand.getbScore().bust);
		
		hand.addCard(cards.get(25));
		assertEquals(hand.getbScore().points,12);
		assertEquals(hand.getCardsDrawn().get(2).toString(),"ACE_DIAMONDS");
		assertFalse(hand.getbScore().bust);
		
		hand.addCard(cards.get(23));
		assertEquals(hand.getbScore().points,22);
		assertEquals(hand.getCardsDrawn().get(3).toString(),"QUEEN_DIAMONDS");
		assertTrue(hand.getbScore().bust);

	}

}
