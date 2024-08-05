package tasks;

public class ArrayFiller {
    public static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
         /*Вывод массива
        for(int index:array){
            System.out.println(index);
        }*/
    }
}
