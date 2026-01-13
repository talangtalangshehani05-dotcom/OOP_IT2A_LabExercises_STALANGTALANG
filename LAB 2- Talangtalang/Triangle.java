public class Triangle extends Shape {

    private double b;
    private double h;

    public Triangle(double b, double h) {
        this.b = b;
        this.h = h;
    }

    @Override
    public void calculateArea() {
        double total = (b * h) / 2;
        System.out.println("Triangle area result: " + total);
    }
}