package tasks;

public class ArrayFiller {
    public static void fillArray() {
        int[] array = new int[100];
        for (int index = 0; index < array.length; index++) {
            array[index] = index + 1;
        }
         /*Вывод массива
        for(int index:array){
            System.out.println(index);
        }*/
    }
}
