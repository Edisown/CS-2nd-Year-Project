/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */

package prelim;

public class Polynomial implements PolynomialInterface {
    private MyLinkedList<Term> terms;

    public Polynomial() {
        this.terms = new MyLinkedList<>();
    }

    // Add a term to the polynomial
    public void addTerm(Term term) {
        // Check if the polynomial is empty
        if (terms.getSize() == 0) {
            terms.addToTail(term);
            return;
        }

        Node<Term> current = terms.getHead();
        Node<Term> prev = null;
        boolean added = false;

        // Traverse to find the correct position to insert the term
        while (current != null) {
            Term existingTerm = current.getData();

            // If exponents are the same, combine coefficients
            if (existingTerm.getExponent() == term.getExponent()) {
                int newCoefficient = existingTerm.getNumericalCoefficient() + term.getNumericalCoefficient();
                if (newCoefficient != 0) {
                    existingTerm.setNumericalCoefficient(newCoefficient);
                } else {
                    // Remove the term if the coefficient becomes zero
                    if (prev == null) {
                        // Removing the head
                        terms.remove(current.getData());
                    } else {
                        // Removing from the middle or end
                        prev.setNext(current.getNext());
                    }
                }
                added = true;
                break;
            } else if (existingTerm.getExponent() < term.getExponent()) {
                // Insert the term before the current node
                if (prev == null) {
                    terms.addToHead(term);  // Add to head if inserting at the front
                } else {
                    terms.addToTail(term);  // Add to tail after the previous node
                }
                added = true;
                break;
            }

            prev = current;
            current = current.getNext();
        }

        // If we reached the end and didn't add the term, it is the smallest term
        if (!added) {
            terms.addToTail(term);
        }
    }

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

    @Override
    public Polynomial add(Polynomial other) {
        Polynomial result = new Polynomial();

        // Add all terms from this polynomial
        Node<Term> thisCurrent = this.terms.getHead();
        while (thisCurrent != null) {
            result.addTerm(thisCurrent.getData());
            thisCurrent = thisCurrent.getNext();
        }

        // Add all terms from the other polynomial
        Node<Term> otherCurrent = other.terms.getHead();
        while (otherCurrent != null) {
            result.addTerm(otherCurrent.getData());
            otherCurrent = otherCurrent.getNext();
        }

        return result;
    }

    @Override
    public Polynomial subtract(Polynomial other) {
        Polynomial result = new Polynomial();

        // Add all terms from this polynomial
        Node<Term> thisCurrent = this.terms.getHead();
        while (thisCurrent != null) {
            result.addTerm(thisCurrent.getData());
            thisCurrent = thisCurrent.getNext();
        }

        // Subtract all terms from the other polynomial
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<Term> current = terms.getHead();

        while (current != null) {
            Term term = current.getData();
            int coefficient = term.getNumericalCoefficient();
            int exponent = term.getExponent();

            // Skip zero coefficients
            if (coefficient == 0) {
                current = current.getNext();
                continue;
            }

            // Handle the sign for the first term or subsequent terms
            if (result.length() > 0) {
                if (coefficient > 0) {
                    result.append(" + ");
                } else {
                    result.append(" - ");
                    coefficient = -coefficient; // Use absolute value for display
                }
            } else if (coefficient < 0) {
                result.append("-"); // Start with a negative sign if the first term is negative
                coefficient = -coefficient; // Use absolute value for display
            }

            // Append the coefficient
            if (exponent == 0) {
                result.append(coefficient); // Constant term
            } else {
                if (coefficient != 1) {
                    result.append(coefficient); // Coefficient for x
                }
                result.append("x"); // Variable
                if (exponent > 1) {
                    result.append("^").append(exponent); // Exponent if greater than 1
                }
            }

            current = current.getNext();
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
