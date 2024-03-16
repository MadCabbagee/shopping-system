package me.madcabbage.shopping_system.util;

import me.madcabbage.shopping_system.products.*;
import me.madcabbage.shopping_system.util.FileDatabase;

public class Search {

    /*okay need to search items from the dataBase.
    * first I got to know how are the items stored
    * then search for items
    * this is a static class
    */

    private Search()
    {
        //hide constructor
    }

    //function to search items with similar names

    public static Product findProduct(String productName){
        Product[] allProducts = FileDatabase.getAllProducts();
        for (int i = 0; i < allProducts.length; i++) {
            Product currentProduct = allProducts[i];
            if (currentProduct.getName() == productName){
                return currentProduct;
            }
        }
        return null;
    }

    public static Product findProduct(String productName, String filterType, String typeName) {
        try {
            switch (filterType) {
                case "Seller":
                    return sellerFilter(productName,typeName);
                case "Product Type":
                    return productTypeFilter(productName, typeName);
                default:
                    break;
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        return null;
    }

    private static Product productTypeFilter(String productName, String ProductType) {
        //add its implementation
        return null;
    }

    //todo add function to get seller in FileDataBase
    //todo add function to get all sellers in FileDataBase

    private static Product sellerFilter(String productName, String sellerName) {
        //add its implementation
        return null;
    }

    //todo implement algorithm to find closest input matches
}
