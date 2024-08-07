package tasks;


public class ArrayBuilder {
    public static int[] createArray(int len, int initialValue) {
        try {
            if (len < 0) {
                throw new NegativeArraySizeException("Передайте методу положительное число");
            }
            int[] array = new int[len];
            for (int index = 0; index < array.length; index++) {
                array[index] = initialValue;
                //System.out.print(array[i] + " ");
            }
            return array;

        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return new int[0];
        }

    }


}
