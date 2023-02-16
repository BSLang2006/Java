import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    public static void main(String[] args) {

        Scanner myScan = new Scanner(System.in);
        int numberOfFiles;
        int numberOfEntries;
        String charToEnter;
        String pathToCreate = "C:\\CIS217\\FileWriter\\src\\";
        String filename;
        Boolean isChar;

        System.out.println();
        System.out.println("Welcome to the file creation and population tool.");
        System.out.println();
        System.out.println("First, enter the number of files to create and then follow the prompts to create your files ");
        System.out.println();
        System.out.println("Number of files to create: ");
        numberOfFiles = myScan.nextInt();
        System.out.println();
        System.out.println("Number of iterations in each file: ");
        numberOfEntries = myScan.nextInt();
        System.out.println();

        CreateFileAndWrite db = new CreateFileAndWrite();
        db.r


    }
}
