package task2;

public interface Figure {

    double calculateArea();

    default double calculatePerimeter() {
        return 0;
    }

    default void printInfo() {
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());

    }

}
