package spielobjekte;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import spiellogik.Spielfeld;

/**
 * Objekte dieser Klasse repraesentieren einen Bogenschuetzen. Dieser zeichnet
 * sich durch die Zugweite 2 aus (auch diagonal), 1 Leben und, dass er alles
 * angreifen kann, was 1 oder 2 Felder von ihm entfernt ist (auch diagonal).
 * 
 * @author Julian
 *
 */
public class Bogenschuetze extends Figur {

    /**
     * Erzeugung eines neuen Objekts mit 1 Leben, der Zugweite 2 und mit der
     * Abkuerzung BOG als Namen.
     */
    public Bogenschuetze(int id) {
        super(1, 2);
        this.setName(Abkuerzung.BOG);
        this.setId(id);
    }

    public String toString() {
        return "BOG   ";
    }

    @Override
    public Set<Koordinate> bestimmePotAngriffsPos(Spielfeld spielfeld) {
        Set<Koordinate> positionen = new HashSet<>();
        int xWert = this.getK1().getX();
        int yWert = this.getK1().getY();
        Spielobjekt[][] feld = spielfeld.getSpielfeld();

        boolean innerhalbFeld = false;

        // Kontrolle, welche Felder in Angriffsweite sind und eine gegnerische Figur
        // darauf haben. Bei dem Bogenschuetzen sind 16 Positionen zu betrachten.

        // Positionen werden von oben nacht unten hier betrachtet
        // 1 Position
        if (((xWert - 2) >= 0) && ((xWert - 2) < feld.length) && (yWert >= 0) && (yWert < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 2][yWert] != null) && (feld[xWert - 2][yWert] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 2][yWert]).getId())) {

            positionen.add(new Koordinate(xWert - 2, yWert));
            innerhalbFeld = false;
        }

        // 2 Position
        if (((xWert - 2) >= 0) && ((xWert - 2) < feld.length) && ((yWert - 2) >= 0) && ((yWert - 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 2][yWert - 2] != null) && (feld[xWert - 2][yWert - 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 2][yWert - 2]).getId())) {

            positionen.add(new Koordinate(xWert - 2, yWert - 2));
            innerhalbFeld = false;
        }

        // 3 Position
        if (((xWert - 2) >= 0) && ((xWert - 2) < feld.length) && ((yWert + 2) >= 0) && ((yWert + 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 2][yWert + 2] != null) && (feld[xWert - 2][yWert + 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 2][yWert + 2]).getId())) {

            positionen.add(new Koordinate(xWert - 2, yWert + 2));
            innerhalbFeld = false;
        }

        // 4 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && (yWert >= 0) && (yWert < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert] != null) && (feld[xWert - 1][yWert] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert));
            innerhalbFeld = false;
        }

        // 5 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && ((yWert - 1) >= 0) && ((yWert - 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert - 1] != null) && (feld[xWert - 1][yWert - 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert - 1]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert - 1));
            innerhalbFeld = false;
        }

        // 6 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert + 1] != null) && (feld[xWert - 1][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert + 1));
            innerhalbFeld = false;
        }

        // 7 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert - 2) >= 0) && ((yWert - 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert - 2] != null) && (feld[xWert][yWert - 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert - 2]).getId())) {

            positionen.add(new Koordinate(xWert, yWert - 2));
            innerhalbFeld = false;
        }

        // 8 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert - 1) >= 0) && ((yWert - 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert - 1] != null) && (feld[xWert][yWert - 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert - 1]).getId())) {

            positionen.add(new Koordinate(xWert, yWert - 1));
            innerhalbFeld = false;
        }

        // 9 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert + 1] != null) && (feld[xWert][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert, yWert + 1));
            innerhalbFeld = false;
        }

        // 10 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert + 2) >= 0) && ((yWert + 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert + 2] != null) && (feld[xWert][yWert + 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert + 2]).getId())) {

            positionen.add(new Koordinate(xWert, yWert + 2));
            innerhalbFeld = false;
        }

        // 11 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && (yWert >= 0) && (yWert < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert] != null) && (feld[xWert + 1][yWert] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert));
            innerhalbFeld = false;
        }

        // 12 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && ((yWert - 1) >= 0) && ((yWert - 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert - 1] != null) && (feld[xWert + 1][yWert - 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert - 1]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert - 1));
            innerhalbFeld = false;
        }

        // 13 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert + 1] != null) && (feld[xWert + 1][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert + 1));
            innerhalbFeld = false;
        }

        // 14 Position
        if (((xWert + 2) >= 0) && ((xWert + 2) < feld.length) && ((yWert - 2) >= 0) && ((yWert - 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 2][yWert - 2] != null) && (feld[xWert + 2][yWert - 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 2][yWert - 2]).getId())) {

            positionen.add(new Koordinate(xWert + 2, yWert - 2));
            innerhalbFeld = false;
        }

        // 15 Position
        if (((xWert + 2) >= 0) && ((xWert + 2) < feld.length) && (yWert >= 0) && (yWert < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 2][yWert] != null) && (feld[xWert + 2][yWert] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 2][yWert]).getId())) {

            positionen.add(new Koordinate(xWert + 2, yWert));
            innerhalbFeld = false;
        }

        // 16 Position
        if (((xWert + 2) >= 0) && ((xWert + 2) < feld.length) && ((yWert + 2) >= 0) && ((yWert + 2) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 2][yWert + 2] != null) && (feld[xWert + 2][yWert + 2] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 2][yWert + 2]).getId())) {

            positionen.add(new Koordinate(xWert + 2, yWert + 2));
            innerhalbFeld = false;
        }
        
        return positionen;

    }
}
