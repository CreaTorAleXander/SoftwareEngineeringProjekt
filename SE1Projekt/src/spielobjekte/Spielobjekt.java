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
		return this.k1;
	}

	public void setK1(Koordinate k1) {
		this.k1 = k1;
	}
	
	
	/*
	 * public abstract class Spielobjekt { 
	 * 
	 * private Koordinate koordinate;
	 * 
	 * public Spielobjekt(Koordinate koordinate) {
	 * 
	 * this.koordinate = koordinate; 
	 * }
	 * 
	 * public Koordinate getKoordinate() { 
	 * 	return koordinate; 
	 * }
	 * 
	 * public void setKoordinate(Koordinate koordinate) { this.koordinate =
	 * koordinate; }
	 * 
	 * public String toString() {
	 * 
	 * return null; } }
	 */
	
	
	
}
