package seedu.trippie.command;

import org.junit.jupiter.api.Test;
import seedu.trippie.exception.TrippieExceedBudgetException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.trippie.command.ListExpenseCommand.createBudgetPercentageBar;

class ListExpenseCommandTest {

    private static final float SPEND_AMOUNT_EQUALS = 200;
    private static final float BUDGET_AMOUNT_EQUALS = 200;
    private static final String EQUAL_SPENDING_BUDGET =  "You have spent finish your budget.";
//    @Test
//    void createBudgetPercentageBar_() throws TrippieExceedBudgetException {
//    float spent = SPEND_AMOUNT_EQUALS;
//    float budget = BUDGET_AMOUNT_EQUALS;
//    ListExpenseCommand command = new ListExpenseCommand();
//    assertEquals(createBudgetPercentageBar(spent,budget), EQUAL_SPENDING_BUDGET);
//    }

}