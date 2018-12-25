package spielobjekte;

import java.util.HashSet;
import java.util.Set;

import spiellogik.Spieler;
import spiellogik.Spielfeld;

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
     * Erzeugung eines neuen Objekts mit 1 Leben, der Zugweite 2 und der Abkuerzung
     * MAG als Namen.
     */
    public Magier() {
        super(1, 2, Spieler.anzahlSpieler);
        this.setName(Abkuerzung.MAG);
    }

    public String toString() {
        return "MGR   ";
    }

    @Override
    public Set<Koordinate> bestimmePotAngriffsPos(Spielfeld spielfeld) {
        Set<Koordinate> positionen = new HashSet<>();
        int xWert = this.getK1().getX();
        int yWert = this.getK1().getY();
        Spielobjekt[][] feld = spielfeld.getSpielfeld();

        boolean innerhalbFeld = false;

        // Kontrolle, welche Felder in Angriffsweite sind und eine gegnerische Figur
        // darauf haben. Bei dem Magier sind 6 Positionen zu betrachten.

        // 1 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert + 1] != null) && (feld[xWert - 1][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert + 1));
            innerhalbFeld = false;
        }

        // 2 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && ((yWert + 2) >= 0) && ((yWert + 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert + 2] != null) && (feld[xWert - 1][yWert + 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert + 2]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert + 2));
            innerhalbFeld = false;
        }

        // 3 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert + 1] != null) && (feld[xWert][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert, yWert + 1));
            innerhalbFeld = false;
        }

        // 4 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert + 2) >= 0) && ((yWert + 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert + 2] != null) && (feld[xWert][yWert + 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert + 2]).getId())) {

            positionen.add(new Koordinate(xWert, yWert + 2));
            innerhalbFeld = false;
        }

        // 5 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert + 1] != null) && (feld[xWert + 1][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert + 1));
            innerhalbFeld = false;
        }

        // 6 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && ((yWert + 2) >= 0) && ((yWert + 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert + 2] != null) && (feld[xWert + 1][yWert + 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert + 2]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert + 2));
            innerhalbFeld = false;
        }

        return positionen;
        
    }
}
