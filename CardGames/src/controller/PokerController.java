package controller;

import java.net.URL;
import java.util.ResourceBundle;

import model.Card;
import model.PModel;
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
	MessageWin mw =new MessageWin(this);
	private Button[] holdButtonArray= new Button[5];
	private int[] playerCardsToReplace = new int[5];
	private int[] aiCardsToReplace = new int[5];
	
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
		model.hum_replace(playerCardsToReplace);
		replaceButton.setDisable(true);
		
		show();
		//need to write ai -- card replacement algorithm
		//then ai_replace and score calculations
		//then victory declaration
		
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
		playerCardsToReplace[x]=x;
		Button b=(Button)e.getSource();
		b.setDisable(true);		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		model.hum_draw(5);
		model.ai_draw(5);
		
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
