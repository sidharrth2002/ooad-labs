public class Medicine {
    private String name;
    private double packagingQuantity;
    private String ID;
    private static int count = 0;

    public Medicine() {
        this.name = "Unknown";
        this.packagingQuantity = 0;
        this.ID = "M" + ++count;
    }

    public Medicine(String name, double packagingQuantity) {
        this.name = name;
        this.packagingQuantity = packagingQuantity;
        this.ID = "M" + ++count;
    }

    //getters and setters
    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        this.ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPackagingQuantity() {
        return packagingQuantity;
    }

    public void setPackagingQuantity(double packagingQuantity) {
        this.packagingQuantity = packagingQuantity;
    }

    //returns a pretty representation
    @Override
    public String toString() {
        return "Medicine ID: " + getID() + "\nName: " + getName() + "\nPackaging Quantity: " + getPackagingQuantity();
    }
}