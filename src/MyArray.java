import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class MyArray {
    public static void checkArray(String[][] shouldBeMatrix4x4) {
        try {
            if (shouldBeMatrix4x4.length != 4) {
                throw new MyArraySizeException("Количество строк должно быть 4");
            }
            for (int i = 0; i < shouldBeMatrix4x4.length; i++) {
                if (shouldBeMatrix4x4[i].length != 4) {
                    throw new MyArraySizeException("В строке " + (i + 1) + " должно быть 4 элемента");
                }
            }

            int memory = 0;
            for (int i = 0; i < shouldBeMatrix4x4.length; i++) {

                for (int j = 0; j < shouldBeMatrix4x4[i].length; j++) {

                    try {
                        int intValue = Integer.parseInt(shouldBeMatrix4x4[i][j]);
                        memory += intValue;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("В строке №: " + (i+1) + " значение №: " + (j+1) + " Невозможно преобразавать в int!");
                    }
                }
            }
            System.out.println(memory);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}