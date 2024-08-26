import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class MyArray {
    void checkArray(String[][] shouldBeMatrix4x4) {
        try {
            if (shouldBeMatrix4x4.length != 4 || shouldBeMatrix4x4[0].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть 4х4");
            }
            int memory = 0;
            for (int i = 0; i < shouldBeMatrix4x4.length; i++) {

                for (int j = 0; j < shouldBeMatrix4x4[i].length; j++) {

                    try {
                    int intValue = Integer.parseInt(shouldBeMatrix4x4[i][j].toString()) ;
                    memory += intValue;
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("В строке №: "+i+" значение №: "+j+" Невозможно преобразавать в int!");}
                }

            }
            System.out.println(memory);
        }  catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
