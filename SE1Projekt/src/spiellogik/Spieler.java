package spiellogik;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        this.figuren.add(new Reiter(Spieler.anzahlSpieler));
        this.figuren.add(new Schwertkaempfer(Spieler.anzahlSpieler));
        this.figuren.add(new Magier(Spieler.anzahlSpieler));
        this.figuren.add(new Bogenschuetze(Spieler.anzahlSpieler));
        this.figuren.add(new Lanzentraeger(Spieler.anzahlSpieler));
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
    /*
    public List<Figur> filtereAngriffsFaehigeFiguren(List<Figur> figuren, Spielfeld spielfeld) {

        List<Figur> gefilterteFigurenListe = new LinkedList<>();

        for (Figur figur : figuren) {

            if (figur instanceof Schwertkaempfer) {

                // Kontrolliere geradlinigen Angrifffsmoeglichkeiten
                if (spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY()] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY()] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1()
                                .getY()]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY()] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY()] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1()
                                .getY()]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY() + 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY() + 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY()
                                + 1]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY() - 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY() - 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY()
                                - 1]).getId())
                    gefilterteFigurenListe.add(figur);

                // Kontrolliere diagonale Angriffsmoeglichkeiten
                else if (spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY() + 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY() + 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1()
                                .getY() + 1]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY() + 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY() + 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1()
                                .getY() + 1]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY() - 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY() - 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1()
                                .getY() - 1]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY() - 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY() - 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1()
                                .getY() - 1]).getId())
                    gefilterteFigurenListe.add(figur);
            }

            else if (figur instanceof Lanzentraeger) {

                // Kontrolle Angriffsmoeglichkeiten nach rechts
                if (spielfeld.getSpielfeld()[figur.getK1().getX() + 2][figur.getK1().getY()] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() + 2][figur.getK1().getY()] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() + 2][figur.getK1()
                                .getY()]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() + 2][figur.getK1().getY() + 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() + 2][figur.getK1().getY() + 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() + 2][figur.getK1()
                                .getY() + 1]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() + 2][figur.getK1().getY() - 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() + 2][figur.getK1().getY() - 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() + 2][figur.getK1()
                                .getY() - 1]).getId())
                    gefilterteFigurenListe.add(figur);

                // Kontrolle Angriffsmoeglichkeiten nach links

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() - 2][figur.getK1().getY()] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() - 2][figur.getK1().getY()] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() - 2][figur.getK1()
                                .getY()]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() - 2][figur.getK1().getY() + 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() - 2][figur.getK1().getY() + 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() - 2][figur.getK1()
                                .getY() + 1]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() - 2][figur.getK1().getY() - 1] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() - 2][figur.getK1().getY() - 1] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() - 2][figur.getK1()
                                .getY() - 1]).getId())
                    gefilterteFigurenListe.add(figur);

                // Kontrolle Angriffsmoeglichkeiten nach oben

                else if (spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY() + 2] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY() + 2] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY()
                                + 2]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY() + 2] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY() + 2] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1()
                                .getY() + 2]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY() + 2] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY() + 2] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1()
                                .getY() + 2]).getId())
                    gefilterteFigurenListe.add(figur);

                // Kontrolle Angriffsmoeglichkeiten nach unten

                else if (spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY() - 2] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY() - 2] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX()][figur.getK1().getY()
                                - 2]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY() - 2] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1().getY() - 2] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() - 1][figur.getK1()
                                .getY() - 2]).getId())
                    gefilterteFigurenListe.add(figur);

                else if (spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY() - 2] != null
                        && spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1().getY() - 2] instanceof Figur
                        && figur.getId() != ((Figur) spielfeld.getSpielfeld()[figur.getK1().getX() + 1][figur.getK1()
                                .getY() - 2]).getId())
                    gefilterteFigurenListe.add(figur);
            }
            
            else if(figur instanceof Bogenschuetze) {
                
            }
        }
    }
    */
}
