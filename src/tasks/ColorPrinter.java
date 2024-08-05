package tasks;

public class ColorPrinter {
    public static void printColor() {
        int value = 101;
        String colour = (value <= 0) ? "Красный" : (value > 0 && value <= 100) ? "Жёлтый" : "Зелёный";
        System.out.println(colour);
    }
}
