public class Car {
    private String brand;
    private String origin;
    private String plateNo;
    private String chassisNo;
    private double price;
    private double speed;   // keep speed

    // No-argument constructor
    public Car() {
        this.brand = "Unknown";
        this.origin = "Unknown";
        this.plateNo = "No PlateNumber";
        this.chassisNo = "No Chassis No Yet!";
        this.price = 0.0;
        this.speed = 0.0;
    }

    // Parameterized constructor
    public Car(String brand, String origin, String plateNo, 
               String chassisNo, double price, double speed) {
        this.brand = brand;
        this.origin = origin;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
        this.price = price;
        this.speed = speed;
    }

    // Method to display car information
    public void displayInfo() {
        String info = "";
        info += "Brand: " + this.brand;
        info += "\nOrigin: " + this.origin;
        info += "\nPlateNo: " + this.plateNo;
        info += "\nChassisNo: " + this.chassisNo;
        info += "\nPrice: " + this.price;
        info += "\nSpeed: " + this.speed + " km/h";

        System.out.println(info);
        System.out.println("-----------------------------");
    }
}
