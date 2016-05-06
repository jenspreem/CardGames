package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import static model.Card.*;

public class BlackjackEvaluator {
	
	private static final Map<Face,Integer> FaceValues;
	static 
	{	
		Map<Face,Integer> aMap = new EnumMap<Face,Integer>(Face.class);
        int[] vals={1,2,3,4,5,6,7,8,9,10,10,10,10};
        for (int i=0;i < Face.values().length;i++)
        {
        	aMap.put(Face.values()[i],vals[i]);
        }
        FaceValues = Collections.unmodifiableMap(aMap);
    }

	public static int getScore(Hand hand){
		int minscore=0;
		int maxscore=0;
		ArrayList<Card> cards = hand.getCardsDrawn();
		for (Card c:cards)
		{
			minscore=minscore+FaceValues.get(c.getFace());
		}
		//calc maxscore
		for (Card c:cards)
		{
			if(c.getFace()==Face.ACE)
			{
				maxscore=maxscore+11;
			}
			else
			{
				minscore=minscore+FaceValues.get(c.getFace());
		
			}
		}
		//return minscore if minscore busts otherwise maxscore bust or not
		if (minscore >21)
		{
		    return minscore;
		}

		else return maxscore;
		
	}
	
	
}
