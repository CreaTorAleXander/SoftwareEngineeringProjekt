package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spiellogik.Spieler;
import spiellogik.Spielfeld;
import spielobjekte.Figur;
import spielobjekte.Koordinate;
import spielobjekte.Magier;
import spielobjekte.Spielobjekt;

/**
 * Klasse zum Testen der Angriffsphase
 * 
 * @author Julian
 *
 */
public class TestAngriffsphase {

    Spieler spielerEins;
    Spieler spielerZwei;
    Spielfeld feld;
    Scanner in;
    @BeforeEach
    public void initialisieren() {
        spielerEins = new Spieler();
        spielerZwei = new Spieler();
        feld = new Spielfeld();
        in = new Scanner(System.in);
        //feld.platziereObjekte(spielerEins.getFiguren(), spielerZwei.getFiguren());
        
        // Beispielhafte Figuren von SpielerEins
        
        // Schwertkaempfer
        feld.getSpielfeld()[5][4] = spielerEins.getFiguren().get(1);
        spielerEins.getFiguren().get(1).setK1(new Koordinate(5, 4));
        
        // Lanzentraeger
        feld.getSpielfeld()[7][4] = spielerEins.getFiguren().get(4);
        spielerEins.getFiguren().get(4).setK1(new Koordinate(7, 4));
        
        // Magier
        feld.getSpielfeld()[2][4] = spielerEins.getFiguren().get(2);
        spielerEins.getFiguren().get(2).setK1(new Koordinate(2, 4));
        
        // Bogenschuetze
        feld.getSpielfeld()[1][4] = spielerEins.getFiguren().get(3);
        spielerEins.getFiguren().get(3).setK1(new Koordinate(1, 4));
        
        // Reiter
        feld.getSpielfeld()[4][4] = spielerEins.getFiguren().get(0);
        spielerEins.getFiguren().get(0).setK1(new Koordinate(4, 4));
        
        // Beispielhafte Figuren von SpielerZwei
        feld.getSpielfeld()[5][5] = spielerZwei.getFiguren().get(1);
        spielerZwei.getFiguren().get(1).setK1(new Koordinate(5, 5));
        
        feld.getSpielfeld()[7][6] = spielerZwei.getFiguren().get(3);
        spielerZwei.getFiguren().get(3).setK1(new Koordinate(7, 6));
        
        feld.getSpielfeld()[2][6] = spielerZwei.getFiguren().get(4);
        spielerZwei.getFiguren().get(4).setK1(new Koordinate(2, 6));
        
        feld.getSpielfeld()[1][5] = spielerZwei.getFiguren().get(2);
        spielerZwei.getFiguren().get(2).setK1(new Koordinate(1, 5));
        
        feld.getSpielfeld()[3][5] = spielerZwei.getFiguren().get(0);
        spielerZwei.getFiguren().get(0).setK1(new Koordinate(3, 5));
        
        feld.printSpielfeld();
    }
    
    /*
    @Test
    public void test1() {
        //feld.waehleFigur(new Koordinate(2, 0), spielerEins);
        //feld.bewegeFigur(new Koordinate(2, 1));
        //feld.printSpielfeld();
        
        for(Figur figur: spielerEins.getFiguren()) {
            Set<Koordinate> pos = figur.bestimmePotAngriffsPos(feld);
            
            System.out.print(figur.toString());
            for(Koordinate koordinate: pos) {
                System.out.print(koordinate.getX() + "" + koordinate.getY() + "; ");
            }
            if(figur instanceof Magier) {
                Set<Koordinate> spaltenZiele = ((Magier) figur).bestimmePotAngriffsPositionenInSpalte(5, feld);
                System.out.println();
                System.out.print(figur.toString() + "Spaltenziele in Spalte 6: ");
                
                for(Koordinate koordinate: spaltenZiele) {
                    System.out.print(koordinate.getX() + "" + koordinate.getY() + "; ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        assertTrue(spielerEins.pruefeObAngriffMoeglich(feld));
    }
    */
    /*
    @Test
    public void ausprobierenMethodeanfrageWaehleFigur() {
        spielerEins.anfrageWaehleFigur(spielerEins.filtereAngriffsFaehigeFiguren(spielerEins.getFiguren(), feld), feld.getSpielfeld(), in);
        System.out.println(spielerEins.getGewaehlteFigur().getName());
        
        assertTrue(true);
    }
    */
    
    /*
    @Test
    public void ausprobierenMethodewaehleAngriffshaltung() {
        spielerEins.anfrageWaehleFigur(spielerEins.filtereAngriffsFaehigeFiguren(spielerEins.getFiguren(), feld), feld.getSpielfeld(), in);
        // waehleAngriffshaltung(Figur gewaehlteFigur, Scanner in, Set<Figur> angriffsFaehigeFiguren,
        //Set<Koordinate> angriffsZiele)
        Set<Koordinate> dieZiele = new HashSet<>();
        dieZiele.add(new Koordinate(7, 6));
        spielerEins.waehleAngriffshaltung(spielerEins.getGewaehlteFigur(), in, spielerEins.filtereAngriffsFaehigeFiguren(spielerEins.getFiguren(), feld), dieZiele);
        System.out.println(spielerEins.getFiguren().get(4).getAngriffsart());
    }
    */
    /*
    @Test
    public void ausprobierenMethodewaehleAngriffsZielFuerFigur() {
        //waehleAngriffsZielFuerFigur(Figur gewaehlteFigur, Spielobjekt[][] feld, Scanner in, Spielfeld spielfeld,
        //Set<Figur> angriffsFaehigeFiguren)
        spielerEins.anfrageWaehleFigur(spielerEins.filtereAngriffsFaehigeFiguren(spielerEins.getFiguren(), feld), feld.getSpielfeld(), in);
        spielerEins.waehleAngriffsZielFuerFigur(spielerEins.getGewaehlteFigur(), feld.getSpielfeld(), in, feld, spielerEins.filtereAngriffsFaehigeFiguren(spielerEins.getFiguren(), feld));
        System.out.println(spielerEins.getFiguren().get(4).getAngriffsart());
    }
    */
    /*
    @Test
    public void ausprobierenMethodenehmeAngriffsInfoAuf() {
        spielerEins.nehmeAngriffsInfoAuf(in, feld);
    }
    */
}
