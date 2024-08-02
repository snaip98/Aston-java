package tasks;

public class SumSign {
    public static void checkSumSign() {
        int a = 4, b = 7;
        System.out.println("Сумма " + (a + b >= 0 ? "положительная" : "отрицательная"));
    }
}
