public class ShapeTester {

    public static void main(String[] args) {

        Shape r = new Rectangle(9, 6);
        Shape s = new Square(5);
        Shape t = new Triangle(4, 7);
        Shape c = new Circle(6);

        r.calculateArea();
        s.calculateArea();
        t.calculateArea();
        c.calculateArea();
    }
}
