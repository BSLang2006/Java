import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FileMaker {
    public static void main(String[] args) {

        //  File A
        try {
            File myObj1 = new File("C:\\CIS217\\FileMaker\\File100.txt");
            if (myObj1.createNewFile()) {
                System.out.println("File created: " + myObj1.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

 /*
        try {
            FileWriter myWriter1 = new FileWriter("File100.txt");
            for (int i = 1; i < 101; i++) {
                myWriter1.write(i + " ");
            }
            myWriter1.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            }


  */
    }

}