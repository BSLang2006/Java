//author: Brandon S. Lang
//date:   10/5/2021
//class:  CIS 217, 2645, Java II

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class MyDate {

    private int month;
    private int day;
    private int year;
    private final int bdayMonth = 11;
    private final int bdayDay = 8;

    //default constructor
    public MyDate() {
        this.month = 10;
        this.day = 12;
        this.year = 2020;
    }

    //overloaded constructor   (Sets the instance variables)
    public MyDate(int m, int d, int y) {
        if (isDateValid(m, d, y)) {
            this.month = m;
            this.day = d;
            this.year = y;
        }
        else{
            this.month = 10;
            this.day = 12;
            this.year = 2020;
        }
   }

   //third constructor
    public MyDate(String date) {
        String[] info = date.split("/");
        int m = Integer.parseInt(info[0]);
        int d = Integer.parseInt(info[1]);
        int y = Integer.parseInt(info[2]);
        if (isDateValid(m,d,y)) {
            month = m;
            day = d;
            year = y;
        }
        else {
            this.month = 10;
            this.day = 12;
            this.year = 2020;
        }
    }
//----------------------------------------------------------------------------------
    //public helper method
    public boolean isLeapYear(int y) {
        if (y % 4 != 0) {
            return false;
        } else if (y % 400 == 0) {
            return true;
        } else if (y % 100 == 0) {
            return false;
        } else { return true; }
    }

    //private helper method
    private int getLastDayOfMonth(int m, int y) {
        int lastDayOfMonth;
        if (m != 2){
            if ((m == 4) || (m == 6) || (m == 9) || (m == 11) ){
                lastDayOfMonth = 30;
            }
            else { lastDayOfMonth = 31; }
        }
        else {
            if (isLeapYear(y)){
                lastDayOfMonth = 29;
            }
            else { lastDayOfMonth = 28;  }
        }
        return lastDayOfMonth;
    }

    //private helper method
    private boolean isDateValid (int m, int d, int y) {
        boolean dateValid = false;
        boolean monthValid;
        boolean yearValid;
        boolean dayValid;
        //day check
        if ((d < 1) || (d > getLastDayOfMonth(m,y))){
            dayValid = false;
        }
        else { dayValid = true; }
        //month check
        if ((m < 1) || (m > 12)){
            monthValid = false;
        }
        else { monthValid = true; }
        //year check
        if ((y < 0) || (y > 9999)) {
            yearValid = false;
        }
        //date check
        else { yearValid = true; }
        if (monthValid && dayValid && yearValid) {
            dateValid = true;
        }
        else { dateValid = false; }
    return dateValid;
    }

    //equals
    public boolean equals(@NotNull MyDate otherDate) {
        if ( day == otherDate.getDay() && month == otherDate.getMonth() && year == otherDate.getYear()) {
            return true;
        } else {
            return false;
        }
    }
//------------------------------------------------------------------------------------
    //accessor methods
    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getYear() { return year; }
    public boolean isMyBirthday () {

        return month == bdayMonth && day == bdayDay;
    }

    public String toString(){ return month + "/" + day + "/" + year;  }

    public String toString(int formatToSet){
        DecimalFormat df = new DecimalFormat("00");

        String[] monthLetters = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        String result = "";

        switch (formatToSet) {
            case 1:
                result = this.toString();
                break;
            case 2:
                result = df.format(month) + "/" + df.format(day) + "/" + year;
                break;
            case 3:
                result = monthLetters[month] + " " + day + ", " + year;
                break;
            case 4:
                result = monthNames[month] + " " + day + ", " + year;
        }
        return result;
    }

//---------------------------------------------------------------------------
//mutator methods
    //next day
    public void nextDay(){
        this.day++;
        if (isDateValid(this.month, this.day, this.year)){
            this.setDay(this.day);
        }
        else {
            this.day = 1;
            this.month++;}
        if (isDateValid(this.month, this.day, this.year)){
           this.setMonth((this.month));
        }
        else {
            this.month = 1;
            this.year++;
        }
    }

    //skip ahead
    public void skipAhead(int numDays) {
        for (int i = 0; i < numDays; i++){
            this.nextDay();
        }
    }
    //setters
    public void setMonth(int month) {
        if (isDateValid(month,day, year)){
            this.month = month;
        }
    }
    public void setDay(int day) {
        if (isDateValid(month, day, year)) {
            this.day = day;
        }
    }
    public void setYear(int year) {
        if (isDateValid(month, day, year)) {
            this.year = year;
        }
    }
    public void setDate (int m, int d, int y) {//sets instance variables to input parameters
        if (isDateValid(m, d, y)) {            // if all three pass isDateValid test
            this.month = m;
            this.day = d;
            this.year = y;
        }
    }
}
