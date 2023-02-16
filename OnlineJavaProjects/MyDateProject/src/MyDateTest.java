//author: Brandon S. Lang
//date:   10/5/2021
//class:  CIS 217, 2645, Java II

public class MyDateTest {
    public static void main (String [] args) {
        int totalLeapYears = 0;
        int datesThatAreEqual = 0;
        System.out.println ("Testing begins");
        System.out.println("");

        //********** phase 1 testing ************
        // testing the default constructor
        MyDate today = new MyDate();
        if (today.getMonth() != 10){
            System.out.println("month should be 10");
        }
        if (today.getDay() != 12){
            System.out.println("day should be 12");
        }

        // TO DO: test the year
        if (today.getYear() != 2020){
            System.out.println("year should be 2020");
        }
        System.out.println("The default date is: " + today);
        //test next day
        System.out.println("Today is: " + today);
        today.nextDay();
        System.out.println("Tomorrow is : " + today);
        today.skipAhead(33);
        System.out.println("32 days from now: " + today);
        today.skipAhead(64);
        System.out.println("Add 64 days: " + today);
        today.nextDay();
        System.out.println("Next day: " + today);

        // testing constructor 2
        MyDate theDay = new MyDate(1, 10, 1995);

        // Test Birthday
        System.out.println("");
        System.out.println("Testing for birthday");
        System.out.println("--------------------");
        today.equals(today.isMyBirthday());
        System.out.println("Is " + today + " my birthday?: " + today.isMyBirthday());
        today.setDay(8);
        today.setMonth(11);
        System.out.println("Is " + today + " my birthday?: " + today.isMyBirthday());

        // TO DO: test the toString method
        System.out.println();
        System.out.println("Testing date formats");
        System.out.println("--------------------");
        System.out.println("Format 1: " + today.toString(1));
        System.out.println("Format 2: " + today.toString(2));
        System.out.println("Format 3: " + today.toString(3));
        System.out.println("Format 4: " + today.toString(4));

        //test leap year
        MyDate leapTester = new MyDate(1,1,1);
        int testYear = 1;
        for (int i =0; i < theDay.getYear(); i++) {
            testYear++;
            if (leapTester.isLeapYear(testYear)) {
                totalLeapYears++;
            }
        }
        System.out.println("");
        System.out.println("Testing leap year");
        System.out.println("-----------------");
        System.out.println("Number of observed leap years in the common era: " + totalLeapYears);
        System.out.println("Is 1900 a leap year? " + today.isLeapYear(1900));
        System.out.println("Is 2000 a leap year? " + today.isLeapYear(2000));

        //test equals
        System.out.println("");
        System.out.println("Testing for equal dates");
        System.out.println("-----------------------");

        MyDate eT1 = new MyDate(10, 12, 2020);
        MyDate eT2 = new MyDate(10, 12, 2020);
        MyDate eT3 = new MyDate(1, 1, 1);

        if ( eT1.equals(eT2)) {
            System.out.println(eT1.toString() + " is equal to " + eT2.toString());
            datesThatAreEqual++;
        }
        else { System.out.println(eT1.toString() + " is not equal to " + eT2.toString()); }

        if ( eT1.equals(eT3)) {
            System.out.println(eT1.toString() + " is equal to " + eT3.toString());
            datesThatAreEqual++;
        }
        else { System.out.println(eT1.toString() + " is not equal to " + eT3.toString()); }

        System.out.println("Number of dates that are equal: " + datesThatAreEqual);
        System.out.println("");
        System.out.println("today: " + today);
        System.out.println("theDay: " + theDay);
        System.out.println("");

        System.out.println ("Testing ends");
        System.out.println("Thank you for using the MyDate class");
    }
}
