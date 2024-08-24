package task2;

public abstract class GeometricFigure implements Figure {
    public String fillColor;
    public String borderColor;

    public GeometricFigure(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public void printInfo() {
        System.out.println("Цвет заливки: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
        Figure.super.printInfo();
    }
}