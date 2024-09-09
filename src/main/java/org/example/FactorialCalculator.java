package org.example;

import java.math.BigInteger;

public class FactorialCalculator {
    private static int maxInputValue = 100;

    public BigInteger calculateFactorial(int value) {
        checkValueInPositiveClass(value);
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= value; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    private void checkValueInPositiveClass(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Нельзя вычислить факториал отрицательного числа");
        }
        if (value > maxInputValue) {
            throw new IllegalArgumentException("Калькулятор принимает значения от 0 до 100");
        }
    }
}