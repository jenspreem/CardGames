package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import model.Card;
import model.PModel;
import model.PokerEvaluator.Combo;
import model.PokerHand;
import view.MessageWin;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PokerController implements Controller,Initializable {
	
	private PModel model = new PModel();
	private Stage stage;
	
	private MessageWin mw =new MessageWin(this);
	private Button[] holdButtonArray= new Button[5];
	
	private static final Set<Integer> allIndex = new HashSet<Integer>(Arrays.asList(0,1,2,3,4));
	private Set<Integer> playerCardsToHold = new HashSet<Integer>(5);
	private Set<Integer> aiCardsToHold = new HashSet<Integer>(5);
	
	private Combo playerScore;
	private Combo  aiScore;
	
	@FXML
	private HBox aiHandfield; // Value injected by FXMLLoader
	@FXML
	private HBox playerHandfield; // Value injected by FXMLLoader
	@FXML
	private HBox buttonField; // Value injected by FXMLLoader
	@FXML
	private Button replaceButton; // Value injected by FXMLLoader
	@FXML
	private Button newGameButton; // Value injected by FXMLLoader
	
	@FXML
	private void replaceAction(){
		//make a modifiable copy
		Set<Integer> temp_set= new HashSet<Integer>();
		temp_set.addAll(allIndex);
		//get cards to replace
		temp_set.removeAll(playerCardsToHold);
		model.hum_replace(temp_set);
		playerScore=model.getHumHand().getScore();
		replaceButton.setDisable(true);
		
		
		//ai turn
		//need to write ai -- card replacement algorithm
		model.ai_draw(5);
		//show ai hand before replacement
		show();
		//then ai_replace and score calculations
		//need score first to decide what to replace
		aiScore=model.getAiHand().getScore();
		model.getAiHand().sort();
		ai_replaceDecision();
		show();
		//then victory declaration
		aiScore=model.getAiHand().getScore();
		calcVictory();

		
	}
	
	private void calcVictory() {
		// if combo bigger than other return victor
		if (aiScore.compareTo(playerScore)<0){
			System.out.println("Player wins");
			
		}
		if (aiScore.compareTo(playerScore)>0){
			System.out.println("Ai wins");
			
		}
		//replace this with a calculation comparing the face values
		else 	System.out.println("Draw");

		
		
	}

	private void ai_replaceDecision() {
// sort hand
		model.getAiHand().sort();
		ArrayList<Card> cards = model.getAiHand().getCardsDrawn(); 
		
		switch(aiScore) {
		    case HIGHCARD:
		        //draw all new
		        for (int i=0;i<=4;i++){
		           model.ai_replace(i);

		        }
		        break;
		    case PAIR:
		        //find pair, keep it, replace others
		    	for (int i=0;i<cards.size()-1;i++){
		    		if (cards.get(i)==cards.get(i+1));
		    		{
		    			aiCardsToHold.add(i);
		    			aiCardsToHold.add(i+1);

		    		}
		    			
		    	}

		        break;
		    case TWO_PAIRS:
		        //find pairS keep them, replace the single
		    	for (int i=0;i<cards.size()-1;i++){
		    		if (cards.get(i)==cards.get(i+1));
		    		{
		    			aiCardsToHold.add(i);
		    			aiCardsToHold.add(i+1);

		    		}
		    			
		    	}

		        break;
		     case THREE:
		        //find three to keep		    	
		    	 for (int i=0;i<cards.size()-1;i++){
		    		if (cards.get(i)==cards.get(i+1)&&cards.get(i)==cards.get(i+2));
		    		{
		    			aiCardsToHold.add(i);
		    			aiCardsToHold.add(i+1);
		    			aiCardsToHold.add(i+2);

		    		}
		    			
		    	}

		        break;
		    case FOUR:
		    	//find four to keep
		    	 for (int i=0;i<cards.size()-1;i++){
		    		if (cards.get(i)!=cards.get(i+1))
		    		{
		    		continue;
		    		}
		    		else 
		    		{
		    			aiCardsToHold.add(i);

		    		}
		    		if(cards.get(4)==cards.get(3)){
		    			aiCardsToHold.add(4);
		    		}
		    			
		    	}
		    	
		       break;
		    	//straight, flush, full-house are just good enough to keep
		    default:
		        
		    	for (int i=0;i<cards.size();i++){
		    		aiCardsToHold.add(i);
		    	}

		        }
		Set<Integer> temp_set= new HashSet<Integer>();
		temp_set.addAll(allIndex);
		//get cards to replace
		temp_set.removeAll(aiCardsToHold);
		model.ai_replace(temp_set);
		aiScore=model.getAiHand().getScore();
		
	}

	@FXML
	private void newAction(){
		model.reset();
		model.hum_draw(5);
		replaceButton.setDisable(false);
		playerCardsToHold = new HashSet<Integer>(5);
		aiCardsToHold = new HashSet<Integer>(5);
		for (Button b :holdButtonArray){
			b.setDisable(false);
		};
		show();
		
	}
	
	@Override
	public void addPopNotifier() {
		stage.xProperty().addListener(new ChangeListener<Number>() {
		     public void changed(ObservableValue<? extends Number> observableValue, Number oldX, Number newX) {
		     mw.setX(newX);
		    }
		});
		
		stage.yProperty().addListener(new ChangeListener<Number>() {
		     public void changed(ObservableValue<? extends Number> observableValue, Number oldY, Number newY) {
		     mw.setY(newY);
		    }
		});

	}

	@Override
	public void addStage(Stage s) {
		stage=s;
	}

	@Override
	public Stage getStage() {
		return stage;
	}
	
	//for handling HOLD buttons
	private EventHandler<ActionEvent> createButtonHandler(int x) {
	    return event -> buttonHandler(x,event);
	}
	private void buttonHandler (int x, ActionEvent e){
		playerCardsToHold.add(x);
		Button b=(Button)e.getSource();
		b.setDisable(true);		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		model.hum_draw(5);
		
		//populate the holdbuttonArray
		
		for(int i = 0; i < 5; i++){
			Button b = new Button("HOLD");
			b.setOnAction(createButtonHandler(i));
			holdButtonArray[i] = b;
			holdButtonArray[i].setMinWidth(71);			
		}
		buttonField.getChildren().addAll(holdButtonArray);
		show();

		
	}


private void show(){
		
		aiHandfield.getChildren().clear();
		for (Card c:model.getAiHand().getCardsDrawn()){
			Image image=new Image(c.getPicFile().getPath());
			ImageView iv2 = new ImageView();
	        iv2.setImage(image);
	        aiHandfield.getChildren().add(iv2);

	    }
		playerHandfield.getChildren().clear();
		for (Card c:model.getHumHand().getCardsDrawn()){
			Image image=new Image(c.getPicFile().getPath());
			ImageView iv2 = new ImageView();
	        iv2.setImage(image);
	        playerHandfield.getChildren().add(iv2);
	    }	
	}
}
