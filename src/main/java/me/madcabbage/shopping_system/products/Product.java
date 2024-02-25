package me.madcabbage.shopping_system.products;

public class Product {

    private String id;
    private String name;
    private double price;
    private Seller seller; //seller object
    private String description;
    private int quantity;
    private String imageURl;
    private ProductType productType; //To categorize products based on type
    private boolean isAvailable; //To check if the product is available right now or not.

    public Product(String name, String description, int quantity, String imageURl, ProductType productType, boolean isAvailable){
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
        this.productType = ProductType.UNCATEGORIZED;
        this.isAvailable = false;
    }
    public Product(String name){
        this.name = name;
        this.description = "";
        this.quantity = 0;
        this.imageURl = "";
        this.productType = ProductType.UNCATEGORIZED;
        this.isAvailable = false;
    }

    //Getter methods
    public String getId() { return id; }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public Seller getSeller() {return seller;}
    public String getDescription() {
        return description;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getImageURl() {
        return imageURl;
    }
    public ProductType getProductType() { return productType; }
    public boolean isAvailable() {return isAvailable;}

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
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
