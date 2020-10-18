package seedu.trippie;

import seedu.trippie.command.Command;
import seedu.trippie.data.ExpenseList;
import seedu.trippie.data.PlaceList;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TripList;

import java.io.IOException;

public class Trippie {
    private final Ui ui;
    private ExpenseList expenseList;
    private PlaceList placeList;
    private TripList tripList;
    private final Storage storage;
    private Trip currentTrip;
    public static int currentTripIndex;
    public static boolean isFirstRun;

    public Trippie() {
        ui = new Ui();
        storage = new Storage();
        tripList = new TripList();
        currentTrip = null;
        currentTripIndex = 0;
        isFirstRun = true;
    }

    public static void main(String[] args) {
        new Trippie().run();
    }

    public void run() {
        ui.greetUser();
        boolean isExit = false;
        storage.setupMasterFile(tripList);
        currentTrip = null; // TODO: store default value of trips
        System.out.println(tripList.list()); // For debugging purposes

        while (!isExit) {
            if (isFirstRun) {
                System.out.println("Please create a new trip first by entering the command 'new trip'!");
                isFirstRun = false;
            }

            String fullCommand = ui.readCommand();
            ui.printLine();
            Command c = Parser.parse(fullCommand);
            if (c != null) {
                // TODO: don't load on each command execution
                currentTrip = tripList.getTripList().get(currentTripIndex);
                Trip tempTrip = storage.loadTrip(currentTrip.getName());
                currentTrip.setPlaceList(tempTrip.getPlaceListObject());
                currentTrip.setExpenseList(tempTrip.getExpenseListObject());

                c.execute(ui, currentTrip, tripList);
                isExit = c.isExit();
            }

            try {
                storage.saveTrip(currentTrip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            storage.saveMasterFile(tripList);
            ui.printLine();
        }
    }
}
