package Runden;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import Karten.Karten;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
   	public void start(Stage primaryStage) throws Exception {
      	       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PokerTableView.fxml"));
        Parent root = loader.load();
        
             
      //  PokerTableController ptController  = loader.getController();
       
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("my Title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	 

	public static void main(String[] args, ActionEvent e, String[] Farbe, String[] Werte ) throws IOException {
		launch(args);
	}
}


