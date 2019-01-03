package spielobjekte;

/**
 * Eine Klasse die Koordinaten auf dem Spielfeld simulieren soll
 * 
 * @author merta
 *
 */
public class Koordinate {
    private int x;
    private int y;

    // Hier entspricht aber die Instanzvariable x dem eigentlichen y Wert(den
    // Buchstaben auf dem Spielfeld, also den Zeilen),
    // die Instanzvariable y dem eigentlichen x Wert (den Zahlen, also den Spalten
    // auf dem Spielfeld)
    /**
     * Der Konstruktor
     * 
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    public Koordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter der x-Koordiante
     * 
     * @return x Koordinate
     */
    public int getX() {
        return x;
    }

    /**
     * �berschreibt die x-Koordinate
     * 
     * @param y
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter der y-Koordiante
     * 
     * @return y Koordinate
     */
    public int getY() {
        return y;
    }

    /**
     * �berschreibt die y-Koordinate
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Koordinate other = (Koordinate) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Koordinate [x=" + x + ", y=" + y + "]";
    }

}
