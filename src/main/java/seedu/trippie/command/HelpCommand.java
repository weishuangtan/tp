package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.TrippieData;

public class HelpCommand extends Command {
    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, TrippieData trippieData) {
        System.out.println("Welcome to Trippie! A one-stop app to plan any of your upcoming trips!");
        System.out.println("Here is a list of commands which you can use to navigate your way\nthrough Trippie!\n");
        System.out.println("[add]     |   Adds a place to your trip");
        System.out.println("          |   Format: add /n PLACE_NAME /d DAY /t TIME");
        System.out.println("          |   Example: add /n Jurong East Mall /d 2 /t 1100 to 1400");
        printBorder();
        System.out.println("[budget]  |   Adds a budget to keep track of in expenditure list");
        System.out.println("          |   Format: budget BUDGET");
        System.out.println("          |   Example: budget 4000");
        printBorder();
        System.out.println("[buy]     |   Adds an item with its final cost into an expenditure list");
        System.out.println("          |   Format: buy /i ITEM_NAME /c FINAL_COST /d DAY_NUMBER");
        System.out.println("          |   Example: buy /i R&B Brown Sugar /c 3.00 /d 2");
        printBorder();
        System.out.println("[delete]  |   Deletes the specified place from the list");
        System.out.println("(places)  |   Format: delete /p PLACE_INDEX");
        System.out.println("          |   Example: delete /p 3");
        printBorder();
        System.out.println("[delete]  |   Deletes an item from the expenditure list");
        System.out.println("(expenses)|   Format: delete /e EXPENSE_INDEX");
        System.out.println("          |   Example: delete /e 3");
        printBorder();
        System.out.println("[exit]    |   Exit the program and auto-save");
        System.out.println("          |   Format: exit");
        printBorder();
        System.out.println("[help]    |   Shows a short guide that lists all the commands");
        System.out.println("          |   Format: help");
        printBorder();
        System.out.println("[list]    |   Displays all places in a timetable format");
        System.out.println("(places)  |   Format: list /p [/d DAY]");
        System.out.println("          |   list /p /d 3");
        printBorder();
        System.out.println("[list]    |   Displays all the items bought in the expenditure list");
        System.out.println("(expenses)|   Format: list /e");
        System.out.println("          |");

    }

    public void printBorder() {
        System.out.println("__________|____________________________________________________________");
    }
}
