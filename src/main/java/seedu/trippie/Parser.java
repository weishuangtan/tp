package seedu.trippie;

import seedu.trippie.command.AddExpenseCommand;
import seedu.trippie.command.AddPlaceCommand;
import seedu.trippie.command.BudgetCommand;
import seedu.trippie.command.Command;
import seedu.trippie.command.DeleteExpenditureCommand;
import seedu.trippie.command.DeletePlaceCommand;
import seedu.trippie.command.ExitCommand;
import seedu.trippie.command.HelpCommand;
import seedu.trippie.command.ListExpenseCommand;
import seedu.trippie.command.ListPlacesCommand;
import seedu.trippie.command.LoadTripCommand;
import seedu.trippie.command.NewTripCommand;
import seedu.trippie.command.SearchCommand;
import seedu.trippie.exception.TrippieIllegalCommandException;
import seedu.trippie.exception.TrippieInvalidArgumentException;

public class Parser {

    private static final String ERROR_MESSAGE = "Invalid Command! Type \"help\" to view the commands available!";

    public static Command parse(String userInput) {
        try {
            if (userInput.equals("exit")) {
                return new ExitCommand();
            } else if (userInput.startsWith("buy")) {
                return new AddExpenseCommand(userInput);
            } else if (userInput.startsWith("delete /e")) {
                return new DeleteExpenditureCommand(userInput);
            } else if (userInput.equals("list /e")) {
                return new ListExpenseCommand();
            } else if (userInput.startsWith("budget")) {
                return new BudgetCommand(userInput);
            } else if (userInput.startsWith("add")) {
                return new AddPlaceCommand(userInput);
            } else if (userInput.startsWith("delete /p")) {
                return new DeletePlaceCommand(userInput);
            } else if (userInput.equals("help")) {
                return new HelpCommand();
            } else if (userInput.startsWith("list /p")) {
                return new ListPlacesCommand(userInput);
            } else if (userInput.startsWith("search")) {
                return new SearchCommand(userInput);
            } else if (userInput.equals("new trip")) {
                return new NewTripCommand();
            } else if (userInput.equals("load trip")) {
                return new LoadTripCommand();
            } else {
                throw new TrippieIllegalCommandException(ERROR_MESSAGE);
            }
        } catch (TrippieIllegalCommandException | TrippieInvalidArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
