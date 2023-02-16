import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GardenManager {
    private ArrayList<Plant> myGarden;

    public GardenManager() {
        myGarden = new ArrayList<>();
    }

    public void addPlant(Plant newPlant) {
        myGarden.add(newPlant);
    }

    public void printArrayList() {
        for (Plant plant : myGarden) {
            System.out.println(plant);
        }
    }

    public ArrayList<Plant> getMyGardenList() {
        return myGarden;
    }

    //----------MAIN----------------------------
    public static void main(String[] args) {
        //keep
        GardenManager g = new GardenManager();

//getting user input
        Scanner scanTool = new Scanner(System.in);
        String plantDetails;
        System.out.println("Enter plant information: ");
        plantDetails = scanTool.nextLine();
        String[] parsedDetails;
        parsedDetails = plantDetails.split(" ");

        while (!Objects.equals(parsedDetails[0], "-1")) {
            if (Objects.equals(parsedDetails[0], "plant")) {
                Plant tempPlant = new Plant();
                tempPlant.setPlantName(parsedDetails[1]);
                tempPlant.setPlantCost(parsedDetails[2]);
                g.addPlant(tempPlant);
            }
            else if (Objects.equals(parsedDetails[0], "flower")) {
                Flower tempFlower = new Flower();
                tempFlower.setPlantName(parsedDetails[1]);
                tempFlower.setPlantCost(parsedDetails[2]);
                if (Objects.equals(parsedDetails[3], "true")) {
                    tempFlower.setPlantType(true);
                }
                else {
                    tempFlower.setPlantType(false);
                }
                tempFlower.setPlantType(tempFlower.getPlantType());
                tempFlower.setColorOfFlowers(parsedDetails[4]);
                g.addPlant(tempFlower);
            }
            plantDetails = scanTool.nextLine();
            parsedDetails = plantDetails.split(" ");

        }
        //print output to screen
        g.printArrayList();
    }
}

