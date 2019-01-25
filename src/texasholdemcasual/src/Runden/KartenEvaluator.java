package Runden;

import java.util.LinkedList;

import Model.Karte;
import Model.KartenFactory;


public class KartenEvaluator {
	
	private LinkedList<Karte> kartenStapelGezeigtGemeinsam;
	
	/**
	 * Constructor.
	 * @param stapelGezeigtGemeinsam
	 */
	public KartenEvaluator(LinkedList<Karte> stapelGezeigtGemeinsam) {
		kartenStapelGezeigtGemeinsam = stapelGezeigtGemeinsam;
		isFullhouse(stapelGezeigtGemeinsam);
	}
	
	
	/**
	 * Diese Methode prüft für einen bestimmten Stapel Karten, ob dieser zusammen mit dem gemeinsamen Stapel ein Royal Flush ergibt.
	 * @param stapel Der Stapel, der zusammen mit den gemenisamen Karten geprüft wird..
	 * @return
	 */
	public boolean isRoyalFlush(LinkedList<Karte> stapelSpieler) {
			
		LinkedList<Karte> tempStapel = new LinkedList<Karte>();
		
		for(Karte k : stapelSpieler)
			tempStapel.add(k);
		
		for(Karte k : kartenStapelGezeigtGemeinsam)
			tempStapel.add(k);
		
		for (int i = 1; i <= 4; i++)
		{
		
			if (tempStapel.contains(KartenFactory.HoleKarte(10, i)) 
					&& tempStapel.contains(KartenFactory.HoleKarte(11, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(12, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(13, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(14, i)))
				{
					return true;
				}
			
		}
				
		return false;
	}
	
	public boolean isStraightFlush(LinkedList<Karte> stapelSpieler) {
		
		LinkedList<Karte> tempStapel = new LinkedList<Karte>();
		
		for(Karte k : stapelSpieler)
			tempStapel.add(k);
		
		for(Karte k : kartenStapelGezeigtGemeinsam)
			tempStapel.add(k);
		
		for (int i = 1; i <= 4; i++) {
			
			
			if (tempStapel.contains(KartenFactory.HoleKarte(2, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(3, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(4, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(5, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(6, i))) {
				return true;
			}
			if (tempStapel.contains(KartenFactory.HoleKarte(3, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(4, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(5, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(6, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(7, i))) {
				return true;
			}
			if (tempStapel.contains(KartenFactory.HoleKarte(4, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(5, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(6, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(7, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(8, i))) {
				return true;
			}
			if (tempStapel.contains(KartenFactory.HoleKarte(5, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(6, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(7, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(8, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(9, i))) {
				return true;
			}
			if (tempStapel.contains(KartenFactory.HoleKarte(6, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(7, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(8, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(9, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(10, i))) {
				return true;
			}
			if (tempStapel.contains(KartenFactory.HoleKarte(7, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(8, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(9, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(10, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(11, i))) {
				return true;
			}
			if (tempStapel.contains(KartenFactory.HoleKarte(8, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(9, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(10, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(11, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(12, i))) {
				return true;
			}
			if (tempStapel.contains(KartenFactory.HoleKarte(9, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(10, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(11, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(12, i))
					&& tempStapel.contains(KartenFactory.HoleKarte(13, i))) {
				return true;
			}
		
		}
		return false;
	}
		
	public boolean isFlush(LinkedList<Karte> stapelSpieler) {
		
		LinkedList<Karte> tempStapel = new LinkedList<Karte>();
		
		for(Karte k : stapelSpieler)
			tempStapel.add(k);
		
		for(Karte k : kartenStapelGezeigtGemeinsam)
			tempStapel.add(k);
		
		
		int[] count = new int[5];

		for(Karte k : tempStapel) {
			count[k.Farbwert] += 1;
		}
				
		if (count[1] >= 5 || count[2]  >= 5 || count[3]  >= 5 || count[4]  >= 5) {
			return true;
		}


		return false;
	}
	
	public boolean isStraight(LinkedList<Karte> stapelSpieler) {
		
		LinkedList<Karte> tempStapel = new LinkedList<Karte>();
		
		for(Karte k : stapelSpieler)
			tempStapel.add(k);
		
		for(Karte k : kartenStapelGezeigtGemeinsam)
			tempStapel.add(k);
	
		int[] count = new int[15];
		
		for(Karte k : tempStapel) {
			count[k.Wert] += 1;
		}
		
		if (count[2] >= 1 && count[3] >= 1 && count[4] >= 1 && count[5] >= 1 && count[6] >= 1) {
			return true;
		}
		
		if (count[3] >= 1 && count[4] >= 1 && count[5] >= 1 && count[6] >= 1 && count[7] >= 1) {
			return true;
		}
		
		if (count[4] >= 1 && count[5] >= 1 && count[6] >= 1 && count[7] >= 1 && count[8] >= 1) {
			return true;
		}
		
		if (count[5] >= 1 && count[6] >= 1 && count[7] >= 1 && count[8] >= 1 && count[9] >= 1) {
			return true;
		}
		
		if (count[6] >= 1 && count[7] >= 1 && count[8] >= 1 && count[9] >= 1 && count[10] >= 1) {
			return true;
		}
		
		if (count[7] >= 1 && count[8] >= 1 && count[9] >= 1 && count[10] >= 1 && count[11] >= 1) {
			return true;
		}
		
		if (count[8] >= 1 && count[9] >= 1 && count[10] >= 1 && count[11] >= 1 && count[12] >= 1) {
			return true;
		}
		
		if (count[9] >= 1 && count[10] >= 1 && count[11] >= 1 && count[12] >= 1 && count[13] >= 1) {
			return true;
		}
		
		if (count[10] >= 1 && count[11] >= 1 && count[12] >= 1 && count[13] >= 1 && count[14] >= 1) {
			return true;
		}
		
		return false;
	}
	
	public boolean isThreeOfAKind(LinkedList<Karte> stapelSpieler) {
		
		LinkedList<Karte> tempStapel = new LinkedList<Karte>();
		
		for(Karte k : stapelSpieler)
			tempStapel.add(k);
		
		for(Karte k : kartenStapelGezeigtGemeinsam)
			tempStapel.add(k);
		
		int[] count = new int[15];
		
		for(Karte k : tempStapel) {
			count[k.Wert] += 1;
		}
			
		for (int i = 2; i <= 14; i++) {
			if (count[i] == 3) {
				return true;
			}
		}
		
		return false;
	}

	public boolean isFourOfAKind(LinkedList<Karte> stapelSpieler) {
		
		LinkedList<Karte> tempStapel = new LinkedList<Karte>();
		
		for(Karte k : stapelSpieler)
			tempStapel.add(k);
		
		for(Karte k : kartenStapelGezeigtGemeinsam)
			tempStapel.add(k);
		
		int[] count = new int[15];
		
		for(Karte k : tempStapel) {
			count[k.Wert] += 1;
		}
			
		for (int i = 2; i <= 14; i++) {
			if (count[i] >= 4) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isOnePair(LinkedList<Karte> stapelSpieler) { 
		
		LinkedList<Karte> tempStapel = new LinkedList<Karte>();
		
		for(Karte k : stapelSpieler)
			tempStapel.add(k);
		
		for(Karte k : kartenStapelGezeigtGemeinsam)
			tempStapel.add(k);
		
		int[] count = new int[15];
		
		for(Karte k : tempStapel) {
			count[k.Wert] += 1;
		}
		for (int i = 2; i <= 14; i++) {
			if (count[i] == 2) {
				return true;
			}
		}
		
		return false;
	}

	public boolean isFullhouse(LinkedList<Karte> stapelSpieler) {
		
		if (isOnePair(stapelSpieler) == true && isThreeOfAKind(stapelSpieler) == true) {
			return true;
		}
		
		return false;
	}

	public boolean isTwoPair(LinkedList<Karte> stapelSpieler) {
		
		LinkedList<Karte> tempStapel = new LinkedList<Karte>();
		
		for(Karte k : stapelSpieler)
			tempStapel.add(k);
		
		for(Karte k : kartenStapelGezeigtGemeinsam)
			tempStapel.add(k);
		
	
			int[] count = new int[15];

		for(Karte k : tempStapel) {
			count[k.Farbwert] += 1;
		}
				
		if (count[1] >= 2 ||
				count[2] >= 2 ||
				count[3] >= 2 ||
				count[4] >= 2 ||
				count[5] >= 2 ||
				count[6] >= 2 ||
				count[7] >= 2 || 
				count[8] >= 2 || 
				count[9] >= 2 || 
				count[10] >= 2 || 
				count[11] >= 2 || 
				count[12] >= 2 ||
				count[13] >= 2 ||
				count[15] >= 2) {
			return true;
		}
				
		return false;
	}
}
	

