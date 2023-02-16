// Author: Brandon S. Lang
// Date: 11/21/21
// Class: Java 217
// Project: Final Project with JDBC

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.sql.*;
import java.io.*;


public class CovidDatabase {

    private ArrayList<CovidEntry> CovidEntryList;
    private static final int SAFE = 5;

    public CovidDatabase() { CovidEntryList = new ArrayList<>(); }

    public ArrayList<CovidEntry> getDatabase() { return CovidEntryList; }

    public void readCovidData(String filename) {
        FileInputStream fileByteStream = null;
        Scanner scnr = null;

        try {
            fileByteStream = new FileInputStream(filename);
            scnr = new Scanner(fileByteStream);
            scnr.useDelimiter("[,\r\n]+");
            scnr.nextLine();

            while(scnr.hasNext()){
                String st = scnr.next();
                int m = scnr.nextInt();
                int d = scnr.nextInt();
                int di = scnr.nextInt();
                int dd = scnr.nextInt();
                int ti = scnr.nextInt();
                int td = scnr.nextInt();

                CovidEntry temp = new CovidEntry(st, m, d, di, dd, ti, td);
                CovidEntryList.add(temp);
            }
            System.out.println(CovidEntryList);
            fileByteStream.close();
        }
        catch(IOException e){
            System.out.println("Error with file: " + filename);
        }
    }

    public ArrayList<CovidEntry> safeToOpen(String st){
        ArrayList<CovidEntry> result = new ArrayList<>();
        int counter = 1;
        int current = 10000;
        boolean safe = false;
        for(CovidEntry entry : CovidEntryList) {
            if (entry.getState().equalsIgnoreCase(st)) {
                if (entry.getDailyInfections() < current) {
                    counter++;
                    current = entry.getDailyInfections();
                    result.add(entry);
                } else {
                    counter = 1;
                    current = entry.getDailyInfections();
                    result.clear();
                    result.add(entry);
                }
            }
            if (counter == SAFE) {
                safe = true;
                break;
            }
        }

        if (safe == true ) {
            return result;
        } else {
            return null;
        }
        }

    public CovidEntry peakDailyDeaths(String st) {
        CovidEntry result = new CovidEntry("", 0,0,0,0,0,0);
        int max = -1;
        boolean valid = false;
        for (CovidEntry entry : CovidEntryList) {
            if (entry.getState().equalsIgnoreCase(st) ){
                valid = true;
                if (entry.getDailyDeaths() > max ) {
                    max = entry.getDailyDeaths();
                    result = entry;
                }
            }
        }
        if (valid) {
            return result;
        }
        else {
            return null;
        }

    }

    public int countRecords() { return CovidEntryList.size(); }

    public int getTotalDeaths() {
        int totalDeaths = 0;
        for (CovidEntry entry : CovidEntryList ){
            totalDeaths += entry.getDailyDeaths();
        }
        return totalDeaths;
    }

    public int getTotalInfections() {
        int totalInfections = 0;
        for (CovidEntry entry : CovidEntryList ){
             totalInfections += entry.getDailyInfections();
        }
        return totalInfections;
    }

    public CovidEntry mostTotalDeaths() {
        CovidEntry result = null;
        int currentHighest = 0;
        for (CovidEntry c : CovidEntryList) {
            if (c.totDead > currentHighest) {
                currentHighest = c.totDead;
                result = c;
            }
        }
        return result;
    }

    public ArrayList<CovidEntry> listMinimumDailyInfections(int m, int d, int min) {
        ArrayList<CovidEntry> result = new ArrayList<>();
        for ( CovidEntry entry : CovidEntryList) {
            if (entry.getMonth() == m && entry.getDay() == d && entry.getDailyInfections() > min) {
                result.add(entry);
            }
        }
        return result;
    }

    public ArrayList<CovidEntry> getDailyDeaths (int m, int d){
        ArrayList<CovidEntry> result = new ArrayList<CovidEntry>();
        for ( CovidEntry entry : CovidEntryList) {
            if (entry.getMonth() == m && entry.getDay() == d ) {
                result.add(entry);
            }
        }
        return result;
    }

    public ArrayList<CovidEntry> topTenDeaths(int m, int d) {
        ArrayList<CovidEntry> allDeaths = new ArrayList<>();
        allDeaths = getDailyDeaths( m,d );
        Collections.sort(allDeaths);
        ArrayList<CovidEntry> result = new ArrayList<>();
        for ( int i = 0; i < 10 && i < allDeaths.size(); i++){
            result.add(allDeaths.get(i));
        }
        return result;
    }
    public int statesReporting() {
        int result = 0;
        ArrayList<CovidEntry> resultList = new ArrayList<>();
        for (CovidEntry entry : CovidEntryList) {
            if (!resultList.contains(entry.getState())) {


                result++;
            }
        }
            return result;
        }




    public CovidEntry peakDailyDeaths(int i, int i1) {
        CovidEntry result = new CovidEntry("", 0, 0, 0, 0, 0, 0);
        int max = -1;
        boolean valid = false;
        for (CovidEntry entry : CovidEntryList) {
            if (entry.getMonth() == i && entry.getDay() == i1) {
                valid = true;
                if (entry.getDailyDeaths() > max) {
                    max = entry.getDailyDeaths();
                    result = entry;
                }
            }
        }
        if (valid) {
            return result;
        } else {
            return null;
        }
    }
}
