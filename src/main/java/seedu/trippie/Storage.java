package seedu.trippie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public void saveList(PlaceList placeList, ExpenseList expenseList) throws IOException {
        FileWriter fileWriter = new FileWriter("trippie.txt");
        fileWriter.write("This file shows your saved trip under Trippie!" + System.lineSeparator()
                + System.lineSeparator());

        List<Place> places = placeList.getPlaceList();
        List<Expense> expenses = expenseList.getExpenseList();
        savePlaceList(fileWriter, places);
        saveExpenseList(expenseList, fileWriter, expenses);


        fileWriter.close();
    }

    private void saveExpenseList(ExpenseList expenseList, FileWriter fileWriter, List<Expense> expenses) throws IOException {
        if (expenses.size() == 0) {
            fileWriter.write("There is currently nothing in your Expense list.");
        } else {
            int listIndex = 1;
            Float pricing = expenseList.getBudgetValue();
            if (pricing != null) {
                fileWriter.write("Total budget: $" + String.format("%.2f", pricing) + System.lineSeparator());
            } else {
                fileWriter.write("Total budget has not been set" + System.lineSeparator());
            }
            fileWriter.write("Expense List:" + System.lineSeparator());
            for (Expense expense: expenses) {
                fileWriter.write("[" + listIndex + "] " + expense.getExpense() + System.lineSeparator());
                listIndex++;
            }
        }
    }

    private void savePlaceList(FileWriter fileWriter, List<Place> places) throws IOException {
        if (places.size() == 0) {
            fileWriter.write("Please add your itinerary!");
        } else {
            fileWriter.write("Here is your itinerary! Enjoy your trip :)" + System.lineSeparator());
            int maxDay = places.get(places.size() - 1).getPlaceDay();
            for (int i = 1; i <= maxDay; i++) {
                fileWriter.write("DAY " + i + ":" + System.lineSeparator());
                for (int j = 0; j < places.size(); j++) {
                    if (places.get(j).getPlaceDay() == i) {
                        fileWriter.write((j + 1) + ". ");
                        fileWriter.write(places.get(j).getPlace() + System.lineSeparator());
                    }
                }
                fileWriter.write(System.lineSeparator());
            }
        }
    }

    public void loadList() {
    }
}
