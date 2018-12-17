package spielobjekte;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import spiellogik.Spielfeld;

/**
 * Objekte dieser Klasse repraesentieren einen Reiter. Dieser zeichnet sich
 * durch die Zugweite 3 aus (nicht diagonal), 2 Leben und, dass er alles
 * angreifen kann was direkt an sein Feld angrenzt (1 Feld entfernt, auch
 * diagonal).
 * 
 * @author Julian
 *
 */
public class Reiter extends Figur {

    /**
     * Erzeugung eines neuen Objekts mit 2 Leben, der Zugweite 3 und der Abkuerzung
     * REI als Namen.
     */
    public Reiter(int id) {
        super(2, 3);
        this.setName(Abkuerzung.REI);
        this.setId(id);
    }

    public String toString() {
        return "RTR   ";
    }

    @Override
    public Set<Koordinate> bestimmePotAngriffsPos(Spielfeld spielfeld) {
        Set<Koordinate> positionen = new HashSet<>();
        int xWert = this.getK1().getX();
        int yWert = this.getK1().getY();
        Spielobjekt[][] feld = spielfeld.getSpielfeld();

        boolean innerhalbFeld = false;

        // Kontrolle, welche Felder in Angriffsweite sind und eine gegnerische Figur
        // darauf haben. Bei dem Reiter sind 8 Positionen zu betrachten.

        // 1 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && (yWert >= 0) && (yWert < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert] != null) && (feld[xWert - 1][yWert] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert));
            innerhalbFeld = false;
        }

        // 2 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && ((yWert - 1) >= 0) && ((yWert - 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert - 1] != null) && (feld[xWert - 1][yWert - 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert - 1]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert - 1));
            innerhalbFeld = false;
        }

        // 3 Position
        if (((xWert - 1) >= 0) && ((xWert - 1) < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert - 1][yWert + 1] != null) && (feld[xWert - 1][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert - 1][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert - 1, yWert + 1));
            innerhalbFeld = false;
        }

        // 4 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert - 1) >= 0) && ((yWert - 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert - 1] != null) && (feld[xWert][yWert - 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert - 1]).getId())) {

            positionen.add(new Koordinate(xWert, yWert - 1));
            innerhalbFeld = false;
        }

        // 5 Position
        if ((xWert >= 0) && (xWert < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert][yWert + 1] != null) && (feld[xWert][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert, yWert + 1));
            innerhalbFeld = false;
        }

        // 6 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && (yWert >= 0) && (yWert < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert] != null) && (feld[xWert + 1][yWert] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert));
            innerhalbFeld = false;
        }

        // 7 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && ((yWert - 1) >= 0) && ((yWert - 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert - 1] != null) && (feld[xWert + 1][yWert - 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert - 1]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert - 1));
            innerhalbFeld = false;
        }

        // 8 Position
        if (((xWert + 1) >= 0) && ((xWert + 1) < feld.length) && ((yWert + 1) >= 0) && ((yWert + 1) < feld[0].length))
            innerhalbFeld = true;

        if (innerhalbFeld && (feld[xWert + 1][yWert + 1] != null) && (feld[xWert + 1][yWert + 1] instanceof Figur)
                && (this.getId() != ((Figur) feld[xWert + 1][yWert + 1]).getId())) {

            positionen.add(new Koordinate(xWert + 1, yWert + 1));
            innerhalbFeld = false;
        }

        return positionen;
    }
}
