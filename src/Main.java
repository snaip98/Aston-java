import task1.*;
import task1.Staff.Cat;
import task1.Staff.Dog;
import task2.*;

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
        Bowl bowlForCats = new Bowl();
        bowlForCats.addFoodToBowl(30);
        for (Cat cat : cats) {
            bowlForCats.eatFromBowl(20);
            System.out.println(bowlForCats.getFoodAmount());
            System.out.println(cat.name + " " + bowlForCats.catsSatiety);
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