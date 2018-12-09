
/**
 * Klasse, die ein Spielfeld repräsentiert. Sie enthält ein 2-dimensionales Array
 * zur Darstellung der Spielobjekte.
 * 
 * */
public class Spielfeld {
	
	/** Spielobjekte des Spielfeldes */
	Spielobjekt[][] spielfeld = new Spielobjekt[10][10];
	
	/** Temporäres Bewegungsspielfeld */
	Spielobjekt[][] tempSpielfeld = new Spielobjekt[10][10];
	
	/** Ausgewaehlte Figur */
	Figur gewaehlteFigur; // ???
	
	/** 
	 * Platziert Objekte auf dem Spielfeld
	 * */
	void platziereObjekte() { 
		this.generiereHindernisse();
		this.platziereFiguren();
	}
	
	/**
	 * Platziert Hindernisse auf dem Spielfeld
	 */
	void generiereHindernisse() {
		
	}
	
	/**
	 * Platziert Figuren auf dem Spielfeld.
	 */
	void platziereFiguren() {
		
	}
	
	/**
	 * Lässt Spieler eine Figur auswaehlen, welche in "gewaehlteFigur" gespeichert wird.
	 */
	void waehleFigur(/*Koordinate*/) {
		
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
