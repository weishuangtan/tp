package seedu.trippie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {


    public void setup(PlaceList placeList, ExpenseList expenseList) {
        File file = new File("trippie.txt");
        Scanner readFile = Storage.startFile(file);
        assert readFile != null;
        //Storage.loadList(readFile,tasks);
    }

    public static Scanner startFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("I can't find a file in your directory :(");
                System.out.println("I created a file for you here!\n" + "File location: " + file.getAbsolutePath());
            } else if (!file.createNewFile()) {
                System.out.println("I found a file in your directory!\nSetting up file over here...");
            }
            return new Scanner(file);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    public void saveList() throws IOException {
        FileWriter fileWriter = new FileWriter("trippie.txt");
        fileWriter.write("Here is the collated list of your tasks:" + System.lineSeparator());
        fileWriter.close();
    }

    public void loadList() {
    }
}
