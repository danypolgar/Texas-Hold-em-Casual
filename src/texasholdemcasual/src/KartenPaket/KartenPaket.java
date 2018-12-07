package KartenPaket;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

import javax.imageio.ImageIO;

import Karten.Karten;

public class KartenPaket {
	private Karten[] pack;
	private int jetztigeKarte;
	
	public KartenPaket() throws IOException {
		
		String[] Werte = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q" , "K", "A"};
		String[] Farben = {"Karo", "Treff", "Herz", "Pik"};
		
		pack = new Karten[52];
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
	
	
	
	
	public void paketzeigen() {
		for(Karten Karte : pack)
			System.out.println(Karte);
	}
	
	public void mixen() {
		jetztigeKarte = 0;
		
		
		SecureRandom randomZahl = new SecureRandom();
		
		for (int erste = 0; erste < pack.length; erste++) {
			
			int zweite = randomZahl.nextInt(52);
			
			Karten temp = pack [erste];
			pack[erste] = pack[zweite];
			pack[zweite] = temp;
			
			
		}
	}
	
	public Karten dealKarte() {
		if(jetztigeKarte < pack.length) {
			return pack[jetztigeKarte++];
		} else {
			return null;
		}
		
	}
	
	public static void main(String[] args ) throws IOException {
		KartenPaket neuPaket = new KartenPaket();
		//neuPaket.paketzeigen();
		neuPaket.mixen();
		neuPaket.paketzeigen();
		
	}
}
