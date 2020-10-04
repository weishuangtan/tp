package seedu.trippie;

public class Product {
    private String productName;
    private String productCost;
    private String productDayBought;

    public Product(String productItem, String productCost, String productDayBought) {
        this.productName = productItem;
        this.productCost = productCost;
        this.productDayBought = productDayBought;
    }

    public static String extractItemName(String userInput) {
        int startIndex = userInput.indexOf("-i") + 2;
        int endIndex = userInput.indexOf("-c") - 1;
        return userInput.substring(startIndex,endIndex).trim();
    }

    public static String extractItemCost(String userInput) {
        int startIndex = userInput.indexOf("-c") + 2;
        int endIndex = userInput.indexOf("-d") - 1;
        String itemCost = userInput.substring(startIndex,endIndex).trim();
        if (itemCost.contains("$")) {
            itemCost = itemCost.replace("$", "");
        }
        return itemCost;
    }

    public static String extractDayBought(String userInput) {
        int startIndex = userInput.indexOf("-d") + 2;
        return userInput.substring(startIndex).replaceAll("[^0-9]","").trim();
    }

    public static String extractCostFromList(Product spending) {
        int startIndex = spending.toString().indexOf("- $") + 3;
        return spending.toString().substring(startIndex);
    }

    public String getProductItem() {
        return productName;
    }

    public String getProductCost() {
        return productCost;
    }

    public String getProductDayBought() {
        return productDayBought;
    }

    @Override
    public String toString() {
        return "Day " + getProductDayBought() + ": " + getProductItem() + " - $" + getProductCost();
    }
}
