package tasks;

public class BinaryArrayConverter {
    public static void binarySwitcher() {
        int[] array = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        /* Вывод массива
        for(int index:array){
            System.out.println(index);*/
    }

}



