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

class DeleteExpenditureCommandTest {

    private static final String[] VALID_ADD_USER_INPUTS = {"buy /i ice-cream /c 3.00 /d 2",
        "buy /i chicken rice /c 5.00 /d 1", "buy /i pants /c $30.00 /d 3"};
    private static final String[] VALID_DELETE_USER_INPUTS = {"delete /e 4", "delete /e 1", "delete /e 1",
        "delete /e 1"};
    private static final String[] BAD_USER_INPUTS = {"delete /e", "delete /e three", "delete ", "delete"};
    private static final int[] EXPECTED_SIZE = {3,2,1,0};

    @Test
    void addExpenseCommand_invalidUserInput_throwsTrippieInvalidArgumentException() {
        for (String badUserInput : BAD_USER_INPUTS) {
            assertThrows(TrippieInvalidArgumentException.class, () -> new DeleteExpenditureCommand(badUserInput));
        }
    }

    @Test
    void deleteExpenditureCommand_validUserInput_parsedCorrectly() throws TrippieInvalidArgumentException,
            ParseException {

        Ui ui = new Ui();
        Storage storage = new Storage();
        TrippieData trippieData = new TrippieData(storage);
        fileSetup(storage, trippieData);

        for (String validAddUserInput : VALID_ADD_USER_INPUTS) {
            AddExpenseCommand c = new AddExpenseCommand(validAddUserInput);
            c.execute(ui,trippieData);
        }

        for (int i = 0; i < VALID_DELETE_USER_INPUTS.length; i++) {
            DeleteExpenditureCommand c = new DeleteExpenditureCommand(VALID_DELETE_USER_INPUTS[i]);
            c.execute(ui,trippieData);
            List<Expense> expenses = trippieData.getCurrentTrip().getExpenseListObject().getExpenseList();
            assertEquals(EXPECTED_SIZE[i],expenses.size());
        }

    }

    private void fileSetup(Storage storage, TrippieData trippieData) throws ParseException {
        storage.setupMasterFile(trippieData);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Trip newTrip = new Trip(trippieData.getTripList().size(), "Singapore", df.parse("11-11-2020"));
        newTrip.getExpenseListObject().setForExValue(Float.parseFloat("100"));
        newTrip.getExpenseListObject().setCurrencyAbbreviation("SGD");
        newTrip.getExpenseListObject().setBudgetValue(Float.parseFloat("1000"));
        trippieData.getTripList().add(newTrip);

    }
}