package task2;

import task1.Cat;
import task1.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dogGarik = new Dog("Гарик");
        dogGarik.swim(5);
        dogGarik.run(1);
        Cat catRichi = new Cat("Ричи");
        catRichi.swim(3);
        catRichi.run(199);
        Dog.printCount();
        Cat.printCount();
        Cat[] cats = new Cat[2];
        cats[0] = new Cat("Барсик");
        cats[1] = new Cat("Леопольд");
        Cat.addFoodToBowl(30);
        for (Cat cat : cats) {
            cat.eatFromBowl(20);
        }
        for (Cat cat : cats) {
            System.out.println(cat.name + " " + cat.catsSatiety);
        }
        Cat.printCount();
        // Задача №2
       Circle circle = new Circle("Зелёный", "Синий", 2);
       Rectangle rectangle = new Rectangle("Красный","Фиолетовый",4,5);
       Triangle triangle = new Triangle("Cиний","Жёлтый",3,4,5);
       circle.printInfo();
       rectangle.printInfo();
       triangle.printInfo();

    }
}