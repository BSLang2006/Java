// Challenge: Create a class that first creates a file and then populates the file

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class CreateFileAndWrite {

    private ArrayList<BuildParameters> database;

    public CreateFileAndWrite() {
        database = new ArrayList<BuildParameters>();
    }
    public ArrayList<BuildParameters> getDatabase() { return database; }

  }
