package me.madcabbage.shopping_system.product;

public class Product {
    //String id;
    String name;
    double price;
    String seller;
    String description;
    int quantity;
    String imageURl;
    String productType; //To categorize products based on type
    boolean isAvailable; //To check if the product is available right now or not.

    Product(){


    }

    //Getter methods
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getSeller() {
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
    public void setSeller(String seller) {
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
