package tasks;

public class BinaryArrayConverter {
    public static void binarySwitcher() {
        int[] binaryArray = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int index = 0; index < binaryArray.length; index++) {
            if (binaryArray[index] == 0) {
                binaryArray[index] = 1;
            } else {
                binaryArray[index] = 0;
            }
        }
        /*Вывод массива
        for (int index : binaryArray) {
            System.out.println(index);
        }*/

    }
}



