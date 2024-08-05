package tasks;

public class SumSignChecker {
    public static void checkSumSign() {
        int a = 4, b = 4;
        int sum = a + b;
        System.out.println("Сумма " + (sum >= 0 ? "положительная" : "отрицательная"));
    }
}
