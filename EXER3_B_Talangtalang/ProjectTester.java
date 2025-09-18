public class ProjectTester {
    public static void main(String[] args) {
        System.out.println("--- Proper Waste Disposal System ---");

        // 1. Recyclable Waste
        System.out.println("\n--- RECYCLABLE ---");
        PlasticBottle bottle = new PlasticBottle("Soda Bottle", 0.1);
        bottle.displayInfo();
        bottle.dispose();

        // 2. Biodegradable Waste
        System.out.println("\n--- BIODEGRADABLE ---");
        FoodScraps scraps = new FoodScraps("Vegetable Peelings", 0.5);
        scraps.displayInfo();
        scraps.dispose();

        // 3. Residual Waste
        System.out.println("\n--- RESIDUAL ---");
        UsedDiaper diaper = new UsedDiaper("Used Baby Diaper", 0.2);
        diaper.displayInfo();
        diaper.dispose();

        // 4. Special Hazardous Residual Waste (E-Waste)
        System.out.println("\n--- SPECIAL RESIDUAL (HAZARDOUS) ---");
        ElectronicWaste oldPhone = new ElectronicWaste("Broken Smartphone", 0.3);
        oldPhone.displayInfo();
        oldPhone.dispose(); // This calls the most specific 'dispose' method
    }
}
