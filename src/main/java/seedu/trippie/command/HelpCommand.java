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
        System.out.println("[new trip]|   Creates a new trip. You will be prompted to enter some details");
        System.out.println("          |   Format: new trip");
        printBorder();
        System.out.println("[help]    |   Shows a concise list of commands available");
        System.out.println("          |   Format: help");
        printBorder();
        System.out.println("[add]     |   Adds a place to your trip");
        System.out.println("          |   Format: add /n PLACE_NAME /d DAY /t TIME");
        System.out.println("          |   Example: add /n Dinner at Marina Bay Sands /d 2 /t 1800 to 2000");
        printBorder();
        System.out.println("[list]    |   Displays all places in a timetable format");
        System.out.println("(places)  |   Format: list /p [/d DAY]");
        System.out.println("          |   list /p /d 2");
        printBorder();
        System.out.println("[search]  |   Displays all places that includes the search keyword");
        System.out.println("(places)  |   Format: search KEYWORD");
        System.out.println("          |   search Dinner");
        printBorder();
        System.out.println("[delete]  |   Deletes the specified place from the list");
        System.out.println("(place)   |   Format: delete /p PLACE_INDEX");
        System.out.println("          |   Example: delete /p 1");
        printBorder();
        System.out.println("[budget]  |   Edits a budget to keep track of in expenditure list");
        System.out.println("          |   Format: budget AMOUNT");
        System.out.println("          |   Example: budget 100");
        printBorder();
        System.out.println("[buy]     |   Adds an item with its final cost into an expenditure list");
        System.out.println("          |   Format: buy /i ITEM_NAME /c FINAL_COST /d DAY_NUMBER");
        System.out.println("          |   Example: buy /i R&B Brown Sugar /c 3.00 /d 2");
        printBorder();
        System.out.println("[list]    |   Displays all the items bought in the expenditure list");
        System.out.println("(expenses)|   Format: list /e");
        System.out.println("          |");
        System.out.println("[delete]  |   Deletes the specified place from the list");
        System.out.println("(expense) |   Format: delete /e EXPENSE_INDEX");
        System.out.println("          |   Example: delete /e 1");
        printBorder();
        System.out.println("[exit]    |   Exit the program and auto-saves");
        System.out.println("          |   Format: exit");
    }

    public void printBorder() {
        System.out.println("__________|______________________________________________________________");
    }
}
