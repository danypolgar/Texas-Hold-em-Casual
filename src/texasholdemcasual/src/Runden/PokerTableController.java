package Runden;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;

import Karten.Karten;
import Model.Karte;
import Model.KartenFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PokerTableController {
	
	public String[] WertName;
	public String[] Farbe;
	private Karten[] pack;
	//private int jetztigeKarte;
	private LinkedList<Karte> kartenStapel;
	
		
	@FXML
	public TextArea connect;
	@FXML
	public ImageView kartensehen;
	@FXML
	public ImageView kartensehen2;

	
	

	public PokerTableController() throws IOException {
		
		kartenStapel = KartenFactory.erstelleKarten();
		
		String[] Werte = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q" , "K", "A"};
		String[] Farben = {"Karo", "Treff", "Herz", "Pik"};
		
		pack = new Karten[52];
			
		this.WertName = Werte;
		this.Farbe = Farben;
			
		//jetztigeKarte = 0;


		
	}
	
	public void paketzeigen() {
		
		for (Karte k : kartenStapel) {
			connect.setText(connect.getText() + "\n" + k.Farbe + " " + k.Wertname);
		}
		
		
		
		String randomFarbe = (Farbe[new Random().nextInt(Farbe.length)]);
		String randomWert = (WertName[new Random().nextInt(WertName.length)]);
		Image spielerkarte = new Image ("/Bilder/" + randomFarbe + "_" + randomWert + ".png");
		
		
		
		String randomFarbe2 = (Farbe[new Random().nextInt(Farbe.length)]);
		String randomWert2 = (WertName[new Random().nextInt(WertName.length)]);
		Image spielerkarte2 = new Image ("/Bilder/" + randomFarbe2 + "_" + randomWert2 + ".png");
		
		
		if (randomWert == ""  && randomFarbe == "") {
			
		}
			
		
			// if karte schon mal verteilt, dann muss neu verteilt werde
			//randomFarbe2 = (Farbe[new Random().nextInt(Farbe.length)]);
			//randomWert2 = (WertName[new Random().nextInt(WertName.length)]);
			//spielerkarte2 = new Image ("/Bilder/" + randomFarbe2 + "_" + randomWert2 + ".png");
		  //}	
}	
	
	
	public void onButtonMixenClick() {	
		mixen();
	}
	
	private void mixen() {
		//jetztigeKarte = 0;
		SecureRandom randomZahl = new SecureRandom();
		
		for (int erste = 0; erste < pack.length; erste++) {
			
			int zweite = randomZahl.nextInt(52);
			
			Karten temp = pack [erste];
			pack[erste] = pack[zweite];
			pack[zweite] = temp;

		}
	}
	
	
	void initialize() {
		mixen();
		paketzeigen();
	}
}
