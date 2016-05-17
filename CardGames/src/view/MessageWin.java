package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

public class MessageWin   {

    final Label label = new Label();  
    Button ok = new Button("ok");
    VBox popUpVBox = new VBox();
    Popup popup = new Popup();

    
	EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
           ok.getScene().getWindow().hide();       
           event.consume();
        }
    };
    
    
    public Popup getPop(){
    	return popup;
    }
    
    
    
   public void setLabel(String s){
	   label.setText(s);
   }
   
   public MessageWin(){
	   
	popUpVBox.setStyle("-fx-background-color: #D6D6D6;");
	popUpVBox.setStyle("-fx-border-color: black; -fx-border-width: 1px; ");
    popUpVBox.getChildren().add(label);
    popUpVBox.getChildren().add(ok);
    ok.setOnAction(handler);
    
    popup.setAutoFix(false);
    popup.setHideOnEscape(true);
    popup.getContent().addAll(popUpVBox);

    }
   


}
