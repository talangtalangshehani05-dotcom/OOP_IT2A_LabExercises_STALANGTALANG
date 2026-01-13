public class Square extends Shape {

    private double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public void calculateArea() {
        double total = edge * edge;
        System.out.println("Square area result: " + total);
    }
}