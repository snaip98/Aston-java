package task2;

public class Circle extends GeometricFigure {
    public double radius;



    public Circle(String borderColor, String fillColor, double radius) {
        super(borderColor, fillColor);
        validatePositive(radius);
        this.radius = radius;
        this.perimeter = this.calculatePerimeter(radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter(double radius) {
        return super.calculatePerimeter(radius);
    }


}