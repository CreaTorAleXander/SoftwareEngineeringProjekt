package spielobjekte;

/**
 * Abstrakte Klasse, die ein Spielobjekt repr�sentiert
 * 
 * 
 * */
public abstract class Spielobjekt {
	//Koordinate als Klassenvariable
	public Koordinate k1 = null;
	
	Spielobjekt() {
	}

	public Koordinate getK1() {
		return k1;
	}

	public void setK1(Koordinate k1) {
		this.k1 = k1;
	}
}
