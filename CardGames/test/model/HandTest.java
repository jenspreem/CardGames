package model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class HandTest {
	Hand hand = new Hand();
	ArrayList<Card> testlist = new ArrayList<Card>();
	
	@Before
	public void initialize(){
		testlist.add(new Card(Card.Face.EIGHT, Card.Suit.DIAMONDS));
		testlist.add(new Card(Card.Face.FOUR,Card.Suit.HEARTS));
		testlist.add(new Card(Card.Face.ACE,Card.Suit.SPADES));
		testlist.add(new Card(Card.Face.TWO,Card.Suit.CLUBS));
		//this already uses addCard method, but we need it for every following test* so thats it
		//*junit calls before -before any test again
		for(Card c:testlist){hand.addCard(c);}
	}

    

	@Test
	public void testAddCard() {	
		assertEquals(hand.getCard(0),testlist.get(0));
		assertEquals(hand.getCard(1),testlist.get(1));
		assertEquals(hand.getCard(2),testlist.get(2));
		assertEquals(hand.getCard(3),testlist.get(3));

	}

	@Test
	public void testgetCard() {
		try {
			hand.getCard(4);
		    fail( "Should throw IndexOutOfBoundsException" );
		} catch (IndexOutOfBoundsException ie) {
		}

		//actually did test this in addCard already
		assertEquals(hand.getCard(0),testlist.get(0));
		//just another peek
		assertEquals(hand.getCard(0).getFace(),Card.Face.EIGHT);
		assertEquals(hand.getCard(0).getSuit(),Card.Suit.DIAMONDS);

	}
	
	
	@Test
	public void testSortHand() {
		hand.sort();
		//is sorted by face value?
		assertEquals(Card.Face.TWO,hand.getCard(0).getFace());
		assertEquals(Card.Face.FOUR,hand.getCard(1).getFace());
		assertEquals(Card.Face.EIGHT,hand.getCard(2).getFace());
		assertEquals(Card.Face.ACE,hand.getCard(3).getFace());
	}

}
