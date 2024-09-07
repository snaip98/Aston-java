package task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {

    Map<String, ArrayList<String>> phoneDirectory = new HashMap<>();

    public void get(String lastName) {
        try {
            if (!phoneDirectory.containsKey(lastName)) {
                throw new NullPointerException("Такой фамилии: " + lastName + " нет справочнике!");
            }
            System.out.println("Все найденные номера телефонов по фамилии: " + lastName + " " + phoneDirectory.get(lastName));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(String lastName, String phoneNumber) {

        if (!phoneDirectory.containsKey(lastName)) {
            phoneDirectory.put(lastName, new ArrayList<>());
        }

        phoneDirectory.get(lastName).add(phoneNumber);
    }
}