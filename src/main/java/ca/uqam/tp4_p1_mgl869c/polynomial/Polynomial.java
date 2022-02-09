package ca.uqam.tp4_p1_mgl869c.polynomial;

import ca.uqam.tp4_p1_mgl869c.polynomial.term.Term;

import java.util.List;

public interface Polynomial {
    boolean addTerm(Term t);
    int getNumberTerms();
    boolean removeTerm(Term t);
    List<Integer> getExponents();
    List<Character> getVariables();
    List<Term> getTerms(char variable, int exponent);
    List<Term> getAllTerms();
}