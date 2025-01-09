package lesson_5;

public class Triangle extends GeometricFigure {
    double a;
    double b;
    double c;

    public double halfPerimeter() {
        return (a + b + c) / 2;
    }

    public double perimeter() {
        return halfPerimeter() * 2;
    }

    public double square() {
        double hp = halfPerimeter();
        return Math.sqrt(hp * (hp - a) * (hp - b) * (hp - c));
    }

    public Triangle(String backgroundColor, String borderColor, double a, double b, double c) {
        super(backgroundColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void printParameters() {
        System.out.println("ПАРАМЕТРЫ ТРЕУГОЛЬНИКА");
        super.printParameters();
        System.out.println("Периметр треугольника: " + perimeter());
        System.out.println("Площадь треугольника: " + square());
    }
}
