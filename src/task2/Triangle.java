package task2;

public class Triangle extends GeometricFigure {
    public double sideA;
    public double sideB;
    public double sideC;
    public Triangle(String fillColor, String borderColor, double sideA, double sideB, double sideC) {
        super(fillColor, borderColor);
        validatePositive(sideA, sideB, sideC);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.perimeter = this.calculatePerimeter(sideA,sideB,sideC);
    }

    @Override
    public double calculateArea() {
        try {
            if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
                throw new IllegalArgumentException("Сторона треугольника не может быть отрицательной или равной 0!");
            }
            if (sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA) {
                throw new IllegalArgumentException("С такими сторонами невозможно построить треугольник!");
            }
            double p = calculatePerimeter(sideA, sideB, sideC) / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public double calculatePerimeter(double sideA, double sideB, double sideC) {
        return super.calculatePerimeter(sideA, sideB, sideC);
    }
}