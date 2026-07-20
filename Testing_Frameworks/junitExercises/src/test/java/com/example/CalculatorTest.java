package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(30, calculator.add(10, 20));
    }

    @Test
    public void testSubtract() {
        assertEquals(15, calculator.subtract(25, 10));
    }

    @Test
    public void testMultiply() {
        assertEquals(24, calculator.multiply(6, 4));
    }

    @Test
    public void testDivide() {
        assertEquals(5, calculator.divide(25, 5));
    }
}