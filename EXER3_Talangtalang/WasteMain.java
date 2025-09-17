import java.util.Scanner;

public class WasteMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to store 3 wastes
        Waste[] wastes = new Waste[3];

        // Input details from user
        for (int i = 0; i < wastes.length; i++) {
            System.out.println("\nEnter details for Waste " + (i + 1));

            System.out.print("Enter Waste Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Waste Type (Recyclable, Biodegradable, Hazardous): ");
            String type = scanner.nextLine();

            // Create Waste object with auto-generated description
            wastes[i] = new Waste(name, type);
        }

        // Display all waste details
        System.out.println("\n--- Waste Details ---");
        for (int i = 0; i < wastes.length; i++) {
            System.out.println("Waste " + (i + 1) + ": "
                    + wastes[i].getName() + " | "
                    + wastes[i].getType() + " | "
                    + wastes[i].getDescription());
        }

        scanner.close();
    }
}