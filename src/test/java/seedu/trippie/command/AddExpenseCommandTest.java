package seedu.trippie.command;

import org.junit.jupiter.api.Test;
import seedu.trippie.data.Expense;
import seedu.trippie.exception.TrippieInvalidArgumentException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AddExpenseCommandTest {
    private final String[] userInputs = {"buy /i ice-cream /c 3.00 /d 2", "buy /i chicken rice /c 5.00 /d 1",
            "buy /i pants /c 30.00 /d 3"};

    /**
     * Tests if expense parameters in AddExpenseCommand is extracted correctly from user input
     *
     * @throws TrippieInvalidArgumentException
     */
    @Test
    void addExpenseCommand_validUserInput_setsExpenseParameters() throws TrippieInvalidArgumentException {
        String[] expenseNames = {"ice-cream", "chicken rice", "pants"};
        Float[] expenseCosts  = {Float.parseFloat("3.00"), Float.parseFloat("5.00"),
                Float.parseFloat("30.00"),};
        int[] expenseDays = {2,1,3};
        for (int i = 0; i < userInputs.length; i++) {
            AddExpenseCommand c = new AddExpenseCommand(userInputs[i]);
            assertEquals(expenseNames[i], c.extractExpenseName(userInputs[i]));
            assertEquals(expenseCosts[i], c.extractExpenseCost(userInputs[i]));
            assertEquals(expenseDays[i], c.extractDayBought(userInputs[i]));
        }
    }


    /**
     * Tests if new expense is added successfully into expense list
     */
  /*  @Test
    void addExpenseCommand_validUserInput_expenseListContainsExpense() throws TrippieInvalidArgumentException {
        String userInput = "buy /i ice-cream /c 3.00 /d 2";
        AddExpenseCommand c = new AddExpenseCommand(userInput);
        Ui ui = new Ui();
        Storage storage = new Storage();
        TrippieData trippieData = new TrippieData(storage);
        storage.setupMasterFile(trippieData);
        c.execute(ui,trippieData);
        List<Expense> expenses = trippieData.getCurrentTrip().getExpenseListObject().getExpenseList();

        assertEquals(1, expenses.size());
        assertEquals("ice-cream", expenses.get(0).getExpenseName());
        assertEquals(3,expenses.get(0).getExpenseCost());
        assertEquals(2, expenses.get(0).getExpenseDayBought());

    }

   */




    @Test
    void isExit_addExpenseCommandParsed_returnsFalse() throws TrippieInvalidArgumentException {
        String userInput = "buy /i ice-cream /c 3.00 /d 2";
        AddExpenseCommand c = new AddExpenseCommand(userInput);
        assertFalse(c.isExit());
    }

    @Test
    void execute() {
    }

    @Test
    void sortExpenseList_unsortedExpenseList_sortedExpenseList() throws TrippieInvalidArgumentException {
        List<Expense> expenses = new ArrayList<>();
        AddExpenseCommand c = new AddExpenseCommand(userInputs[0]);
        expenses.add(new Expense("ice-cream", Float.parseFloat("3"),2 ));
        expenses.add(new Expense("chicken rice", Float.parseFloat("5"),1 ));
        c.sortExpenseList(expenses);
        assertEquals("chicken rice",expenses.get(0).getExpenseName());
        assertEquals("ice-cream",expenses.get(1).getExpenseName());

    }
}