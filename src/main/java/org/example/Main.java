package org.example;

import org.testng.annotations.Test;

public class Main {
    @Test
    public static void main(String[] args) {
        FactorialCalculator factorialCalculator = new FactorialCalculator();
        System.out.println(factorialCalculator.calculateFactorial(5));
    }
}