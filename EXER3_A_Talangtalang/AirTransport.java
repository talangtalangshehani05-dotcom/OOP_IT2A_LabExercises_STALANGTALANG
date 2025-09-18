public class AirTransport extends Transportation {
    protected double maxAltitude; // in feet

    public AirTransport(String name, int capacity, double speed, double maxAltitude) {
        super(name, capacity, speed); // Calls the parent constructor
        this.maxAltitude = maxAltitude;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Displays parent info first
        System.out.println("Max Altitude: " + maxAltitude + " ft");
    }
}

