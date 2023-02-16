import java.util.ArrayList;

public class CovidDatabaseManager {

    public static void main(String[] args) {
        CovidDatabase cdb = new CovidDatabase();
        cdb.readCovidData("covid_data.csv");

        int totalDead = cdb.getTotalDeaths();
        System.out.println("Total number of dead from Covid-19 is " + totalDead);


        /*
        ArrayList<CovidEntry> top10;
        top10 = cdb.topTenDeaths(8,10);
        for ( CovidEntry  : ){
            System.out.println(top10);
        }
        */


        int states = cdb.statesReporting();
        System.out.println("Number of states that have reported data is " + states);

        CovidEntry peakDeathsForDay = cdb.peakDailyDeaths(4,20);
        System.out.println("The state with the highest deaths for seleceted day is " + peakDeathsForDay.getState() + " with a total of " + peakDeathsForDay.getDailyDeaths() + " dead");
        }
    }