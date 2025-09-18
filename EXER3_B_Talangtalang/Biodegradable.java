public class Biodegradable extends Waste {
    public Biodegradable(String itemName, double weight) {
        super(itemName, weight);
    }

    @Override
    public void dispose() {
        System.out.println("🌱 DISPOSAL: Place in a compost bin or bury in a compost pit.");
    }
}