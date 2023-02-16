import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/*
Author:       Brandon S. Lang
Project Name: StockManager
Date:         10/25/2021
Class:        Java 217 - 2645

 */
public class StockDatabaseManager {

    public static void PrintContents(ArrayList<StockEntry> list){
        for (StockEntry s : list  ){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        StockDatabase db = new StockDatabase();
        db.readStockData("data/stock_data.csv");


        StockEntry r = db.GetHighestValue();
        ArrayList<StockEntry> l = db.getTopFiveValues();
        int under200 = db.numberOfLowsBelow200();
        StockEntry lowestOpen = db.GetLowestOpen();
        ArrayList<StockEntry> dailyLoss = db.closeLessThanOpen();

        System.out.println();
        System.out.println("Number of entries in this report: " + db.countRecords());
        System.out.println("******************************************************************");
        System.out.println("The following results are displayed using the declarative approach");
        System.out.println("******************************************************************");
        System.out.println();
        System.out.println("Day with highest value: " + r.getDate() + " with a value of: " + r.getHigh());
        System.out.println();
        System.out.println("The top five highs: ");
        PrintContents(l);
        System.out.println("");
        System.out.println("The number of days with a low below $200 is " + under200);
        System.out.println();
        System.out.println("Day with the lowest open was " + lowestOpen.getDate() + " with an opening value of " + lowestOpen.getOpen());
        System.out.println();
        System.out.println("Days with a net loss: ");
        PrintContents(dailyLoss);
        System.out.println();

        System.out.println("****************************************************************************************");
        System.out.println("The following results are displayed using streams which utilize the declarative approach");
        System.out.println("****************************************************************************************");
        System.out.println();

        //List<StockEntry> highGreaterThan100 = db.getDatabase().stream().filter(stockEntry -> stockEntry.getHigh() > 100).collect(Collectors.toList());
        //highGreaterThan100.forEach(System.out::println);

        //Highest day
        db.getDatabase().stream().max(Comparator.comparing(StockEntry::getHigh)).ifPresent(s -> {
            System.out.println("Day with highest value: " + s.getDate() + " with a value of: " + s.getHigh());
        });

        System.out.println();

        //Top 5 highs
        System.out.println("The top five highs: ");
        List<StockEntry> sortedByTopFive = db.getDatabase().stream().sorted(Comparator.comparing(StockEntry::getHigh).reversed()).limit(5).collect(Collectors.toList());
        sortedByTopFive.forEach(System.out::println);

        System.out.println();

        // Return the number of days with low below 200
        long netLoss = db.getDatabase().stream().filter(w -> w.getLow() < 200).count();
        System.out.println("The number of days with a low below $200 is " + netLoss);

        System.out.println();

        // Return the object with the lowest open
        db.getDatabase().stream().min(Comparator.comparing(StockEntry::getOpen)).ifPresent(s -> {
            System.out.println("Day with the lowest open was " + s.getDate() + " with an opening value of " + s.getOpen());
        });

        System.out.println();

        //List the days with a net loss
        System.out.println("Days with a net loss: ");
        List<StockEntry> dailyLosers = db.getDatabase().stream().filter(list -> list.getClose() < list.getOpen()).collect(Collectors.toList());
        dailyLosers.forEach(System.out::println);

        //for(StockEntry stockEntry : db.getDatabase()){ System.out.println(stockEntry); }
        //Count of days with a low below 200
    }
}

//this is code from my week 8 assignment
        /*
        //print the highest & lowest
        double highest = 0;
        double lowest = 1000;
        for(StockEntry stockEntry : db.getDatabase()){
            if(stockEntry.high > highest)
                highest = stockEntry.high;
        }
        for(StockEntry stockEntry : db.getDatabase()){
            if(stockEntry.low < lowest)
                lowest = stockEntry.low;
        }
        System.out.println("Highest high: " + highest);
        System.out.println("Lowest low: " + lowest);
        System.out.println();
        */

