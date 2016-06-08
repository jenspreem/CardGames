package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import model.Card.Face;




public class PokerEvaluator {
	//from weakest
	public enum Combo{      
        HIGHCARD,
        PAIR,
        TWO_PAIRS,
        THREE,
        STRAIGHT,
        FLUSH,
        FULLHOUSE,
        FOUR,
        STRAIGHTFLUSH     
	}
	
	
private static final Map<Face,Integer> FaceValues;
 static 
	{	
		Map<Face,Integer> aMap = new EnumMap<Face,Integer>(Face.class);
        int[] vals={1,2,3,4,5,6,7,8,9,10,11,12,13};
        for (int i=0;i < Face.values().length;i++)
        {
        	aMap.put(Face.values()[i],vals[i]);
        }
        FaceValues = Collections.unmodifiableMap(aMap);
    }
 
public static Combo getScore(Hand hand){
    ArrayList<Card> cards = hand.getCardsDrawn();
    boolean isFlusH=false;
    boolean isStraight=false;
    ArrayList<Card.Suit> suits = new ArrayList<Card.Suit>();
    
    for (Card c : cards){
    	suits.add(c.getSuit());
    }
    Collections.sort(suits);

    if (suits.get(0)==suits.get(5)){
        isFlusH=true;
    }

    ArrayList<Card.Face> faces = new ArrayList<Card.Face>();   
    for (Card c : cards){
    	faces.add(c.getFace());
    }   
    Collections.sort(faces);
    //if each next face is n+1
    for (int i=0;i<5;i++){
     if (faces.get(i).ordinal()==faces.get(i+1).ordinal()+1 && i!=4){
    	 continue;
     }
     if (i==4){
    	 isStraight=true;break;
     }
     else break; 
    }
    
    //return straight,flush and straight-flush
	if (isStraight==true&&isFlusH==true){
	return Combo.STRAIGHTFLUSH;
	    }
	    if (isStraight==true){
	        return Combo.STRAIGHT;
	    }
	    if (isFlusH==true){
	        return Combo.FLUSH;
	    }    
	//other combinations
	//Four if one of the first faces have 3 other of the same kind
	int occurrences1 = Collections.frequency(faces, faces.get(0));
	int occurrences2 = Collections.frequency(faces, faces.get(1));
	if (occurrences1==4||occurrences2==4) {

	    return Combo.FOUR;
	    }
	//Full house  
	//TODO test your operation order and parenthesis
	if (((faces.get(0)==faces.get(1)&&(faces.get(0)==faces.get(2))&&(faces.get(3)==faces.get(4)))			
	||((faces.get(0)==faces.get(1))&&(faces.get(2)==faces.get(3)&&faces.get(2)==faces.get(4)))))
	{
	    return Combo.FULLHOUSE;
	}
	//Three - there are three chances to get three faces in a row
	if ((faces.get(0)==faces.get(1)&&faces.get(0)==faces.get(2))||(faces.get(1)==faces.get(2)&&faces.get(1)==faces.get(3))||(faces.get(2)==faces.get(3)&&faces.get(2)==faces.get(4))) {
	    return Combo.THREE;
	    }
	//Two pairs
	//Three chances -- the single card is either in front, back or middle
	if ((faces.get(0)==faces.get(1)&&faces.get(2)==faces.get(3))||(faces.get(1)==faces.get(2)&&faces.get(3)==faces.get(4))||(faces.get(0)==faces.get(1)&&faces.get(3)==faces.get(4))) {
	   return Combo.TWO_PAIRS;
	 }
    //Pair -- four chances to consider
	if ((faces.get(0)==faces.get(1))||(faces.get(1)==faces.get(2))||(faces.get(2)==faces.get(3))||(faces.get(3)==faces.get(4))) {
	    return Combo.PAIR;
	    }
	//If nothing else was returned
	    return Combo.HIGHCARD;
	}
	
	
	
	
	
}
