
public class Spiel {
	
	public static void main(String[] args) {
		
		Spieler firstPlayer = new Spieler();
		Spieler secondPlayer = new Spieler();
		Spielfeld spielbrett = new Spielfeld();
		spielbrett.platziereObjekte(firstPlayer.getFiguren(), secondPlayer.getFiguren());
		System.out.println(spielbrett.spielfeld[0][0].toString());
		System.out.println(spielbrett.spielfeld[2][0].toString());
		System.out.println(spielbrett.spielfeld[4][0].toString());
		System.out.println(spielbrett.spielfeld[6][0].toString());
		System.out.println(spielbrett.spielfeld[8][0].toString());
		
		spielbrett.printSpielfeld();
	}
}
