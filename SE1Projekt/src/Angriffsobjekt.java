/**
 * Eine Klasse, die ein Angriffsobjekt erzeugen soll
 * 
 * @author Mert
 *
 */
public class Angriffsobjekt {

	private Koordinate angriffskoordinate;
	private Angriffsart angriffshaltung;
	private int erlittenerSchaden;
	
	/**
	 * Konstruktor der Klasse
	 * 
	 * Setzt den erlittenen Schaden automatisch auf 0
	 * 
	 * @param angriffskoordinate Koordinate des Objektes
	 * @param angriffshaltung	 Angriffsart ( Enum )
	 */
	public Angriffsobjekt(Koordinate angriffskoordinate, Angriffsart angriffshaltung) {
		this.angriffskoordinate = angriffskoordinate;
		this.angriffshaltung = angriffshaltung;
		this.erlittenerSchaden = 0;
	}
	
	/* Getter & Setter */
	
	
	/**
	 * Getter der Koordinate des Angriffsobjektes
	 * 
	 * @return angriffskoordinate Koordinate
	 */
	public Koordinate getAngriffskoordinate() {
		return angriffskoordinate;
	}

	/**
	 * Setzt die Angriffskoordinate auf eine
	 * bestimmte Koordinate
	 * 
	 * @param angriffskoordinate Koordinate
	 */
	public void setAngriffskoordinate(Koordinate angriffskoordinate) {
		this.angriffskoordinate = angriffskoordinate;
	}
	
	/**
	 * Getter der Angriffshaltung
	 * 
	 * @return erlittenerSchaden
	 */
	public Angriffsart getAngriffshaltung() {
		return angriffshaltung;
	}
	
	/**
	 * Überschreibt die Angriffsart mit einer 
	 * Neuen
	 * 
	 * @param angriffshaltung
	 */
	public void setAngriffshaltung(Angriffsart angriffshaltung) {
		this.angriffshaltung = angriffshaltung;
	}

	/**
	 * Getter des erlittenen Schadens
	 * 
	 * @return erlittenerSchaden
	 */
	public int getErlittenerSchaden() {
		return erlittenerSchaden;
	}
	
	/* ------------*/
	
	
	/* Zusätzliche Methoden */
	
	/**
	 * Erhöht den erlittenen Schaden um eine gewisse Zahl
	 * 
	 * @param schaden
	 */
	public void addSchaden(int schaden) {
		this.erlittenerSchaden+=schaden;
	}
	
	/*---------------------*/
	
}
