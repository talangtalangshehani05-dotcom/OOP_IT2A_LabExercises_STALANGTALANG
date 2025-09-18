public class TransportationTester {
    public static void main(String[] args) {
        System.out.println("--- Air Transport ---");
        Helicopter heli = new Helicopter(4, 240);
        heli.displayInfo();

        System.out.println("\n---");
        Airplane plane = new Airplane(180, 880);
    

        System.out.println("\n---");
        SpaceShuttle shuttle = new SpaceShuttle(7, 28000);
        shuttle.displayInfo();

        System.out.println("\n--- Land Transport ---");
        Truck truck = new Truck(3, 110);
        truck.displayInfo();

        System.out.println("\n---");
        SUV suv = new SUV(7, 180);
        suv.displayInfo();

        System.out.println("\n---");
        Tricycle trike = new Tricycle(4, 50);
        trike.displayInfo();

        System.out.println("\n---");
        Motorcycle motor = new Motorcycle(2, 120);
        motor.displayInfo();

        System.out.println("\n---");
        Kariton kariton = new Kariton(1);
        kariton.displayInfo();

        System.out.println("\n--- Water Transport ---");
        Ferry ferry = new Ferry(500, 30);
        ferry.displayInfo();

        System.out.println("\n---");
        Submarine sub = new Submarine(150, 46);
        sub.displayInfo();
    }
}