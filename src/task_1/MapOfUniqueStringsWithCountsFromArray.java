package task_1;

import java.util.HashMap;
import java.util.Map;

public class MapOfUniqueStringsWithCountsFromArray {
    public MapOfUniqueStringsWithCountsFromArray(String[] words) {
        fillMap(words);
    }

    Map<String, Integer> stringCountMap = new HashMap<>();

    public void printListOfUniqueWords() {
        System.out.println("Список уникальных слов в массиве: " + stringCountMap.keySet());
    }

    private void fillMap(String[] words) {
        for (String word : words) {
            stringCountMap.put(word, stringCountMap.getOrDefault(word, 0) + 1);
        }
    }

    public void printWordCount() {
        for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
            System.out.println("Количество слов: " + entry.getKey() + " - " + entry.getValue());
        }
    }
}