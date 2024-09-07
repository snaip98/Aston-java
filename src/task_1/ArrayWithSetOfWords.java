package task_1;

import java.util.HashMap;
import java.util.Map;

public class ArrayWithSetOfWords {

    Map<String, Integer> stringCountMap = new HashMap<>();

    public void printListOfUniqueWords() {
        System.out.println("Список уникальных слов в массиве: " + stringCountMap.keySet());
    }

    public void printWordCount(String[] words) {

        for (String word : words) {
            stringCountMap.put(word, stringCountMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
            System.out.println("Количество слов: "+entry.getKey() + " - " + entry.getValue());
        }
    }
}