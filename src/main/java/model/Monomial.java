package model;

public class Monomial implements Comparable<Monomial>{

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private int n;

    @Override
    public int compareTo(Monomial o) {
        return o.n - this.n;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }
    private float c;

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
