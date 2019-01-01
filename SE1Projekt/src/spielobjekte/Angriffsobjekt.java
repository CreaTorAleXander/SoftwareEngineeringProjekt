package spielobjekte;

import java.util.Set;

/**
 * Eine Klasse, die ein Angriffsobjekt erzeugen soll
 * 
 * @author Mert
 *
 */
public class Angriffsobjekt {

	private Set<Koordinate> angriffskoordinaten;
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
	public Angriffsobjekt(Set<Koordinate> angriffskoordinaten, Angriffsart angriffshaltung) {
		this.angriffskoordinaten = angriffskoordinaten;
		this.angriffshaltung = angriffshaltung;
		this.erlittenerSchaden = 0;
	}
	
	/* Getter & Setter */
	
	
	/**
	 * Getter der Koordinaten des Angriffsobjektes
	 * 
	 * @return angriffskoordinate Koordinaten
	 */
	public Set<Koordinate> getAngriffskoordinaten() {
		return angriffskoordinaten;
	}

	/**
	 * Setzt die Angriffskoordinaten auf eine Menge an
	 * bestimmten Koordinaten
	 * 
	 * @param angriffskoordinaten Koordinaten
	 */
	public void setAngriffskoordinaten(Set<Koordinate> angriffskoordinaten) {
		this.angriffskoordinaten = angriffskoordinaten;
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
	 * �berschreibt die Angriffsart mit einer 
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
	
	
	/* Zus�tzliche Methoden */
	
	/**
	 * Erh�ht den erlittenen Schaden um eine gewisse Zahl
	 * 
	 * @param schaden
	 */
	public void addSchaden(int schaden) {
		this.erlittenerSchaden+=schaden;
	}
	
	/*---------------------*/
	
}
