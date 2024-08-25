package task2;

public interface IFigure {

    double calculateArea();

    default double calculatePerimeter(double radius) {
        return 2*Math.PI*radius;
    }
    default double calculatePerimeter(double length, double width) {
        return 2*(length+width);
    }
    default double calculatePerimeter(double sideA, double sideB ,double sideC) {
        return sideA+sideB+sideC;
    }
    String getFillColor();

    String getBorderColor();

    default void printInfo(double perimeter) {
        System.out.println("Фигура: " + this.getClass().getSimpleName());
        System.out.println("Периметр: " + perimeter );
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }
}
