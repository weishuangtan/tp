package seedu.trippie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.trippie.command.*;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private Parser parser;

    @BeforeEach
    public void setUp() {
        parser = new Parser();
    }


    @Test
    public void parse_exitCommand_parsedCorrectly() {
        final String input = "exit";
        parseAndAssertCommandType(input, ExitCommand.class);
    }

    @Test
    public void parse_buyCommand_parsedCorrectly() {
        final String input = "buy /i ice-cream /c 3.00 /d 2";
        parseAndAssertCommandType(input, AddExpenseCommand.class);
    }

    @Test
    public void parse_deleteExpenditureCommand_parsedCorrectly() {
        final String input = "delete /e 2";
        parseAndAssertCommandType(input, DeleteExpenditureCommand.class);
    }

    @Test
    public void parse_listExpensesCommand_parsedCorrectly() {
        final String input = "list /e";
        parseAndAssertCommandType(input, ListExpenseCommand.class);
    }

    @Test
    public void parse_budgetCommand_parsedCorrectly() {
        final String input = "budget 1000";
        parseAndAssertCommandType(input, BudgetCommand.class);
    }

    @Test
    public void parse_calculateCurrencyCommand_parsedCorrectly() {
        final String input = "convert /toFOR 500";
        parseAndAssertCommandType(input, CalculateCurrencyCommand.class);
    }

    @Test
    public void parse_addPlaceCommand_parsedCorrectly() {
        final String input = "add /n Dinner at Marina Bay Sands /d 2 /t 1800 to 2000";
        parseAndAssertCommandType(input, AddPlaceCommand.class);
    }

    @Test
    public void parse_deletePlaceCommand_parsedCorrectly() {
        final String input = "delete /p 2";
        parseAndAssertCommandType(input, DeletePlaceCommand.class);
    }

    @Test
    public void parse_helpCommand_parsedCorrectly() {
        final String input = "help";
        parseAndAssertCommandType(input, HelpCommand.class);
    }

    @Test
    public void parse_listPlacesCommand_parsedCorrectly() {
        final String input = "list /p";
        parseAndAssertCommandType(input, ListPlacesCommand.class);
    }

    @Test
    public void parse_searchCommand_parsedCorrectly() {
        final String input = "search Marina";
        parseAndAssertCommandType(input, SearchCommand.class);
    }

    @Test
    public void parse_newTripCommand_parsedCorrectly() {
        final String input = "new trip";
        parseAndAssertCommandType(input, NewTripCommand.class);
    }

    @Test
    public void parse_loadTripCommand_parsedCorrectly() {
        final String input = "load trip";
        parseAndAssertCommandType(input, LoadTripCommand.class);
    }


    private <T extends Command> T parseAndAssertCommandType (String userInput, Class<T> expectedCommandClass) {
        Command result = parser.parse(userInput);
        assertTrue(result.getClass().isAssignableFrom(expectedCommandClass));
        if (expectedCommandClass != ExitCommand.class) {
            assertFalse(result.isExit());
        } else {
            assertTrue(result.isExit());
        }
        return (T) result;
    }
}