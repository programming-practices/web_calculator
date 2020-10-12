package com.trl.web_calculator.service.calculator;

public class ExceptionIncorrectArithmeticExpression extends IllegalArgumentException {

    public ExceptionIncorrectArithmeticExpression(String message) {
        super(message);
    }

}
