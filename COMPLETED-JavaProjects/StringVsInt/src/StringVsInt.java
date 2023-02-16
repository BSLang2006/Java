import java.util.Scanner;
import java.util.InputMismatchException;

public class StringVsInt {
    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);

        int age;
        String name;

        name = myScan.next();
        while (!name.equals("-1")) {
           try {
                age = myScan.nextInt();
                System.out.println(name + " " + (age + 1));
           }
           catch (Exception e){
               myScan.nextLine();
               age = 0;
               System.out.println(name + " " + age);
            }
           name = myScan.next();
        }
    }
}
