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
	
	public boolean wurdeGesetzt = false;
	
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
	protected Figur(int leben) {
        this.setLeben(leben);
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
    public Object getAngriffsart() {
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
    
    public void printHP() {
    	System.out.print("|HP: " + leben + " ");
    
    }


}
