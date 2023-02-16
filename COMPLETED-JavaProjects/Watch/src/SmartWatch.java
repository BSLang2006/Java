public class SmartWatch extends Watch {
    private int batteryPercentage;

    void public setPercentage(int setPercentage) {
        batteryPercentage = setPercentage;
    }

    @Override
    void printItem() {
        System.out.println(hours + ":" + mins + " " + batteryPercentage + "%");
    }
}