package model;

import java.util.ArrayList;

public class Calculator {
    public Polynomial addPolynomials(Polynomial pol1, Polynomial pol2){
        pol1 = solve(pol1);
        pol2 = solve(pol2);

        pol1.sortByPower();
        pol2.sortByPower();

        Polynomial res = new Polynomial();
        int i = 0,j = 0;
        while(i < pol1.getLen() && j < pol2.getLen()){
            Monomial mon1 = pol1.get(i);
            Monomial mon2 = pol2.get(j);

            if(mon1.getN() > mon2.getN()){
                res.addMonomial(mon1.getC(),mon1.getN());
                i++;
            }else if(mon1.getN() == mon2.getN()){
                res.addMonomial(mon1.getC() + mon2.getC(),mon1.getN());
                i++;
                j++;
            }
            else{
                res.addMonomial(mon2.getC(), mon2.getN());
                j++;
            }
        }
        while(i<pol1.getLen()){
            Monomial mon1 = pol1.get(i);
            res.addMonomial(mon1.getC(),mon1.getN());
            i++;
        }
        while(j<pol2.getLen()){
            Monomial mon2 = pol2.get(j);
            res.addMonomial(mon2.getC(), mon2.getN());
            j++;
        }

        res.sortByPower();
        return res;
    }

    public Polynomial subtractPolynomials(Polynomial pol1, Polynomial pol2){
        pol1 = solve(pol1);
        pol2 = solve(pol2);

        pol1.sortByPower();
        pol2.sortByPower();

        Polynomial res = new Polynomial();
        int i = 0,j = 0;
        while(i < pol1.getLen() && j < pol2.getLen()){
            Monomial mon1 = pol1.get(i);
            Monomial mon2 = pol2.get(j);

            if(mon1.getN() > mon2.getN()){
                res.addMonomial(mon1.getC(),mon1.getN());
                i++;
            }else if(mon1.getN() == mon2.getN()){
                res.addMonomial(mon1.getC() - mon2.getC(),mon1.getN());
                i++;
                j++;
            }
            else{
                res.addMonomial(-mon2.getC(), mon2.getN());
                j++;
            }
        }
        while(i<pol1.getLen()){
            Monomial mon1 = pol1.get(i);
            res.addMonomial(mon1.getC(),mon1.getN());
            i++;
        }
        while(j<pol2.getLen()){
            Monomial mon2 = pol2.get(j);
            res.addMonomial(-mon2.getC(), mon2.getN());
            j++;
        }

        res.sortByPower();
        return res;
    }

    public Polynomial derivative(Polynomial pol){

        pol = solve(pol);

        ArrayList<Monomial> aux = pol.getMonomials();

        Polynomial res = new Polynomial();
        for (Monomial mon:
             aux) {
            float c = mon.getC();
            int n = mon.getN();
            if(n == 0) {
                res.addMonomial(0, 0);
            }else {
                res.addMonomial(c*n,n-1);
            }
        }

        return res;
    }

    public Polynomial integrate(Polynomial pol){

        pol = solve(pol);

        ArrayList<Monomial> aux = pol.getMonomials();

        Polynomial res = new Polynomial();
        for (Monomial mon:
                aux) {
            float c = mon.getC();
            int n = mon.getN();
            if(n == 0) {
                res.addMonomial(0, 0);
            }else {
                res.addMonomial(c/(n+1),n+1);
            }
        }

        return res;
    }

    public Polynomial multiply(Polynomial pol1, Polynomial pol2){
        Polynomial res = new Polynomial();
        ArrayList<Monomial> monomials1 = pol1.getMonomials();
        ArrayList<Monomial> monomials2 = pol2.getMonomials();
        for (Monomial mon1:
             monomials1) {
            for (Monomial mon2:
                 monomials2) {
                float coeff = mon1.getC() * mon2.getC();
                int power = mon1.getN() + mon2.getN();
                res.addMonomial(coeff,power);
            }
        }
        res.sortByPower();
        res = solve(res);
        return res;
    }

    public ArrayList<Polynomial> divide(Polynomial pol1,Polynomial pol2){

        ArrayList<Polynomial> res = new ArrayList<>();

        if(pol1.degree() < pol2.degree()){
            return null;
        }

        pol1.sortByPower();
        pol2.sortByPower();
        ArrayList<Monomial> poly2 = pol2.getMonomials();

        Polynomial q = new Polynomial();
        Polynomial r = pol1;

        if(poly2.size() == 0){
            System.err.println("Division by 0");
            return res;
        }

        r.deleteRedundantTerms();
        pol2.deleteRedundantTerms();
        
        while(!r.isZero() && r.degree() >= pol2.degree()){
            pol2.deleteRedundantTerms();
            Monomial rLTerm = r.getLeadingTerm();
            Monomial pol2LTerm = pol2.getLeadingTerm();
            Monomial t = new Monomial(rLTerm.getC()/pol2LTerm.getC(),rLTerm.getN()-pol2LTerm.getN());
            q.addMonomial(t);

            Polynomial aux = multiply(new Polynomial(t),pol2);
            r = subtractPolynomials(r,aux);
            r.deleteRedundantTerms();
        }
        res.add(solve(q));
        res.add(solve(r));

        return res;
    }

    public Polynomial solve(Polynomial pol){    //adds coefficients of same x^n
        pol.sortByPower();
        ArrayList<Monomial> monomialInts = pol.getMonomials();
        Polynomial res = new Polynomial();

        Monomial prev = monomialInts.get(0);
        float sumOfCoeff = -prev.getC();  //first element added twice
        for (Monomial mon:
                monomialInts) {
            if(prev.getN() == mon.getN()){
                sumOfCoeff += prev.getC();
            } else {
                sumOfCoeff += prev.getC();
                res.addMonomial(sumOfCoeff,prev.getN());
                sumOfCoeff=0;
            }
            prev = mon;
        }
        sumOfCoeff += prev.getC();
        res.addMonomial(sumOfCoeff,prev.getN());
        return res;
    }
}
