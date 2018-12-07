package Runden;




public class Runden {
public static void main(String[] args) {
	int[] pack = new int[52];
	String[] Farben = {"Pik", "Treff", "Karo", "Herz"};
	String[] Werte = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Bube", "Dame", "König", "Ass"};
	
	
	for (int i = 0; 1 < pack.length; i++) pack[i] = 1;
	
	for (int i = 0; 1 < pack.length; i++) {
		int index = (int)(Math.random() * pack.length);
		int temp = pack[i];
		pack[i] = pack[index];
		pack[index] = temp;
		
	}
	
	
	for (int i = 0; 1 < pack.length; i++) {
		String Farbe = Farben[pack[i] / 13];
		String Wert = Werte[pack[i] % 13];
		System.out.println("Karte Nummer " + pack[i] + ": " + Farbe + Wert);
	}
}
}


