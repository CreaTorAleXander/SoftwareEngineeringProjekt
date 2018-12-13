package spielobjekte;

/**
 * Objekte dieser Klasse repraesentieren einen Bogenschuetzen.
 * Dieser zeichnet sich durch die Zugweite 2 aus (auch diagonal), 1 Leben und, dass er alles
 * angreifen kann, was 1 oder 2 Felder von ihm entfernt ist (auch diagonal).
 * @author Julian
 *
 */
public class Bogenschuetze extends Figur {

	/**
	 * Erzeugung eines neuen Objekts mit 1 Leben, der Zugweite 2 und mit der Abkuerzung BOG
	 * als Namen.
	 */
	public Bogenschuetze(int id) {
		super(1, 2);
		this.setName(Abkuerzung.BOG);
		this.setId(id);
	}
	
	public String toString() {
		return "BOG   ";
	}
}
