package me.madcabbage.shopping_system.util;
import me.madcabbage.shopping_system.products.Product;
import me.madcabbage.shopping_system.util.Search;

public class DisplaySearch {


    private DisplaySearch() {
        //hide constructor
    }

    public static void searchProduct(){
        String productName = askName("Product");
        Product product = Search.findProduct(productName);
        if (product == null){
            Console.printSpaced("Product Does not Exist");
            return;
        }
        displayDetails(product);
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
}
