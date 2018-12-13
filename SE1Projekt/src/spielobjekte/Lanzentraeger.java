package spielobjekte;

/**
 * Objekte dieser Klasse repraesentieren einen Lanzentraeger. Er zeichnet sich
 * durch die Zugweite 1 aus (auch diagonal), 1 Leben und, dass er alles
 * angreifen kann, was 2 Felder von ihm entfernt ist (nicht jedoch diagonal).
 * 
 * @author Julian
 *
 */
public class Lanzentraeger extends Figur {

    /**
     * Erzeugung eines neuen Objekts mit 1 Leben, der Zugweite 1 und mit der
     * Abkuerzung LAT als Namen.
     */
    public Lanzentraeger(int id) {
        super(1, 1);
        this.setName(Abkuerzung.LAT);
        this.setId(id);
    }

    public String toString() {
        return "LZT   ";
    }

}
