public class ElectronicWaste extends Residual {
    public ElectronicWaste(String itemName, double weight) {
        super(itemName, weight);
    }

    // Override the dispose method again for special instructions
    @Override
    public void dispose() {
        System.out.println("⚠️ HAZARDOUS! DISPOSAL: Do NOT mix with regular trash. Bring to a designated e-waste collection facility.");
    }
}