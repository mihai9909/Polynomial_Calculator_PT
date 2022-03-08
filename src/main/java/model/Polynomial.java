package model;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {

    ArrayList<Monomial> polynomial = new ArrayList<>();

    public Polynomial(Monomial mon){
        polynomial.add(mon);
    }
    public Polynomial(){ }

    public void addMonomial(int coefficient,int power){
        polynomial.add(new Monomial((float)coefficient,power));
    }

    public void addMonomial(float coefficient,int power){
        polynomial.add(new Monomial(coefficient,power));
    }

    public void addMonomial(Monomial monomial){
        polynomial.add(monomial);
    }

    public void sortByPower(){
        Collections.sort(polynomial);
    }

    public int getLen(){
        return polynomial.size();
    }

    public Monomial get(int i){
        return polynomial.get(i);
    }

    public ArrayList<Monomial> getMonomials(){
        return polynomial;
    }

    public Monomial getLeadingTerm() {
        int min = -1;
        Monomial res = new Monomial();
        for (Monomial mon :
                polynomial) {
            if (mon.getN() > min) {
                min = mon.getN();
                res = mon;
            }
        }
        return res;
    }

    public boolean isZero(){
        for (Monomial mon:
             polynomial) {
            if(mon.getC() != 0)
                return false;
        }
        return true;
    }

    public int degree(){
        int degr = 0;
        for (Monomial m:
             polynomial) {
            if(m.getN() > degr){
                degr = m.getN();
            }
        }
        return degr;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Monomial m:
             polynomial) {
            if(!m.toString().startsWith("-"))
                res.append("+").append(m.toString());
            else res.append(m.toString());
        }
        return res.toString();
    }

    public void deleteRedundantTerms(){
        polynomial.removeIf(m -> m.getC() == 0);
    }
}
