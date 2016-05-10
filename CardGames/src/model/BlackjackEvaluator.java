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
        int[] vals={2,3,4,5,6,7,8,9,10,10,10,10,11};
        for (int i=0;i < Face.values().length;i++)
        {
        	aMap.put(Face.values()[i],vals[i]);
        }
        FaceValues = Collections.unmodifiableMap(aMap);
    }

	public static BpointStatus getScore(Hand hand){
		int minscore=0;
		int maxscore=0;
		ArrayList<Card> cards = hand.getCardsDrawn();
		for (Card c:cards)
		{
			maxscore=maxscore+FaceValues.get(c.getFace());
		}
		//calc min
		for (Card c:cards)
		{
			if(c.getFace()==Face.ACE)
			{
				minscore=minscore+1;
			}
			else
			{
				minscore=minscore+FaceValues.get(c.getFace());
		
			}
		}
		//if minscore bust then this is it
		if (minscore >21)
		{
		    return new BpointStatus(true,minscore);
		}
		//if maxscore busts then use minscore
		else if (maxscore>21){
			return new BpointStatus(false,minscore);
		}
		//if maxscore ok use maxscore
		else return new BpointStatus(false,maxscore);
	}
	
	
}
