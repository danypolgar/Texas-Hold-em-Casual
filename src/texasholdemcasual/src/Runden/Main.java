package Runden;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
   	public void start(Stage primaryStage) throws Exception {
      	       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PokerTableView.fxml"));
        Parent root = loader.load();
        
             
      //  PokerTableController ptController  = loader.getController();
       
        
        Scene scene = new Scene(root);
       // primaryStage.getIcons().add(new Image("/Bilder/gameicon.jpg") );
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setTitle("Texas Hold'em Casual");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	 

	public static void main(String[] args ) {
		launch(args);
	}
}


