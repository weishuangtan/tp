package seedu.trippie;

import seedu.trippie.command.Command;

import java.io.IOException;

public class Trippie {
    private final Ui ui;
    private ExpenseList expenseList;
    private PlaceList placeList;
    private final Storage storage;

    public Trippie() {
        ui = new Ui();
        storage = new Storage();
        try {
            expenseList = new ExpenseList();
            placeList = new PlaceList();
        } catch (Exception e) {
            System.out.println("No file detected");
            expenseList = new ExpenseList();
            placeList = new PlaceList();
        }
    }

    public static void main(String[] args) {
        new Trippie().run();
    }

    public void run() {
        try {
            ui.greetUser();
            boolean isExit = false;
            storage.setup(placeList, expenseList);
            while (!isExit) {
                String fullCommand = ui.readCommand();
                ui.printLine();
                Command c = Parser.parse(fullCommand);
                if (c != null) {
                    c.execute(ui, placeList, expenseList);
                    isExit = c.isExit();
                }
                storage.saveList(placeList, expenseList);
                ui.printLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
