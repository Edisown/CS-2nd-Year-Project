/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 * Prelim Individual Project 2
 */

package prelim;

public class Term implements Comparable<Term> {
    private int numericalCoefficient; // Changed to int
    private String literalCoefficient; // e.g., "x"
    private int exponent;

    public Term(int numericalCoefficient, String literalCoefficient, int exponent) {
        this.numericalCoefficient = numericalCoefficient; // Updated constructor
        this.literalCoefficient = literalCoefficient;
        this.exponent = exponent;
    }

    // Getters and Setters
    public int getNumericalCoefficient() {
        return numericalCoefficient; // Updated return type
    }

    public void setNumericalCoefficient(int numericalCoefficient) {
        this.numericalCoefficient = numericalCoefficient; // Updated setter
    }

    public String getLiteralCoefficient() {
        return literalCoefficient;
    }

    public void setLiteralCoefficient(String literalCoefficient) {
        this.literalCoefficient = literalCoefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (numericalCoefficient < 0) {
            sb.append(numericalCoefficient); // Will include negative sign
        } else if (numericalCoefficient == 0) {
            return "0"; // Handle zero coefficient
        } else {
            sb.append(numericalCoefficient);
        }

        if (exponent == 1) {
            sb.append(literalCoefficient); // x
        } else if (exponent > 1) {
            sb.append(literalCoefficient).append("^").append(exponent); // x^2, x^3, etc.
        }

        return sb.toString();
    }

    @Override
    public int compareTo(Term o) {
        return Integer.compare(this.exponent, o.exponent);
    }
}
