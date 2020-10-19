package seedu.trippie;

import seedu.trippie.command.Command;
import seedu.trippie.data.ExpenseList;
import seedu.trippie.data.PlaceList;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;

import java.io.IOException;

public class Trippie {
    private final Ui ui;
    private TrippieData trippieData;
    private final Storage storage;
    private Trip currentTrip;
    public static int currentTripIndex;
    public static boolean isFirstRun;

    public Trippie() {
        ui = new Ui();
        storage = new Storage();
        trippieData = new TrippieData();
        currentTrip = null;
        currentTripIndex = 0;
        isFirstRun = true;
    }

    public static void main(String[] args) {
        new Trippie().run();
    }

    public void run() {
        ui.greetUser();
        storage.setupMasterFile(trippieData);
        currentTrip = null; // TODO: store default value of trips
        System.out.println(trippieData.list()); // For debugging purposes
        boolean isExit = false;

        while (!isExit) {
            if (isFirstRun) {
                System.out.println("Please create a new trip first by entering the command 'new trip'!");
                isFirstRun = false;
            }


            String fullCommand = ui.readCommand();
            ui.printLine();
            Command c = Parser.parse(fullCommand);
            if (c != null) {
                c.execute(ui, currentTrip, trippieData);
                isExit = c.isExit();
            }
            try {
                storage.saveTrip(currentTrip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            updateCurrentTrip();
            storage.saveMasterFile(trippieData);
            ui.printLine();
        }
    }

    private void updateCurrentTrip() {
        if (currentTripIndex < trippieData.getTripList().size()) {
            // TODO: don't load on each command execution
            currentTrip = trippieData.getTripList().get(currentTripIndex);
            Trip tempTrip = storage.loadTrip(currentTrip);
            currentTrip.setPlaceList(tempTrip.getPlaceListObject());
            currentTrip.setExpenseList(tempTrip.getExpenseListObject());
        }
    }
}
