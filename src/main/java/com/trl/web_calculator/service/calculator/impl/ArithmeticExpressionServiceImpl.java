package com.trl.web_calculator.service.calculator.impl;

import com.trl.web_calculator.controller.calculator.dto.ArithmeticExpressionDTO;
import com.trl.web_calculator.controller.calculator.dto.ArithmeticExpressionResultDTO;
import com.trl.web_calculator.service.calculator.ArithmeticExpressionService;
import com.trl.web_calculator.service.calculator.Calculator;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticExpressionServiceImpl implements ArithmeticExpressionService {

    @Override
    public ArithmeticExpressionResultDTO calculate(ArithmeticExpressionDTO expressionDTO) {
        ArithmeticExpressionResultDTO resultDTO = new ArithmeticExpressionResultDTO();

        resultDTO.setResult(String.valueOf(Calculator.calculateArithmeticExpression(expressionDTO.getExpression())));

        return resultDTO;
    }

}
