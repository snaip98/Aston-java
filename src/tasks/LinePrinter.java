package tasks;

public class LinePrinter {
    public static void printStringMultipleTimes(String line, int repeatCount) {
        try {
            if (repeatCount < 0) {
                throw new IllegalArgumentException("Введите положительное число ");
            }
            for (int counter = 0; counter < repeatCount; counter++) {
                System.out.println(line);

            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}
