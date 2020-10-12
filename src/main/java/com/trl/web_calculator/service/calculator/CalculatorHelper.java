package com.trl.web_calculator.service.calculator;

import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * This is an auxiliary class.
 * This class prepares an arithmetic expression for the calculation.
 */
@NoArgsConstructor
public final class CalculatorHelper {

    private String arithmeticExpression;
    private List<Character> allowedCharacters = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '+', '-', '*', '/', ' ', '.');
    private List<String> notAllowedSequenceOperations = Arrays.asList("--", "-+", "+-", "-*", "*-", "-/", "/-", "++", "+*", "*+", "+/", "/+", "**", "*/", "/*", "//");

    public CalculatorHelper(String arithmeticExpression) {
        this.arithmeticExpression = arithmeticExpression;
    }

    /**
     * This function removes all spaces from an arithmetic arithmeticExpression.
     */
    void removeSpacesFromArithmeticExpression() {
        arithmeticExpression = arithmeticExpression.replaceAll("\\s+", "");
    }

    /**
     * This function checks allowed characters in Arithmetic Expression.
     * <p>
     * If the arithmeticExpression has incorrect characters, then the function throws ExceptionIncorrectArithmeticExpression().
     *
     * @throws ExceptionIncorrectArithmeticExpression
     */
    void checkIsAllowedCharactersInArithmeticExpression() {

        for (Character chr : arithmeticExpression.toCharArray()) {
            if (!allowedCharacters.contains(chr)) {
                throw new ExceptionIncorrectArithmeticExpression(arithmeticExpression + " <-- this expression contains not allowed characters.");
            }
        }
    }

    /**
     * This function checks arithmetic operations.
     * <p>
     * If arithmetic operations are not allowed, this function throws ExceptionIncorrectArithmeticExpression().
     *
     * @throws ExceptionIncorrectArithmeticExpression
     */
    void checkArithmeticOperations() {

        for (String notAllowedOperation : notAllowedSequenceOperations) {
            if (arithmeticExpression.contains(notAllowedOperation)) {
                throw new ExceptionIncorrectArithmeticExpression(arithmeticExpression + " <-- this expression contains not allowed operation.");
            }
        }
    }

    /**
     * This function tests arithmetic expressions on correctly open and closed parentheses.
     * <p>
     * If all brackets are open and closed incorrect, this function throws ExceptionIncorrectArithmeticExpression().
     *
     * @throws ExceptionIncorrectArithmeticExpression
     */
    void checkParenthesis() {
        char[] charArray = arithmeticExpression.toCharArray();
        Stack<Character> stack = new Stack();

        for (Character chr : charArray) {

            if (chr.equals('(') || chr.equals(')')) {

                if (!stack.isEmpty()) {

                    if (stack.get(stack.size() - 1).equals(chr)) {
                        stack.push(chr);
                    } else if (!stack.get(stack.size() - 1).equals(chr)) {
                        stack.pop();
                    }
                } else {
                    stack.push(chr);
                }
            }
        }
        if (!stack.isEmpty()) {
            throw new ExceptionIncorrectArithmeticExpression(arithmeticExpression + " <-- in this arithmetic expression, the location of brackets is bad.");
        }
    }

    /**
     * This function prepares an arithmetic arithmeticExpression to calculate
     */
    public void verifyArithmeticExpression() {
        removeSpacesFromArithmeticExpression();
        checkIsAllowedCharactersInArithmeticExpression();
        checkArithmeticOperations();
        checkParenthesis();
    }

    public String getArithmeticExpression() {
        return arithmeticExpression;
    }

    public void setArithmeticExpression(String arithmeticExpression) {
        this.arithmeticExpression = arithmeticExpression;
    }
}

