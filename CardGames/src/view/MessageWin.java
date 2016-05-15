package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

public class MessageWin {

    final Label label = new Label();
    
    Button ok = new Button("ok");
    

    VBox popUpVBox = new VBox();
    Popup popup = new Popup();

    public Popup getPop(){
    	return popup;
    }
   public void setLabel(String s){
	   label.setText(s);
   }
   
   public MessageWin(){
	   
    popUpVBox.getChildren().add(label);
    popUpVBox.getChildren().add(ok);
    
    popup.setAutoFix(false);
    popup.setHideOnEscape(true);
    popup.getContent().addAll(popUpVBox);
    popup.centerOnScreen();
    //popup.setX(250);
    //popup.setY(175);
    }

}
