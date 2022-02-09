package ca.uqam.tp3_mgl869c.polynomial;

import ca.uqam.tp3_mgl869c.polynomial.term.Term;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LLPolynomial implements Polynomial {
    private final List<Term> terms = new ArrayList<>();
    
    @Override
    public boolean addTerm(Term t) {
        if (t == null)
            return false;
        return terms.add(t);
    }
    
    @Override
    public int getNumberTerms() {
        return terms.size();
    }
    
    @Override
    public boolean removeTerm(Term t) {
        if (t == null)
            return false;
        return terms.remove(t);
    }
    
    @Override
    public List<Integer> getExponents() {
        List<Integer> listOfExponent = new LinkedList<>();
        for (Term term : terms) {
            if (term != null) {
                int exponent = term.exponent;
                if (!listOfExponent.contains(exponent)) {
                    listOfExponent.add(exponent);
                }
            }
        }
        //return listOfExponent.stream().mapToInt(i -> i).toArray();
        return listOfExponent;
    }
    
    @Override
    public List<Character> getVariables() {
        List<Character> listOfVariable = new LinkedList<>();
        for (Term term : terms) {
            if (term != null) {
                char variable = term.variable;
                if (!listOfVariable.contains(variable)) {
                    listOfVariable.add(variable);
                }
            }
        }
        return listOfVariable;
    }
    
    @Override
    public List<Term> getTerms(char variable, int exponent) {
        List<Term> listOfTerm = new LinkedList<>();
        for (Term term : terms) {
            if (term != null) {
                if (term.exponent == exponent && term.variable == variable) {
                    listOfTerm.add(term);
                }
            }
        }
        return listOfTerm;
    }
    
    @Override
    public List<Term> getAllTerms() {
        List<Term> listOfTerm = new LinkedList<>();
        for (Term term : terms) {
            if (term != null) {
                listOfTerm.add(term);
            }
        }
        return listOfTerm;
    }
    
    @Override
    public String toString() {
        StringBuilder returnValueBuilder = new StringBuilder();
        for (Term term : terms) {
            if (term != null) {
                returnValueBuilder.append(String.format("%s+", term));
            }
        }
        String returnValue = returnValueBuilder.toString();
        returnValue = returnValue.substring(0, returnValue.length() - 1);
        return returnValue;
    }
}
