package tasks;

import java.util.Arrays;

public class ArrayBuilder {
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;

        }
        return array;

    }
// метод для вывода массива
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
