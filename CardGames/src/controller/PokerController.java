package controller;

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import model.Card;
import model.PModel;
import model.PokerEvaluator.Combo;
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
		//then victory declaration
		aiScore=model.getAiHand().getScore();
		calcVictory();

		
	}
	
	private void calcVictory() {
		// TODO Auto-generated method stub
		
	}

	private void ai_replaceDecision() {
		switch(aiScore) {
		    case HIGHCARD:
		        //draw all new
		        for (int i=0;i<=4;i++){
		           model.ai_replace(i);

		        }
		        break;
		    case PAIR:
		        //find pair, keep it, replace others

		        break;
		    case TWO_PAIRS:
		        //find pairS keep them, replace the single

		        break;
		     case THREE:
		        //find three to keep

		        break;
		    case FOUR:
		    	//find four to keep
		       break;
		    	//straight, flush, are just good enough to keep
		    default:
		        System.out.println("Some other combo");

		        }

		
	}

	@FXML
	private void newAction(){
		
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
