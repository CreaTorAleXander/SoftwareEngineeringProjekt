package spiellogik;

import java.io.IOException;
import java.util.*;

import spielobjekte.Angriffsart;
import spielobjekte.Angriffsobjekt;
import spielobjekte.Figur;
import spielobjekte.Koordinate;
import spiellogik.Spieler;

public class Spiel {

	private static Scanner scanner = new Scanner(System.in);

	private static Spielfeld spielfeld;
	private static Spieler spieler1;
	private static Spieler spieler2;
	
	/**
	 * Leitet den Spielbeginn ein. Keine weiteren Maßnahmen für den Spielfluss erforderlich.
	 * 
	 * @throws IOException durch Konsoleneingabe bei "starteRunde()"
	 */
	public static void starteSpiel() throws IOException {
		spieler1 = new Spieler();
		spieler2 = new Spieler();
		spielfeld = new Spielfeld();
		spielfeld.platziereObjekte(spieler1.getFiguren(), spieler2.getFiguren());
		starteRunde();
	}
	
	/**
	 * Started eine Runde, in der sowohl Spieler 1, als auch Spieler 2
	 * ihren Zug machen können.
	 * 
	 * @throws IOException durch Konsoleneingabe bei "zugDesSpielers(spieler)"
	 */
	private static void starteRunde() throws IOException {
		spielfeld.printSpielfeld();
		
		System.out.println("\n Spieler 1 ist an der Reihe.\n");	
		zugDesSpielers(spieler1);
		System.out.println("\n Spieler 2 ist an der Reihe.\n");
		zugDesSpielers(spieler2);
			
		beendeRunde();
	}
	
	
	/**
	 * Laesst einen Spieler seinen Zug machen
	 * 
	 * @param spieler Spieler der am Zug ist
	 */
	private static void zugDesSpielers(Spieler spieler) {

		for (Figur f : spieler.getFiguren()) {
			boolean isZugMoeglich = false;
			do {
				System.out.println("Wohin soll " + f.toString() + "gezogen werden? \n");
				int k1=-1;
				int k2=-1;
				
				do {
					k1 = konvertiereEingabe(scanner.next());
					k2 = konvertiereEingabe(scanner.next());
				}while (k1<0 || k2<0);
				
				spielfeld.waehleFigur(f.getK1(), spieler);

				if (spielfeld.pruefeBewegung(new Koordinate(k1, k2))) {
					isZugMoeglich = true;
					spielfeld.bewegeFigur(new Koordinate(k1, k2));
				} else {
					System.out.println("Zug nicht möglich");
				}
			} while (!isZugMoeglich);

			/* Zum Angreifen */
			
//			if(!f.getAngreifbare().equals(null)) {
//				System.out.println("Wollen Sie eine der folgenden Figuren angreifen? "+ f.getAngreifbare().toString());
//				System.out.println("Schreiben Sie dazu: Ja");
//				String s=scanner.next().toUpperCase();
//				
//				if(s.equals("JA")) {
//					System.out.println("Geben Sie die Koordinate an, die angegriffen werden soll.");
//					k1 = scanner.nextInt();
//					k2 = scanner.nextInt();
//					
//					new Angriffsobjekt(new Koordinate(k1,k2),Angriffsart.SCHERE); 
//				}
//			}

		}
	}
	
	/**
	 * Konvertiert einen String in der Form einer Koordinate in einen
	 * Koordinaten-Wert
	 * 
	 * 
	 * @param input Eingabestring
	 * @return Koordinatenwert einer Achse
	 */
	private static int konvertiereEingabe(String input) {
		int xNumber = -1;
		switch (input) {
			case "A": xNumber = 0; break;  case "1" : xNumber = 0; break;
			case "B": xNumber = 1; break;  case "2" : xNumber = 1; break;
			case "C": xNumber = 2; break;  case "3" : xNumber = 2; break;
			case "D": xNumber = 3; break;  case "4" : xNumber = 3; break;
			case "E": xNumber = 4; break;  case "5" : xNumber = 4; break;
			case "F": xNumber = 5; break;  case "6" : xNumber = 5; break;
			case "G": xNumber = 6; break;  case "7" : xNumber = 6; break;
			case "H": xNumber = 7; break;  case "8" : xNumber = 7; break;
			case "I": xNumber = 8; break;  case "9" : xNumber = 8; break;
			case "J": xNumber = 9; break;  case "10": xNumber = 9; break;
		}	
		return xNumber;
	}

	
	/**
	 * Entscheidet ob das eine neue Runde gestartet wird
	 * 
	 * @throws IOException durch Konsoleneingabe bei "starteRunde()"
	 */
	private static void beendeRunde() throws IOException {
		if (pruefeSpielende() == true)
			beendeSpiel();
		else
			starteRunde();
	}

	/**
	 * Prüft auf das Ende des Spiels (Keine Figuren mehr vorhanden)
	 * 
	 * @return true wenn ein Spieler keine Figuren mehr besitzt
	 */
	private static boolean pruefeSpielende() {
		return (spieler1.getFiguren().equals(null) || spieler2.getFiguren().equals(null))? true : false;
	}
	
	/**
	 * Beendet das Spiel
	 * 
	 */
	private static void beendeSpiel() {
	}

	public static void main(String[] args) throws IOException {
		//Spielablauf wird eingeleitet
		starteSpiel();
		//Scanner wird geschlossen
		scanner.close();
		
	}
}
