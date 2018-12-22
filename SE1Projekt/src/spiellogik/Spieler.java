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
     * Prueft ob der Spieler in dieser Runde Figuren kontrolliert, mit denen er angreifen kann.
     * 
     * @return Ob der Spieler in dieser Runde angreifen kann
     */
    public boolean pruefeObAngriffMoeglich(Spielfeld spielfeld) {
        Set<Figur> angriffsFaehig = this.filtereAngriffsFaehigeFiguren(this.getFiguren(), spielfeld);
        
        if(angriffsFaehig.isEmpty())
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
        
        // Fuegt alle Figuren des Spielers, derene Menge an Angriffspositionen nicht leer ist
        // zu der Menge der angriffsfaehigen Figuren hinzu.
        for(Figur figur: this.getFiguren()) {
            if(!figur.bestimmePotAngriffsPos(spielfeld).isEmpty())
                gefilterteFiguren.add(figur);
        }
        
        return gefilterteFiguren;
    }
    
    /**
     * Nimmt die Angriffszuege auf, die der Spieler in dieser Angriffsphase durchfuehren moechte.
     * 
     * @param spielfeld Das zu betrachtende Spielfeld
     */
    
    public void nehmeAngriffsInfoAuf(Scanner in, Spielfeld spielfeld) {
        Set<Figur> angriffsFaehigeFiguren;
        angriffsFaehigeFiguren = this.filtereAngriffsFaehigeFiguren(this.getFiguren(), spielfeld);
        Spielobjekt[][] feld = spielfeld.getSpielfeld();
        Figur gewaehlteFigur = null;
        String ausgabe = "Die Figuren, mit denen in dieser Phase angegriffen werden kann:\n";
        System.out.println(ausgabe);
        
       
        
        // Der User wird solange aufgefordert Eingaben zu machen, bis Angriffskoordinaten für alle angriffsfaehigen Figuren gesammelt wurden
        // oder der User die Eingabe der Angriffskoordinaten abbricht
        while(!angriffsFaehigeFiguren.isEmpty()) {
           
            this.printAbkuerzungenFigurenMenge(angriffsFaehigeFiguren);
            System.out.println("\nBitte geben sie die Koordinaten der Figur"
                    + "ein, mit der Sie angreifen wollen.\nDabei geben Sie bitte zuerst die y-Koordinate ein und dann die x-Koordinate");
            String eingabe = in.next();
          
            // Erster Wert ist die Zeilenangabe, zweiter Wert des String ist die Spaltenangabe
            String zeilenWert = eingabe.charAt(0) + "";
            String spaltenWert = eingabe.charAt(1) + "";
            
           int zeilenKoordinate = Spiel.konvertiereEingabe(zeilenWert);
           int spaltenKoordinate = Spiel.konvertiereEingabe(spaltenWert);   
           
           // ob die Figur, die der User auswaehlt existiert und angreifen kann
           boolean existiertGewaehlteFigur = false;
           
           while(!existiertGewaehlteFigur) {
               
               if((feld[zeilenKoordinate][spaltenKoordinate] instanceof Figur) && angriffsFaehigeFiguren.contains(feld[zeilenKoordinate][spaltenKoordinate])) {
                   
                   existiertGewaehlteFigur = true;
                   gewaehlteFigur = (Figur) feld[zeilenKoordinate][spaltenKoordinate];
                   
                   System.out.println("Bitte geben Sie die Koordinaten ihres Angriffsziels für diese Figur ein.");
                   String angriffsEingabe = in.next();
                   
                   int angriffZeilenKoordinate = Spiel.konvertiereEingabe(angriffsEingabe.charAt(0) + "");
                   int angriffSpaltenKoordinate = Spiel.konvertiereEingabe(angriffsEingabe.charAt(1) + "");
                   
                   Koordinate angriffsZiel = new Koordinate(angriffZeilenKoordinate, angriffSpaltenKoordinate);
                   
                   boolean gueltigeAngriffshaltung = false;
                   
                   while(!gueltigeAngriffshaltung) {
                       
                       System.out.println("Bitte wählen sie ihre Angriffshaltung für diese Figur aus (Schere, Stein, Papier)");
                       String haltung = in.next().toLowerCase();
                       
                       if(haltung.equals("schere")) {
                           gewaehlteFigur.setAngriffsart(new Angriffsobjekt(angriffsZiel, Angriffsart.SCHERE));
                           gueltigeAngriffshaltung = true;
                           angriffsFaehigeFiguren.remove(gewaehlteFigur);
                       }
                       
                       else if(haltung.equals("stein")) {
                           gewaehlteFigur.setAngriffsart(new Angriffsobjekt(angriffsZiel, Angriffsart.STEIN));
                           gueltigeAngriffshaltung = true;
                           angriffsFaehigeFiguren.remove(gewaehlteFigur);
                       }
                       
                       else if(haltung.equals("papier")) {
                           gewaehlteFigur.setAngriffsart(new Angriffsobjekt(angriffsZiel, Angriffsart.PAPIER));
                           gueltigeAngriffshaltung = true;
                           angriffsFaehigeFiguren.remove(gewaehlteFigur);
                       }
                       
                       else {
                           System.out.println("Diese Angriffshaltung existiert nicht. Bitte geben sie eine gültige Angriffshaltung ein.");
                       }
                   }
               }
               
               System.out.println("Auf dieser Position ist keine Figur, die Sie kontrollieren.\n Bitte geben sie gültige Koordinaten ein.");
           }
        }
    }
    
    /**
     * Gibt die Abkuerzungen der Figuren aus einer Menge an Figuren aus.
     * 
     * @param figuren Die Menge der Figuren, fuer die die Abkuerzungen der Figuren ausgegeben werden sollen
     */
    public void printAbkuerzungenFigurenMenge(Set<Figur> figuren) {
        
        // Gibt die Abkuerzungen der Figuren aus der Menge aus
        for(Figur figur: figuren) {
            System.out.print(figur.getName() + " ");
        }
        System.out.println();
    }
    
}
