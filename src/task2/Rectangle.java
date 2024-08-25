package task2;

public class Rectangle extends GeometricFigure{
 public double length;
 public double width;
    public Rectangle(String fillColor, String borderColor, double length, double width) {
        super(fillColor, borderColor);
        validatePositive(length,width);
        this.length = length;
        this.width = width;
        this.perimeter = this.calculatePerimeter(length,width);
    }

    @Override
    public double calculateArea() {
        return length*width;
    }

    @Override
    public double calculatePerimeter(double length, double width) {
        return super.calculatePerimeter(length, width);
    }
}