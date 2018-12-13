package spielobjekte;

/**
 * Eine Klasse, die eine Figur repraesentiert.
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
     * Name der jeweiligen Art von Figur.
     */
    private Abkuerzung name;

    /**
     * Das aktuelle Angriffsobjekt der Figur.
     */
    private Angriffsobjekt angriffsart;

    /**
     * Zu Vererbungszwecken implementiert.
     * 
     * @param leben    Das Leben der Figur
     * @param zugweite Die Zugweite der Figur
     */
    protected Figur(int leben, int zugweite) {
        this.setLeben(leben);
        this.setZugweite(zugweite);
    }

    /**
     * Enum, die die erlaubten Abkuerzungen der Figuren festlegt.
     * Die dargestellten Abkürzungen sind ein Beispiel.
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
    public void setZugweite(int zugweite) {
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
     * Gibt einen String mit Herzen zurueck, abhaengig von der Anzahl der Leben der
     * Figur.
     * 
     * @return String mit Herzen
     */

    public void printHP() {
        System.out.print("|HP: " + leben + " ");

    }

}
