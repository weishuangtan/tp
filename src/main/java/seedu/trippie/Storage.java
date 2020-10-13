package seedu.trippie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Storage {


    public void setup(PlaceList placeList, ExpenseList expenseList) {
        File file = new File("trippie.txt");
        Scanner readFile = Storage.startFile(file);
        assert readFile != null;
        Storage.loadList(readFile, placeList, expenseList);
    }

    public static Scanner startFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("I can't find a file in your directory :(");
                System.out.println("I created a new Trippie.txt file for you!");
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

    private void saveExpenseList(ExpenseList expenseList, FileWriter fileWriter, List<Expense> expenses)
            throws IOException {
        if (expenses.size() == 0) {
            fileWriter.write("There is currently nothing in your Expense list.");
        } else {
            fileWriter.write("These are your expenses!" + System.lineSeparator());
            fileWriter.write("Day | Item | Cost" + System.lineSeparator());
            for (Expense expense : expenses) {
                fileWriter.write(expense.getExpenseDayBought() + " | " + expense.getExpenseName()
                        + " | $" + expense.getExpenseCost() + System.lineSeparator());
            }
        }

        Float pricing = expenseList.getBudgetValue();
        if (pricing != null) {
            fileWriter.write(System.lineSeparator() + "Total budget: $" + String.format("%.2f", pricing)
                    + System.lineSeparator());
        } else {
            fileWriter.write(System.lineSeparator() + "Total budget has not been set" + System.lineSeparator());
        }

    }

    private void savePlaceList(FileWriter fileWriter, List<Place> places) throws IOException {

        if (places.size() == 0) {
            fileWriter.write("Please add your itinerary!");
        } else {
            fileWriter.write("Here is your itinerary! Enjoy your trip :)" + System.lineSeparator());
            fileWriter.write("Day | Start Time | End Time | Place" + System.lineSeparator());
            int maxDay = places.get(places.size() - 1).getPlaceDay();
            for (int i = 1; i <= maxDay; i++) {
                for (Place place : places) {
                    if (place.getPlaceDay() == i) {
                        fileWriter.write(place.getPlaceDay() + " | "
                                + String.format("%04d", place.getPlaceStartTime()) + " | "
                                + String.format("%04d", place.getPlaceEndTime()) + " | "
                                + place.getPlaceName() + System.lineSeparator());
                    }
                }
            }
        }
        fileWriter.write(System.lineSeparator());

    }

    public static void loadList(Scanner readFile, PlaceList placeList, ExpenseList expenseList) {
        List<Place> places = placeList.getPlaceList();
        List<Expense> expenses = expenseList.getExpenseList();
        while (readFile.hasNext()) {
            String line = readFile.nextLine();
            if (line.contains("Day | Start Time | End Time | Place")) {
                String input;
                input = readFile.nextLine();
                do {
                    String[] placeParameters = input.split(" \\| ");
                    places.add(new Place(placeParameters[3], Integer.parseInt(placeParameters[0]),
                            Integer.parseInt(placeParameters[1]), Integer.parseInt(placeParameters[2])));
                    input = readFile.nextLine();
                } while (!input.equals(""));
            } else if (line.contains("Day | Item | Cost")) {
                String input;
                input = readFile.nextLine();
                do {
                    String[] expenseParameters = input.split(" \\| ");
                    expenses.add(new Expense(expenseParameters[1], expenseParameters[2].substring(1),
                            expenseParameters[0]));
                    input = readFile.nextLine();
                } while (!input.equals(""));
            } else if (line.contains("Total budget: $")) {
                expenseList.setBudgetValue(extractBudgetValue(line));
            }

        }
    }

    private static Float extractBudgetValue(String userInput) throws NullPointerException, NumberFormatException {
        String budgetValueString = userInput.replace("Total budget: $","").trim();
        return Float.parseFloat(budgetValueString);
    }

}
