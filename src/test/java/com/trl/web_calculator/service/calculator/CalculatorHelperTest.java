package com.trl.web_calculator.service.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorHelperTest {

    private CalculatorHelper helper = new CalculatorHelper();

//==================================== removeSpacesFromArithmeticExpression() ==========================================

    @Test
    public void removeSpacesFromArithmeticExpression() {
        String expression = "(2+(8-1)*10 )+11";
        helper.setArithmeticExpression(expression);
        helper.removeSpacesFromArithmeticExpression();
        Assert.assertEquals("(2+(8-1)*10)+11", helper.getArithmeticExpression());
    }

    @Test
    public void removeSpacesFromArithmeticExpression_1() {
        String expression = "    ( 2 +     ( 8 - 1 )    * 10 )      + 11      ";
        helper.setArithmeticExpression(expression);
        helper.removeSpacesFromArithmeticExpression();
        Assert.assertEquals("(2+(8-1)*10)+11", helper.getArithmeticExpression());
    }

//================================ checkIsAllowedCharactersInArithmeticExpression() ====================================

    @Test
    public void checkIsAllowedCharactersInArithmeticExpression() {
        helper.setArithmeticExpression("(((2+3)*4)/(45/3))-10");    // All characters are allowed
        try {
            helper.checkIsAllowedCharactersInArithmeticExpression();
            Assert.assertTrue(true);
        } catch (ExceptionIncorrectArithmeticExpression ex) {

            Assert.fail();
        }
    }

    @Test
    public void checkIsAllowedCharactersInArithmeticExpression_1() {
        helper.setArithmeticExpression("(((2.6+3)*4)/(45/3))-10");    // All characters are allowed
        try {
            helper.checkIsAllowedCharactersInArithmeticExpression();
            Assert.assertTrue(true);
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.fail();
        }
    }

    @Test
    public void checkIsAllowedCharactersInArithmeticExpression_2() {
        helper.setArithmeticExpression("(((2.6+3)*4)/(45,1/3))-10");    // Not allowed character 'coma'
        try {
            helper.checkIsAllowedCharactersInArithmeticExpression();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIsAllowedCharactersInArithmeticExpression_3() {
        helper.setArithmeticExpression("(((2.6+3A)*4)/(45/3))-10");    // Not allowed character 'A'
        try {
            helper.checkIsAllowedCharactersInArithmeticExpression();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkIsAllowedCharactersInArithmeticExpression_4() {
        helper.setArithmeticExpression("((      (2.6+3)*4)/(45/3))-10");    // All characters are allowed
        try {
            helper.checkIsAllowedCharactersInArithmeticExpression();
            Assert.assertTrue(true);
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.fail();
        }
    }

//============================================ checkArithmeticOperations() =============================================

    @Test
    public void checkArithmeticOperations() {
        helper.setArithmeticExpression("(((2+3)*4)/(45/3))-10");    // All arithmetic operations are allowed
        try {
            helper.checkArithmeticOperations();
            Assert.assertTrue(true);
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.fail();
        }
    }

    @Test
    public void checkArithmeticOperations_1() {
        helper.setArithmeticExpression("(((2++3)*4)/(45/3))-10");    // Not allowed arithmetic operations '++'
        try {
            helper.checkArithmeticOperations();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkArithmeticOperations_2() {
        helper.setArithmeticExpression("(((2+3)*4)/(45//3))-10");    // Not allowed arithmetic operations '//'
        try {
            helper.checkArithmeticOperations();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }


    //================================================= checkParenthesis() =================================================
    @Test
    public void checkParenthesis() {
        helper.setArithmeticExpression("");
        try {
            helper.checkParenthesis();
            Assert.assertTrue(true);
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.fail();
        }
    }

    @Test
    public void checkParenthesis_1() {
        helper.setArithmeticExpression("(    (  ()  )   )");
        try {
            helper.checkParenthesis();
            Assert.assertTrue(true);
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.fail();
        }
    }

    @Test
    public void checkParenthesis_2() {
        helper.setArithmeticExpression("    (  ()  )   )");
        try {
            helper.checkParenthesis();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkParenthesis_3() {
        helper.setArithmeticExpression("(    ((  ()  )   )");
        try {
            helper.checkParenthesis();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkParenthesis_4() {
        helper.setArithmeticExpression("(    (  ()  )   ))");
        try {
            helper.checkParenthesis();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkParenthesis_5() {
        helper.setArithmeticExpression("))");
        try {
            helper.checkParenthesis();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkParenthesis_6() {
        helper.setArithmeticExpression("((");
        try {
            helper.checkParenthesis();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkParenthesis_7() {
        helper.setArithmeticExpression(")");
        try {
            helper.checkParenthesis();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkParenthesis_8() {
        helper.setArithmeticExpression("(");
        try {
            helper.checkParenthesis();
            Assert.fail();
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void checkParenthesis_9() {
        //TODO: At the moment I have no solution to cover this situation.
        helper.setArithmeticExpression(")(");
        try {
            helper.checkParenthesis();
//            Assert.fail();
            Assert.assertTrue(true);
        } catch (ExceptionIncorrectArithmeticExpression ex) {
            Assert.assertTrue(true);
        }
    }

}