package controller;

import model.Calculator;
import model.Parser;
import model.Polynomial;

import java.util.ArrayList;

public class Controller {

    Parser p;
    Calculator c;

    public Controller(){
        p = new Parser();
        c = new Calculator();
    }

    public String getMultiplication(String poly1,String poly2){
        Polynomial pol1 = p.parsePolynomial(poly1);
        Polynomial pol2 = p.parsePolynomial(poly2);

        if(pol1 == null || pol2 == null)
            return "USAGE: c1*x^n1+c2*x^n2+... (* is optional)";

        Polynomial res = c.multiply(pol1,pol2);
        return res.toString();
    }

    public String getDivision(String poly1,String poly2){
        Polynomial pol1 = p.parsePolynomial(poly1);
        Polynomial pol2 = p.parsePolynomial(poly2);

        if(pol1 == null || pol2 == null)
            return "USAGE: c1*x^n1+c2*x^n2+... (* is optional)";

        ArrayList<Polynomial> res = c.divide(pol1,pol2);

        if(res == null){
            return "Degree P1 < Degree P2";
        }

        return res.get(0).toString() + "\n" + res.get(1).toString();
    }

    public String getAddition(String poly1,String poly2){
        Polynomial pol1 = p.parsePolynomial(poly1);
        Polynomial pol2 = p.parsePolynomial(poly2);

        if(pol1 == null || pol2 == null)
            return "USAGE: c1*x^n1+c2*x^n2+... (* is optional)";

        Polynomial res = c.addPolynomials(pol1,pol2);
        return res.toString();
    }

    public String getSubtraction(String poly1,String poly2){
        Polynomial pol1 = p.parsePolynomial(poly1);
        Polynomial pol2 = p.parsePolynomial(poly2);

        if(pol1 == null || pol2 == null)
            return "USAGE: c1*x^n1+c2*x^n2+... (* is optional)";

        Polynomial res = c.subtractPolynomials(pol1,pol2);
        return res.toString();
    }

    public String getDerivative(String poly1){
        Polynomial pol1 = p.parsePolynomial(poly1);

        if(pol1 == null)
            return "USAGE: c1*x^n1+c2*x^n2+... (* is optional)";

        Polynomial res = c.derivative(pol1);
        return res.toString();
    }

    public String getIntegral(String poly1){
        Polynomial pol1 = p.parsePolynomial(poly1);

        if(pol1 == null)
            return "USAGE: c1*x^n1+c2*x^n2+... (* is optional)";

        Polynomial res = c.integrate(pol1);
        return res.toString();
    }
}
