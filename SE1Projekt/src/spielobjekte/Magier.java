package spielobjekte;

/**
 * Objekte dieser Klasse repraesentieren einen Magier. Dieser zeichnet sich
 * durch die Zugweite 2 aus (auch diagonal), 1 Leben und, dass er entweder 1
 * Feld oder 2 Felder entfernt in Richtung gegnerischer Seite angreifen kann
 * (nicht diagonal), wobei die vertikalen 3 Felder vor ihm angegriffen werden.
 * 
 * @author Julian
 *
 */
public class Magier extends Figur {

    /**
     * Erzeugung eines neuen Objekts mit 1 Leben, der Zugweite 2 und der Abkuerzung MAG
     * als Namen.
     */
    public Magier(int id) {
        super(1, 2);
        this.setName(Abkuerzung.MAG);
        this.setId(id);
    }

    public String toString() {
        return "MGR   ";
    }
}
