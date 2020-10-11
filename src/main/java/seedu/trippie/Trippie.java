package seedu.trippie;

import seedu.trippie.command.Command;

public class Trippie {
    //private final Storage storage;
    private final Ui ui;
    private ExpenseList expenseList;
    private PlaceList placeList;

    public Trippie(String filePath) {
        ui = new Ui();
        expenseList = new ExpenseList();
        placeList = new PlaceList();
//        to be implemented with storage
//        try {
//             expenseList = new ExpenseList(storage.load());
//             placeList = new PlaceList(storage.load());
//        } catch (NullPointerException e) {
//            System.out.println("No file detected");
//            expenseList = new ExpenseList();
//            placeList = new PlaceList();
//        }
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
                c.execute(ui, placeList, expenseList);
                isExit = c.isExit();
            }
            ui.printLine();
        }
    }
}
