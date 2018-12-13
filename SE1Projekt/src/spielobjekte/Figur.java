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
	
	private int zugweite;
	
	private boolean wurdeGesetzt = false;
	
	/**
	 * Name der jeweiligen Art von Figur
	 */
	private Abkuerzung name;
	
	/**
	 * Das aktuelle Angriffsobjekt der Figur. Wird spÃ¤ter vom Typ Angriffsobjekt sein.
	 */
	private Angriffsobjekt angriffsart = null;

	/**
	 * Zu Vererbungszwecken implementiert.
	 * 
	 * @param leben Das Leben der Figur
	 * @param wurdeBewegt Ob die Figur bewegt wurde
	 * @param angriffsart Die Angriffsart der Figur
	 */
	protected Figur(int leben, int zugweite) {
	    this.setLeben(leben);
        this.setZugweite(zugweite);
    }
	
	/**
	 * Enum, die die erlaubten Abkuerzungen der 
	 * Figuren festlegt.
	 * 
	 * @author Julian
	 *
	 */
	protected enum Abkuerzung{
	    LT, MAG, BOG, REI, SK 
	}
	
	public int getZugweite() {
		return zugweite;
	}

	public void setZugweite(int zugweite) {
		this.zugweite = zugweite;
	}

	public boolean isWurdeGesetzt() {
		return wurdeGesetzt;
	}

	public void setWurdeGesetzt(boolean wurdeGesetzt) {
		this.wurdeGesetzt = wurdeGesetzt;
	}

    /**
     * Gibt das Leben der Figur zurueck.
	 * 
	 * @return Das Leben der Figur
	 */
	public int getLeben() {
		return leben;
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
		return wurdeBewegt;
	}

	/**
	 * Setzt, ob die Figur bewegt wurde oder nicht.
	 * @param wurdeBewegt Zu setzender Wert, ob die 
	 *                    Figur bewegt wurde.
	 *           
	 */
	public void setWurdeBewegt(boolean wurdeBewegt) {
		this.wurdeBewegt = wurdeBewegt;
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
     * Gibt einen String mit Herzen zurueck, abhaengig von der Anzahl der Leben
     * der Figur.
     * 
     * @return String mit Herzen
     */
    /*
    public String printHP() {
    	System.out.print("|HP: " + leben + " ");
    
    }
    */

}
