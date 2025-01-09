package lesson_5;

abstract class GeometricFigure implements Geometrical {
    String backgroundColor;
    String borderColor;

    public GeometricFigure(String backgroundColor, String borderColor) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    public void printParameters() {
        System.out.println("Цвет заливки: " + backgroundColor);
        System.out.println("Цвет границ: " + borderColor);
    }
}
