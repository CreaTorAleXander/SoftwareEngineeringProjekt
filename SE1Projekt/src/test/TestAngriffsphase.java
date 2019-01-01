package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import spiellogik.Spieler;
import spiellogik.Spielfeld;
import spielobjekte.Figur;
import spielobjekte.Koordinate;
import spielobjekte.Magier;

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

    @BeforeEach
    public void initialisieren() {
        spielerEins = new Spieler();
        spielerZwei = new Spieler();
        feld = new Spielfeld();
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
        
        assertTrue(spielerEins.pruefeObAngriffMoeglich(feld));
    }

}
