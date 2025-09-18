public class Residual extends Waste {
    public Residual(String itemName, double weight) {
        super(itemName, weight);
    }

    @Override
    public void dispose() {
        System.out.println("🗑️ DISPOSAL: Bag securely and wait for local waste collection for landfill disposal.");
    }
}