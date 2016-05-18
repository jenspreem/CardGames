package view;
	
import java.io.IOException;

import controller.BlackJackController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.BModel;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	  public void start(Stage primaryStage) throws IOException {
		//create model and attach it to CardController
		final BModel model = new BModel();
		
		//loader loads fxml modified controllerfactory
		//allows us to attach our model to controller on creation
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/BlackJackGUI.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
	        @Override
	        public Object call(Class<?> aClass) {
	            return new BlackJackController(model);
	        }
	    });
		
		
	    AnchorPane pane =  (AnchorPane) loader.load();
		BlackJackController bc = loader.getController();
		//the easy way - creates state though,
		//depends on order in main function
	    bc.addStage(primaryStage);
	    bc.addPopNotifier();
	    
	    
	    Scene scene = new Scene( pane );
	    primaryStage.setScene( scene );
	    primaryStage.setTitle( "CardGames" );
	
	    primaryStage.show();
	    
	  }
	
	public static void main(String[] args) {
		launch(args);
	}
}
