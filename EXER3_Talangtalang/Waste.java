public class Waste {
    private static int counter = 1;

    private int wasteId;
    private String name;
    private String type;
    private String description;

    // Constructor with name and type
    public Waste(String name, String type) {
        this.wasteId = counter++;
        this.name = name;
        this.type = type;
        this.description = "This is " + type.toLowerCase() + " waste named " + name + ".";
    }

    // Getters
    public int getWasteId() {
        return wasteId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    // Setters (if needed)
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}