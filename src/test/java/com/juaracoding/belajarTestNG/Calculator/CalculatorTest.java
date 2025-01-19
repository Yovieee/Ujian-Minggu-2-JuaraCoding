package com.juaracoding.belajarTestNG.Calculator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void addTest() {
        int actualResult = Calculator.add(10, 20);
        int expectedResult = 30;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subtractTest() {
        int actualResult = Calculator.substract(10, 20);
        int expectedResult = -10;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplyTest() {
        int actualResult = Calculator.multiply(10, 20);
        int expectedResult = 200;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divideTest() {
        int actualResult = Calculator.divide(10, 2);
        int expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void modulusTest() {
        int actualResult = Calculator.modulus(10, 3);
        int expectedResult = 1;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void bodyMassIndexTest() {
        int actualResult = Calculator.bodyMassIndex(70, 170);
        int expectedResult = 24;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
