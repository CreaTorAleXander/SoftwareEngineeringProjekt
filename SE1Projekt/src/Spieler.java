
import java.util.ArrayList;
import java.util.List;

import spielobjekte.Bogenschuetze;
import spielobjekte.Figur;
import spielobjekte.Lanzentraeger;
import spielobjekte.Magier;
import spielobjekte.Reiter;
import spielobjekte.Schwertkaempfer;

/**
 * Objekte dieser Klasse repraesentieren einen Spieler.
 * Dieser zeichnet sich durch die Figuren aus, die er kontrolliert.
 * 
 * @author Julian
 *
 */
public class Spieler {

    /**
     * Liste in der die Figuren des Spielers
     * gespeichert werden.
     */
    private List<Figur> figuren = new ArrayList<Figur>();
    
    
    /**
     * Erzeugt ein neues Objekt.
     * Dabei werden die Figuren zu der Liste der Figuren, 
     * die der Spieler hat hinzugefügt.
     */
    public Spieler() {
        figuren.add(new Reiter());
        figuren.add(new Schwertkaempfer());
        figuren.add(new Magier());
        figuren.add(new Bogenschuetze());
        figuren.add(new Lanzentraeger());
    }

    /**
     * Gibt die Figuren des Spielers zurueck.
     * 
     * @return Die Figuren des Spielers
     */
    public List<Figur> getFiguren() {
        return this.figuren;
    }

    /**
     * Setzt die Figuren.
     * 
     * @param figuren Die zu setzenden Figuren
     */
    public void setFiguren(List<Figur> figuren) {
        this.figuren = figuren;
    }
    
    
}
