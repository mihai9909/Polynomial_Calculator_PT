package model;

public class Monomial implements Comparable<Monomial>{

    public int getN() {
        return n;
    }

    private final int n;

    @Override
    public int compareTo(Monomial o) {
        return o.n - this.n;
    }

    public float getC() {
        return c;
    }

    private final float c;

    public Monomial(float c, int n){
        this.c = c;
        this.n = n;
    }

    public Monomial(){
        this.c = 0;
        this.n = 0;
    }

    @Override
    public String toString() {
        return c + "*x^" + n;
    }
}
