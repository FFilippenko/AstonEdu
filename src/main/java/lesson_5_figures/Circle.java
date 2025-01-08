package lesson_5_figures;

public class Circle extends GeometricFigure {
    double r;

    public double perimeter() {
        return 2 * Math.PI * r;
    }

    public double square() {
        return Math.PI * Math.pow(r, 2);
    }

    public Circle(String backgroundColor, String borderColor, double r) {
        super(backgroundColor, borderColor);
        this.r = r;
    }

    public void printParameters() {
        System.out.println("ПАРАМЕТРЫ КРУГА");
        super.printParameters();
        System.out.println("Периметр круга: " + perimeter());
        System.out.println("Площадь круга: " + square());
    }
}