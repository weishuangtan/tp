package seedu.trippie;

import seedu.trippie.command.Command;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;

import java.io.IOException;

public class Trippie {
    private final Ui ui;
    private TrippieData trippieData;
    private final Storage storage;
    private boolean isFirstRun;

    public Trippie() {
        ui = new Ui();
        storage = new Storage();
        trippieData = new TrippieData(storage);
        isFirstRun = false;
    }

    public static void main(String[] args) {
        new Trippie().run();
    }

    public void run() {
        ui.greetUser();
        storage.setupMasterFile(trippieData);

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
                c.execute(ui, trippieData);
                isExit = c.isExit();
            }
            try {
                // here current Trip should not output index out of bounds exception.
                storage.saveTrip(trippieData.getCurrentTrip());
            } catch (IOException e) {
                e.printStackTrace();
            }

            storage.saveMasterFile(trippieData);
            ui.printLine();
        }
    }


}
