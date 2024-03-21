package me.madcabbage.shopping_system.console_ui.menus;

import me.madcabbage.shopping_system.products.Product;
import me.madcabbage.shopping_system.util.Console;
import me.madcabbage.shopping_system.util.FileDatabase;
import me.madcabbage.shopping_system.util.Search;

import java.io.File;

public class SellerMenus {


    private static final String[] sellerMenuOptions = { "Add Product", "Remove Product", "Edit Product",
            "View Products","Account Options","Logout" };
    private static final String[] productSelectionMenu = {"Product Name","Product ID"};
    private static final String[] accountOptionsMenu = {"Change Name","Change Password","Delete Account"};
    private static boolean showSellerMenuOptions;

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
        // Account Details
        if (input.equals(sellerMenuOptions[0])) {
            //displayAddProducts();
        }
        // View cart option selected

        else if (input.equals(sellerMenuOptions[4])) {
            showSellerMenuOptions = false;
            // todo set current user to null;
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


}
