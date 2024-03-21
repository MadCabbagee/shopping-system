package me.madcabbage.shopping_system.console_ui.menus;

import me.madcabbage.shopping_system.products.Product;
import me.madcabbage.shopping_system.util.Console;
import me.madcabbage.shopping_system.util.FileDatabase;
import me.madcabbage.shopping_system.util.Search;

import java.io.File;

public class SellerMenus {


    private static final String[] sellerMenuOptions = { "Add Product", "Remove Product", "Edit Product",
            "View Products","Account Options","Logout" };
    private static final String[] productSelectionMenu = {"Name","ID"};
    private static final String[] accountOptionsMenu = {"Change Name","Change Password","Delete Account"};
    private static boolean showSellerMenuOptions;
    private static boolean showAccountOptionMenu;

    private SellerMenus() {
        //  Hide implicit constructor
    }
    public static void show() {
        showSellerMenuOptions = true;
        while (showSellerMenuOptions) {
            String input = Console.promptWithChoicesSpaced("Seller Menu:", sellerMenuOptions );
            handleMainMenuInput(input);
        }
    }

    public static void handleMainMenuInput(String input) {
        // add a product
        if (input.equals(sellerMenuOptions[0])) {
            //addProduct();
        }
        else if (input.equals(sellerMenuOptions[1])) {
            //removeProduct();
        }
        else if (input.equals(sellerMenuOptions[2])) {
            //editProduct();
        }else if (input.equals(sellerMenuOptions[3])) {
            //viewProduct();
        }else if (input.equals(sellerMenuOptions[4])) {
            displayAccountOptionMenu();
        }
        else if (input.equals(sellerMenuOptions[5])) {
            showSellerMenuOptions = false;
            // todo set current user to null;
        }
    }

    public static void handleAccountOptionMenu(String input) {
        // Account Details
        if (input.equals(sellerMenuOptions[0])) {
            //changeName();
        }

        else if (input.equals(sellerMenuOptions[1])) {
            //changePassword();
        }
        else if (input.equals(sellerMenuOptions[2])) {
            //deleteAccount();
        }
        else if (input.equals(sellerMenuOptions[3])) {
            showAccountOptionMenu = false;
        }
    }

    public static String handleProductSelectionMenu(String input) {
        // Select name and return ID
        if (input.equals(productSelectionMenu[0])) {
            String name = Console.promptSpaced("Enter Name");
            return Search.findIDByName(name);
        }
        // return the ID
        else if (input.equals(productSelectionMenu[1])) {
            return Console.promptSpaced("Enter ID");
        }
        else
            return null;
    }
    private static void displayAccountOptionMenu() {
        showAccountOptionMenu = true;
        while (showAccountOptionMenu) {
            String input = Console.promptWithChoicesSpaced("Choose search type:", accountOptionsMenu);
            handleAccountOptionMenu(input);
        }
    }

    public static Product getProduct(){
        String input = Console.promptWithChoicesSpaced("Select Product By", productSelectionMenu);
        String id = handleProductSelectionMenu(input);
        //find product using id
        return  Search.findProductByID(id);
    }


}
