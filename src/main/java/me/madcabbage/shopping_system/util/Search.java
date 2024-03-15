package me.madcabbage.shopping_system.util;

import me.madcabbage.shopping_system.util.FileDatabase;
import me.madcabbage.shopping_system.util.Console;
import me.madcabbage.shopping_system.products.*;

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
}
