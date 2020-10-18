package seedu.trippie;

import seedu.trippie.command.Command;
import seedu.trippie.data.ExpenseList;
import seedu.trippie.data.PlaceList;
import seedu.trippie.data.TripList;

import java.io.IOException;

public class Trippie {
    private final Ui ui;
    private ExpenseList expenseList;
    private PlaceList placeList;
    private TripList tripList;
    private final Storage storage;

    public Trippie() {
        ui = new Ui();
        storage = new Storage();
        tripList = new TripList();
    }

    public static void main(String[] args) {
        new Trippie().run();
    }

    public void run() {
        ui.greetUser();
        boolean isExit = false;
        storage.setupMasterFile(tripList);

        System.out.println(tripList.list());

        while (!isExit) {
            String fullCommand = ui.readCommand();
            ui.printLine();
            Command c = Parser.parse(fullCommand);
            if (c != null) {
                c.execute(ui, placeList, expenseList);
                isExit = c.isExit();
            }
            storage.saveMasterFile(tripList);
            ui.printLine();
        }
    }
}
