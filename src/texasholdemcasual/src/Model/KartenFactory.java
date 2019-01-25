package Model;

import java.util.LinkedList;

import javafx.scene.image.Image;

public class KartenFactory {

	public static LinkedList<Karte> kartenStapel;
		
	public static void erstelleTestKarten_FourOfAKind() {
		
		kartenStapel = new LinkedList<Karte>();
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 11; j <= 14; j++) {
				
				Karte k = new Karte();
				switch (i) {
					
					case 1:
						k.Farbwert = 1;
						k.Farbe = "Karo";
						break;
					case 2: 
						k.Farbwert = 2;
						k.Farbe = "Treff";
						break;
					case 3:
						k.Farbwert = 3;
						k.Farbe = "Herz";
						break;
					case 4: 
						k.Farbwert = 4;
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
				
				kartenStapel.add(k);
			}
		}
		
	}
	
	public static void erstelleTestKarten_ThreeOfAKind() {
		
		kartenStapel = new LinkedList<Karte>();
		
		for (int i = 1; i <= 3; i++) {
			for (int j = 11; j <= 14; j++) {
				
				Karte k = new Karte();
				switch (i) {
					
					case 1:
						k.Farbwert = 1;
						k.Farbe = "Karo";
						break;
					case 2: 
						k.Farbwert = 2;
						k.Farbe = "Treff";
						break;
					case 3:
						k.Farbwert = 3;
						k.Farbe = "Herz";
						break;
					case 4: 
						k.Farbwert = 4;
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
				
				kartenStapel.add(k);
			}
		}
		
	}
	
	public static void erstelleTestKarten_Straight() {
		
		kartenStapel = new LinkedList<Karte>();
		
		for (int i = 1; i <= 2; i++) {
			for (int j = 2; j <= 7; j++) {
				
				Karte k = new Karte();
				switch (i) {
					
					case 1:
						k.Farbwert = 1;
						k.Farbe = "Karo";
						break;
					case 2: 
						k.Farbwert = 2;
						k.Farbe = "Treff";
						break;
					case 3:
						k.Farbwert = 3;
						k.Farbe = "Herz";
						break;
					case 4: 
						k.Farbwert = 4;
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
				
				kartenStapel.add(k);
			}
		}
		
	}
	
	public static void erstelleTestKarten_Flush() {
		
		kartenStapel = new LinkedList<Karte>();
		
		for (int i = 4; i <= 4; i++) {
			for (int j = 2; j <= 14; j++) {
				
				Karte k = new Karte();
				switch (i) {
					
					case 1:
						k.Farbwert = 1;
						k.Farbe = "Karo";
						break;
					case 2: 
						k.Farbwert = 2;
						k.Farbe = "Treff";
						break;
					case 3:
						k.Farbwert = 3;
						k.Farbe = "Herz";
						break;
					case 4: 
						k.Farbwert = 4;
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
				
				kartenStapel.add(k);
			}
		}
		
	}
	
	public static void erstelleTestKarten_RoyalFlush() {
		
		kartenStapel = new LinkedList<Karte>();
		
		for (int i = 4; i <= 4; i++) {
			for (int j = 10; j <= 14; j++) {
				
				Karte k = new Karte();
				switch (i) {
					
					case 1:
						k.Farbwert = 1;
						k.Farbe = "Karo";
						break;
					case 2: 
						k.Farbwert = 2;
						k.Farbe = "Treff";
						break;
					case 3:
						k.Farbwert = 3;
						k.Farbe = "Herz";
						break;
					case 4: 
						k.Farbwert = 4;
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
				
				kartenStapel.add(k);
			}
		}
		
		Karte k6  = new Karte();
		k6.Wert = 9;
		k6.Farbe = "Herz";
		k6.Wertname = "9";
		k6.Farbwert = 3;
		k6.Bild = new Image ("/Bilder/" + k6.Farbe + "_" + k6.Wertname + ".png");
		kartenStapel.add(k6);
		
		Karte k7  = new Karte();
		k7.Wert = 9;
		k7.Wertname = "9";
		k7.Farbe = "Pik";
		k7.Farbwert = 4;
		k7.Bild = new Image ("/Bilder/" + k7.Farbe + "_" + k7.Wertname + ".png");
		kartenStapel.add(k7);
		
		/*Karte k8  = new Karte();
		k8.Wert = 8;
		k8.Wertname = "8";
		k8.Farbe = "Pik";
		k8.Farbwert = 4;
		k8.Bild = new Image ("/Bilder/" + k8.Farbe + "_" + k8.Wertname + ".png");
		kartenStapel.add(k8);
		
		Karte k9  = new Karte();
		k9.Wert = 7;
		k9.Wertname = "7";
		k9.Farbe = "Pik";
		k9.Farbwert = 4;
		k9.Bild = new Image ("/Bilder/" + k9.Farbe + "_" + k9.Wertname + ".png");
		kartenStapel.add(k9);*/
	}
		
	public static void erstelleKarten() {
				
		kartenStapel = new LinkedList<Karte>();
				
		for (int i = 1; i <= 4; i++) {
			for (int j = 2; j <= 14; j++) {
				
				Karte k = new Karte();
				switch (i) {
					
					case 1:
						k.Farbwert = 1;
						k.Farbe = "Karo";
						break;
					case 2: 
						k.Farbwert = 2;
						k.Farbe = "Treff";
						break;
					case 3:
						k.Farbwert = 3;
						k.Farbe = "Herz";
						break;
					case 4: 
						k.Farbwert = 4;
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
				
				kartenStapel.add(k);
			}
		}
	}

	public static Karte HoleKarte(int wert, int farbeWert) {
		
		for (Karte k : kartenStapel) {
			if (k.Wert == wert && k.Farbwert == farbeWert) {
				return k;
			}
		}
		return null;
	}
	
	
	
}
