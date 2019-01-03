package spiellogik;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import spielobjekte.Angriffsart;
import spielobjekte.Angriffsobjekt;
import spielobjekte.Bogenschuetze;
import spielobjekte.Figur;
import spielobjekte.Koordinate;
import spielobjekte.Lanzentraeger;
import spielobjekte.Magier;
import spielobjekte.Reiter;
import spielobjekte.Schwertkaempfer;
import spielobjekte.Spielobjekt;

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
     * Die aktuell gewaehlte Figur des Spielers in der Angriffsphase
     */
    private Figur gewaehlteFigur = null;

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
     * Gibt die gewaehlte Figur zurueck.
     * 
     * @return Die gewaehlte Figur
     */
    public Figur getGewaehlteFigur() {
        return this.gewaehlteFigur;
    }

    /**
     * Setzt die gewaehlte Figur.
     * 
     * @param gewaehlteFigur Die zu setzende gewaehlte Figur
     */
    public void setGewaehlteFigur(Figur gewaehlteFigur) {
        this.gewaehlteFigur = gewaehlteFigur;
    }

    /**
     * Prueft ob der Spieler in dieser Runde Figuren kontrolliert, mit denen er
     * angreifen kann.
     * 
     * @return Ob der Spieler in dieser Runde angreifen kann
     */
    public boolean pruefeObAngriffMoeglich(Spielfeld spielfeld) {
        Set<Figur> angriffsFaehig = this.filtereAngriffsFaehigeFiguren(this.getFiguren(), spielfeld);

        if (angriffsFaehig.isEmpty())
            return false;
        return true;
    }

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

        Set<Figur> gefilterteFiguren = new HashSet<>();

        // Fuegt alle Figuren des Spielers, derene Menge an Angriffspositionen nicht
        // leer ist
        // zu der Menge der angriffsfaehigen Figuren hinzu.
        for (Figur figur : this.getFiguren()) {
            if (!figur.bestimmePotAngriffsPos(spielfeld).isEmpty())
                gefilterteFiguren.add(figur);
        }

        return gefilterteFiguren;
    }

    /**
     * Nimmt die Angriffszuege auf, die der Spieler in dieser Angriffsphase
     * durchfuehren moechte. Art Top-level Methode
     * 
     * @param spielfeld Das zu betrachtende Spielfeld
     */

    public void nehmeAngriffsInfoAuf(Scanner in, Spielfeld spielfeld) {

        Set<Figur> angriffsFaehigeFiguren = this.filtereAngriffsFaehigeFiguren(this.getFiguren(), spielfeld);
        Spielobjekt[][] feld = spielfeld.getSpielfeld();

        if (this.pruefeObAngriffMoeglich(spielfeld)) {

            while (!angriffsFaehigeFiguren.isEmpty()) {

                this.anfrageWaehleFigur(angriffsFaehigeFiguren, feld, in);
                // gewaehlteFigur sollte jetzt eine passende Figur als Wert haben

                this.waehleAngriffsZielFuerFigur(this.getGewaehlteFigur(), feld, in, spielfeld, angriffsFaehigeFiguren);
                // gewaehlteFigur sollte jetzt ein gueltiges Angriffsobjekt haben
            }
        }

        else
            System.out.println(
                    "Sie haben diese Runde keine Figuren, die angreifen können.\nIhre Angriffsphase wird beendet.");

    }

    /**
     * Gibt die Abkuerzungen der Figuren aus einer Menge an Figuren aus.
     * 
     * @param figuren Die Menge der Figuren, fuer die die Abkuerzungen der Figuren
     *                ausgegeben werden sollen
     */
    public void printAbkuerzungenFigurenMenge(Set<Figur> figuren) {

        // Gibt die Abkuerzungen der Figuren aus der Menge aus
        for (Figur figur : figuren) {
            System.out.print(figur.getName() + " ");
        }
        System.out.println();
    }

    /**
     * Fordere User auf eine Figur fuer einen Angriffs auszuwaehlen.
     * 
     * @param angriffsFaehigeFiguren Die Menge der Figuren, die angriffsfaehig sind
     * @param feld                   Das Feld, auf dem sich die Figuren befinden.
     * @param in                     Der Scanner, ueber den die Eingaben erfolgen
     */
    public void anfrageWaehleFigur(Set<Figur> angriffsFaehigeFiguren, Spielobjekt[][] feld, Scanner in) {

        String ausgabe = "Die Figuren, mit denen in dieser Angriffsphase noch angegriffen werden kann:\n";
        System.out.println(ausgabe);

        this.printAbkuerzungenFigurenMenge(angriffsFaehigeFiguren);

        boolean valideFigur = false;
        Figur ausgewaehlteFigur = null;

        while (!valideFigur) {

            System.out.println("\nBitte geben sie die Koordinaten der Figur"
                    + " ein, mit der Sie angreifen wollen.\nDabei geben Sie bitte zuerst die y-Koordinate ein und dann die x-Koordinate.");
            String eingabe = in.next();

            Koordinate koordinate = Spiel.konvertiereEingabe2(eingabe);
            if (this.existiertGewaehlteFigur(angriffsFaehigeFiguren, koordinate, feld)) {
                valideFigur = true;
                ausgewaehlteFigur = (Figur) feld[koordinate.getX()][koordinate.getY()];
                this.setGewaehlteFigur(ausgewaehlteFigur);
            }

            if (!valideFigur)
                System.out.println(
                        "Auf dieser Position ist keine Figur, die Sie kontrollieren und angreifen kann.\nBitte geben sie gültige Koordinaten ein.");
        }

    }

    /**
     * Fordert den User auf das Angriffsziel fuer die gewaehlte Figur auszuwaehlen.
     * 
     * @param gewaehlteFigur Die aktuell gewaehlte Figur
     * @param feld           Das Feld, auf dem sich die Figuren befinden
     * @param in             Der Scanner, ueber den die Eingabe erfolgt
     * @param spielfeld      Das Spielfeld mit dem der Spieler interagiert
     */
    public void waehleAngriffsZielFuerFigur(Figur gewaehlteFigur, Spielobjekt[][] feld, Scanner in, Spielfeld spielfeld,
            Set<Figur> angriffsFaehigeFiguren) {

        // ob das gewaehlte Angriffsziel gueltig ist
        boolean gueltigesAngriffsziel = false;

        while (!gueltigesAngriffsziel) {

            if (!(gewaehlteFigur instanceof Magier)) {

                System.out.println("Bitte geben Sie die Koordinaten ihres Angriffsziels für diese Figur ein.");
                String angriffsEingabe = in.next();

                Koordinate angriffsZiel = Spiel.konvertiereEingabe2(angriffsEingabe);
                if (gewaehlteFigur.bestimmePotAngriffsPos(spielfeld).contains(angriffsZiel)) {

                    gueltigesAngriffsziel = true;
                    Set<Koordinate> dieAngriffsZiele = new HashSet<>();
                    dieAngriffsZiele.add(angriffsZiel);
                    this.waehleAngriffshaltung(gewaehlteFigur, in, angriffsFaehigeFiguren, dieAngriffsZiele);
                }

            }

            // Ist die gewaehlte Figur ein Magier, waehlt der User die Spalte, in der die 3
            // Felder gleichzeitig angegriffen werden

            else if (gewaehlteFigur instanceof Magier) {

                System.out.println(
                        "Bitte geben Sie eine y Koordinate ein, also die Spalte, die zum Ziel des Angriffs des Magiers werden soll.");
                String angriffsEingabe = in.next();

                int angriffSpaltenKoordinate = Spiel.konvertiereSpaltenEingabeBeiMagier(angriffsEingabe.charAt(0) + "");

                Set<Koordinate> dieAngriffsZiele = ((Magier) gewaehlteFigur)
                        .bestimmePotAngriffsPositionenInSpalte(angriffSpaltenKoordinate, spielfeld);

                if (!dieAngriffsZiele.isEmpty()) {
                    gueltigesAngriffsziel = true;
                    this.waehleAngriffshaltung(gewaehlteFigur, in, angriffsFaehigeFiguren, dieAngriffsZiele);
                }
            }

            // War die Eingabe nicht korrekt, wird der User aufgefordert erneut ein
            // Angriffsziel einzugeben
            if (!gueltigesAngriffsziel)
                System.out.println(
                        "Das war kein gueltiges Angriffsziel für diese Figur. Bitte geben sie eine gueltige Koordinate als Angriffsziel ein.");
        }
    }

    /**
     * Fordert den User auf die Angriffshaltung fuer die gewaehlte Figur zu waehlen.
     * 
     * @param gewaehlteFigur         Die gewaehlte Figur
     * @param in                     Der Scanner, ueber den die Eingabe erfolgt.
     * @param angriffsFaehigeFiguren Die Menge der angriffsfaehigen Figuren
     * @param angriffsZiel           Das Angriffsziel der gewaehlten Figur
     */
    public void waehleAngriffshaltung(Figur gewaehlteFigur, Scanner in, Set<Figur> angriffsFaehigeFiguren,
            Set<Koordinate> angriffsZiele) {

        boolean gueltigeAngriffshaltung = false;

        while (!gueltigeAngriffshaltung) {

            System.out.println("Bitte wählen sie ihre Angriffshaltung für diese Figur aus (Schere, Stein, Papier)");
            String haltung = in.next().toLowerCase();

            if (haltung.equals("schere")) {
                gewaehlteFigur.setAngriffsart(new Angriffsobjekt(angriffsZiele, Angriffsart.SCHERE));
                gueltigeAngriffshaltung = true;
                angriffsFaehigeFiguren.remove(gewaehlteFigur);
            }

            else if (haltung.equals("stein")) {
                gewaehlteFigur.setAngriffsart(new Angriffsobjekt(angriffsZiele, Angriffsart.STEIN));
                gueltigeAngriffshaltung = true;
                angriffsFaehigeFiguren.remove(gewaehlteFigur);
            }

            else if (haltung.equals("papier")) {
                gewaehlteFigur.setAngriffsart(new Angriffsobjekt(angriffsZiele, Angriffsart.PAPIER));
                gueltigeAngriffshaltung = true;
                angriffsFaehigeFiguren.remove(gewaehlteFigur);
            }

            else {
                System.out.println(
                        "Diese Angriffshaltung existiert nicht. Bitte geben sie eine gültige Angriffshaltung ein.");
            }
        }
    }

    /**
     * Kontrolliert, ob die gewaehlte Figur tatsaechlich existiert.
     * 
     * @param angriffsFaehigeFiguren Die Menge der angriffsfaehigen Figuren
     * @param zeilenWert             Der Zeilenwert der Position, an der sich die
     *                               Figur befinden soll
     * @param spaltenWert            Der Spaltenwert der Position, an der sich die
     *                               Figur befinden soll
     * @param feld                   Das Feld, auf dem sich die Figur befinden soll
     * 
     * @return Ob die gewaehlte Figur existiert oder nicht
     */
    public boolean existiertGewaehlteFigur(Set<Figur> angriffsFaehigeFiguren, Koordinate koordinate,
            Spielobjekt[][] feld) {
        int zeilenWert = koordinate.getX();
        int spaltenWert = koordinate.getY();

        // Das ist die Koordinate die standardmaeßig zurueckgegeben wird, wenn die
        // Eingabe des Users nicht dem
        // Erwartetem entspricht (siehe konvertiereEingabe2 Methode in Spiel Klasse)
        if ((zeilenWert == -1) && (spaltenWert == -1))
            return false;

        if ((feld[zeilenWert][spaltenWert] instanceof Figur)
                && angriffsFaehigeFiguren.contains(feld[zeilenWert][spaltenWert]))
            return true;
        return false;
    }

}
