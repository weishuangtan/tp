package seedu.trippie;

import seedu.trippie.command.Command;

public class Trippie {
    //private final Storage storage;
    private final Ui ui;
    private ExpenseList expenseList;

    public Trippie(String filePath) {
        ui = new Ui();
        try {
            expenseList = new ExpenseList();
            // expenseList = new ExpenseList(storage.load());
        } catch (NullPointerException e) {
            System.out.println("No file detected");
            expenseList = new ExpenseList();
        }
    }

    public static void main(String[] args) {
        new Trippie("data/trippie.txt").run();
    }

    public void run() {
        ui.greetUser();
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = ui.readCommand();
            ui.printLine();
            Command c = Parser.parse(fullCommand);
            if (c != null) {
                c.execute();
                isExit = c.isExit();
            }
            ui.printLine();
        }
        /*
        while (!isExit) {
            try {
                storage.save(tasks.getList());
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                if (c != null) {
                    c.execute(tasks, ui, storage);
                    isExit = c.isExit();
                }
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
        */
    }
}
