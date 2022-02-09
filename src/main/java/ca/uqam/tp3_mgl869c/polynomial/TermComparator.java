package ca.uqam.tp3_mgl869c.polynomial;

import ca.uqam.tp3_mgl869c.polynomial.term.Term;

import java.util.Comparator;

public class TermComparator implements Comparator<Term> {
    
    @Override
    public int compare(Term o1, Term o2) {
        int variableComparison = o1.variable - o2.variable;
        if ((o1.variable == ' ' || o2.variable == ' '))
            variableComparison *= -1;
        int exponentComparison = o2.exponent - o1.exponent;
        if (variableComparison == 0) {
            if (exponentComparison == 0)
                return 0;
            return (int) Math.signum(exponentComparison);
        }
        else
            return (int) Math.signum(variableComparison);
    }
}
