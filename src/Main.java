import task_1.MapOfUniqueStringsWithCountsFromArray;
import task_2.TelephoneDirectory;

public class Main {
    public static void main(String[] args) {
        //Задача №1
        String[] words = new String[]{"стол", "стол", "монитор", "мышка", "телефон", "стул", "телефон", "стул", "стол", "ноутбук", "стул", "ноутбук", "стул", "клавиатура"};
        MapOfUniqueStringsWithCountsFromArray actionsUsingCollections = new MapOfUniqueStringsWithCountsFromArray(words);
        actionsUsingCollections.printWordCount();
        actionsUsingCollections.printListOfUniqueWords();

        //Задача №2
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Aksnovich", "+375333372258");
        telephoneDirectory.add("Aksnovich", "+375333372259");
        telephoneDirectory.add("Naumenko", "+375336751710");
        telephoneDirectory.add("Krikun", "+375333371117");
        telephoneDirectory.add("Krikun", "+375333371124");
        telephoneDirectory.add("Aksnovich", "+375333372255");
        telephoneDirectory.add("Naumenko", "+375336751815");
        telephoneDirectory.get("Aksnovich");
        telephoneDirectory.get("Naumenko");
        telephoneDirectory.get("Krikuh");
        telephoneDirectory.get("Krikun");
    }
}