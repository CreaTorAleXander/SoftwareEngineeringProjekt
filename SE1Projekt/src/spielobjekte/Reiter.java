package spielobjekte;

import java.util.HashSet;
import java.util.Set;

import spiellogik.Spieler;
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
    public Reiter() {
        super(2, 3, Spieler.anzahlSpieler);
        this.setName(Abkuerzung.REI);
        
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
    
    public Set<Koordinate> bestimmePotZuege(Spielfeld spielfeld) {
    	Set<Koordinate> positionen = new HashSet<>();
        int xFigur = this.getK1().getX();
        int yFigur = this.getK1().getY();
        Spielobjekt[][] feld = spielfeld.getSpielfeld();
        
        //Ausgehend von der Position des Reiters, muss in alle 4 Himmelsrichtungen gelaufen werden.
        //Jede for-Schleife hat zwei Abbruchbedingungen:
        //1.Abbruchbedingung: maximale Zugweite des Reiters
        //2. Abbruchbedingung: Rand des Spielfeldes
        //Desweiteren kann der Reiter Hindernisse/andere Figuren nicht umgehen. Wird sein
        //Weg also versperrt, muss die Schleife verlassen werden.
        
        //Norden
        for(int i = xFigur; i >= xFigur-this.getZugweite() && i >= 0; i--) {
        	if (feld[i][yFigur] != null)
        		break;
        	else
        		positionen.add(new Koordinate(i, yFigur));
        }
        
        //Süden
        for(int i = xFigur; i <= xFigur+this.getZugweite() && i < 10; i++) {
        	if(feld[i][yFigur] != null)
        		break;
        	else
        		positionen.add(new Koordinate(i, yFigur));
        }
    	
        //Westen
        for(int i = yFigur; i >= yFigur-this.getZugweite() && i >= 0; i--) {
        	if(feld[xFigur][i] != null)
        		break;
        	else
        		positionen.add(new Koordinate(xFigur, i));
        }
        
        //Osten
        for(int i = yFigur; i <= yFigur+this.getZugweite() && i < 10; i++) {
        	if(feld[xFigur][i] != null)
        		break;
        	else
        		positionen.add(new Koordinate(xFigur, i));
        }
        
        
    	return positionen;
    }
}
