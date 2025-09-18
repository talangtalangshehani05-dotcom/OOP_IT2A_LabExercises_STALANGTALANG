public class LandTransport extends Transportation {
    protected int numberOfWheels;

    public LandTransport(String name, int capacity, double speed, int numberOfWheels) {
        super(name, capacity, speed);
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Wheels: " + numberOfWheels);
    }
}