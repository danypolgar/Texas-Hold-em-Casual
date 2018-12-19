package Model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class KartenFactory {

	public static LinkedList<Karte> erstelleKarten() {
	
		LinkedList<Karte> karten = new LinkedList<Karte>();
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 2; j <= 14; j++) {
				
				Karte k = new Karte();
				switch (i) {
					
					case 1:
						k.Farbe = "Karo";
						break;
					case 2: 
						k.Farbe = "Treff";
						break;
					case 3:
						k.Farbe = "Herz";
						break;
					case 4: 
						k.Farbe = "Pik";
						break;	
					default: 
						break;
				}
				
				if (j < 11) {
					k.Wertname = String.valueOf(j);
				}
				else if (j == 11) {
					k.Wertname ="J";
				}
				else if (j == 12) {
					k.Wertname ="Q";
				}
				else if (j == 13) {
					k.Wertname ="K";
				}
				else if (j == 14) {
					k.Wertname ="A";
				}
									
				k.Wert = j;
				k.Bild = new Image ("/Bilder/" + k.Farbe + "_" + k.Wertname + ".png");
				
				karten.add(k);
			}
		}
		
		return karten;
	}
}
