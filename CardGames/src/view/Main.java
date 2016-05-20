package view;
	
import java.io.IOException;
import controller.BlackJackController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	  public void start(Stage primaryStage) throws IOException {
		

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/BlackJackGUI.fxml"));
		loader.setControllerFactory(new Callback<Class<?>, Object>() {
	        @Override
	        public Object call(Class<?> aClass) {
	            return new BlackJackController();
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
