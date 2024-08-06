package tasks;


public class ArrayBuilder {
    public static int[] createArray(int len, int initialValue) {
        try {
            if (len < 0) {
                throw new NegativeArraySizeException("Передайте методу положительное число");
            }
            int[] array = new int[len];
            for (int i = 0; i < array.length; i++) {
                array[i] = initialValue;
                //System.out.print(array[i] + " ");
            }
            return array;

        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return new int[0];
        }

    }


}
