package midtermlabproject2;
import java.util.Scanner;

/**
 * This is the PostfixCalculator executable class. It has 2 functions including:
 * <li>Convert Infix Expression to Postfix.</li>
 * <li>Compute Postfix Expression and Display the Result</li>
 * <li>Exit Program</li>
 * <p>These functions display table of process on how it arrived to the result that is shown after the execution of the each function.</p>
 * @author CS211-9344 Group 2
 */
public class PostfixCalculator {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        PostfixCalculator program;
        try{
            program = new PostfixCalculator();
            program.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the program
     */
    public void run(){
        while (true) {
            displayMenu();
            int choice = readInteger("Choice: ");

            try {
                switch (choice) {
                    case 1 -> {
                        while (true) {
                            String infixExpression = readString("Enter an Infix Expression: ");

                            if (isValidInfix(infixExpression)) {
                                String postfixExpression = convertToPostfix(infixExpression);
                                System.out.print("Postfix Expression: " + postfixExpression + "\n");
                                System.out.print("\nCompute Postfix Expression? [Y/N]: ");
                                if (scan.nextLine().equalsIgnoreCase("y")){
                                    System.out.println("Result of Computation: "+computePostfix(postfixExpression)+"\n");
                                }
                            } else {
                                System.err.println("\n-- Cannot Convert Input --\n");
                                continue;
                            }
                            break;
                        }
                    }
                    case 2 -> {
                        String postfixExpression = readString("Enter a Postfix Expression to Compute: ");
                        double postfixResult = computePostfix(postfixExpression);
                        System.out.println("Result of Computation: " + postfixResult + "\n");
                    }
                    case 3 -> {
                        System.out.println("Thank you for using our program.");
                        return;
                    }
                    default -> System.out.println("Invalid choice.\n Please try again.\n");
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }

    /**
     * Shows the menu which gives users options to choose from
     */
    private void displayMenu(){
        System.out.println("============================================");
        System.out.println( "          -THE POSTFIX CALCULATOR-         ");
        System.out.println("============================================");
        System.out.println(" [1] Convert Infix to Postfix               ");
        System.out.println(" [2] Compute for Postfix Expression         ");
        System.out.println(" [3] Exit                                   ");
        System.out.println("============================================");
    }


    /**
     * Convert an infix expression input to a postfix expression.
     * It will split the input infix into an array using the operators as
     * regular expressions. It will then add operands directly to the postfix expression.
     * For operators, it will add them according to their precedence. If there is an open parenthesis,
     * add the operators on the stack first. If a matching closing parenthesis is detected,
     * add all the operators to the postfix expression according to precedence.
     * @param infix a String input that is an infix expression.
     * @return {@link MyStack<Character>} as a final result of the method (i.e. converted expression).
     */
    private String convertToPostfix(String infix) {
        MyStack<String> operatorStack = new MyStack<>();
        StringBuilder postfixExpression = new StringBuilder();

        // Convert infix expression into an array of tokens
        String[] tokens = infix.split("(?<=\\+|-|\\*|/|log|\\(|\\))|(?=\\+|-|\\*|/|log|\\(|\\))");
        System.out.println("\n-- Process Table --");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-10s | %-35s | %-10s\n", "Symbol", "postfixExpression", "operatorStack");
        System.out.println("----------------------------------------------------------------");
        for (String symbol : tokens) {
            symbol = symbol.trim(); // Trim whitespace

            // If the token is an operand, append it to the result
            if (isNumeric(symbol) || isLiteral(symbol)) {
                postfixExpression.append(symbol).append(" ");
            }
            // If the token is an opening parenthesis, push to stack
            else if (symbol.equals("(")) {
                operatorStack.push(symbol);
            }
            // If the token is a closing parenthesis, pop from stack until opening parenthesis
            else if (symbol.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    postfixExpression.append(operatorStack.pop()).append(" ");
                }
                // Pop the opening parenthesis
                if (!operatorStack.isEmpty()) {
                    operatorStack.pop();
                }
            }
            // If the token is an operator
            else if (isOperator(symbol)) {
                // Pop operators with higher or equal precedence from the stack
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")
                        && precedence(operatorStack.peek(), symbol)) {
                    postfixExpression.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(symbol); // Push the current operator onto the stack
            }
            System.out.printf("%-10s | %-35s | %-10s\n", symbol, postfixExpression, operatorStack);
        }

        // Pop the remaining operators from the stack
        while (!operatorStack.isEmpty()) {
            if (!operatorStack.peek().equals("(")) {
                postfixExpression.append(operatorStack.pop()).append(" ");
            } else {
                operatorStack.pop(); // Discard opening parenthesis
            }
            System.out.printf("%-10s | %-35s | %-10s\n", "", postfixExpression, operatorStack);
        }
        System.out.println("----------------------------------------------------------------");
        return postfixExpression.toString().trim(); // Return the trimmed postfix expression
    }



    /**
     * Computes for the value of a postfix expression. It splits the input postfix
     * using spaces as regular expressions. It will then check if a token is an operand
     * or an operator.
     * @param postfix a String representation of postfix expression.
     * @return evaluated postfix expression (i.e. the result after the operations are applied).
     */
    private double computePostfix(String postfix) {
        MyStack<Double> operandStack = new MyStack<>();
        String[] tokens = postfix.split("\\s");
        assignValue(tokens);
        System.out.println("\n-- State of Operand Stack per Push and Pop --\n");
            System.out.printf("%-30s | %-35s \n", "Operand Stack", "Operator");
            System.out.println("---------------------------------------------------------");
        for (String token : tokens) {
            if (isNumeric(token)) {
                operandStack.push(Double.parseDouble(token));
                System.out.printf("%-30s | %-35s \n", operandStack, isNumeric(token) ? "": token);
            } else if (token.equals("log")) {
                if (operandStack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid postfix expression: Not enough operands for log.");
                }
                double num = operandStack.pop();
                if (num <= 0) {
                    throw new IllegalArgumentException("Logarithm undefined for non-positive values.");
                }
                // Push the result of the logarithm
                operandStack.push((Math.log(num)));
                System.out.printf("%-30s | %-35s \n", operandStack, isNumeric(token) ? "": token);
            } else if (isOperator(token)) {
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: Not enough operands for operation " + token);
                }
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();

                double postfixResult = evaluateOperation(token, operand1, operand2);
                operandStack.push(postfixResult);
                System.out.printf("%-30s | %-35s \n", operandStack, isNumeric(token) ? "": token);
            } else {
                throw new IllegalArgumentException("Invalid token in postfix expression: " + token);
            }
        }

        // Check if the stack contains only 1 value
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix: Too many operands remaining in the stack.");
        }
        System.out.println("---------------------------------------------------------");
        return operandStack.pop();
    }

    /**
     * assigns value for the literals or variables that is used in the expression.
     * @param tokens a String array that will pass through a loop and change the literal to numerical values.
     */
    private void assignValue(String[] tokens) {
        for (int index = 0; index < tokens.length; index++) {
            if (isLiteral(tokens[index])) {
                if(!isOperator(tokens[index])) {
                    tokens[index] = String.valueOf(readInteger("Enter value for variable "+tokens[index]+": "));
                }
            }
        }
    }

    /**
     * helper method for computePostfix to check if the String is numeric
     *
     * @param str a String input that will be validated.
     * @return true if the input is an Integer.
     */
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * validates String input.
     * @param str a String input that will be validated.
     * @return true if the input is a letter.
     */
    private boolean isLiteral(String str) {
        for (char chars : str.toCharArray()) {
            return Character.isLetter(chars);
        }
        return false;
    }

    /**
     * helper methods for computePostfix. Validates whether an input is an operator or not.
     * @param operator a String input that will pass through validation.
     * @return true if the input is an operator.
     */
    private boolean isOperator(String operator) {
        return "+-*^/log".contains(operator);
    }

    /**
     * helper methods for computePostfix
     * @param operator String parameter for the operator.
     * @param op1 the first operand.
     * @param op2 the second operand.
     * @return the result after the evaluation of the entered parameters.
     */
    private double evaluateOperation(String operator, double op1, double op2) {
        switch (operator) {
            case "+" -> {
                return op1 + op2;
            }
            case "-" -> {
                return op1 - op2;
            }
            case "*" -> {
                return op1 * op2;
            }
            case "/" -> {
                if (op2 == 0) {
                    throw new ArithmeticException("division by zero");
                }
                return op1 / op2;
            }
            case "^" -> {
                return (int) Math.pow(op1, op2);
            }
            default -> throw new IllegalArgumentException("invalid operator: " + operator);
        }
    }

    /**
     * reads String input and validate it whether it is an integer or not.
     * @param prompt a String input that will notify the user.
     * @return the input after validation.
     */
    public int readInteger(String prompt){
        Scanner scan = new Scanner(System.in);
        int num = 0;
        boolean isValid = false;
        while (!isValid){
            try {
                System.out.print(prompt);
                num = Integer.parseInt(scan.nextLine());
                isValid = true;
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid integer");
            }
        }
        return num;
    }

    /**
     * reads String input and validate to avoid empty input.
     * @param message a String input that will notify the user.
     * @return the String input after validation.
     */
    public String readString(String message) {
        String input = null;
        while (true) {
            System.out.print(message);
            input = scan.nextLine();
            if (input.isEmpty()) {
                System.out.println("\n-- No entry --\n");
                continue;
            }
            break;
        }
        return input;
    }

    /**
     * validates infix expression.
     * @param expression a String input that will be validated.
     * @return true if the input has at least one occurence of an operator between operands
     * <p>(i.e. [operand] [operator] [operand] -> A+B) .</p>
     */
    public boolean isValidInfix(String expression) {
        String regex = ".*[a-zA-Z0-9].*[+\\-*/].*[a-zA-Z0-9].*";
        return expression.matches(regex);
    }

    /**
     * method to check if 'op1' has higher or equal precedence compared to 'op2'
     * @param op1 first operator to compare.
     * @param op2 second operator to compare.
     * @return true if op1 is larger than op2.
     */
    public boolean precedence(String op1, String op2) {
        return getPrecedence(op1) >= getPrecedence(op2);
    }

    /**
     * helper method to assign precedence to operators
     * @param operator a String input that will go through validation.
     * @return the int value of the precedence.
     */
    private int getPrecedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;//lowest precedence
            case "*", "/" -> 2;//high precedence
            case "^" -> 3;//higher precedence (right-associative)
            case "log" -> 4; //highest precedence
            default -> -1;//for non-operators (like parentheses)
        };
    }
}
