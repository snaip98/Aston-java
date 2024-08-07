package tasks;

public class ColorPrinter {
    public static void printColor() {
        int value = -11;
        System.out.println((value <= 0) ? "Красный" : (value > 0 && value <= 100) ? "Жёлтый" : "Зелёный");
    }
}
