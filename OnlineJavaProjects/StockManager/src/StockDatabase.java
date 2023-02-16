/*
Author:       Brandon S. Lang
Project Name: StockManager
Date:         10/25/2021
Class:        Java 217 - 2645

 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

public class StockDatabase {

    private ArrayList<StockEntry> database;

    public StockDatabase() {
        database = new ArrayList<StockEntry>();
    }

    public ArrayList<StockEntry> getDatabase() {
        return database;
    }

    // Return object with the highest high
    public StockEntry GetHighestValue(){
        StockEntry result = null;
        double max = 0;
        for(StockEntry s : database){
            if ( s.getHigh() > max ){
                max = s.getHigh();
                result = s;
            }
        }
        return result;
    }
    // Return object with the lowest open
    public StockEntry GetLowestOpen(){
        StockEntry result = null;
        double minOpen = 1000;
        for(StockEntry s : database){
            if ( s.getOpen() < minOpen ){
                minOpen = s.getOpen();
                result = s;
            }
        }
        return result;
    }
    // Return a sublist of the 5 highest values
    public ArrayList<StockEntry> getTopFiveValues(){
        ArrayList<StockEntry> result = new ArrayList<StockEntry>();
        ArrayList<StockEntry> list = database;
        Collections.sort(list);
        for ( int i = 0; i < 5; i++){
            result.add(list.get(i));
        }
        return result;
    }
    // Return a sublist of the days when close was less than the open
    public ArrayList<StockEntry> closeLessThanOpen(){
        ArrayList<StockEntry> result = new ArrayList<StockEntry>();
        ArrayList<StockEntry> list = database;
        for(StockEntry s : database)
        if ( s.getClose() < s.getOpen()){
            result.add(s);
        }
        return result;
    }

    // Return the number of record with a low below 200
    public int numberOfLowsBelow200(){
        int sub200Lows = 0;
        for(StockEntry s : database){
            if (s.getLow() < 200){
                sub200Lows++;
            }
        }
        return sub200Lows;
    }

    public void readStockData(String filename){
        FileInputStream fileByteStream = null;
        Scanner scnr = null;
        try{
            //open file & set delimeters
            fileByteStream = new FileInputStream(filename);
            scnr = new Scanner(fileByteStream);
            scnr.useDelimiter("[,\r\n]+");
            scnr.nextLine();
            while(scnr.hasNext()){
                String date = scnr.next();
                double open = scnr.nextDouble();
                double high = scnr.nextDouble();
                double low = scnr.nextDouble();
                double close = scnr.nextDouble();
                StockEntry temp = new StockEntry( date, open, high, low, close );
                database.add(temp);
            }
            fileByteStream.close();
        }
        catch(IOException error1){
            System.out.println("Error with file " + filename);
        }
    }
    public int countRecords(){
        return database.size();
    }
}
