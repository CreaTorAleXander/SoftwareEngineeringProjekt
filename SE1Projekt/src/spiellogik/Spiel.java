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

		int anzahlDerZuege = spieler.getFiguren().size();

		while (anzahlDerZuege > 0) {
			System.out.println("Soll eine Figur bewegt werden? (ja/nein)");
			String antwort = scanner.next().toUpperCase();
			
			//Wenn ein Zug gemacht werden soll
			if (antwort.equals("JA")) {
				boolean isZugMoeglich = false;
				boolean isFigur = true;
				Koordinate k1 = new Koordinate(-1, -1);
				
				//Angabe der Koordinate der Figur, die bewegt werden soll
				do {
					System.out.println("Geben Sie die Koordinate der Figur ein, die bewegt werden soll");
					k1 = konvertiereEingabe2(scanner.next());
					isFigur = true;
					try {
						spielfeld.waehleFigur(k1, spieler);
					//Catcht die eigene Exception, wenn eine Figur nicht auf der Koordinate liegt
					} catch (InputMismatchException ex) {
						isFigur = false;
						System.err.println("Invalide Koordinate");
					}
				} while (!isFigur);

				//Zurücksetzen der Koordinate
				k1 = new Koordinate(-1, -1);
				
				//Angabe wohin die Figur bewegt werden soll.
				do {
					System.out.println("Wohin soll " + spielfeld.gewaehlteFigur.toString() + "gezogen werden?");
					do {
						k1 = konvertiereEingabe2(scanner.next());
					} while (k1.getX() == (-1));
					//Überprüfung, ob der Zug möglich ist
					if (spielfeld.pruefeBewegung(k1)) {
						isZugMoeglich = true;
						spielfeld.bewegeFigur(k1);
					} else {
						System.err.println("Zug nicht möglich");
					}
				} while (!isZugMoeglich);
				
				
				anzahlDerZuege--;
			
			//Ausbruch aus der While-SChleife, wenn kein Zug gemacht werden soll
			} else if (antwort.equals("NEIN")) {
				anzahlDerZuege = 0;
			//Wenn nicht ja/nein bei der Frage eingegeben wird (ob ein Zug gemacht werden soll)
			} else {
				System.out.println("Invalide Antwort");
			}
		}
		
		
//		for (Figur f : spieler.getFiguren()) {
//			boolean isZugMoeglich = false;
//			do {
//				System.out.println("Wohin soll " + f.toString() + "gezogen werden? \n");
//				Koordinate k1;
//				
//				do {
//					k1 = konvertiereEingabe(scanner.next());
//				}while (k1.getX()==(-1));
//				
//				spielfeld.waehleFigur(f.getK1(), spieler);
//
//				if (spielfeld.pruefeBewegung(k1)) {
//					isZugMoeglich = true;
//					spielfeld.bewegeFigur(k1);
//				} else {
//					System.err.println("Zug nicht möglich");
//				}
//			} while (!isZugMoeglich);
//		}

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
	
	
	
	/**
	 * OUTDATED!!!
	 * 
	 * Konvertiert einen String in der Form einer Koordinate in einen
	 * Koordinaten-Wert
	 * 
	 * 
	 * @param input Eingabestring
	 * @return Koordinatenwert einer Achse
	 */
	public static int konvertiereEingabe(String input) {
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
			
			case "a": xNumber = 0; break;  
            case "b": xNumber = 1; break;  
            case "c": xNumber = 2; break;  
            case "d": xNumber = 3; break;  
            case "e": xNumber = 4; break;  
            case "f": xNumber = 5; break;  
            case "g": xNumber = 6; break;  
            case "h": xNumber = 7; break;  
            case "i": xNumber = 8; break;  
            case "j": xNumber = 9; break;  
			
			
		}	
		return xNumber;
	}

	
	
	
	/**
	 * Konvertiert einen String in der Form einer Koordinate in einen
	 * Koordinaten-Wert
	 * 
	 * Bsp "A1" -> Koordinate(0,0)
	 * 
	 * @param input Eingabestring
	 * @return Koordinatenwert einer Achse
	 */
	private static Koordinate konvertiereEingabe2(String input) {
		Koordinate koordinate = new Koordinate(-1,-1);
		switch (input.toUpperCase()) {
		
			case "A1": koordinate = new Koordinate( 0,0); break; case "A2": koordinate = new Koordinate( 0,1); break;
			case "A3": koordinate = new Koordinate( 0,2); break; case "A4": koordinate = new Koordinate( 0,3); break;
			case "A5": koordinate = new Koordinate( 0,4); break; case "A6": koordinate = new Koordinate( 0,5); break;
			case "A7": koordinate = new Koordinate( 0,6); break; case "A8": koordinate = new Koordinate( 0,7); break;
			case "A9": koordinate = new Koordinate( 0,8); break; case "A10": koordinate = new Koordinate( 0,9); break;
			
			case "B1": koordinate = new Koordinate( 1,0); break; case "B2": koordinate = new Koordinate( 1,1); break;
			case "B3": koordinate = new Koordinate( 1,2); break; case "B4": koordinate = new Koordinate( 1,3); break;
			case "B5": koordinate = new Koordinate( 1,4); break; case "B6": koordinate = new Koordinate( 1,5); break;
			case "B7": koordinate = new Koordinate( 1,6); break; case "B8": koordinate = new Koordinate( 1,7); break;
			case "B9": koordinate = new Koordinate( 1,8); break; case "B10": koordinate = new Koordinate( 1,9); break;
			
			case "C1": koordinate = new Koordinate( 2,0); break; case "C2": koordinate = new Koordinate( 2,1); break;
			case "C3": koordinate = new Koordinate( 2,2); break; case "C4": koordinate = new Koordinate( 2,3); break;
			case "C5": koordinate = new Koordinate( 2,4); break; case "C6": koordinate = new Koordinate( 2,5); break;
			case "C7": koordinate = new Koordinate( 2,6); break; case "C8": koordinate = new Koordinate( 2,7); break;
			case "C9": koordinate = new Koordinate( 2,8); break; case "C10": koordinate = new Koordinate( 2,9); break;
			
			case "D1": koordinate = new Koordinate( 3,0); break; case "D2": koordinate = new Koordinate( 3,1); break;
			case "D3": koordinate = new Koordinate( 3,2); break; case "D4": koordinate = new Koordinate( 3,3); break;
			case "D5": koordinate = new Koordinate( 3,4); break; case "D6": koordinate = new Koordinate( 3,5); break;
			case "D7": koordinate = new Koordinate( 3,6); break; case "D8": koordinate = new Koordinate( 3,7); break;
			case "D9": koordinate = new Koordinate( 3,8); break; case "D10": koordinate = new Koordinate( 3,9); break;
			
			case "E1": koordinate = new Koordinate( 4,0); break; case "E2": koordinate = new Koordinate( 4,1); break;
			case "E3": koordinate = new Koordinate( 4,2); break; case "E4": koordinate = new Koordinate( 4,3); break;
			case "E5": koordinate = new Koordinate( 4,4); break; case "E6": koordinate = new Koordinate( 4,5); break;
			case "E7": koordinate = new Koordinate( 4,6); break; case "E8": koordinate = new Koordinate( 4,7); break;
			case "E9": koordinate = new Koordinate( 4,8); break; case "E10": koordinate = new Koordinate( 4,9); break;
			
			case "F1": koordinate = new Koordinate( 5,0); break; case "F2": koordinate = new Koordinate( 5,1); break;
			case "F3": koordinate = new Koordinate( 5,2); break; case "F4": koordinate = new Koordinate( 5,3); break;
			case "F5": koordinate = new Koordinate( 5,4); break; case "F6": koordinate = new Koordinate( 5,5); break;
			case "F7": koordinate = new Koordinate( 5,6); break; case "F8": koordinate = new Koordinate( 5,7); break;
			case "F9": koordinate = new Koordinate( 5,8); break; case "F10": koordinate = new Koordinate( 5,9); break;
			
			case "G1": koordinate = new Koordinate( 6,0); break; case "G2": koordinate = new Koordinate( 6,1); break;
			case "G3": koordinate = new Koordinate( 6,2); break; case "G4": koordinate = new Koordinate( 6,3); break;
			case "G5": koordinate = new Koordinate( 6,4); break; case "G6": koordinate = new Koordinate( 6,5); break;
			case "G7": koordinate = new Koordinate( 6,6); break; case "G8": koordinate = new Koordinate( 6,7); break;
			case "G9": koordinate = new Koordinate( 6,8); break; case "G10": koordinate = new Koordinate( 6,9); break;
			
			case "H1": koordinate = new Koordinate( 7,0); break; case "H2": koordinate = new Koordinate( 7,1); break;
			case "H3": koordinate = new Koordinate( 7,2); break; case "H4": koordinate = new Koordinate( 7,3); break;
			case "H5": koordinate = new Koordinate( 7,4); break; case "H6": koordinate = new Koordinate( 7,5); break;
			case "H7": koordinate = new Koordinate( 7,6); break; case "H8": koordinate = new Koordinate( 7,7); break;
			case "H9": koordinate = new Koordinate( 7,8); break; case "H10": koordinate = new Koordinate( 7,9); break;
			
			case "I1": koordinate = new Koordinate( 8,0); break; case "I2": koordinate = new Koordinate( 8,1); break;
			case "I3": koordinate = new Koordinate( 8,2); break; case "I4": koordinate = new Koordinate( 8,3); break;
			case "I5": koordinate = new Koordinate( 8,4); break; case "I6": koordinate = new Koordinate( 8,5); break;
			case "I7": koordinate = new Koordinate( 8,6); break; case "I8": koordinate = new Koordinate( 8,7); break;
			case "I9": koordinate = new Koordinate( 8,8); break; case "I10": koordinate = new Koordinate( 8,9); break;
			
			case "J1": koordinate = new Koordinate( 9,0); break; case "J2": koordinate = new Koordinate( 9,1); break;
			case "J3": koordinate = new Koordinate( 9,2); break; case "J4": koordinate = new Koordinate( 9,3); break;
			case "J5": koordinate = new Koordinate( 9,4); break; case "J6": koordinate = new Koordinate( 9,5); break;
			case "J7": koordinate = new Koordinate( 9,6); break; case "J8": koordinate = new Koordinate( 9,7); break;
			case "J9": koordinate = new Koordinate( 9,8); break; case "J10": koordinate = new Koordinate( 9,9); break;	
		}	
		return koordinate;
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
