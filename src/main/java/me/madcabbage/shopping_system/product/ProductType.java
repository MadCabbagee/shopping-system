package me.madcabbage.shopping_system.product;

public enum ProductType {
    BEAUTY_PRODUCTS("Beauty Products"),
    BOOKS_AND_STATIONARY("Books and Stationary"),
    CABBAGES("Cabbages"),
    CAMPING_GOODS("Camping Goods"),
    CLOTHING("Clothing"),
    ELECTRONICS("Electronics"),
    FURNITURE("Furniture"),
    GROCERIES("Groceries"),
    GUNS("Guns"),
    HOME_KITCHEN_APPLIANCES("Home And Kitchen Appliances"),
    MEDICINE("Medicine"),
    SPORTS_GOOD("Sports Goods"),
    TOYS_AND_GAMES("Toys And Games"),
    UNCATEGORIZED("Uncategorized");

    private final String productName;
    private ProductType(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }
}
