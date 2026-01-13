public class Circle extends Shape {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public void calculateArea() {
        double total = Math.PI * Math.pow(r, 2);
        System.out.println("Circle area result: " + total);
    }
}