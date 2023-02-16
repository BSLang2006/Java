import java.util.ArrayList;

public class WatchManager {
    public static void main(String[] args) {
        SmartWatch watch1;
        SmartWatch watch2;
        Watch watch3;

        ArrayList<Watch> watchList = new ArrayList<Watch>();
        int i;

        watch1 = new SmartWatch();
        watch1.setHours(5);
        watch1.setMins(32);
        watch1.setPercentage(10);

        watch2 = new SmartWatch();
        watch2.setHours(17);
        watch2.setMins(49);
        watch2.setPercentage(65);

        watch3 = new Watch();
        watch3.setHours(6);
        watch3.setMins(25);

        watchList.add(watch1);
        watchList.add(watch3);
        watchList.add(watch2);

        for(i = 0; i < watchList.size(); ++i) {
            watchList.get(i).printItem();
        }

        /* Modified For Loop
        for( Watch watch : watchList){
            watch.printItem();
        }

        */
    }
}