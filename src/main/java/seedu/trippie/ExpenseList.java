package seedu.trippie;

import java.util.ArrayList;
import java.util.List;

public class ExpenseList {
    private List<Expense> expenseList;

    public ExpenseList() {
        expenseList = new ArrayList<>();
    }

    public ExpenseList(List<Expense> expenseList) {
        this.expenseList = new ArrayList<>(expenseList);
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = new ArrayList<>(expenseList);
    }
}
