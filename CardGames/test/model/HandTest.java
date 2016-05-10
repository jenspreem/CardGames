package model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class HandTest {
	Hand hand = new Hand();
	ArrayList<Card> testlist = new ArrayList<Card>();
	Deck deck = new Deck();
	
	@Before
	public void initialize(){
		deck.fill();
	
	
	}

	@Test
	public void testdrawCard(){
		//todo
	}
    

	


}
