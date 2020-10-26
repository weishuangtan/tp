package seedu.trippie.command;

import org.junit.jupiter.api.Test;
import seedu.trippie.Storage;
import seedu.trippie.Ui;
import seedu.trippie.data.Expense;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;
import seedu.trippie.exception.TrippieInvalidArgumentException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddExpenseCommandTest {

    private final String[] validUserInputs = {"buy /i ice-cream /c 3.00 /d 2", "buy /i chicken rice /c 5.00 /d 1",
        "buy /i pants /c $30.00 /d 3"};

    private final String[] badUserInputs = {"buy /i /c /d", "buy /i ice-cream /c three dollars /d 2",
        "buy /i ice-cream /c 3.00 /d two", "buy /i ice-cream /c /d", "buy /i /c /d 2",
        "buys /i ice-cream /c 3.00 /d 2"};

    @Test
    void addExpenseCommand_invalidUserInput_throwsTrippieInvalidArgumentException() {
        for (String badUserInput : badUserInputs) {
            assertThrows(TrippieInvalidArgumentException.class, () -> new AddExpenseCommand(badUserInput));
        }
    }

    @Test
    void addExpenseCommand_validUserInput_setsExpenseParameters() throws TrippieInvalidArgumentException {
        String[] expenseNames = {"ice-cream", "chicken rice", "pants"};
        Float[] expenseCosts  = {Float.parseFloat("3.00"), Float.parseFloat("5.00"),
                Float.parseFloat("30.00"),};
        int[] expenseDays = {2,1,3};
        for (int i = 0; i < validUserInputs.length; i++) {
            AddExpenseCommand c = new AddExpenseCommand(validUserInputs[i]);
            assertEquals(expenseNames[i], c.extractExpenseName(validUserInputs[i]));
            assertEquals(expenseCosts[i], c.extractExpenseCost(validUserInputs[i]));
            assertEquals(expenseDays[i], c.extractDayBought(validUserInputs[i]));
        }
    }

    @Test
    void addExpenseCommand_validUserInput_parsedCorrectly() throws TrippieInvalidArgumentException, ParseException {

        Ui ui = new Ui();
        Storage storage = new Storage();
        TrippieData trippieData = new TrippieData(storage);
        fileSetup(storage, trippieData);

        for (String validUserInput : validUserInputs) {
            AddExpenseCommand c = new AddExpenseCommand(validUserInput);
            c.execute(ui,trippieData);
        }

        List<Expense> expenses = trippieData.getCurrentTrip().getExpenseListObject().getExpenseList();
        assertEquals(3,expenses.size());

    }

    private void fileSetup(Storage storage, TrippieData trippieData) throws ParseException {
        storage.setupMasterFile(trippieData);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Trip newTrip = new Trip(trippieData.getTripList().size(), "Singapore", df.parse("11-11-2020"));
        newTrip.getExpenseListObject().setForExValue(Float.parseFloat("100"));
        newTrip.getExpenseListObject().setCurrencyAbbreviation("SGD");
        newTrip.getExpenseListObject().setBudgetValue(Float.parseFloat("1000"));
        int index = trippieData.getTripList().size();
        trippieData.getTripList().add(newTrip);
        trippieData.setCurrentTripFromIndex(index);
    }

}
