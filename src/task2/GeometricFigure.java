package task2;

public abstract class GeometricFigure implements IFigure {
    public String fillColor;
    public String borderColor;
    public double perimeter;
    public GeometricFigure(String borderColor, String fillColor) {
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public void printInfo(double perimeter) {
        IFigure.super.printInfo(perimeter);
    }

    protected void validatePositive(double... values) {
        for (double value : values) {
            if (value <= 0) {
                throw new IllegalArgumentException("Значение должно быть положительным: " + value);
            }
        }
    }
}