public class Transportation {
    protected String name;
    protected int capacity;
    protected double speed; // speed in km/h

    public Transportation(String name, int capacity, double speed) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
    }

    public void displayInfo() {
        System.out.println("Type: " + name);
        System.out.println("Capacity: " + capacity + " people");
        System.out.println("Speed: " + speed + " km/h");
    }
}