public class Waste {
    protected String itemName;
    protected double weight; 

    public Waste(String itemName, double weight) {
        this.itemName = itemName;
        this.weight = weight;
    }

    public void dispose() {
        System.out.println("Disposing of " + itemName + ". Please check specific disposal guidelines.");
    }

    
    public void displayInfo() {
        System.out.println("Item: " + itemName);
        System.out.println("Weight: " + weight + " kg");
    }
}