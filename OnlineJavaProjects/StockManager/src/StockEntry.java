/*
Author:       Brandon S. Lang
Project Name: StockManager
Date:        10/25/2021
Class:        Java 217 - 2645

 */
public class StockEntry implements Comparable{
    String date;
    double open, high, low, close;

    public StockEntry(String date, double open, double high, double low, double close){
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    //setters
    public void setDate(String date) {
        this.date = date;
    }
    public void setOpen(double open) {
        this.open = open;
    }
    public void setHigh(double high) {
        this.high = high;
    }
    public void setLow(double low) {
        this.low = low;
    }
    public void setClose(double close) {
        this.close = close;
    }

    //getters
    public double getOpen() { return open; }
    public double getHigh() { return high; }
    public double getLow() { return low; }
    public double getClose() { return close; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return  "Date " + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close ;
    }
    public int compareTo(Object other){
        StockEntry s = (StockEntry) other;
        return (int)s.getHigh() - (int)high;
    }
}
