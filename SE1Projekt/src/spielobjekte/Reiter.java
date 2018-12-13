package spielobjekte;

/**
 * Objekte dieser Klasse repraesentieren einen Reiter. Dieser zeichnet sich durch die 
 * Zugweite 3 aus (nicht diagonal), 2 Leben und, dass er alles angreifen kann was direkt 
 * an sein Feld angrenzt (1 Feld entfernt, auch diagonal).
 * 
 * @author Julian
 *
 */
public class Reiter extends Figur {
	
	/**
	 * Erzeugung eines neuen Objekts mit 2 Leben, der Zugweite 3 und der Abkuerzung REI
	 * als Namen.
	 */
	public Reiter(int id) {
		super(2, 3);
		this.setName(Abkuerzung.REI);
		this.setId(id);
	}
	
	public String toString() {
		return "RTR   ";
	}
}
