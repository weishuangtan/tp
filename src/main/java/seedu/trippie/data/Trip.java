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

    /**
     * A trip constructor that initializes both an empty expense list and an empty place list.
     */
    public Trip() {
        this.expenseList = new ExpenseList();
        this.placeList = new PlaceList();
    }

    /**
     * A trip constructor based on given parameters.
     * @param index Given trip index
     * @param name Given trip name
     * @param startDate Given trip startDate
     * @throws TrippieException A common Trippie exception
     */
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
        return maxDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setExpenseList(ExpenseList expenseList) {
        this.expenseList = expenseList;
    }

    public void setPlaceList(PlaceList placeList) {
        this.placeList = placeList;
    }

    public void updateMaxDay() {
        maxDay = Integer.max(placeList.getMaxDay(), expenseList.getMaxDay());
    }


    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return index + 1 + " " + name + " " + df.format(startDate);
    }

}
