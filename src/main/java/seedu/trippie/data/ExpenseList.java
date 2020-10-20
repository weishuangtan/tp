package seedu.trippie.data;

import java.util.ArrayList;
import java.util.List;

public class ExpenseList {
    private List<Expense> expenseList;
    private Float budgetValue;
    private Float forExValue;
    private String currencyAbbreviation;

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

    public Float getBudgetValue() {
        return budgetValue;
    }

    public Float getForExValue() {
        return forExValue;
    }

    public String getCurrencyAbbreviation() {
        return currencyAbbreviation;
    }

    public Float getTotalExpenses() {
        float totalExpenses = 0;
        for (Expense expense: expenseList) {
            totalExpenses += expense.getExpenseCost();
        }
        return totalExpenses;
    }

    public void setBudgetValue(Float budgetValue) {
        this.budgetValue = budgetValue;
    }

    public void setForExValue(Float forExValue) {
        this.forExValue = forExValue;
    }

    public void setCurrencyAbbreviation(String currencyAbbreviation) {
        this.currencyAbbreviation = currencyAbbreviation;
    }
}
