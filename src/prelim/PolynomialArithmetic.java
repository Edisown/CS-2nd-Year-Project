/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */
package prelim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PolynomialArithmetic {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyLinkedList<Polynomial> polynomials = new MyLinkedList<>();
        String input;

        try {
            while (true) {
                System.out.println("\n===================================================");
                System.out.println("          Polynomial Arithmetic Calculator         ");
                System.out.println("===================================================");
                System.out.println("              1. Evaluate a Polynomial             ");
                System.out.println("              2. Add Polynomials                   ");
                System.out.println("              3. Subtract Polynomials              ");
                System.out.println("              4. Multiply Polynomials              ");
                System.out.println("              5. Divide Polynomials                ");
                System.out.println("              6. Quit                              ");
                System.out.println("===================================================");
                System.out.print("              Choose an option: ");

                input = reader.readLine();

                switch (input) {
                    case "1":
                        evaluatePolynomial(reader);
                        break;
                    case "2":
                        addPolynomials(reader);
                        break;
                    case "3":
                        subtractPolynomials(reader);
                        break;
                    case "4":
                        multiplyPolynomials(reader);
                        break;
                    case "5":
                        dividePolynomials(reader);
                        break;
                    case "6":
                        System.out.println("\nExiting the program...");
                        return;
                    default:
                        System.out.println("\nInvalid option! Please choose again.");
                }
            }
        } catch (IOException e) {
            System.err.println("\nAn error occurred while reading input: " + e.getMessage());
        }
    }

    private static void evaluatePolynomial(BufferedReader reader) throws IOException {
        System.out.print("Enter the polynomial: ");
        String polynomialInput = reader.readLine();
        Polynomial polynomial = parsePolynomial(polynomialInput);

        System.out.print("Enter the value of x: ");
        int x = Integer.parseInt(reader.readLine());

        double result = polynomial.evaluate(x);
        System.out.println("Result: " + result);
    }

    private static void addPolynomials(BufferedReader reader) throws IOException {
        System.out.print("Enter the first polynomial: ");
        String poly1Input = reader.readLine();
        Polynomial poly1 = parsePolynomial(poly1Input);

        System.out.print("Enter the second polynomial: ");
        String poly2Input = reader.readLine();
        Polynomial poly2 = parsePolynomial(poly2Input);

        Polynomial result = poly1.add(poly2);
        System.out.println("Result: " + result);
    }

    private static void subtractPolynomials(BufferedReader reader) throws IOException {
        System.out.print("Enter the first polynomial: ");
        String poly1Input = reader.readLine();
        Polynomial poly1 = parsePolynomial(poly1Input);

        System.out.print("Enter the second polynomial: ");
        String poly2Input = reader.readLine();
        Polynomial poly2 = parsePolynomial(poly2Input);

        Polynomial result = poly1.subtract(poly2);
        System.out.println("Result: " + result);
    }

    private static void multiplyPolynomials(BufferedReader reader) throws IOException {
        System.out.print("Enter the first polynomial: ");
        String poly1Input = reader.readLine();
        Polynomial poly1 = parsePolynomial(poly1Input);

        System.out.print("Enter the second polynomial: ");
        String poly2Input = reader.readLine();
        Polynomial poly2 = parsePolynomial(poly2Input);

        Polynomial result = poly1.multiply(poly2);
        System.out.println("Result: " + result);
    }

    private static void dividePolynomials(BufferedReader reader) throws IOException {
        System.out.print("Enter the dividend polynomial: ");
        String dividendInput = reader.readLine();
        Polynomial dividend = parsePolynomial(dividendInput);

        System.out.print("Enter the divisor polynomial: ");
        String divisorInput = reader.readLine();
        Polynomial divisor = parsePolynomial(divisorInput);

        Polynomial result = dividend.divide(divisor);
        System.out.println("Result: " + result);
    }

    private static Polynomial parsePolynomial(String input) {
        MyLinkedList<Term> terms = new MyLinkedList<>();
        String[] termStrings = input.split("\\s*\\+\\s*"); // split by plus signs and trim spaces

        for (String termString : termStrings) {
            termString = termString.trim();
            if (!termString.isEmpty()) {
                int coefficient = 1; // default coefficient
                int exponent = 0; // default exponent

                boolean isNegative = termString.startsWith("-");
                if (isNegative) {
                    termString = termString.substring(1).trim(); // remove the negative sign
                }

                // determine if term contains 'x'
                if (termString.contains("x")) {
                    String[] parts = termString.split("x");
                    // determine the coefficient
                    if (parts[0].isEmpty()) {
                        coefficient = isNegative ? -1 : 1; // case: x or -x, determine if the coefficient is negative or not
                    } else {
                        coefficient = isNegative ? -Integer.parseInt(parts[0].trim()) : Integer.parseInt(parts[0].trim());
                    }

                    //determine the exponent
                    if (parts.length > 1 && parts[1].startsWith("^")) {
                        exponent = Integer.parseInt(parts[1].substring(1).trim()); //get the exponent
                    } else {
                        exponent = 1;
                    }
                } else {
                    coefficient = isNegative ? -Integer.parseInt(termString.trim()) : Integer.parseInt(termString.trim());
                    exponent = 0;
                }

                // create term using the correct constructor
                Term term = new Term(coefficient, "x", exponent);
                terms.addToTail(term);
            }
        }

        // create a new Polynomial
        Polynomial polynomial = new Polynomial();

        // traverse the linked list to add terms to the polynomial
        Node<Term> current = terms.getHead();
        while (current != null) {
            polynomial.addTerm(current.getData());
            current = current.getNext();
        }

        return polynomial;
    }
}
