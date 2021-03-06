package spielobjekte;

import java.util.HashSet;
import java.util.Set;
import spiellogik.Spieler;
import spiellogik.Spielfeld;

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
    public Lanzentraeger() {
        super(1, 1, Spieler.anzahlSpieler);
        this.setName(Abkuerzung.LAT);
    }

    public String toString() {
        return "LZT   ";
    }

    @Override
    public Set<Koordinate> bestimmePotAngriffsPos(Spielfeld spielfeld) {
        Set<Koordinate> positionen = new HashSet<>();
        int xWert = this.getK1().getX();
        int yWert = this.getK1().getY();
        Spielobjekt[][] feld = spielfeld.getSpielfeld();

        boolean innerhalbFeld = false;

        // Kontrolle, welche Felder in Angriffsweite sind und eine gegnerische Figur
        // darauf haben. Bei dem Lanzentraeger sind 12 Positionen zu betrachten.

        // 1 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert + 2) >= 0) && ((yWert + 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert + 2] != null) && (feld[xWert][yWert + 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert + 2]).getId())) {

            positionen.add(new Koordinate(xWert, yWert + 2));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 2 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && ((yWert + 2) >= 0) && ((yWert + 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert + 2] != null) && (feld[xWert - 1][yWert + 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert + 2]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert + 2));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 3 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && ((yWert + 2) >= 0) && ((yWert + 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert + 2] != null) && (feld[xWert + 1][yWert + 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert + 2]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert + 2));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 4 Position
        if (((xWert - 2) >= 0) && ((xWert - 2) < feld.length) && (yWert >= 0) && (yWert < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 2][yWert] != null) && (feld[xWert - 2][yWert] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 2][yWert]).getId())) {

            positionen.add(new Koordinate(xWert - 2, yWert));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 5 Position
        if (((xWert - 2) >= 0) && ((xWert - 2) < feld.length) && ((yWert - 1) >= 0) && ((yWert - 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 2][yWert - 1] != null) && (feld[xWert - 2][yWert - 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 2][yWert - 1]).getId())) {

            positionen.add(new Koordinate(xWert - 2, yWert - 1));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 6 Position
        if (((xWert - 2) >= 0) && ((xWert - 2) < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 2][yWert + 1] != null) && (feld[xWert - 2][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 2][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert - 2, yWert + 1));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 7 Position
        if (((xWert + 2) >= 0) && ((xWert + 2) < feld.length) && (yWert >= 0) && (yWert < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 2][yWert] != null) && (feld[xWert + 2][yWert] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 2][yWert]).getId())) {

            positionen.add(new Koordinate(xWert + 2, yWert));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 8 Position
        if (((xWert + 2) >= 0) && ((xWert + 2) < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 2][yWert + 1] != null) && (feld[xWert + 2][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 2][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert + 2, yWert + 1));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 9 Position
        if (((xWert + 2) >= 0) && ((xWert + 2) < feld.length) && ((yWert - 1) >= 0) && ((yWert - 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 2][yWert - 1] != null) && (feld[xWert + 2][yWert - 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 2][yWert - 1]).getId())) {

            positionen.add(new Koordinate(xWert + 2, yWert - 1));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 10 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && ((yWert - 2) >= 0) && ((yWert - 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert - 2] != null) && (feld[xWert - 1][yWert - 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert - 2]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert - 2));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 11 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert - 2) >= 0) && ((yWert - 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert - 2] != null) && (feld[xWert][yWert - 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert - 2]).getId())) {

            positionen.add(new Koordinate(xWert, yWert - 2));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        // 12 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && ((yWert - 2) >= 0) && ((yWert - 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert - 2] != null) && (feld[xWert + 1][yWert - 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert - 2]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert - 2));
        }
        
        if(innerhalbFeld)
            innerhalbFeld = false;
        
        return positionen;

    }
}
