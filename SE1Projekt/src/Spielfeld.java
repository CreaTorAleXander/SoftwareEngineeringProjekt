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
			while (firstFiguren.get(index).isWurdeGesetzt()) {
				index = r.nextInt(5);
			}
			// ...Figur noch nicht gesetzt wurde. Dann auf Brett setzen.
			if (!firstFiguren.get(index).isWurdeGesetzt()) {
				spielfeld[i][0] = firstFiguren.get(index);
				firstFiguren.get(index).setWurdeGesetzt(true); 
				firstFiguren.get(index).setK1(new Koordinate(i, 0)); // = new Koordinate(0, i);
			}
		}

		// Wählt per Zufallszahl eine der 5 Figuren
		int index2 = r.nextInt(5);
		// Iteration über Startpositionen
		for (int i = 1; i < 10; i = i + 2) {
			// Wenn Figur schon gesetzt, solange neue Zufallszahl bestimmen, bis..
			while (secondFiguren.get(index2).isWurdeGesetzt()) {
				index2 = r.nextInt(5);
			}
			// ...Figur noch nicht gesetzt wurde. Dann auf Brett setzen.
			if (!secondFiguren.get(index2).isWurdeGesetzt()) {
				spielfeld[i][9] = secondFiguren.get(index2);
				secondFiguren.get(index2).setWurdeGesetzt(true);
				secondFiguren.get(index2).k1 = new Koordinate(i, 9);
			}
		}
	}
	
	/**
	 * Lässt Spieler eine Figur auswaehlen, welche in "gewaehlteFigur" gespeichert wird.
	 */
	void waehleFigur(Koordinate wahl, Spieler player) {
		//Figur nur wählen, wenn in eigener Liste vorhanden
		if(player.getFiguren().contains(spielfeld[wahl.getX()][wahl.getY()]))
			gewaehlteFigur = (Figur)spielfeld[wahl.getX()][wahl.getY()];
		//else: Exception kann geworfen werden und in der Spiel-main gehandlet werden
	}
	
	/**
	 * Lässt den Spieler eine Figur bewegen, die Bewegungen werden in einem extra 
	 * Spielfeld-Array gespeichert.
	 * 
	 * @param zuBewegen
	 */
	void bewegeFigur(Koordinate ziel) {
		if(pruefeBewegung(ziel)) {
			//Figur verschieben
			spielfeld[ziel.getX()][ziel.getY()] = gewaehlteFigur;
			//Figur vom alten Platz löschen
			spielfeld[gewaehlteFigur.getK1().getX()][gewaehlteFigur.getK1().getY()] = null;
			//Figur neue Koordinaten zuweisen
			gewaehlteFigur.setK1(new Koordinate(ziel.getX(), ziel.getY()));
			//Bewegte Figur als bewegt markieren
			gewaehlteFigur.setWurdeBewegt(true);
		}
		
		
		//Exception-Handling für nicht bewegbare Figur?
	}
	
	/**
	 * Ueberprueft, ob ein Spielzug möglich ist.
	 * */
	boolean pruefeBewegung(Koordinate ziel) {
		
		//Wenn die Bewegung möglich ist von gewaehlterFigur aus
			if(spielfeld[ziel.getX()][ziel.getY()] == null) {	
				if((gewaehlteFigur).getK1().getX()-ziel.getX() <= gewaehlteFigur.getZugweite() && 
						(gewaehlteFigur.getK1().getX()-ziel.getX()) >= -(gewaehlteFigur.getZugweite())) {
					if (gewaehlteFigur.getK1().getY()-ziel.getY() <= gewaehlteFigur.getZugweite() && 
							gewaehlteFigur.getK1().getY()-ziel.getY() >= -(gewaehlteFigur.getZugweite())) {
						return true;
					}
					else return false;
				}
				else return false;
			}
			else return false;
				
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
