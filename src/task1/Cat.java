package task1;

import task1.Staff.Bowl;

public class Cat extends Animal {
    private static int catCount = 0;
    public boolean catsSatiety;
    public Cat(String name) {
        super(name, 200, 0, false);
        catCount++;
        this.catsSatiety = false;
    }
    public void tryToEatFromTheBowl(Bowl bowl, double catAppetite) {
        if (bowl.getFoodAmountInTheBowl() >= catAppetite) {
            bowl.eatFromBowl(catAppetite);
            catsSatiety = true;
            System.out.println(name + " наелся и теперь сыт!");
        } else {
            System.out.println(name + " не поел!");
            System.out.println( "Добавьте в миску еды!");
        }
    }


    public static void printCount() {
        System.out.println("Количество котов: " + catCount);
    }
}