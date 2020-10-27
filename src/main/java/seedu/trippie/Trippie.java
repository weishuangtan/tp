package seedu.trippie;

import seedu.trippie.command.Command;
import seedu.trippie.command.ExitCommand;
import seedu.trippie.command.NewTripCommand;
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
    }

    public static void main(String[] args) {
        new Trippie().run();
    }

    public void run() {
        ui.greetUser();
        storage.setupMasterFile(trippieData);

        boolean isExit = false;

        if (trippieData.getTripList().isEmpty()) {
            System.out.println("Please create a new trip first by entering the command 'new trip'!");
            isFirstRun = true;
        }


        while (!isExit) {

            Command c = parseCommand();

            if (isFirstRun) {
                if (!(c instanceof NewTripCommand) && !(c instanceof ExitCommand)) {
                    c = promptNewTripCommand();
                }
                isFirstRun = false;
            }

            isExit = executeCommand(c);

            if (trippieData.getCurrentTrip() != null) {
                try {
                    // here current Trip should not output index out of bounds exception.
                    storage.saveTrip(trippieData.getCurrentTrip());
                    trippieData.getCurrentTrip().updateMaxDay();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            storage.saveMasterFile(trippieData);
            ui.printLine();
        }
    }

    private Command parseCommand() {
        String fullCommand = ui.readCommand();
        ui.printLine();
        return Parser.parse(fullCommand);
    }

    private boolean executeCommand(Command c) {
        if (c != null) {
            c.execute(ui, trippieData);
            return c.isExit();
        }
        return false;
    }

    private Command promptNewTripCommand() {
        Command c;
        do {
            System.out.println("Please create a new trip first by entering the command 'new trip'!");
            c = parseCommand();
        } while (isFirstRun && !(c instanceof NewTripCommand));
        return c;
    }
}
