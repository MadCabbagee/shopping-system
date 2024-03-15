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
        provideDetails(product);
    }

    private static String askName(String nameToAsk){
        String ProductName = Console.promptSpaced("Enter "+nameToAsk+"Name: ");
        return ProductName;
    }

    private static void provideDetails(Product product){

        Console.printSpaced("Product Details are as follows: ");
        Console.printSpaced("Name: "+product.getName());
        Console.printSpaced("Description: "+product.getDescription());
        Console.printSpaced("Description: "+product.getProductType());
        Console.printSpaced("Description: "+product.getPrice());
        Console.printSpaced("Description: "+product.getSeller());
        Console.printSpaced("Description: "+product.getQuantity());
        Console.printSpaced("Description: "+product.getImageURl());
    }
}
