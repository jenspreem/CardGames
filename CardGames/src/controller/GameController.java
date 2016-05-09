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
import model.Player;

public class GameController implements Initializable{
	private  enum Victory{
		PLAYERWIN,
		AIWIN,
		DRAW
		
	}
	
	private BModel model;
	private Deck deck;
	
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
	
	private Victory getWinner(Player p1, Player p2){
		int s1=p1.getbScore();
		int s2=p2.getbScore();
		//add busts!
		if (s1>s2){return Victory.PLAYERWIN;}
		if (s1<s2){return Victory.AIWIN;}
		return Victory.DRAW;
	}
	
	private void show(){
		Player ai =model.getAi_player();
		Player hum = model.getHum_player();
		for (Card c:ai.getHand().getCardsDrawn()){
			Image image=new Image(c.getPicFile().getPath());
			ImageView iv2 = new ImageView();
	        iv2.setImage(image);
	        aiHandfield.getChildren().add(iv2);
			
		}
		for (Card c:hum.getHand().getCardsDrawn()){
			Image image=new Image(c.getPicFile().getPath());
			ImageView iv2 = new ImageView();
	        iv2.setImage(image);
	        playerHandfield.getChildren().add(iv2);
			
		}
		
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// just test button-attributes
		drawButton.setText("DRAW");
		holdButton.setText("HOLD");
		//get deck to modify
		deck=model.getDeck();
		//one card to dealer 
		model.getAi_player().drawCard(deck);
		//show model as it is
		show();

        
		

		
	}
}


