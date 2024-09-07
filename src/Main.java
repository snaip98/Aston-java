import task_1.ArrayWithSetOfWords;
import task_2.TelephoneDirectory;

public class Main {
    public static void main(String[] args) {
        //Задача №1
        String[] words = new String[]{"стол", "стол", "монитор", "мышка", "телефон", "стул", "телефон", "стул", "стол", "ноутбук", "стул", "ноутбук", "стул", "клавиатура"};
        ArrayWithSetOfWords actionsUsingCollections = new ArrayWithSetOfWords();
        actionsUsingCollections.printWordCount(words);
        actionsUsingCollections.printListOfUniqueWords();

        //Задача №2
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Aksnovich", "+375333372258");
        telephoneDirectory.add("Aksnovich", "+375333372259");
        telephoneDirectory.add("Naumenko", "+375336751710");
        telephoneDirectory.add("Krikun", "+375333371117");
        telephoneDirectory.add("Krikun", "+375333371124");
        telephoneDirectory.add("Aksnovich", "+375333372259");
        telephoneDirectory.add("Naumenko", "+375336751815");
        telephoneDirectory.get("Aksnovich");
        telephoneDirectory.get("Naumenko");
        telephoneDirectory.get("Krikun");
        telephoneDirectory.get("Krikuh");
    }
}