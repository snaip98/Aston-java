package task1.Staff;

import task1.Animal;

public class Cat extends Animal {
    private static int catCount = 0;

    public Cat(String name) {
        super(name, 200, 0, false);
        catCount++;
    }

    public static void printCount() {
        System.out.println("Количество котов: " + catCount);
    }
}