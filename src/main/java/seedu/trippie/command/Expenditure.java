package seedu.trippie.command;

import java.util.ArrayList;

public class Expenditure {
    private String itemName;
    private String itemCost;
    private String dayBought;

    public Expenditure(String itemName, String itemCost, String dayBought) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.dayBought = dayBought;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemCost() {
        return itemCost;
    }

    public String getDayBought() {
        return dayBought;
    }

    public static void buyItem(String userInput, ArrayList<Expenditure> expenditureList) {
        Expenditure itemEntry = null;
        String itemName = extractItemName(userInput);
        String itemCost = extractItemCost(userInput);
        String dayBought = extractDayBought(userInput);
        itemEntry = new Expenditure(itemName, itemCost, dayBought);
        System.out.println("Got it! I've added the following item: " + itemEntry.toString());
        expenditureList.add(itemEntry);
        numberOfItemsTracker(expenditureList);
    }

    public static void deleteItem(String userInput, ArrayList<Expenditure> expenditureList) {
        String[] segments = userInput.split("-e ");
        int expenseIndex = Integer.parseInt(segments[1]) - 1;
        if(expenseIndex < expenditureList.size()) {
            System.out.println("Noted. I've removed this item from the expenditure list.");
            System.out.println(expenditureList.get(expenseIndex).toString());
            expenditureList.remove(expenseIndex);
            numberOfItemsTracker(expenditureList);
        } else {
            System.out.println("Item has not been created yet. Enter a valid index.");
        }
    }

    public static void displayExpenditureList(String userInput, ArrayList<Expenditure> expenditureList) {
        if (expenditureList.isEmpty()) {
            System.out.println("There is currently nothing in your expenditure list.");
        } else {
            int listIndex = 1;
            System.out.println("Expenditure List:");
            for (Expenditure item: expenditureList) {
                System.out.println("[" + listIndex + "] " + item.toString());
                listIndex++;
            }
        }
    }

    public static String extractItemName(String userInput) {
        int startIndex = userInput.indexOf("-i") + 2;
        int endIndex = userInput.indexOf("-c") - 1;
        return userInput.substring(startIndex,endIndex).trim();
    }
    public static String extractItemCost(String userInput) {
        int startIndex = userInput.indexOf("-c") + 2;
        int endIndex = userInput.indexOf("-d") - 1;
        return userInput.substring(startIndex,endIndex).trim();
    }
    public static String extractDayBought(String userInput) {
        int startIndex = userInput.indexOf("-d") + 2;
        return userInput.substring(startIndex).trim();
    }
    public static void numberOfItemsTracker(ArrayList<Expenditure> expenditureList) {
        int numberOfItems = expenditureList.size();
        System.out.println("Now you have " + numberOfItems + " item(s).");
    }

    @Override
    public String toString() {
        return "Day " + getDayBought() + ": " + getItemName() + " - $" + getItemCost();
    }

}
