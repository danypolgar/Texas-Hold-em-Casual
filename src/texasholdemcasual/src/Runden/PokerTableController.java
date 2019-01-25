package Runden;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;


import Model.Karte;
import Model.KartenFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PokerTableController {
	
	private boolean isTest = false;
	
	public String[] WertName;
	public String[] Farbe;
	public boolean temp;

	private LinkedList<Karte> kartenStapelGezeigtAlle;
	private LinkedList<Karte> kartenStapelGezeigtSpieler;
	private LinkedList<Karte> kartenStapelGezeigtFirstBot;
	private LinkedList<Karte> kartenStapelGezeigtSecondBot;
	private LinkedList<Karte> kartenStapelGezeigtThirdBot;
	private LinkedList<Karte> kartenStapelGezeigtFourthBot;
	private LinkedList<Karte> kartenStapelGezeigtGemeinsam;
	private int roundCounter = 0;
	private int highCardScore;
	private int onePairScore = 100;
	private int twoPairScore = 200;
	private int threeOfAKindScore = 300;
	private int straightScore = 400;
	private int flushScore = 500;
	private int fullHouseScore = 600;
	private int fourOfAKindScore = 700;
	private int StraightFlushScore = 800;
	private int royalFlushScore = 900;
	private int spielerPunkte = 0;
	private int firstBotPunkte = 0;
	private int secondBotPunkte = 0;
	private int thirdBotPunkte = 0;
	private int fourthBotPunkte = 0;
	
	
		
	@FXML
	public TextArea connect;
	@FXML
	public Button showCardsButton;
	@FXML
	public ImageView kartensehen;
	@FXML
	public ImageView kartensehen2;
	@FXML
	public Button revealButton;
	@FXML
	public ImageView kartensehenFirstBot;
	@FXML
	public ImageView kartensehenFirstBot2;
	@FXML
	public ImageView kartensehenSecondBot;
	@FXML
	public ImageView kartensehenSecondBot2;
	@FXML
	public ImageView kartensehenThirdBot;
	@FXML
	public ImageView kartensehenThirdBot2;
	@FXML
	public ImageView kartensehenFourthBot;
	@FXML
	public ImageView kartensehenFourthBot2;
	@FXML
	public ImageView kartensehenGemeinsam1;
	@FXML
	public ImageView kartensehenGemeinsam2;
	@FXML
	public ImageView kartensehenGemeinsam3;
	@FXML
	public ImageView kartensehenGemeinsam4;
	@FXML
	public ImageView kartensehenGemeinsam5;
	@FXML
	public Button readyButton;
	@FXML
	public Button resultsButton;
	
	public PokerTableController() {
		
		if (isTest == false) {
			KartenFactory.erstelleKarten();
			
		}
		else {
			KartenFactory.erstelleTestKarten_RoyalFlush();
			//KartenFactory.erstelleTestKarten_Flush();
			//KartenFactory.erstelleTestKarten_Straight();
			//KartenFactory.erstelleTestKarten_ThreeOfAKind();
			//KartenFactory.erstelleTestKarten_FourOfAKind();
		}
				
		kartenStapelGezeigtAlle = new LinkedList<Karte>();
		kartenStapelGezeigtSpieler = new LinkedList<Karte>();
		kartenStapelGezeigtFirstBot = new LinkedList<Karte>();
		kartenStapelGezeigtSecondBot = new LinkedList<Karte>();
		kartenStapelGezeigtThirdBot = new LinkedList<Karte>();
		kartenStapelGezeigtFourthBot = new LinkedList<Karte>();
		kartenStapelGezeigtGemeinsam = new LinkedList<Karte>();
		
	}
	
	
	public void onTestButtonClick() {
		
		kartenZeigen(1);
		kartenZeigen(2);
		kartenZeigen(3);
		kartenZeigen(4);
		
		kartensehenFirstBot.setVisible(true);
		kartensehenFirstBot2.setVisible(true);
		
		kartensehenSecondBot.setVisible(true);
		kartensehenSecondBot2.setVisible(true);
		
		kartensehenFirstBot.setImage(kartenStapelGezeigtFirstBot.get(0).Bild);
		kartensehenFirstBot2.setImage(kartenStapelGezeigtFirstBot.get(1).Bild);
		
		kartensehenSecondBot.setImage(kartenStapelGezeigtSecondBot.get(0).Bild);
		kartensehenSecondBot2.setImage(kartenStapelGezeigtSecondBot.get(1).Bild);
		
		kartensehenThirdBot.setImage(kartenStapelGezeigtThirdBot.get(0).Bild);
		kartensehenThirdBot2.setImage(kartenStapelGezeigtThirdBot.get(1).Bild);
		
		kartensehenFourthBot.setImage(kartenStapelGezeigtFourthBot.get(0).Bild);
		kartensehenFourthBot2.setImage(kartenStapelGezeigtFourthBot.get(1).Bild);
		
		
	}
	
	public void onZeigeKartenClick() {
		
		kartenZeigen(0);
		readyButton.setVisible(true);
		
		
		
		
	}
	
	public void onReadyClick() {
		
		roundCounter++;
		
		KarteBrennen();
		
		switch (roundCounter) {
			
		case 1:
			ersteWettrundeKarten();
			break;
		case 2:
			zweiteWettrundeKarte();
			break;
		case 3:
			dritteWettrundeKarte();
			readyButton.setVisible(false);
			revealButton.setVisible(true);
			roundCounter = 0;
			break;
		}
	
	
	}
	
	
	public void spielReset() {
		
		kartenStapelGezeigtAlle.clear();
		kartenStapelGezeigtSpieler.clear();
		kartenStapelGezeigtFirstBot.clear();
		kartenStapelGezeigtSecondBot.clear();
		kartenStapelGezeigtThirdBot.clear();
		kartenStapelGezeigtFourthBot.clear();
		kartenStapelGezeigtGemeinsam.clear();
		spielerPunkte = 0; 
		showCardsButton.setVisible(true);
	}
	
	/**
	 * 
	 * @param fuerWen: 0 = Spieler, 1 = Bot 1, 2 = Bot 2
	 */
	private void kartenZeigen(int fuerWen) {

		Karte gezeigteKarte = HoleZufallsKarte();
		Karte gezeigteKarte2 = HoleZufallsKarte();
		
		if (fuerWen == 0) {
			kartenStapelGezeigtSpieler.add(gezeigteKarte);
			kartenStapelGezeigtSpieler.add(gezeigteKarte2);
			kartensehen.setImage(gezeigteKarte.Bild);
			kartensehen2.setImage(gezeigteKarte2.Bild);
		}
		else if (fuerWen == 1) {
			kartenStapelGezeigtFirstBot.add(gezeigteKarte);
			kartenStapelGezeigtFirstBot.add(gezeigteKarte2);
			// setImage ???
		} 
		else if (fuerWen == 2) {
			kartenStapelGezeigtSecondBot.add(gezeigteKarte);
			kartenStapelGezeigtSecondBot.add(gezeigteKarte2);
		}
		else if (fuerWen == 3) {
			kartenStapelGezeigtThirdBot.add(gezeigteKarte);
			kartenStapelGezeigtThirdBot.add(gezeigteKarte2);
		}
		else if (fuerWen == 4) {
			kartenStapelGezeigtFourthBot.add(gezeigteKarte);
			kartenStapelGezeigtFourthBot.add(gezeigteKarte2);
		}
		
		showCardsButton.setVisible(false);
	}
	
	private void ersteWettrundeKarten() {
				
		Karte gezeigteKarte = HoleZufallsKarte();
		Karte gezeigteKarte2= HoleZufallsKarte();
		Karte gezeigteKarte3 = HoleZufallsKarte();
		
		kartenStapelGezeigtGemeinsam.add(gezeigteKarte);
		kartenStapelGezeigtGemeinsam.add(gezeigteKarte2);
		kartenStapelGezeigtGemeinsam.add(gezeigteKarte3);
		
		kartensehenGemeinsam1.setImage(gezeigteKarte.Bild);
		kartensehenGemeinsam2.setImage(gezeigteKarte2.Bild);
		kartensehenGemeinsam3.setImage(gezeigteKarte3.Bild);
		
		
	
	}
	
	private void zweiteWettrundeKarte() {
		
		Karte gezeigteKarte = HoleZufallsKarte();
		
		kartenStapelGezeigtGemeinsam.add(gezeigteKarte);
		
		kartensehenGemeinsam4.setImage(gezeigteKarte.Bild);

	}
	
	private void dritteWettrundeKarte() {
		
 		Karte gezeigteKarte = HoleZufallsKarte();
 		
		kartenStapelGezeigtGemeinsam.add(gezeigteKarte);
		
		kartensehenGemeinsam5.setImage(gezeigteKarte.Bild);
		
		
	}
	
	private void KarteBrennen() {
		
		if (isTest == false)
			HoleZufallsKarte();
	}

	
	private Karte HoleZufallsKarte() {
		
		int w= new Random().nextInt(13) + 2;	   	
		int f = new Random().nextInt(4) + 1;   
		Karte karte = KartenFactory.HoleKarte(w, f);		
	
				
		if (kartenStapelGezeigtAlle.size() == KartenFactory.kartenStapel.size()) {
			showInformation("Warnung", "Es wurden bereits alle Karten gespielt. (dieser Fall darf eigentlich nicht passieren!!!)");
			return null;
		}
		
		while (karte == null || kartenStapelGezeigtAlle.contains(karte) == true) {		
			
			w = new Random().nextInt(13) + 2;
			f = new Random().nextInt(4) + 1; 
			karte = KartenFactory.HoleKarte(w, f);
			
		}
		
		
		kartenStapelGezeigtAlle.add(karte);
		
		return karte;
	}

	/*
	private Karte HoleKarte(int wert, int farbeWert) {
	
		for (Karte k : kartenStapel) {
			if (k.Wert == wert && k.Farbwert == farbeWert) {
				return k;
			}
		}
		return null;
	}
	*/
	
	
	private void showInformation(String title, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public void onResultsButtonclick() {
			
		KartenEvaluator evaluator = new KartenEvaluator(kartenStapelGezeigtGemeinsam);
		
		if (evaluator.isRoyalFlush(kartenStapelGezeigtSpieler) == true)	{
			spielerPunkte = spielerPunkte + royalFlushScore; 
			System.out.println("Royal Flush!!!");
			System.out.println(spielerPunkte);
			resultsButton.setVisible(false);
			
		}
		
		
		if (evaluator.isRoyalFlush(kartenStapelGezeigtFirstBot) == true) {
			firstBotPunkte = royalFlushScore; 
			System.out.println("Royal Flush!!!");
			System.out.println(firstBotPunkte);
			resultsButton.setVisible(false);
		}
		
		/*...*/
		
		if (evaluator.isStraightFlush(kartenStapelGezeigtSpieler) == true) {
			spielerPunkte = spielerPunkte + StraightFlushScore; 
			System.out.println("Straight Flush!!!");
			System.out.println(spielerPunkte);
			resultsButton.setVisible(false);
		}
		
		if (evaluator.isRoyalFlush(kartenStapelGezeigtSpieler) == true && evaluator.isStraightFlush(kartenStapelGezeigtSpieler) == true) {
			spielerPunkte = spielerPunkte - 800;
			System.out.println(spielerPunkte);
			resultsButton.setVisible(false);
		}
		
		if (evaluator.isFourOfAKind(kartenStapelGezeigtSpieler) == true) {
			spielerPunkte = spielerPunkte + fourOfAKindScore; 
			System.out.println("Four of a kind!!!");
			System.out.println(spielerPunkte);
			resultsButton.setVisible(false);
		}
		
		if (evaluator.isFlush(kartenStapelGezeigtSpieler) == true) {
			spielerPunkte = spielerPunkte + flushScore; 
			System.out.println("Flush!!!");
			System.out.println(spielerPunkte);
			resultsButton.setVisible(false);
		}
		
		if (evaluator.isStraight(kartenStapelGezeigtSpieler) == true) {
			spielerPunkte = spielerPunkte + straightScore; 
			System.out.println("Straight!!!");
			System.out.println(spielerPunkte);
			resultsButton.setDisable(true);
		}
		
		if (evaluator.isThreeOfAKind(kartenStapelGezeigtSpieler) == true) {
			spielerPunkte = spielerPunkte + threeOfAKindScore; 
			System.out.println("Three of a Kind!!!");
			System.out.println(spielerPunkte);
			resultsButton.setVisible(false);
		}
		
		if (evaluator.isFullhouse(kartenStapelGezeigtSpieler) == true) {
			spielerPunkte = spielerPunkte + fullHouseScore; 
			System.out.println("fullhouse!!!");
			System.out.println(spielerPunkte);
			resultsButton.setVisible(false);
		}
		
		if (evaluator.isOnePair(kartenStapelGezeigtSpieler) == true) {
			spielerPunkte = spielerPunkte + onePairScore; 
			System.out.println("One Pair!!!");
			System.out.println(spielerPunkte);
			resultsButton.setVisible(false);
		}
		
		if (evaluator.isTwoPair(kartenStapelGezeigtSpieler) == true) {
			spielerPunkte = spielerPunkte + twoPairScore; 
			System.out.println("Two Pair!!!");
			System.out.println(spielerPunkte);
			resultsButton.setVisible(false);
		}
		
		
	}
	

}
