package tasks;

public class LinePrinter {
    public static void printStringMultipleTimes(String line, int number) {
        try {
            if (number < 0) {
                throw new IllegalArgumentException("Введите положительное число ");
            }
            for (int i = 0; i < number; i++) {
                System.out.println(line);

            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}
