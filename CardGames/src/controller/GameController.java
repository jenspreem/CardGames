package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.BModel;
import model.Player;

public class GameController implements Initializable{
	public  enum Victory{
		PLAYERWIN,
		AIWIN,
		DRAW
		
	}
	
	private BModel model;
	
	@FXML 
    private Button drawButton; // Value injected by FXMLLoader
	@FXML 
    private Button holdButton; // Value injected by FXMLLoader
	
	
	public GameController(BModel m){
		model=m;
	}
	
	public Victory getWinner(Player p1, Player p2){
		int s1=p1.getbScore();
		int s2=p2.getbScore();
		//add busts!
		if (s1>s2){return Victory.PLAYERWIN;}
		if (s1<s2){return Victory.AIWIN;}
		return Victory.DRAW;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		drawButton.setText("DRAW");
		holdButton.setText("HOLD");

		
	}
}


