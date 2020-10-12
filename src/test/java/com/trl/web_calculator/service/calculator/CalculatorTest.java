package com.trl.web_calculator.service.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void calculateArithmeticExpression() {
        Assert.assertEquals(7.0, Calculator.calculateArithmeticExpression("8-1"), 0);
    }

    @Test
    public void calculateArithmeticExpression_0() {
        Assert.assertEquals(7.0, Calculator.calculateArithmeticExpression("(8-1)"), 0);
    }

    @Test
    public void calculateArithmeticExpression_1() {
        Assert.assertEquals(77.0, Calculator.calculateArithmeticExpression("(8-1)*11"), 0);
    }

    @Test
    public void calculateArithmeticExpression_2() {
        Assert.assertEquals(77.0, Calculator.calculateArithmeticExpression("11*(8-1)"), 0);
    }

    @Test
    public void calculateArithmeticExpression_3() {
        Assert.assertEquals(70.0, Calculator.calculateArithmeticExpression("((8-1)*10)"), 0);
    }

    @Test
    public void calculateArithmeticExpression_4() {
        Assert.assertEquals(87.0, Calculator.calculateArithmeticExpression("10+(8-1)*11"), 0);
    }

    @Test
    public void calculateArithmeticExpression_5() {
        Assert.assertEquals(81.0, Calculator.calculateArithmeticExpression("((8-1)*10)+11"), 0);
    }

    @Test
    public void calculateArithmeticExpression_6() {
        Assert.assertEquals(81.0, Calculator.calculateArithmeticExpression("11+((8-1)*10)"), 0);
    }

    @Test
    public void calculateArithmeticExpression_7() {
        Assert.assertEquals(83.0, Calculator.calculateArithmeticExpression("(2+(8-1)*10)+11"), 0);
    }

    @Test
    public void calculateArithmeticExpression_8() {
        Assert.assertEquals(41.5, Calculator.calculateArithmeticExpression("((2+(8-1)*10)+11)/2"), 0);
    }

    @Test
    public void calculateArithmeticExpression_9() {
        Assert.assertEquals(4.0, Calculator.calculateArithmeticExpression("(9-1)/2"), 0);
    }

    @Test
    public void calculateArithmeticExpression_10() {
        Assert.assertEquals(10.2, Calculator.calculateArithmeticExpression("5.1*2"), 0);
    }

    @Test
    public void calculateArithmeticExpression_11() {
        Assert.assertEquals(10.2, Calculator.calculateArithmeticExpression("2.0*5.1"), 0);
    }

    @Test
    public void calculateArithmeticExpression_12() {
        String arithmeticExpression = "5.1-2";
        Assert.assertEquals(3.0999999999999996, Calculator.calculateArithmeticExpression("5.1-2"), 0);
        // Java makes a bad rounding of numbers
        // Assert.assertEquals(3.1, Calculator.calculateArithmeticExpression("5.1-2"), 0);
    }

    @Test
    public void calculateArithmeticExpression_13() {
        Assert.assertEquals(-3.0999999999999996, Calculator.calculateArithmeticExpression("2-5.1"), 0);
    }

}