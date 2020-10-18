package seedu.trippie.data;

import java.util.Date;
import java.util.List;

public class Trip {
    private int index;
    private String name;
    private Date startDate;
    private ExpenseList expenseList;
    private PlaceList placeList;

    public Trip() {
        this.expenseList = new ExpenseList();
        this.placeList = new PlaceList();
    }

    public Trip(int index, String name, Date startDate) {
        this.index = index;
        this.name = name;
        this.startDate = startDate;
        this.expenseList = new ExpenseList();
        this.placeList = new PlaceList();
    }

    public ExpenseList getExpenseListObject() {
        return this.expenseList;
    }

    public PlaceList getPlaceListObject() {
        return this.placeList;
    }

    public void setExpenseList(ExpenseList expenseList) {
        this.expenseList = expenseList;
    }

    public void setPlaceList(PlaceList placeList) {
        this.placeList = placeList;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getMaxDay() {

        return 0;
        //TODO: Fix placeList.getMaxDay();

//  TODO: return integer in expenses, get ExpenseDayBought.
//        return Integer.max(
//                places.get(places.size() - 1).getPlaceDay(),
//                expenses.get(expenses.size() - 1).getExpenseDayBought()
//                );
    }


}
