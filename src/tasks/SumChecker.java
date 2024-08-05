package tasks;

public class SumChecker {
    public static boolean sumInRange(int num1, int num2) {
        int sum = num1 + num2;
        return (sum >= 10 && sum <= 20) ? true : false;
    }
}
