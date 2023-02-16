// Author: Brandon S. Lang
// Date: 11/21/21
// Class: Java 217
// Project: Final Project with JDBC


public class CovidEntry implements Comparable{
    String state;
    int month, day, dayDead, dayInfect, totDead, totInfect;

    public CovidEntry(String st, int m, int d, int di, int dd, int ti, int td){
        this.state = st;
        this.day = d;
        this.dayDead = dd;
        this.dayInfect = di;
        this.totDead = td;
        this.totInfect = ti;
        this.month = m;
    }

    //Setters
    public void setState(String state) {
        this.state = state;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setTotInfect(int totInfect) {
        this.totInfect = totInfect;
    }
    public void setDayDead(int dayDead) {
        this.dayDead = dayDead;
    }
    public void setDayInfect(int dayInfect) {
        this.dayInfect = dayInfect;
    }
    public void setTotDead(int totDead) {
        this.totDead = totDead;
    }

    //Getters
    public String getState() { return state; }
    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getDailyDeaths() { return dayDead; }
    public int getDailyInfections() { return dayInfect;  }
    public int getTotalDeaths() { return totDead; }
    public int getTotalInfections() { return totInfect; }

    @Override
    public String toString() {
        return "CovidEntry{" +
                "state='" + state + '\'' +
                ", month=" + month +
                ", day=" + day +
                ", dayDead=" + dayDead +
                ", dayInfect=" + dayInfect +
                ", totDead=" + totDead +
                ", totInfect=" + totInfect +
                '}';
    }

    public int compareTo(Object other){
        CovidEntry c = (CovidEntry) other;
        return c.getDailyDeaths() - getDailyDeaths();
    }
}
