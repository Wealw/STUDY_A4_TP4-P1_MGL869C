package ca.uqam.tp3_mgl869c.polynomial;

import ca.uqam.tp3_mgl869c.polynomial.term.Term;

public interface Polynomial {
    boolean addTerm(Term t);
    int getNumberTerms();
    boolean removeTerm(Term t);
    int[] getExponents();
    char[] getVariables();
    Term[] getTerms(char variable, int exponent);
    Term[] getAllTerms();
}