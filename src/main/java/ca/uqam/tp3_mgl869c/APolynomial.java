package ca.uqam.tp3_mgl869c;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class APolynomial implements Polynomial {
    private final int    size  = 100;
    private final Term[] terms = new Term[size];
    
    @Override
    public boolean addTerm(Term t) {
        for (int i = 0; i < size; i++) {
            if (terms[i] == null) {
                terms[i] = t;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int getNumberTerms() {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (terms[i] != null)
                c++;
        }
        return c;
    }
    
    @Override
    public boolean removeTerm(Term t) {
        for (int i = 0; i < size; i++) {
            if (terms[i] == t) {
                terms[i] = null;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int[] getExponents() {
        ArrayList<Integer> listOfExponent = new ArrayList<Integer>() {};
        for (int i = 0; i < size; i++) {
            if (terms[i] != null) {
                int exponent = terms[i].exponent;
                if (!listOfExponent.contains(exponent)) {
                    listOfExponent.add(exponent);
                }
            }
        }
        return listOfExponent.stream()
                             .mapToInt(i -> i)
                             .toArray();
    }
    
    @Override
    public char[] getVariables() {
        ArrayList<Character> listOfVariable = new ArrayList<>() {};
        for (int i = 0; i < size; i++) {
            if (terms[i] != null) {
                char variable = terms[i].variable;
                if (!listOfVariable.contains(variable)) {
                    listOfVariable.add(variable);
                }
            }
        }
        char[] returnValue = new char[listOfVariable.size()];
        for (int i = 0; i < listOfVariable.size(); i++) {
            returnValue[i] = listOfVariable.get(i);
        }
        return returnValue;
    }
    
    @Override
    public Term[] getTerms(char variable, int exponent) {
        ArrayList<Term> listOfTerm = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (terms[i] != null) {
                if (terms[i].exponent == exponent && terms[i].variable == variable) {
                    listOfTerm.add(terms[i]);
                }
            }
        }
        return listOfTerm.toArray(new Term[0]);
    }
    
    @Override
    public Term[] getAllTerms() {
        ArrayList<Term> listOfTerm = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (terms[i] != null) {
                listOfTerm.add(terms[i]);
            }
        }
        return listOfTerm.toArray(new Term[0]);
    }
    
    @Override
    public String toString() {
        StringBuilder returnValueBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (terms[i] != null) {
                returnValueBuilder.append(String.format("%s+", terms[i].toString()));
            }
        }
        String returnValue = returnValueBuilder.toString();
        returnValue = returnValue.substring(0, returnValue.length() - 1);
        return returnValue;
    }
}
