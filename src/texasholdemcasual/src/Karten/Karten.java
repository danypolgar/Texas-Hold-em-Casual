package Karten;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Karten {
	private String WertName, Farbe; 
	private int KartenWert;
	private BufferedImage KartenBild;
	 
public Karten(String Farbe, String Wert, int KartenWert, BufferedImage Karte) {

	 
	this.Farbe = Farbe;
	this.WertName = Wert;
	this.KartenWert = KartenWert;
	KartenBild = Karte;
	 
}

public String toString() {
	return WertName + " " + Farbe;
}

public int getKartenWert() {
	return KartenWert;
}

public BufferedImage getKartenBild() {
	return KartenBild;
}

public static void main(String[] args) throws IOException {
	
	Karten PikAss = new Karten("Pik", "Ass",14, ImageIO.read(new File("res/Classic/Pik_Ass.png")));
	
	
	System.out.println(PikAss.toString());
	System.out.println("Ass = " + PikAss.getKartenWert());
	
	/*JFrame Fenster = new JFrame("Karte");
	Fenster.setSize(400,600);
	Fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Fenster.setVisible(true);
	
	JPanel Tisch = new JPanel(new BorderLayout());
	
	
	JLabel KarteLabel = new JLabel(new ImageIcon(PikAss.getKartenBild()));
	KarteLabel.setSize(50,100);
	
	Tisch.add(KarteLabel);
	Fenster.add(Tisch);*/
	
}

}


