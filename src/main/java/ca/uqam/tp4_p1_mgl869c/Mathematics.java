package ca.uqam.tp4_p1_mgl869c;

import ca.uqam.tp4_p1_mgl869c.polynomial.LLPolynomial;
import ca.uqam.tp4_p1_mgl869c.polynomial.Polynomial;
import ca.uqam.tp4_p1_mgl869c.polynomial.TermComparator;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.ExceptionCoefficientZero;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.Term;

import java.util.List;

public class Mathematics {
    
    public static void simplify(Polynomial polynomial) {
        List<Integer>   exponents = polynomial.getExponents();
        List<Character> variables = polynomial.getVariables();
        for (int exponent : exponents) {
            for (char variable : variables) {
                List<Term> terms            = polynomial.getTerms(variable, exponent);
                double     sumOfCoefficient = 0;
                for (Term term : terms) {
                    sumOfCoefficient += term.coefficient;
                    polynomial.removeTerm(term);
                }
                try {
                    polynomial.addTerm(new Term(sumOfCoefficient, variable, exponent));
                } catch (ExceptionCoefficientZero ignored) {
                }
            }
        }
    }
    
    public static Polynomial sumPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial polynomial = new LLPolynomial();
        List<Term> p1Terms    = polynomial1.getAllTerms();
        List<Term> p2Terms    = polynomial2.getAllTerms();
        for (Term p1Term : p1Terms) {
            polynomial.addTerm(p1Term);
        }
        for (Term p2Term : p2Terms) {
            polynomial.addTerm(p2Term);
        }
        Mathematics.simplify(polynomial);
        return polynomial;
    }
    
    public static Polynomial sort(Polynomial polynomial) {
        List<Term> terms = polynomial.getAllTerms();
        terms.sort(new TermComparator());
        Polynomial return_value = new LLPolynomial();
        for (Term term : terms) {
            return_value.addTerm(term);
        }
        return return_value;
    }
}
