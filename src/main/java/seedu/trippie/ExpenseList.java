package seedu.trippie;

import java.util.ArrayList;
import java.util.List;

public class ExpenseList {
    private List<Expense> expenseList;
    private Float budgetValue;

    public ExpenseList() {
        expenseList = new ArrayList<>();
    }

    /*
        Uses for Storage
     */
    //    public ExpenseList(List<Expense> expenseList) {
    //        this.expenseList = new ArrayList<>(expenseList);
    //    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = new ArrayList<>(expenseList);
    }

    public Float getBudgetValue() {
        return budgetValue;
    }

    public void setBudgetValue(Float budgetValue) {
        this.budgetValue = budgetValue;
    }
}
