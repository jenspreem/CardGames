package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.BModel;
import model.Card;
import model.Deck;
import model.Hand;


public class BlackJackController implements Initializable{

	
	private BModel model;
	
	
	@FXML 
    private Button hitButton; // Value injected by FXMLLoader
	@FXML 
    private Button drawButton; // Value injected by FXMLLoader
	@FXML
	private HBox aiHandfield; // Value injected by FXMLLoader
	@FXML
	private HBox playerHandfield; // Value injected by FXMLLoader
	
	private BlackJackController(){
		//just because
	}
	
	public BlackJackController(BModel m){
		model=m;
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
		//now calculate victory?
		if(model.getAiScore().bust){
			//implement pop-up?
			System.out.println("Ai busted! "+ model.getAiScore().points);

		}
		else {
			if(model.getAiScore().points==model.getHumScore().points){
				System.out.println("Draw!");
			}
			else  if (model.getAiScore().points>model.getHumScore().points){
					System.out.println("Dealer wins! "+ model.getAiScore().points);;
				}
			else if (model.getAiScore().points<model.getHumScore().points){
				System.out.println("Player wins! "+ model.getHumScore().points);;
			}
		
		}
		
	}

	@FXML
	private void drawAction(){
		model.hum_draw();
		if (model.getHumScore().bust){
			//implement pop-up/message window
			show();
			System.out.println("Player busted! "+ model.getHumScore().points);
			
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.hum_draw();
		model.hum_draw();
		show();

        
		

		
	}
}


