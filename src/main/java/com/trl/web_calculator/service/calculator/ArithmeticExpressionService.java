package com.trl.web_calculator.service.calculator;

import com.trl.web_calculator.controller.calculator.dto.ArithmeticExpressionDTO;
import com.trl.web_calculator.controller.calculator.dto.ArithmeticExpressionResultDTO;

public interface ArithmeticExpressionService {

    /**
     * This method calculate arithmetic expression.
     *
     * @throws ExceptionIncorrectArithmeticExpression
     */
    ArithmeticExpressionResultDTO calculate(ArithmeticExpressionDTO expressionDTO);

}
