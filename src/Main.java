import task1.Cat;
import task1.Dog;
import task1.Staff.Bowl;
import task2.Circle;
import task2.Rectangle;
import task2.Triangle;

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
            cat.tryToEatFromTheBowl(bowlForCats, 20);
            System.out.println("Количество еды в миске: " + bowlForCats.getFoodAmountInTheBowl());
            System.out.println(cat.name + " " + cat.catsSatiety);
        }
        Cat.printCount();

        // Задача №2
        Circle circle = new Circle("Зелёный", "Синий", 3);
        Rectangle rectangle = new Rectangle("Красный", "Фиолетовый", 4, 5);
        Triangle triangle = new Triangle("Cиний", "Жёлтый", 3, 4, 5);
        circle.printInfo(circle.perimeter);
        rectangle.printInfo(rectangle.perimeter);
        triangle.printInfo(triangle.perimeter);
    }
}