package spiellogik;

import java.util.*;

import spielobjekte.*;

/**
 * Klasse, die ein Spielfeld repraesentiert. Sie enthaelt ein 2-dimensionales
 * Array zur Darstellung der Spielobjekte.
 * 
 */
public class Spielfeld {

	/** Spielobjekte des Spielfeldes */
	Spielobjekt[][] spielfeld = new Spielobjekt[10][10];

	/** Temporaeres Bewegungsspielfeld um Zuege vor Gegner zu verstecken */
	Spielobjekt[][] tempSpielfeld = new Spielobjekt[10][10];

	/** Ausgewaehlte Figur */
	Figur gewaehlteFigur; // ???

	/**
	 * Platziert Objekte auf dem Spielfeld
	 */
	void platziereObjekte(List<Figur> firstFiguren, List<Figur> secondFiguren) {
		this.generiereHindernisse();
		this.platziereFiguren(firstFiguren, secondFiguren);
	}

	/**
	 * Platziert Hindernisse auf dem Spielfeld
	 */
	void generiereHindernisse() {

		Random r = new Random();
		int zeile = r.nextInt(2) + 1; // Zufallszahl 1..2, dient dazu den index der for-Schleife zu iterieren
		int anzahlKleineH = 0; // Anz. der bereits gesetzten kleinen Hindernisse
		int anzahlGrosseH = 0; // Anz. der bereits gesetzten großen Hindernisse

		// 5 Hindernisse, die zufaellig 1 oder 2 Zeilen auseinander liegen (Spielfeld 10
		// Felder groß, 5 Hindernise => max. 2 Zeilen Abstand)
		for (int i = r.nextInt(2); i < 10; i = i + zeile) {

			int spalte = r.nextInt(8) + 1; // Zufaellige Platzierung des Hindernisses in der Spalte
			int hindernisart = r.nextInt(2); // Für Zufallswahl ob kleines oder großes Hindernis platziert werden soll

			if (hindernisart == 1 && anzahlGrosseH >= 2) // Falls keine kleinen HIndernisse mehr übrig sind, soll ein
															// großes platziert werden
				hindernisart = 0;

			if (hindernisart == 0 && anzahlKleineH >= 3) // Falls keine großen Hindernisse mehr übrig sind, soll ein
															// kleines platziert werden
				hindernisart = 1;

			if (hindernisart == 0 && anzahlKleineH < 3) { // //Platzieren eines kleinen HIndernisses
				spielfeld[i][spalte] = new Hindernis();
				anzahlKleineH++;
			}

			else if (hindernisart == 1 && anzahlGrosseH < 2) { // Platzieren eines großen Hindernisses
				if (spalte == 8)
					spalte--;
				spielfeld[i][spalte] = new Hindernis();
				spielfeld[i][spalte + 1] = new Hindernis();
				anzahlGrosseH++;
			}

			zeile = r.nextInt(2) + 1;

		}

	}

	/**
	 * Platziert Figuren auf dem Spielfeld.
	 */
	void platziereFiguren(List<Figur> firstFiguren, List<Figur> secondFiguren) {
		Random r = new Random();
		// Waehlt per Zufallszahl eine der 5 Figuren
		int index = r.nextInt(5);
		// Iteration ueber Startpositionen
		for (int i = 0; i < 10; i = i + 2) {
			// Wenn Figur schon gesetzt, solange neue Zufallszahl bestimmen, bis..
			while (firstFiguren.get(index).isWurdeGesetzt()) {
				index = r.nextInt(5);
			}
			// ...Figur noch nicht gesetzt wurde. Dann auf Brett setzen.
			if (!firstFiguren.get(index).isWurdeGesetzt()) {
				spielfeld[i][0] = firstFiguren.get(index);
				firstFiguren.get(index).setWurdeGesetzt(true);
				firstFiguren.get(index).setK1(new Koordinate(i, 0)); 
			}
		}

		// Waehlt per Zufallszahl eine der 5 Figuren
		int index2 = r.nextInt(5);
		// Iteration ueber Startpositionen
		for (int i = 1; i < 10; i = i + 2) {
			// Wenn Figur schon gesetzt, solange neue Zufallszahl bestimmen, bis..
			while (secondFiguren.get(index2).isWurdeGesetzt()) {
				index2 = r.nextInt(5);
			}
			// ...Figur noch nicht gesetzt wurde. Dann auf Brett setzen.
			if (!secondFiguren.get(index2).isWurdeGesetzt()) {
				spielfeld[i][9] = secondFiguren.get(index2);
				secondFiguren.get(index2).setWurdeGesetzt(true);
				secondFiguren.get(index2).setK1(new Koordinate(i, 9));
			}
		}
	}

	/**
	 * Laesst Spieler eine Figur auswaehlen, welche in "gewaehlteFigur" gespeichert
	 * wird.
	 * 
	 * @exception InputMismatchException wenn sich an der Koordinate keine eigene Figur befindet
	 */
	void waehleFigur(Koordinate wahl, Spieler player) {
		// Figur nur wï¿½hlen, wenn in eigener Liste vorhanden
		if (player.getFiguren().contains(spielfeld[wahl.getX()][wahl.getY()]))
			gewaehlteFigur = (Figur) spielfeld[wahl.getX()][wahl.getY()];
		// else: Exception kann geworfen werden und in der Spiel-main gehandlet werden
		else
			throw new InputMismatchException("Hier befindet sich keine eigene Figur!");
	}

	/**
	 * Laesst den Spieler eine Figur bewegen, die Bewegungen werden in einem extra
	 * Spielfeld-Array gespeichert.
	 * 
	 * @param zuBewegen
	 */
	void bewegeFigur(Koordinate ziel) {
		if (pruefeBewegung(ziel)) {
			// Figur verschieben
			spielfeld[ziel.getX()][ziel.getY()] = gewaehlteFigur;
			// Figur vom alten Platz lï¿½schen
			spielfeld[gewaehlteFigur.getK1().getX()][gewaehlteFigur.getK1().getY()] = null;
			// Figur neue Koordinaten zuweisen
			gewaehlteFigur.setK1(new Koordinate(ziel.getX(), ziel.getY()));
			// Bewegte Figur als bewegt markieren
			gewaehlteFigur.setWurdeBewegt(true);
		}

		// Exception-Handling fï¿½r nicht bewegbare Figur?
	}

	/**
	 * Ueberprueft, ob ein Spielzug moeglich ist.
	 */
	boolean pruefeBewegung(Koordinate ziel) {

		// Wenn die Bewegung moeglich ist von gewaehlterFigur aus
		if (spielfeld[ziel.getX()][ziel.getY()] == null) {
			if ((gewaehlteFigur).getK1().getX() - ziel.getX() <= gewaehlteFigur.getZugweite()
					&& (gewaehlteFigur.getK1().getX() - ziel.getX()) >= -(gewaehlteFigur.getZugweite())) {
				if (gewaehlteFigur.getK1().getY() - ziel.getY() <= gewaehlteFigur.getZugweite()
						&& gewaehlteFigur.getK1().getY() - ziel.getY() >= -(gewaehlteFigur.getZugweite())) {
					return true;
				} else
					return false;
			} else
				return false;
		} else
			return false;

	}

	/**
	 * Gibt das Aktuelle Spielfeld auf der Konsole aus.
	 */
	void printSpielfeld() {
		System.out.println("      1      2      3      4      5      6      7      8      9      10");
		System.out.print("   _______________________________________________________________________");
		for (int row = 0; row < 10; row++) {
			System.out.println("");
			//Zeile 1
			for (int column = 0; column < 10; column++) {
				if (column == 0)
					System.out.print("   ");
				if (spielfeld[row][column] == null)
					System.out.print("|  " + " " + " " + " " + " ");
				if (spielfeld[row][column] instanceof Figur)
					System.out.print("|" + spielfeld[row][column].toString());
				if (spielfeld[row][column] instanceof Hindernis)
					System.out.print("|" + "XXXXXX");
			}
			System.out.print("|\n");
			//Zeile 2
			for (int column = 0; column < 10; column++) {
				if (column == 0)
					System.out.print((char) (row + 65) + "  ");
				if (spielfeld[row][column] == null)
					System.out.print("|  " + " " + " " + " " + " ");
				if (spielfeld[row][column] instanceof Figur)
					((Figur) spielfeld[row][column]).printHP();
				if (spielfeld[row][column] instanceof Hindernis)
					System.out.print("|" + "XXXXXX");

			}
			System.out.print("|\n");
			//Zeile 3
			for (int column = 0; column < 10; column++) {
				if (column == 0)
					System.out.print("   ");
				if (spielfeld[row][column] == null || spielfeld[row][column] instanceof Figur)
					System.out.print("|__" + "_" + "_" + "_" + "_");
				if (spielfeld[row][column] instanceof Hindernis)
					System.out.print("|" + "XXXXXX");
			}
			System.out.print("|");
		}
		System.out.println("");
	}

	/**
	 * Gibt das Spielfeld als Array zurueck.
	 * 
	 * @return Spielfeld als Array
	 */
	public Spielobjekt[][] getSpielfeld() {
		return spielfeld;
	}

	/**
	 * Setzt das Spielfeld auf neue Werte.
	 * 
	 * @param spielfeld
	 *            Neues Spielfeld
	 */
	public void setSpielfeld(Spielobjekt[][] spielfeld) {
		this.spielfeld = spielfeld;
	}

	/**
	 * Gibt die aktuell gewaehlte Figur zurueck.
	 * 
	 * @return Gewaehlte Figur
	 */
	public Figur getGewaehlteFigur() {
		return gewaehlteFigur;
	}

	/**
	 * Setzt eine neue gewaehlte Figur fest.
	 * 
	 * @param gewaehlteFigur
	 *            Neue gewaehlte Figur
	 */
	public void setGewaehlteFigur(Figur gewaehlteFigur) {
		this.gewaehlteFigur = gewaehlteFigur;
	}
}
