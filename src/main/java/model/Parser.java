package model;

import java.util.regex.*;

public class Parser {

    public Polynomial parsePolynomial(String polynomialString){

        Polynomial pol = new Polynomial();
        polynomialString = polynomialString.replaceAll("\\s","");

        Pattern pattern = Pattern.compile("[-|+]?\\d+\\*?x\\^\\d+([-|+]\\d+\\*?x\\^\\d+)*");
        Matcher matcher = pattern.matcher(polynomialString);
        matcher.find();
        if(!matcher.matches()) {
            System.out.println("Pattern doesn't match");
            System.out.println("USAGE: c1*x^n1+c2*x^n2+... (* is optional)");
            return  null;
        }

        pattern = Pattern.compile("[-|+]?\\d+\\*?x\\^\\d+");
        matcher = pattern.matcher(polynomialString);

        String res = "";
        while(matcher.find()) {
            res = matcher.group();
            Pattern subPattern = Pattern.compile("[-|+]?\\d+");
            Matcher subMatcher = subPattern.matcher(res);
            subMatcher.find();
            int coeff = Integer.parseInt(subMatcher.group());
            subMatcher.find();
            int power = Integer.parseInt(subMatcher.group());
            pol.addMonomial(coeff,power);
        }
        return pol;
    }
}
