package lesson_5;

public class Rectangle extends GeometricFigure {
    double a;
    double b;

    public double perimeter() {
        return (a + b) * 2;
    }

    public double square() {
        return a * b;
    }

    public Rectangle(String backgroundColor, String borderColor, double a, double b) {
        super(backgroundColor, borderColor);
        this.a = a;
        this.b = b;
    }

    public void printParameters() {
        System.out.println("ПАРАМЕТРЫ ПРЯМОУГОЛЬНИКА");
        super.printParameters();
        System.out.println("Периметр прямоугольника: " + perimeter());
        System.out.println("Площадь прямоугольника: " + square());
    }
}


