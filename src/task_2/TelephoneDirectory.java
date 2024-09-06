package task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {

    Map<String, ArrayList<String>> phoneDirectory = new HashMap<>();

    public void get(String lastName) {
        System.out.println("Все найденные номера телефонов по фамилии: " + lastName + " " + phoneDirectory.get(lastName));
    }

    public void add(String lastName, String phoneNumber) {

        if (!phoneDirectory.containsKey(lastName)) {
            phoneDirectory.put(lastName, new ArrayList<>());
        }

        phoneDirectory.get(lastName).add(phoneNumber);
    }
}