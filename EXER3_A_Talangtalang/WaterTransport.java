public class WaterTransport extends Transportation {
    protected String propulsionType; // e.g., "Sail", "Engine"

    public WaterTransport(String name, int capacity, double speed, String propulsionType) {
        super(name, capacity, speed);
        this.propulsionType = propulsionType;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Propulsion: " + propulsionType);
    }
}
