public class Rectangle extends Shape {

    private double len;
    private double wid;

    public Rectangle(double len, double wid) {
        this.len = len;
        this.wid = wid;
    }

    @Override
    public void calculateArea() {
        double total = len * wid;
        System.out.println("Rectangle area result: " + total);
    }
}