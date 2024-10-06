/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 * Prelim Individual Project 2
 */

package prelim;

/**
 * Represents a polynomial using a singly linked list of terms.
 * Provides methods to add, evaluate, add, subtract, multiply, and divide polynomials.
 */
public class Polynomial implements PolynomialInterface {
    private MyLinkedList<Term> terms;

    /**
     * Constructs an empty Polynomial.
     */
    public Polynomial() {
        this.terms = new MyLinkedList<>();
    }

    /**
     * Adds a term to the polynomial. If the term's exponent already exists in the polynomial,
     * their coefficients will be combined. If the resulting coefficient is zero, the term is removed.
     *
     * @param term the term to add
     */
    public void addTerm(Term term) {
        if (terms.getSize() == 0) {
            terms.addToTail(term);
            return;
        }

        Node<Term> current = terms.getHead();
        Node<Term> prev = null;
        boolean added = false;

        while (current != null) {
            Term existingTerm = current.getData();

            if (existingTerm.getExponent() == term.getExponent()) {
                int newCoefficient = existingTerm.getNumericalCoefficient() + term.getNumericalCoefficient();
                if (newCoefficient != 0) {
                    existingTerm.setNumericalCoefficient(newCoefficient);
                } else {
                    if (prev == null) {
                        terms.remove(current.getData());
                    } else {
                        prev.setNext(current.getNext());
                    }
                }
                added = true;
                break;
            } else if (existingTerm.getExponent() < term.getExponent()) {
                if (prev == null) {
                    terms.addToHead(term);
                } else {
                    terms.addToTail(term);
                }
                added = true;
                break;
            }

            prev = current;
            current = current.getNext();
        }

        if (!added) {
            terms.addToTail(term);
        }
    }

    /**
     * Evaluates the polynomial for a given value of x.
     *
     * @param x the value to evaluate the polynomial at
     * @return the result of the evaluation
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        Node<Term> current = terms.getHead();

        while (current != null) {
            Term term = current.getData();
            result += term.getNumericalCoefficient() * Math.pow(x, term.getExponent());
            current = current.getNext();
        }
        return result;
    }

    /**
     * Adds two polynomials together and returns the resulting polynomial.
     *
     * @param other the polynomial to add
     * @return the sum of the two polynomials
     */
    @Override
    public Polynomial add(Polynomial other) {
        Polynomial result = new Polynomial();

        Node<Term> thisCurrent = this.terms.getHead();
        while (thisCurrent != null) {
            result.addTerm(thisCurrent.getData());
            thisCurrent = thisCurrent.getNext();
        }

        Node<Term> otherCurrent = other.terms.getHead();
        while (otherCurrent != null) {
            result.addTerm(otherCurrent.getData());
            otherCurrent = otherCurrent.getNext();
        }

        return result;
    }

    /**
     * Subtracts one polynomial from another and returns the resulting polynomial.
     *
     * @param other the polynomial to subtract
     * @return the difference of the two polynomials
     */
    @Override
    public Polynomial subtract(Polynomial other) {
        Polynomial result = new Polynomial();

        Node<Term> thisCurrent = this.terms.getHead();
        while (thisCurrent != null) {
            result.addTerm(thisCurrent.getData());
            thisCurrent = thisCurrent.getNext();
        }

        Node<Term> otherCurrent = other.terms.getHead();
        while (otherCurrent != null) {
            Term negatedTerm = new Term(-otherCurrent.getData().getNumericalCoefficient(),
                    otherCurrent.getData().getLiteralCoefficient(),
                    otherCurrent.getData().getExponent());
            result.addTerm(negatedTerm);
            otherCurrent = otherCurrent.getNext();
        }

        return result;
    }

    /**
     * Multiplies two polynomials and returns the resulting polynomial.
     *
     * @param other the polynomial to multiply by
     * @return the product of the two polynomials
     */
    @Override
    public Polynomial multiply(Polynomial other) {
        Polynomial result = new Polynomial();
        Node<Term> thisCurrent = this.terms.getHead();

        while (thisCurrent != null) {
            Term thisTerm = thisCurrent.getData();
            Node<Term> otherCurrent = other.terms.getHead();

            while (otherCurrent != null) {
                Term otherTerm = otherCurrent.getData();
                int newCoeff = thisTerm.getNumericalCoefficient() * otherTerm.getNumericalCoefficient();
                int newExp = thisTerm.getExponent() + otherTerm.getExponent();

                result.addTerm(new Term(newCoeff, thisTerm.getLiteralCoefficient(), newExp));
                otherCurrent = otherCurrent.getNext();
            }

            thisCurrent = thisCurrent.getNext();
        }

        return result;
    }

    /**
     * Divides the polynomial by another polynomial and returns the quotient.
     *
     * @param divisor the polynomial to divide by
     * @return the quotient polynomial
     */
    @Override
    public Polynomial divide(Polynomial divisor) {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = this;

        while (remainder.terms.getSize() > 0 && remainder.terms.getHead().getData().getExponent() >= divisor.terms.getHead().getData().getExponent()) {
            Term leadTermRemainder = remainder.terms.getHead().getData();
            Term leadTermDivisor = divisor.terms.getHead().getData();

            int newCoeff = leadTermRemainder.getNumericalCoefficient() / leadTermDivisor.getNumericalCoefficient();
            int newExp = leadTermRemainder.getExponent() - leadTermDivisor.getExponent();
            Term quotientTerm = new Term(newCoeff, leadTermRemainder.getLiteralCoefficient(), newExp);
            quotient.addTerm(quotientTerm);

            Polynomial temp = new Polynomial();
            temp.addTerm(quotientTerm);

            Polynomial subtraction = temp.multiply(divisor);
            remainder = remainder.subtract(subtraction);
        }

        return quotient;
    }

    /**
     * Returns a string representation of the polynomial in standard form.
     *
     * @return the polynomial as a string
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<Term> current = terms.getHead();

        while (current != null) {
            Term term = current.getData();
            int coefficient = term.getNumericalCoefficient();
            int exponent = term.getExponent();

            if (coefficient == 0) {
                current = current.getNext();
                continue;
            }

            if (result.length() > 0) {
                if (coefficient > 0) {
                    result.append(" + ");
                } else {
                    result.append(" - ");
                    coefficient = -coefficient;
                }
            } else if (coefficient < 0) {
                result.append("-");
                coefficient = -coefficient;
            }

            if (exponent == 0) {
                result.append(coefficient);
            } else {
                if (coefficient != 1) {
                    result.append(coefficient);
                }
                result.append("x");
                if (exponent > 1) {
                    result.append("^").append(exponent);
                }
            }

            current = current.getNext();
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
