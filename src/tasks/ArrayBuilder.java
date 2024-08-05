package tasks;

import java.util.Arrays;

public class ArrayBuilder {
    public static int[] createArray(int len, int initialValue) {
        try {
            if (len < 0) {
                throw new NegativeArraySizeException("Передайте методу положительное число");
            }
            int[] array = new int[len];
            for (int i = 0; i < array.length; i++) {
                array[i] = initialValue;

            }
            return array;

        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return new int[0];
        }

    }

    // метод для вывода массива
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
