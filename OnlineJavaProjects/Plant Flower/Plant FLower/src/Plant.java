public class Plant {
    protected String plantName;
    protected String price;

    //default constructor
    public Plant() {
        plantName = "No Name";
        price = "0.0";
    }

    //setters
    void setPlantName(String setPlantName) {
        plantName = setPlantName;
    }
    void setPlantCost(String setPlantCost) {
        price = setPlantCost;
    }

    @Override
    public String toString() {
        return "\nPlant Information" +
                "\n\tPlant name: " + plantName +
                "\n\tCost: $" + price;
    }

    //getters
    public String getPlantName() {
        return plantName;
    }
    public String getPlantCost() {
        return price;
    }
}

