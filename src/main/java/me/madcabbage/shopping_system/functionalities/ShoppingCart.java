package me.madcabbage.shopping_system.functionalities;
import me.madcabbage.shopping_system.product.Product;

import java.util.ArrayList;

public class ShoppingCart {

    //BuyerUser buyer;

    private double totalPrice;
    private double discountedPrice;
    private ArrayList<Product> productArrayList;
    private double[] allItemPrices;

    public ShoppingCart(ArrayList<Product> productArrayList){
        this.productArrayList = productArrayList;
        this.totalPrice = calculateTotal();
        this.allItemPrices = calculateAllItemPrices();
    }
    public ShoppingCart(Product product){
        ArrayList<Product> productArrayList = new ArrayList<Product>();
        productArrayList.add(product);
        this.productArrayList = productArrayList;
        this.totalPrice = calculateTotal();
        this.allItemPrices = calculateAllItemPrices();


    }

    //Getter Methods

    public double getTotalPrice() {
        return totalPrice;
    }
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    public double[] getAllItemPrices() {
        return allItemPrices;
    }

    //Setter Methods

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    //Adder Methods

    public void addProduct(Product product){
        this.productArrayList.add(product);
    }
    public void addProduct(ArrayList<Product> productArrayList){
        for (int i = 0; i < productArrayList.size(); i++) {
            Product product = productArrayList.get(i);
            addProduct(product);
        }
    }

    //Method to return total Price
    private double calculateTotal(){
        double totalPrice = 0;
        for (int i = 0; i < productArrayList.size(); i++) {
            Product product = productArrayList.get(i);
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    //Method to return array of total prices of all the prices of all the products
    //present in the cart
    private double[] calculateAllItemPrices(){
        double[] pricesArray = new double[productArrayList.size()];
        for (int i = 0; i < productArrayList.size(); i++){
            pricesArray[i] = productArrayList.get(i).getPrice();
        }
        return pricesArray;
    }

}
