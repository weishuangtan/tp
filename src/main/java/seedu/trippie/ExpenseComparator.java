package seedu.trippie;

import java.util.Comparator;

public class ExpenseComparator implements Comparator<Expense> {
    @Override
    public int compare(Expense a, Expense b) {
        return a.getExpenseDayBought() - b.getExpenseDayBought();
    }
}
