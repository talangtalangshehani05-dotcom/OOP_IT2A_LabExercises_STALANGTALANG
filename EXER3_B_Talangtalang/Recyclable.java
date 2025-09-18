public class Recyclable extends Waste {
    private String materialType;

    public Recyclable(String itemName, double weight, String materialType) {
        super(itemName, weight); // Calls the constructor of the Waste class
        this.materialType = materialType;
    }

    @Override
    public void dispose() {
        System.out.println("✅ DISPOSAL: Clean and segregate for recycling. Send to a materials recovery facility.");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Material: " + this.materialType);
    }
}