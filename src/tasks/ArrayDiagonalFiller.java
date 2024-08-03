package tasks;

public class ArrayDiagonalFiller {
    public static void fillDiagonal() {
        int[][] array = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;// заполняется первая диагональ
            array[i][array.length - i - 1] = 1; // заполняется вторая диагональ

        }
        // вывод двумерного массива
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();

        }
    }
}
