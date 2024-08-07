package tasks;

public class ArrayMultiplier {
    public static void multiplyByTwoIfLessThanSix() {
        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int index = 0; index < array.length; index++) {
            array[index] = array[index] < 6 ? array[index] * 2 : array[index];
        }
        //Вывод массива
        /*for(int index:array){
            System.out.println(index);
        }*/
    }
}
