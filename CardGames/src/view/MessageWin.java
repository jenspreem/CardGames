package view;



import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;

public class MessageWin   {

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
	   
	popUpVBox.setStyle("-fx-background-color: #D6D6D6;");
	popUpVBox.setStyle("-fx-border-color: black; -fx-border-width: 1px; ");
    popUpVBox.getChildren().add(label);
    popUpVBox.getChildren().add(ok);
    
    popup.setAutoFix(false);
    popup.setHideOnEscape(true);
    popup.getContent().addAll(popUpVBox);
  //paneks wm-i kuulama vanem-akna positsiooni ja s2tiks teda ennas vastavalt

    }

}
