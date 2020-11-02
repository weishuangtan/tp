package seedu.trippie.data;

import seedu.trippie.Trippie;
import seedu.trippie.exception.TrippieException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Trip {
    private int index;
    private String name;
    private Date startDate;
    private ExpenseList expenseList;
    private PlaceList placeList;
    private int maxDay;

    public Trip() {
        this.expenseList = new ExpenseList();
        this.placeList = new PlaceList();
    }

    public Trip(int index, String name, Date startDate) throws TrippieException {

        if (index < 0) {
            throw new TrippieException("Index out of bounds");
        }

        if (name.isEmpty()) {
            throw new TrippieException("Trip name should not be empty");
        }


        this.index = index;
        this.name = name;
        this.startDate = startDate;
        this.expenseList = new ExpenseList();
        this.placeList = new PlaceList();
    }

    public Trip(int index, String name, Date startDate, int maxDay) throws TrippieException {
        this(index, name, startDate);
        this.maxDay = maxDay;
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

    public void updateMaxDay() {
        maxDay = Integer.max(placeList.getMaxDay(), expenseList.getMaxDay());
    }

    public int getMaxDay() {
        return maxDay;
    }

    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return index + 1 + " " + name + " " + df.format(startDate);
    }

}
