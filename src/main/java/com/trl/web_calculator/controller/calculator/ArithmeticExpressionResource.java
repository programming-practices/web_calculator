package com.trl.web_calculator.controller.calculator;

import com.trl.web_calculator.controller.calculator.dto.ArithmeticExpressionDTO;
import com.trl.web_calculator.controller.calculator.dto.ArithmeticExpressionResultDTO;
import com.trl.web_calculator.service.calculator.ArithmeticExpressionService;
import com.trl.web_calculator.service.calculator.ExceptionIncorrectArithmeticExpression;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class ArithmeticExpressionResource {

    private final ArithmeticExpressionService expressionService;

    /**
     * Method to calculate arithmetic expression.
     * <p>
     *
     * @param expressionDTO Arithmetic expression to be calculate.
     * @return ResponseEntity<ArithmeticExpressionDTO>
     */
    @PostMapping(path = "/calculator")
    public ResponseEntity<ArithmeticExpressionResultDTO> calculate(@RequestBody ArithmeticExpressionDTO expressionDTO) {
        ResponseEntity<ArithmeticExpressionResultDTO> response = null;
        ArithmeticExpressionResultDTO expressionResultDTO = null;

        try {
            expressionResultDTO = expressionService.calculate(expressionDTO);
            response = ResponseEntity.ok(expressionResultDTO);
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            response = ResponseEntity.badRequest().body(new ArithmeticExpressionResultDTO(ex.getMessage()));
        }

        return response;
    }

}
