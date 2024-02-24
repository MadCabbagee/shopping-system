package me.madcabbage.shopping_system.functionalities;
import me.madcabbage.shopping_system.Main;
import me.madcabbage.shopping_system.product.Product;

import java.util.ArrayList;

public class ShoppingCart {

    //BuyerUser buyer;

    private double totalPrice;
    private double discountedPrice;
    private ArrayList<Product> productArrayList;
    private double[] allItemPrices;
    private String[] itemNames;
    private boolean[] productsAvailability;
    private String[] productsDescription;
    public ShoppingCart(ArrayList<Product> productArrayList){
        this.productArrayList = productArrayList;
        this.totalPrice = calculateTotal();
        this.allItemPrices = calculateAllItemPrices();
        this.itemNames = itemNames();
        this.productsAvailability = productsAvailability();
    }
    public ShoppingCart(Product product){
        ArrayList<Product> productArrayList = new ArrayList<Product>();
        productArrayList.add(product);
        this.productArrayList = productArrayList;
        this.totalPrice = calculateTotal();
        this.allItemPrices = calculateAllItemPrices();
        this.itemNames = itemNames();
        this.productsAvailability = productsAvailability();

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
    public String[] getItemNames() {
        return itemNames;
    }
    public boolean[] getProductsAvailability() {
        return productsAvailability;
    }
    public String[] getProductsDescription() {
        return productsDescription;
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

    //product removing methods
    public void removeProduct(Product productToBeDeleted)
    {
        productArrayList.remove(productToBeDeleted);
    }
    public void removeProduct(ArrayList<Product> productArrayList){

        for (Product product : productArrayList)
        {
            removeProduct(product);
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

    //return array of total prices of all the prices of all the products present in the cart
    private double[] calculateAllItemPrices(){
        double[] pricesArray = new double[productArrayList.size()];
        for (int i = 0; i < productArrayList.size(); i++){
            pricesArray[i] = productArrayList.get(i).getPrice();
        }
        return pricesArray;
    }

    //return array of all the items name
    private String[] itemNames(){
        String[] namesArray = new String[productArrayList.size()];
        for (int i = 0; i < productArrayList.size(); i++){
            namesArray[i] = productArrayList.get(i).getName();
        }
        return namesArray;
    }

    //Method to check out the shopping cart items
    public double checkOutItems(double userCash)
    {
        if (userCash < totalPrice)
            return -1;
        double remaining = userCash - totalPrice;
        //todo add method to decrease item quantity from the database
        productArrayList.clear();
        return remaining;
    }

    //method to show product availability
    public boolean[] productsAvailability(){
        boolean[] availabilityArray = new boolean[productArrayList.size()];
        for (int i = 0; i < productArrayList.size(); i++){
            availabilityArray[i] = productArrayList.get(i).isAvailable();
        }
        return availabilityArray;
    }

    //Method to return array of product descriptions
    public String[] productsDescription(){
        String[] descriptionsArray = new String[productArrayList.size()];
        for (int i = 0; i < productArrayList.size(); i++){
            descriptionsArray[i] = productArrayList.get(i).getDescription();
        }
        return descriptionsArray;
    }

}
