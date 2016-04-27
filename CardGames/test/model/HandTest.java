package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HandTest {
	

	@Test
	public void testAddCard() {
		fail("Not yet implemented");
	}

	@Test
	public void testSortHand() {
		ArrayList<Card> cards =new ArrayList<Card>();
		cards.add(new Card(Card.Face.EIGHT, Card.Suit.SPADES));
		cards.add(new Card(Card.Face.FOUR,Card.Suit.HEARTS));
		cards.add(new Card(Card.Face.ACE,Card.Suit.SPADES));
		cards.add(new Card(Card.Face.TWO,Card.Suit.CLUBS));
		cards.sort(null);
		
		assertEquals(Card.Face.TWO,cards.get(0).getFace());
		
	}

}
