import java.util.List;

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
    private List<Figur> figuren;
    
    /**
     * Erzeugt ein neues Objekt.
     * 
     * @param figuren Die Figuren die der Spieler 
     *                dann kontrollieren kann
     */
    public Spieler(List<Figur> figuren) {
        this.figuren = figuren;
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
