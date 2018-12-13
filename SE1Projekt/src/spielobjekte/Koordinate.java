package spielobjekte;
/**
 * Eine Klasse die Koordinaten auf dem Spielfeld simulieren soll
 * 
 * @author merta
 *
 */
public class Koordinate {
	private int x;
	private int y;
	
	/**
	 * Der Konstruktor
	 * 
	 * @param x x-Koordinate
	 * @param y	y-Koordinate
	 */
	public Koordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Getter der x-Koordiante
	 * 
	 * @return x Koordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * �berschreibt die x-Koordinate
	 * 
	 * @param y
	 */
	public void setX(int x) {
		this.x = x;
	}
	

	/**
	 * Getter der y-Koordiante
	 * 
	 * @return y Koordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * �berschreibt die y-Koordinate
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	
}
