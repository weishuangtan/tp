package seedu.trippie.command;

import org.junit.jupiter.api.Test;
import seedu.trippie.exception.TrippieInvalidArgumentException;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BudgetCommandTest {

    @Test
    void isExit_budgetCommandParsed_returnsFalse() throws TrippieInvalidArgumentException {
        String userInput = "budget 1000";
        BudgetCommand c = new BudgetCommand(userInput);
        assertFalse(c.isExit());
    }

    @Test
    void execute() {
    }

}
