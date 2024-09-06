package task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayWithSetOfWords {

    Map<String, ArrayList<Integer>> map = new HashMap<>();

    public void printSetWords() {
        System.out.println("Список уникальных слов в массиве: " + map.keySet());
    }

    public void arrayToMap(String[] words) {

        for (String word : words) {

            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }

            map.get(word).add(1);
        }
    }

    public void printCountSameWords() {

        for (String key : map.keySet()) {

            System.out.println("Количество слов: " + key + " - " + map.get(key).size());
        }
    }
}