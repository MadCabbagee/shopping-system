package me.madcabbage.shopping_system.util;
import me.madcabbage.shopping_system.products.Product;
import me.madcabbage.shopping_system.util.Search;

import javax.swing.*;

public class DisplaySearch {


    private DisplaySearch() {
        //hide constructor
    }

    //todo modify function later to return product in after search to add to cart and bill and stuff
    public static void searchProduct(){
        String productName = askName("Product");
        Product[] matchingProducts = Search.matchingProducts(productName);
        if (matchingProducts[0] == null){
            Console.printSpaced("Product Does not Exist");
            return;
        }
        Product chosenProduct = selectFromMatchingProducts(matchingProducts);
        displayDetails(chosenProduct);
    }

    private static Product selectFromMatchingProducts(Product[] matchingProducts) {
        String chosenProductName;
        chosenProductName = Console.promptWithChoices("Select: ", Search.getMatchingProductsNames(matchingProducts));
        Product chosenProduct = Search.findProduct(chosenProductName, matchingProducts);
        return chosenProduct;
    }

    private static String askName(String nameToAsk){
        String ProductName = Console.promptSpaced("Enter "+nameToAsk+"Name: ");
        return ProductName;
    }


    private static void displayDetails(Product product){
        //todo make a generalized method to displayDetails using switch statements
        //todo make checks if information is incomplete
        Console.printSpaced("Product Details are as follows: ");
        Console.printSpaced("Name: "+product.getName());
        Console.printSpaced("Description: "+product.getDescription());
        Console.printSpaced("Type: "+product.getProductType());
        Console.printSpaced("Price: "+product.getPrice()+"$");
        Console.printSpaced("Seller: "+product.getSeller());
        Console.printSpaced("Items Available: "+product.getQuantity());
        Console.printSpaced("Image Url: "+product.getImageURl());
    }

    public static void main(String[] args) {
        searchProduct();
    }

}