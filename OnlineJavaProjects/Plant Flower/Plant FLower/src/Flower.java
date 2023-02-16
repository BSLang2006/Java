public class Flower extends Plant{
    private boolean annual;
    private String color;

    public Flower() {
        super();
        annual = false;
        color = "TBD";
    }

    void setPlantType(boolean setAnnual){
        annual = setAnnual;
    }
    void setColorOfFlowers(String setColor){
        color = setColor;
    }
    public String getColorOfFlowers(){
        return color;
    }
    public Boolean getPlantType(){
        return annual;
    }

    @Override
    public String toString() {
        return  super.toString() + "\n\tAnnual: " + annual +
                "\n\tColor of flowers: " + color;

    }
}
