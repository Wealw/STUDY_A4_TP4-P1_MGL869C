package ca.uqam.tp3_mgl869c;

public class Mathematics {
    
    public void simplify(Polynomial polynomial) {
        int[]  exponents = polynomial.getExponents();
        char[] variables = polynomial.getVariables();
        for (int exponent : exponents) {
            for (char variable : variables) {
                Term[] terms            = polynomial.getTerms(variable, exponent);
                double sumOfCoefficient = 0;
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
    
    public Polynomial sumPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial polynomial = new APolynomial();
        Term[] p1Terms = polynomial1.getAllTerms();
        Term[] p2Terms = polynomial2.getAllTerms();
        for (Term p1Term : p1Terms) {
            polynomial.addTerm(p1Term);
        }
        for (Term p2Term : p2Terms) {
            polynomial.addTerm(p2Term);
        }
        simplify(polynomial);
        return polynomial;
    }
}
