package org.example;

import org.testng.annotations.Test;

public class Main {
    @Test
    public static void main(String[] args) {
        System.out.println(new FactorialCalculator().calculateFactorial(2));
    }
}