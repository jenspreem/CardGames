package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import view.MessageWin;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.BModel;
import model.Card;



public class BlackJackController implements Initializable, Controller{

	
	private BModel model = new BModel();
	private Stage stage;
	MessageWin mw =new MessageWin(this);
	PokerController pc = new PokerController();

	
	
	
	@FXML 
    private Button hitButton; // Value injected by FXMLLoader
	@FXML 
    private Button drawButton; // Value injected by FXMLLoader
	@FXML
	private HBox aiHandfield; // Value injected by FXMLLoader
	@FXML
	private HBox playerHandfield; // Value injected by FXMLLoader

	

	
	public void addPopNotifier(){
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
	private void toPoker() throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PokerGUI.fxml"));
		loader.setController(pc);
		
		
		AnchorPane pane =  (AnchorPane) loader.load();
	    

		Scene scene = new Scene(pane);
		stage.setScene(scene);
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
		mw.showPop();
		
		
	}

	@FXML
	private void drawAction(){
		model.hum_draw();
		show();
		if (model.getHumScore().bust){
			//implement pop-up/message window
			mw.setLabel("Player busted!");
			mw.showPop();
		drawButton.setDisable(true);
		hitButton.setDisable(true);
				
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



	public void addStage(Stage s) {
		stage=s;		
	}
	
	public Stage getStage(){
		return stage;
	}

	




}


