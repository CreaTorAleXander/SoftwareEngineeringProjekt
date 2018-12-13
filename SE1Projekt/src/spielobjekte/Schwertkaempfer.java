package spielobjekte;

/**
 * Objekte dieser Klasse repraesentieren einen Schwertkaempfer. Dieser zeichenet
 * sich durch die Zugweite 1 aus (auch diagonal), 3 Leben und, dass er alles
 * angreifen kann, was direkt an sein Feld angrenzt (1 Feld von ihm entfernt, auch diagonal).
 * 
 * @author Julian
 *
 */
public class Schwertkaempfer extends Figur {

    /**
     * Erzeugung eines neuen Objekts Schwertkaempfer mit 3 Leben, der Zugweite 1 und der 
     * Abkuerzung SWL als Namen.
     */
    public Schwertkaempfer(int id) {
        super(3, 1);
        this.setName(Abkuerzung.SWK);
        this.setId(id);
    }

    public String toString() {
        return "STK   ";
    }
}
