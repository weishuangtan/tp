package seedu.trippie;

import java.util.ArrayList;
import java.util.List;

public class ExpenditureList {
    protected static ArrayList<Product> expenditureList = new ArrayList<>();

//    public ExpenditureList() {
//        expenditureList = new ArrayList<Product>();
//    }

    public ExpenditureList(List<Product> expenditureList) {
        expenditureList = new ArrayList<>(expenditureList);
    }

    public static ArrayList<Product> getExpenditureList() {
        return expenditureList;
    }

    public static void addToExpenditureList(Product product) {
        expenditureList.add(product);
    }

    public static void numberOfItemsTracker(ArrayList<Product> expenditureList) {
        int numberOfItems = expenditureList.size();
        System.out.println("Now you have " + numberOfItems + " item(s) in the list.");
    }

}
