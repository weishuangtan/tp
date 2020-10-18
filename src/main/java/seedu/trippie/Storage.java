package seedu.trippie;

import seedu.trippie.data.Expense;
import seedu.trippie.data.ExpenseList;
import seedu.trippie.data.Place;
import seedu.trippie.data.PlaceList;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TripList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    private final String MASTER_DIRECTORY = "trippie_data";
    private final String MASTER_FILE_NAME = "trippie.txt";
    private final String MASTER_FILE_PATH = MASTER_DIRECTORY + File.separator + MASTER_FILE_NAME;
    private final String FILE_EXTENSION = ".txt";

    public void setupMasterFile(TripList tripList) {
        File file = new File(MASTER_FILE_PATH);
        Scanner readFile = findFile(file);
        loadMasterFile(readFile, tripList);
    }

    public Scanner findFile(File file) {
        try {
            // Code referenced from
            // https://stackoverflow.com/questions/2833853/create-whole-path-automatically-when-writing-to-a-new-file
            Files.createDirectories(Path.of(file.getPath()).getParent());

            if (file.createNewFile()) {
                System.out.println("I can't find a file in your directory :(");
                System.out.println("I created a new " + file.getPath() + " file for you!");

            } else if (!file.createNewFile()) {
                System.out.println("I found a file in your directory!\nSetting up the file now...");
            }

            return new Scanner(file);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This method saves a tripList object to a single master txt file.
     *
     * Each line in the master file stores a trip in the following format:
     * TRIP_INDEX,TRIP_NAME,TRIP_DATE
     *
     * @param tripList The tripList object to be saved.
     */
    public void saveMasterFile(TripList tripList) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(MASTER_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter finalFileWriter = fileWriter;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        tripList.getTripList().stream().forEach(trip -> {
            try {
                finalFileWriter.write(
                        Integer.toString(trip.getIndex()) + ","
                        + trip.getName() + ","
                        + df.format(trip.getStartDate()) + "\n"
                );
            } catch (IOException e) {
                System.out.println("Error occured when saving Master File.");
                e.printStackTrace();
            }
        });


        try {
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Encountered a problem when closing file.");
            e.printStackTrace();
        }
    }

    public void saveTrip(Trip trip) throws IOException {
        String path = MASTER_DIRECTORY + File.separator + trip.getName() + FILE_EXTENSION;
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(
                "This file shows your saved trips under Trippie!"
                        + System.lineSeparator()
                        + System.lineSeparator()
        );

        savePlaceList(fileWriter, trip.getPlaceListObject());
        saveExpenseList(fileWriter, trip.getExpenseListObject());

        fileWriter.close();
    }

    private void saveExpenseList(FileWriter fileWriter, ExpenseList expenseList) throws IOException {


        if (expenseList.getExpenseList().size() == 0) {
            fileWriter.write("There is currently nothing in your Expense list.");
        } else {
            fileWriter.write("These are your expenses!" + System.lineSeparator());
            fileWriter.write("Day | Item | Cost" + System.lineSeparator());
            for (Expense expense : expenseList.getExpenseList()) {
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

    private void savePlaceList(FileWriter fileWriter, PlaceList placeList) throws IOException {

        if (placeList.getPlaceList().size() == 0) {
            fileWriter.write("Please add your itinerary!");
        } else {
            fileWriter.write("Here is your itinerary! Enjoy your trip :)" + System.lineSeparator());
            fileWriter.write("Day | Start Time | End Time | Place" + System.lineSeparator());

            int maxDay = placeList.getMaxDay();

            for (int i = 1; i <= maxDay; i++) {
                for (Place place : placeList.getPlaceList()) {
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

    public Trip loadTrip(String tripName) {
        File file = new File(MASTER_DIRECTORY + File.separator + tripName + FILE_EXTENSION);
        Scanner readFile = findFile(file);

        Trip trip = new Trip();

        List<Place> places = trip.getPlaceListObject().getPlaceList();
        List<Expense> expenses = trip.getExpenseListObject().getExpenseList();
        while (readFile.hasNext()) {
            String line = readFile.nextLine();
            if (line.contains("Day | Start Time | End Time | Place")) {
                String input;
                input = readFile.nextLine();

                do {
                    String[] placeParameters = input.split(" \\| ");
                    places.add(new Place(
                            placeParameters[3],
                            Integer.parseInt(placeParameters[0]),
                            Integer.parseInt(placeParameters[1]),
                            Integer.parseInt(placeParameters[2]))
                    );
                    input = readFile.nextLine();
                } while (!input.equals(""));

            } else if (line.contains("Day | Item | Cost")) {
                String input;
                input = readFile.nextLine();

                do {
                    String[] expenseParameters = input.split(" \\| ");
                    expenses.add(new Expense(
                            expenseParameters[1],
                            expenseParameters[2].substring(1),
                            expenseParameters[0])
                    );
                    input = readFile.nextLine();
                } while (!input.equals(""));

            } else if (line.contains("Total budget: $")) {
                trip.getExpenseListObject().setBudgetValue(extractBudgetValue(line));
            }
        }
        trip.setExpenseList(new ExpenseList(expenses));
        trip.setPlaceList(new PlaceList(places));

        return trip;
    }

    private Float extractBudgetValue(String userInput) throws NullPointerException, NumberFormatException {
        String budgetValueString = userInput.replace("Total budget: $","").trim();
        return Float.parseFloat(budgetValueString);
    }

    public void loadMasterFile(Scanner readFile, TripList tripList) {
        List<Trip> parsedTripList = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        while (readFile.hasNext()) {
            String line = readFile.nextLine();
            String[] parameters = line.split(",");

            try {
                parsedTripList.add(
                        new Trip(
                                Integer.parseInt(parameters[0]),
                                parameters[1],
                                df.parse(parameters[2])
                        )
                );
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        tripList.setTripList(parsedTripList);
    }

}
