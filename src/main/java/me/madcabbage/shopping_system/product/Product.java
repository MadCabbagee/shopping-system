package me.madcabbage.shopping_system.product;


public class Product {
    //String id;
    private String name;
    private double price;
    private Seller seller; //seller object
    private String description;
    private int quantity;
    private String imageURl;
    private String productType; //To categorize products based on type
    private boolean isAvailable; //To check if the product is available right now or not.

    public Product(String name, String description, int quantity, String imageURl, String productType, boolean isAvailable){
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.imageURl = imageURl;
        this.productType = productType;
        this.isAvailable = isAvailable;
    }
    public Product(String name, String description, int quantity){
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.imageURl = "";
        this.productType = "";
        this.isAvailable = false;
    }
    public Product(String name){
        this.name = name;
        this.description = "";
        this.quantity = 0;
        this.imageURl = "";
        this.productType = "";
        this.isAvailable = false;

    }

    //Getter methods
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public Seller getSeller() {
        return seller;
    }
    public String getDescription() {
        return description;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getImageURl() {
        return imageURl;
    }
    public String getProductType() {
        return productType;
    }



    //Setter Methods
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static void main(String[] args) {

    }
}
