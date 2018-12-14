package Runden;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import javax.imageio.ImageIO;
import Karten.Karten;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Runden extends Application {
	
	
		@Override
		    public void start(Stage primaryStage) throws Exception {
		        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
		        Scene scene = new Scene(root);
		        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		        primaryStage.setTitle("my Title");
		        primaryStage.setScene(scene);
		        primaryStage.show();
		    }
		 
		
	

		private Karten[] pack;
		private int jetztigeKarte;
		
		public Runden() throws IOException {
			
			String[] Werte = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q" , "K", "A"};
			String[] Farben = {"Karo", "Treff", "Herz", "Pik"};
			
			pack = new Karten[52];
			
			
			
			/*Image spielerkarte = new Image ("/Bilder/Pik_Q.jpg");
			kartensehen.setImage(spielerkarte);*/
			
		
			
			
			jetztigeKarte = 0;
			
			
			
			final int breite = 123;
			final int groesse = 172;
			final int zeilen = 4;
			final int spalten = 13;
			
			BufferedImage PaketBild = ImageIO.read(new File("res/Kartenpaket.jpg"));
			BufferedImage tempCardImage;
			
			for (int farbe = 0; farbe < 4; farbe++) {
				
				for (int wert = 0; wert < 13; wert++) {
					tempCardImage = PaketBild.getSubimage(wert * breite + (wert * 9), farbe * groesse + (farbe * 14), breite, groesse);
				
				
				pack[(wert + (farbe * 13))] = new Karten(Farben[farbe], Werte[wert], wert+2, tempCardImage);
				}
			}
			
			
			
		}
		
	
		@FXML
		public Label connect;
		
		@FXML
		public ImageView kartensehen;
		
		
			
		public void paketzeigen(ActionEvent event) {
			for(Karten Karte : pack)
			connect.setText(Karte + "");
			//System.out.println(Karte);
		}
		
		/*
			String spielerkarte = "res/" + farbe + "_" + wert + ".png";
			Runden view = new Runden(ImageIO.read(new File(spielerkarte)));
		}*/
		
		public void mixen(ActionEvent event) {
			jetztigeKarte = 0;
			
			
			SecureRandom randomZahl = new SecureRandom();
			
			for (int erste = 0; erste < pack.length; erste++) {
				
				int zweite = randomZahl.nextInt(52);
				
				Karten temp = pack [erste];
				pack[erste] = pack[zweite];
				pack[zweite] = temp;
				
				
			}
		}
		
		/*public Karten dealKarte() {
			if(jetztigeKarte < pack.length) {
				return pack[jetztigeKarte++];
			} else {
				return null;
			}*/
			
		//}
		
			
		public static void main(String[] args, ActionEvent e) throws IOException {
			Runden neuPaket = new Runden();
			neuPaket.mixen(e);
			neuPaket.paketzeigen(e);
			launch(args);
			
		}
	}


