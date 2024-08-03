package tasks;


public class ArrayMultiplier {
    public static void multiplyByTwoIfLessThanSix() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] < 6 ? array[i] * 2 : array[i];
        }
        /* Вывод массива
        for(int index:array){
            System.out.println(index);
        }*/
    }
}
