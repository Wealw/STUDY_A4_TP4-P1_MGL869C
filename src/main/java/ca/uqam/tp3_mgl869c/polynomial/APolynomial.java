package ca.uqam.tp3_mgl869c.polynomial;

import ca.uqam.tp3_mgl869c.polynomial.term.Term;

import java.util.ArrayList;
import java.util.stream.IntStream;

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
        int[] listOfExponent = new int[0];
        for (int i = 0; i < size; i++) {
            if (terms[i] != null) {
                int exponent = terms[i].exponent;
                if (IntStream.of(listOfExponent)
                             .noneMatch(x -> x == exponent)) {
                    int[] temp = new int[listOfExponent.length + 1];
                    System.arraycopy(listOfExponent, 0, temp, 0, listOfExponent.length);
                    System.arraycopy(new int[] {exponent}, 0, temp, listOfExponent.length, 1);
                    listOfExponent = temp;
                }
            }
        }
        //return listOfExponent.stream().mapToInt(i -> i).toArray();
        return listOfExponent;
    }
    
    @Override
    public char[] getVariables() {
        char[] listOfVariable = new char[0];
        for (int i = 0; i < size; i++) {
            if (terms[i] != null) {
                char variable = terms[i].variable;
                if (!(new String(listOfVariable).contains(String.valueOf(variable)))) {
                    char[] temp = new char[listOfVariable.length + 1];
                    System.arraycopy(listOfVariable, 0, temp, 0, listOfVariable.length);
                    System.arraycopy(new char[] {variable}, 0, temp, listOfVariable.length, 1);
                    listOfVariable = temp;
                }
            }
        }
        return listOfVariable;
    }
    
    @Override
    public Term[] getTerms(char variable, int exponent) {
        Term[] listOfTerm = new Term[0];
        for (int i = 0; i < size; i++) {
            if (terms[i] != null) {
                if (terms[i].exponent == exponent && terms[i].variable == variable) {
                    Term[] temp = new Term[listOfTerm.length + 1];
                    System.arraycopy(listOfTerm, 0, temp, 0, listOfTerm.length);
                    System.arraycopy(new Term[] {terms[i]}, 0, temp, listOfTerm.length, 1);
                    listOfTerm = temp;
                }
            }
        }
        return listOfTerm;
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
