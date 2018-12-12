import java.util.*;

/**
 * Klasse, die ein Spielfeld repräsentiert. Sie enthält ein 2-dimensionales Array
 * zur Darstellung der Spielobjekte.
 * 
 * */
public class Spielfeld {
	
	/** Spielobjekte des Spielfeldes */
	Spielobjekt[][] spielfeld = new Spielobjekt[10][10];
	
	/** Temporäres Bewegungsspielfeld um Züge vor Gegner zu verstecken */
	Spielobjekt[][] tempSpielfeld = new Spielobjekt[10][10];
	
	/** Ausgewaehlte Figur */
	Figur gewaehlteFigur; // ???
	
	/** 
	 * Platziert Objekte auf dem Spielfeld
	 * */
	void platziereObjekte(List<Figur> firstFiguren, List<Figur> secondFiguren) { 
		this.generiereHindernisse();
		this.platziereFiguren(firstFiguren, secondFiguren);
	}
	
	/**
	 * Platziert Hindernisse auf dem Spielfeld
	 */
	void generiereHindernisse() {
		
	}
	
	/**
	 * Platziert Figuren auf dem Spielfeld.
	 */
	void platziereFiguren(List<Figur> firstFiguren, List<Figur> secondFiguren) {
		Random r = new Random();
		// Wählt per Zufallszahl eine der 5 Figuren
		int index = r.nextInt(5);
		// Iteration über Startpositionen
		for (int i = 0; i < 10; i = i + 2) {
			// Wenn Figur schon gesetzt, solange neue Zufallszahl bestimmen, bis..
			while (firstFiguren.get(index).wurdeGesetzt) {
				index = r.nextInt(5);
			}
			// ...Figur noch nicht gesetzt wurde. Dann auf Brett setzen.
			if (!firstFiguren.get(index).wurdeGesetzt)
				spielfeld[i][0] = firstFiguren.get(index);
			firstFiguren.get(index).wurdeGesetzt = true;
			firstFiguren.get(index).k1 = new Koordinate(0, i);
		}

		// Wählt per Zufallszahl eine der 5 Figuren
		int index2 = r.nextInt(5);
		// Iteration über Startpositionen
		for (int i = 1; i < 10; i = i + 2) {
			// Wenn Figur schon gesetzt, solange neue Zufallszahl bestimmen, bis..
			while (secondFiguren.get(index2).wurdeGesetzt) {
				index2 = r.nextInt(5);
			}
			// ...Figur noch nicht gesetzt wurde. Dann auf Brett setzen.
			if (!secondFiguren.get(index2).wurdeGesetzt)
				spielfeld[i][9] = secondFiguren.get(index2);
			secondFiguren.get(index2).wurdeGesetzt = true;
			secondFiguren.get(index2).k1 = new Koordinate(0, i);
		}
	}
	
	/**
	 * Lässt Spieler eine Figur auswaehlen, welche in "gewaehlteFigur" gespeichert wird.
	 */
	void waehleFigur(/*Koordinate*/) {
		//Figur nur wählen, wenn in eigener Liste vorhanden?
	}
	
	/**
	 * Lässt den Spieler eine Figur bewegen, die Bewegungen werden in einem extra 
	 * Spielfeld-Array gespeichert.
	 * 
	 * @param zuBewegen
	 */
	void bewegeFigur(Figur zuBewegen /*,Koordinate als Ziel*/) {
		this.pruefeBewegung();
		//Bewegen, wenn pruefeBewegung == true
		zuBewegen.setWurdeBewegt(true);
	}
	
	/**
	 * Ueberprueft, ob ein Spielzug möglich ist.
	 * */
	boolean pruefeBewegung(/*Zu überprüfende Koordinate*/) {
		return true; //Wenn die Bewegung möglich ist
	}
	
	/**
	 * Gibt das Aktuelle Spielfeld auf der Konsole aus.
	 */
	void printSpielfeld() {
		System.out.println("      1      2      3      4      5      6      7      8      9      10");
		System.out.print("   _______________________________________________________________________");
		for (int row = 0; row < 10; row++)
	      {
			 
			System.out.println("");
			//System.out.print("A");
	          for (int column = 0; column < 10; column++)
	          {
	              if(column == 0)
	            	  System.out.print("   ");
	              if(spielfeld[row][column] == null)
	            	  System.out.print("|  " + " " + " " + " " + " ");
	        	  if(spielfeld[row][column] instanceof Figur)
	        		  System.out.print("|" + spielfeld[row][column].toString());
	              
	          }   
	          System.out.print("|\n");
	          for (int column = 0; column < 10; column++)
	          {
	        	  if(column == 0)
	        		  System.out.print((char)(row+65) + "  ");
	        	  if(spielfeld[row][column] == null)
	        		  System.out.print("|  " + " " + " " + " " + " ");
	        	  if(spielfeld[row][column] instanceof Figur)	
	        		  ((Figur)spielfeld[row][column]).printHP();
	              
	          }   
	          System.out.print("|\n");
	          for (int column = 0; column < 10; column++)
	          {
	        	  if(column == 0)
	        		  System.out.print("   ");
	              System.out.print("|__" + "_" + "_" + "_" + "_");
	              //Hinderniss durch zusätzliche if-Abfrage einbauen?
	              
	          }   
	          System.out.print("|");
	   
	    }
	    System.out.println("");
	    //System.out.println("-----------------------------------------");
	    //System.out.println("_________________________________________");
	 }
	
	
	/**
	 * Gibt das Spielfeld als Array zurueck.
	 * @return Spielfeld als Array
	 */
	public Spielobjekt[][] getSpielfeld() {
		return spielfeld;
	}
	
	/**
	 * Setzt das Spielfeld auf neue Werte.
	 * 
	 * @param spielfeld Neues Spielfeld
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
	 * @param gewaehlteFigur Neue gewaehlte Figur
	 */
	public void setGewaehlteFigur(Figur gewaehlteFigur) {
		this.gewaehlteFigur = gewaehlteFigur;
	}
}
