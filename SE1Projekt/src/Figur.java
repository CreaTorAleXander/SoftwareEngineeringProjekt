
public abstract class Figur {

	/**
	 * Felder des Objektes Figur
	 */
	private int leben;
	private boolean wurdeBewegt;
	private Object angriff;

	/**
	 * @return das leben
	 */
	public int getLeben() {
		return leben;
	}

	/**
	 * @param leben
	 *            das leben wird gesetzt
	 */
	public void setLeben(int leben) {
		this.leben = leben;
	}

	/**
	 * @return  wurdeBewegt
	 */
	public boolean isWurdeBewegt() {
		return wurdeBewegt;
	}

	/**
	 * @param wurdeBewegt
	 *            wurde bewegt wird gesetzt
	 */
	public void setWurdeBewegt(boolean wurdeBewegt) {
		this.wurdeBewegt = wurdeBewegt;
	}

	/**
	 * @return  angriff
	 */
	public Object getAngriff() {
		return angriff;
	}

	/**
	 * @param angriff
	 *             angriff wurde gesetzt
	 */
	public void setAngriff(Object angriff) {
		this.angriff = angriff;
	}
	
	public void angreifen(int x, int y) {
		
	}
	
	private boolean pruefeAngriff(int x, int y) {
		boolean dummy = true  ;
		return dummy;
		
	}
	
	public void erleideSchaden(int x) {
		
	}
	
	
	
	
}
