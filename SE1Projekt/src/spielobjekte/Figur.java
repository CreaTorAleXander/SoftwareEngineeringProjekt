package spielobjekte;


import java.util.HashSet;
import java.util.Set;


import spiellogik.Spielfeld;

/**
 * Eine abstrakte Klasse, die eine Figur repraesentiert.
 * 
 * @author Julian
 *
 */
public abstract class Figur extends Spielobjekt {

    /**
     * Das aktuelle Leben der Figur.
     */
    private int leben;

    /**
     * Ob die Figur bewegt wurde.
     */
    private boolean wurdeBewegt = false;

    /**
     * Die Zugweite der Figur.
     */
    private int zugweite;

    /**
     * Ob die Figur bisher gesetzt wurde.
     */
    private boolean wurdeGesetzt = false;

    /**
     * Name der jeweiligen Art von Figur (jeweils passende Abkuerzung).
     */
    private Abkuerzung name;

    /**
     * Das aktuelle Angriffsobjekt der Figur.
     */
    private Angriffsobjekt angriffsart;

    /**
     * ID, die angibt von welchem Spieler die Figur kontrolliert wird.
     */
    private int id;


    /**
     * Zu Vererbungszwecken implementiert.
     * 
     * @param leben    Das Leben der Figur
     * @param zugweite Die Zugweite der Figur
     */
    protected Figur(int leben, int zugweite, int id) {
        this.setLeben(leben);
        this.setZugweite(zugweite);
        this.setId(id);
    }

    /**
     * Enum, die die erlaubten Abkuerzungen der Figuren festlegt. Die dargestellten
     * Abkürzungen sind ein Beispiel.
     * 
     * @author Julian
     *
     */
    protected enum Abkuerzung {
        LAT, MAG, BOG, REI, SWK
    }

    /**
     * Gibt das Leben der Figur zurueck.
     * 
     * @return Das Leben der Figur
     */
    public int getLeben() {
        return this.leben;
    }

    /**
     * Setzt das Leben der Figur.
     * 
     * @param leben das zu setzende Leben
     */
    public void setLeben(int leben) {
        this.leben = leben;
    }

    /**
     * Kontrolle ob die Figur bewegt wurde.
     * 
     * @return Ob die Figur bewegt wurde
     */
    public boolean isWurdeBewegt() {
        return this.wurdeBewegt;
    }

    /**
     * Setzt, ob die Figur bewegt wurde oder nicht.
     * 
     * @param wurdeBewegt Zu setzender Wert, ob die Figur bewegt wurde.
     * 
     */
    public void setWurdeBewegt(boolean wurdeBewegt) {
        this.wurdeBewegt = wurdeBewegt;
    }

    /**
     * Gibt die Zugweite der Figur zurueck.
     * 
     * @return Die Zugweite der Figur
     */
    public int getZugweite() {
        return this.zugweite;
    }

    /**
     * Setzt die Zugweite der Figur.
     * 
     * @param zugweite Die zu setzende Zugweite
     */
    protected void setZugweite(int zugweite) {
        this.zugweite = zugweite;
    }

    /**
     * Gibt zurueck, ob die Figur bisher gesetzt wurde.
     * 
     * @return Ob die Figur gesetzt wurde
     */
    public boolean isWurdeGesetzt() {
        return this.wurdeGesetzt;
    }

    /**
     * Setzt, dass die Figur gesetzt wurde oder nicht gesetzt wurde.
     * 
     * @param wurdeGesetzt Ob die Figur gesetzt wurde
     */
    public void setWurdeGesetzt(boolean wurdeGesetzt) {
        this.wurdeGesetzt = wurdeGesetzt;
    }

    /**
     * Gibt den Name der Figur zurueck.
     * 
     * @return Den Namen der Figur
     */
    public Abkuerzung getName() {
        return this.name;
    }

    /**
     * Setzt den Namen für die Figur.
     * 
     * @param Der zu setzende Name
     */
    protected void setName(Abkuerzung name) {
        this.name = name;
    }

    /**
     * Gibt die Angriffsart der Figur zurueck.
     * 
     * @return Die Angriffsart der Figur
     */
    public Angriffsobjekt getAngriffsart() {
        return this.angriffsart;
    }

    /**
     * Setzt die Angriffsart der Figur.
     * 
     * @param angriffsart Die zu setzende Angriffsart der Figur
     */
    public void setAngriffsart(Angriffsobjekt angriffsart) {
        this.angriffsart = angriffsart;
    }

    /**
     * Gibt die ID der Figur zurueck.
     * 
     * @return Die ID der Figur
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setzt die ID der Figur.
     * 
     * @param id Die zu setzende ID
     */
    protected void setId(int id) {
        this.id = id;
    }

    /**
     * Gibt einen String mit Herzen zurueck, abhaengig von der Anzahl der Leben der
     * Figur.
     * 
     * @return String mit Herzen
     */

    public void printHP() {
        System.out.print("|HP: " + leben + " ");

    }

    /**
     * Bestimmt die potentiellen Positionen zum Angreifen der Figur ausgehend von
     * ihrer aktuellen Position.
     * 
     * @return Eine Menge von Koordinaten der potentiellen Positionen zum Angreifen
     *         der Figur
     */
    public abstract Set<Koordinate> bestimmePotAngriffsPos(Spielfeld spielfeld);


    /**
     * Bestimme die potentiellen Positionen, auf die eine Figur ausgehend von ihrer
     * aktuellen Position ziehen kann.
     * Der Algorithmus ist fuer jede Klasse, ausser den Reiter, gleich.
     * 
     * @param spielfeld Das aktuelle Spielfeld
     * 
     * @return Eine Menge von Koordinaten der potentiellen Zugmoeglichkeiten
     */
    public Set<Koordinate> bestimmePotZuege(Spielfeld spielfeld) {
    	Set<Koordinate> positionen = new HashSet<>();
        int xFigur = this.getK1().getX();
        int yFigur = this.getK1().getY();
        Spielobjekt[][] feld = spielfeld.getSpielfeld();
         
     	int potX;
     	int potY;
     	
     	//X-Koordinate als Startpunkt(potX) der Iteration waehlen,
     	//falls außerhalb des Feldes, ist die Startposition 0
     	if(xFigur - this.getZugweite() < 0)
     		potX = 0;
     	else
     		potX = xFigur - getZugweite();
     	
     	//Y-Koordinate als Startpunkt(potY) der Iteration waehlen,
     	//falls außerhalb des Feldes, ist die Startposition 0
     	if(yFigur - this.getZugweite() < 0)
     		potY = 0;
     	else 
     		potY = yFigur - getZugweite();
    	
     	//Iteriert durch das Spielfeld. Startpunkt der Iteration ist die erste mögliche Position
     	//"oben links" im Feld.
     	//1. Abbruchbedingung: Wenn über die mögliche Schrittweite iteriert wird
     	//2. Abbruchbedingung: Wenn über das Spielbrett hinaus iteriert wird
     	for(int i = potX; i <= (2*this.getZugweite() + potX) && i < 10; i++) {
     		for(int j = potY; j <= (2*this.getZugweite() + potY) && j < 10; j++) {
     			if(feld[i][j] != null)
     				positionen.add(new Koordinate(i, j));
     		}
     	}
     	
     	return positionen;
    }
    
    /**
     * Setzt das Angriffsobjekt der Figur zurueck.
     */
    public void setzeAngriffsobjektZurueck() {
        this.angriffsart = null;
    }
}
