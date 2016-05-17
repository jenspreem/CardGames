package controller;

import java.net.URL;
import java.util.ResourceBundle;

import view.MessageWin;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.BModel;
import model.Card;



public class BlackJackController implements Initializable{

	
	private BModel model;
	private Stage stage;
	MessageWin mw =new MessageWin();
	
	
	@FXML 
    private Button hitButton; // Value injected by FXMLLoader
	@FXML 
    private Button drawButton; // Value injected by FXMLLoader
	@FXML
	private HBox aiHandfield; // Value injected by FXMLLoader
	@FXML
	private HBox playerHandfield; // Value injected by FXMLLoader
	
	@SuppressWarnings("unused")
	private BlackJackController(){
		//don't want people using it without model
	}
	
	public BlackJackController(BModel m){
		model=m;
	}
	
	public void addStage(Stage s){
		stage=s;
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
	
	@FXML
	private void hitAction(){
		drawButton.setDisable(true);
		//now dealer should draw up to 17
		while (model.getAiScore().points<17){
			model.ai_draw();
			show();
		}
		//now calculate victory
		if(model.getAiScore().bust){
			mw.setLabel("Dealer busted!");

		}
		else {
			if(model.getAiScore().points==model.getHumScore().points){
				mw.setLabel("It's a Draw!");

				}
			else  if (model.getAiScore().points>model.getHumScore().points){
				mw.setLabel("Dealer wins!");
				}
			else if (model.getAiScore().points<model.getHumScore().points){
				mw.setLabel("Player wins!");
				}
			
		}
		hitButton.setDisable(true);
		mw.getPop().show(stage);
		
		
	}

	@FXML
	private void drawAction(){
		model.hum_draw();
		show();
		if (model.getHumScore().bust){
			//implement pop-up/message window
			mw.setLabel("Player busted!");
			mw.getPop().show(stage);
				
		}
		
	}
	
	@FXML
	private void newAction(){
		model.reset();
		model.hum_draw();
		model.hum_draw();
		hitButton.setDisable(false);
		drawButton.setDisable(false);
		show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		model.hum_draw();
		model.hum_draw();
		show();

		
	}

	




}


