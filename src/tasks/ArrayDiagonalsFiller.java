package tasks;

public class ArrayDiagonalsFiller {
    public static void fillDiagonals() {
        int[][] array = new int[5][5];
        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            array[rowIndex][rowIndex] = 1;// заполняется первая диагональ
            array[rowIndex][array.length - rowIndex - 1] = 1; // заполняется вторая диагональ

        }
        // вывод двумерного массива
        /*for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {

            for (int columnIndex = 0; columnIndex < array[rowIndex].length; columnIndex++) {
                System.out.print(array[rowIndex][columnIndex] + " ");
            }
            System.out.println();

        }*/
    }
}
