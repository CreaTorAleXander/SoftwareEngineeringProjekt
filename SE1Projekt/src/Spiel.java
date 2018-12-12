import java.util.*;

public class Spiel {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Spieler firstPlayer = new Spieler();
		Spieler secondPlayer = new Spieler();
		Spielfeld spielbrett = new Spielfeld();
		spielbrett.platziereObjekte(firstPlayer.getFiguren(), secondPlayer.getFiguren());
	
		
		while(true) {
		spielbrett.printSpielfeld();
		System.out.println("Spieler 1 ist an der Reihe.\n");
		
	
		
		System.out.println("Waehlen sie eine Figur per Koordinate.\n");
		int k1 = sc.nextInt();
		int k2 = sc.nextInt();
		spielbrett.waehleFigur(new Koordinate(k1, k2), firstPlayer);
		System.out.println(spielbrett.getGewaehlteFigur().toString());
		
		
		
		System.out.println("Wohin wollen Sie ziehen?\n");
		k1 = sc.nextInt();
		k2 = sc.nextInt();
		spielbrett.bewegeFigur(new Koordinate(k1, k2));
		
		if(firstPlayer.getFiguren().get(1).isWurdeBewegt())
			System.out.println("Wurde gewaehlt");
		
		System.out.println("Spieler 2 ist an der Reihe.\n");
		
		System.out.println("Waehlen sie eine Figur per Koordinate.\n");
		k1 = sc.nextInt();
		k2 = sc.nextInt();
		spielbrett.waehleFigur(new Koordinate(k1, k2), secondPlayer);
		
		System.out.println("Wohin wollen Sie ziehen?\n");
		k1 = sc.nextInt();
		k2 = sc.nextInt();
		spielbrett.bewegeFigur(new Koordinate(k1, k2));
		
		}
	}
}
