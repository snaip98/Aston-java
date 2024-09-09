package org.example;

public class FactorialCalculator {
    public long calculateFactorial(int value) {
        if (value == 0) {
            return 1;
        }
        if (value < 0) {
            throw new IllegalArgumentException("Нельзя вычислить факториал отрицательного числа");
        }
        if (value > 20) {
            throw new IllegalArgumentException("Факториал 20 предел для long");
        }
        long factorial = 1;
        for (int i = 1; i <= value; i++) {
            factorial *= i;
        }
        return factorial;
    }
}