package ca.uqam.tp4_p1_mgl869c;

import ca.uqam.tp4_p1_mgl869c.polynomial.LLPolynomial;
import ca.uqam.tp4_p1_mgl869c.polynomial.Polynomial;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.ExceptionCoefficientZero;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.Term;


public class main {
    @SuppressWarnings ("MethodNameSameAsClassName")
    public static void main(String[] args) {
        try {
            Polynomial p1 = new LLPolynomial();
            Polynomial p2 = new LLPolynomial();
            p1.addTerm(new Term(1.5, ' ', 0));
            p1.addTerm(new Term(-4, ' ', 0));
            p1.addTerm(new Term(2, 'x', 1));
            p1.addTerm(new Term(8, 'x', 2));
            p2.addTerm(new Term(-20, 'y', 2));
            p2.addTerm(new Term(2, 'y', 10));
            p2.addTerm(new Term(9, 'y', 10));
            Polynomial p3 = Mathematics.sort(Mathematics.sumPolynomials(p1, p2));
            System.out.print(p3);
        } catch (ExceptionCoefficientZero e) {
            e.printStackTrace();
        }
    }
}