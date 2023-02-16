import java.io.*;
import java.util.Scanner;


public class MultiThreadLab {



    public static void main(String[] args) {

        // Create Tasks ... Build Race Car
        //Runnable printA = new PrintChar();


        // Create Threads ... Race the Car
        //Thread thread1 = new Thread(PrintA);

        // Start Threads
        //thread1.start();


        File fileToCaputre = new File("File100.txt");
        try {
            FileInputStream fis = new FileInputStream(fileToCaputre);
            int oneByte;
            while ((oneByte = fis.read()) != -1) {
                System.out.write(oneByte);
                // System.out.print((char)oneByte); // could also do this
            }
            System.out.flush();
        } catch ( );

    }



    }
