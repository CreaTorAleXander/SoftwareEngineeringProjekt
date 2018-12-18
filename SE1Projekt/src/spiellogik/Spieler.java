package spiellogik;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

import spielobjekte.Bogenschuetze;
import spielobjekte.Figur;
import spielobjekte.Lanzentraeger;
import spielobjekte.Magier;
import spielobjekte.Reiter;
import spielobjekte.Schwertkaempfer;

/**
 * Objekte dieser Klasse repraesentieren einen Spieler. Dieser zeichnet sich
 * durch die Figuren aus, die er kontrolliert.
 * 
 * @author Julian
 *
 */
public class Spieler {

    /**
     * Anzahl der angelegten Spieler.
     */
    public static int anzahlSpieler = 0;

    /**
     * Liste in der die Figuren des Spielers gespeichert werden.
     */
    private List<Figur> figuren = new ArrayList<Figur>();

    /**
     * Erzeugt ein neues Objekt. Dabei werden die Figuren zu der Liste der Figuren
     * hinzugefuegt, die der Spieler kontrolliert.
     */
    public Spieler() {
        anzahlSpieler++;
        this.figuren.add(new Reiter());
        this.figuren.add(new Schwertkaempfer());
        this.figuren.add(new Magier());
        this.figuren.add(new Bogenschuetze());
        this.figuren.add(new Lanzentraeger());
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

    // Methoden, die fuer die Angriffsphase da sind.

    /**
     * Filtert alle Figuren des Spielers, die ueberhaupt potenziell angreifen
     * koennen.
     * 
     * @param figuren   Die Figuren, die der Spieler kontrolliert
     * @param spielfeld Das Spielfeld, auf dem sich die Figuren befinden
     * 
     * @return Liste an Figuren, deren Figuren jeweils angreifen koennen
     */
    public Set<Figur> filtereAngriffsFaehigeFiguren(List<Figur> figuren, Spielfeld spielfeld) {
       
        Set<Figur> gefilterteFigurenListe = new HashSet<>();
        
        // Fuegt alle Figuren des Spielers, derene Menge an Angriffspositionen nicht leer ist
        // zu der Menge der angriffsfaehigen Figuren hinzu.
        for(Figur figur: this.getFiguren()) {
            if(!figur.bestimmePotAngriffsPos(spielfeld).isEmpty())
                gefilterteFigurenListe.add(figur);
        }
        
        return gefilterteFigurenListe;
    }
    
    /**
     * Nimmt die Angriffszuege auf, die der Spieler in dieser Angriffsphase durchfuehren moechte.
     * 
     * @param spielfeld Das zu betrachtende Spielfeld
     */
    /*
    public void nehmeAngriffsInfoAuf(Spielfeld spielfeld) {
        
    }
    */
}
