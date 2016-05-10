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


public class GameController implements Initializable{

	
	private BModel model;
	
	
	@FXML 
    private Button drawButton; // Value injected by FXMLLoader
	@FXML 
    private Button holdButton; // Value injected by FXMLLoader
	@FXML
	private HBox aiHandfield; // Value injected by FXMLLoader
	@FXML
	private HBox playerHandfield; // Value injected by FXMLLoader
	
	private GameController(){
		//just because
	}
	
	public GameController(BModel m){
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
		
		
	}

	@FXML
	private void drawAction(){
		model.hum_draw();
		if (model.getHumScore().bust){
			//implement pop-up/message window
			show();
			System.out.println("Player busted! "+ model.getHumScore().points);
			
		}
		else {show();System.out.println("OK! "+ model.getHumScore().points);
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model.hum_draw();
		model.hum_draw();
		show();

        
		

		
	}
}


