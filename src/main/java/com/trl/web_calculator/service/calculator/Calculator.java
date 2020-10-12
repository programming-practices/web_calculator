package com.trl.web_calculator.service.calculator;

/**
 * This class performs the action of the calculator.
 */
public final class Calculator {

    private Calculator() {
    }

    /**
     * This method is to calculate the arithmetic arithmeticExpression.
     *
     * @return double result.
     */
    public static double calculateArithmeticExpression(String arithmeticExpression) {
        CalculatorHelper calculatorHelper = new CalculatorHelper(arithmeticExpression);
        calculatorHelper.verifyArithmeticExpression();
        return calculate(arithmeticExpression);
    }

    /**
     * This method is to calculate the arithmetic expression.
     *
     * @return double result.
     */
    private static double calculate(String expr) {
        if (expr.startsWith("(") && expr.endsWith(")")) {

            return calculate(expr.substring(1, expr.length() - 1));
        } else if (expr.startsWith("(") && !expr.endsWith(")")) {

            return startCalculationFromEnd(expr);
        } else {

            return startCalculationFromBeginning(expr);
        }
    }

    /**
     *
     */
    private static double startCalculationFromBeginning(String expr) {
        int pos = 0;
        while (pos < expr.length() - 1) {
            if (Character.isDigit(expr.charAt(pos)) || expr.charAt(pos) == '.') {
                pos++;
            } else {
                double leftOperand = Double.valueOf(expr.substring(0, pos));
                char operator = expr.charAt(pos);
                double rightOperand = calculate(expr.substring(pos + 1));
                switch (operator) {
                    case '+':
                        return leftOperand + rightOperand;
                    case '-':
                        return leftOperand - rightOperand;
                    case '*':
                        return leftOperand * rightOperand;
                    case '/':
                        return rightOperand / leftOperand;
                }
            }
        }
        return Double.valueOf(expr);
    }

    /**
     *
     */
    private static double startCalculationFromEnd(String expr) {
        int pos = expr.length() - 1;
        while (pos >= 0) {
            if (Character.isDigit(expr.charAt(pos)) || expr.charAt(pos) == '.') {
                pos--;
            } else {
                double leftOperand = Double.valueOf(expr.substring(pos + 1));
                char operator = expr.charAt(pos);
                double rightOperand = calculate(expr.substring(0, pos));
                switch (operator) {
                    case '+':
                        return leftOperand + rightOperand;
                    case '-':
                        return leftOperand - rightOperand;
                    case '*':
                        return leftOperand * rightOperand;
                    case '/':
                        return rightOperand / leftOperand;
                }
            }
        }
        return Double.valueOf(expr);
    }

}
