
import tasks.*;

public class Main {
    public static void main(String[] args) {
        // Задача №1
        ThreeWords.printThreeWords();
        // Задача №2
        SumSign.checkSumSign();
        // Задача №3
        СhoiceColour.printColor();
        // Задача №4
        ValueComparator.compareNumbers();
        // Задача №5
        SumChecker.sumInRange(21, 9);
        // Задача №6
        NumberChecker.checkNumber(0);
        // Задача №7
        SignChecker.checkIfNegative(-1);
        // Задача №8
        LinePrinter.printStringMultipleTimes("rabbit", 3);
        // Задача №9
        LeapYearDeterminer.checkLeapYear(4);
        // Задача №10
        BinaryArrayConverter.binarySwitcher();
        // Задача №11
        ArrayFiller.fillArray();
        // Задача №12
        ArrayMultiplier.multiplyByTwoIfLessThanSix();
        // Задача №13
        ArrayDiagonalFiller.fillDiagonal();
        // Задача №14
        ArrayBuilder.createArray(5, 4);
       /* метод для печати массива
       printArray(createArray(5, 4));
        */
    }
}
