package tasks;

public class SumSignChecker {
    public static void checkSumSign() {
        int a = 4;
        int b = 5;
        System.out.println("Сумма " + (a + b >= 0 ? "положительная" : "отрицательная"));
    }
}
