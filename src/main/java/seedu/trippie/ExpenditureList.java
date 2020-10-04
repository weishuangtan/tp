package seedu.trippie;

import java.util.ArrayList;
import java.util.List;

public class ExpenditureList {
    protected static ArrayList<Product> expenditureList;

    public ExpenditureList() {
        expenditureList = new ArrayList<>();
    }

    public ExpenditureList(List<Product> expenditureList) {
        this.expenditureList = new ArrayList<>(expenditureList);
    }

    public static ArrayList<Product> getExpenditureList() {
        return expenditureList;
    }

    public void setExpenditureList(ArrayList<Product> expenditureList) {
        this.expenditureList = expenditureList;
    }

    public static void numberOfItemsTracker(ArrayList<Product> expenditureList) {
        int numberOfItems = expenditureList.size();
        System.out.println("Now you have " + numberOfItems + " item(s) in the list.");
    }

}
