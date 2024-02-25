package me.madcabbage.shopping_system.console_ui.menus;

import me.madcabbage.shopping_system.util.Console;

public class BuyerMenus {

    private static final String[] mainMenu = { "Products", "View Cart", "Checkout", "Account Options","Logout" };
    private static final String[] productsMenu = { "Browse", "Search", "View details by ID", "Add to cart by ID", "Back" };
    private static final String[] browseMenu = { "Next Page", "Previous Page", "Select Page", "Back" };
    private static final String[] searchMenu = { "By name", "By category", "By seller", "Back" };

    private static boolean showMainMenu;
    private static boolean showProductsMenu;
    private static boolean showSearchMenu;
    private BuyerMenus() {
        // Hide implicit constructor
    }

    public static void show() {
        showMainMenu = true;
        while (showMainMenu) {
            String input = Console.promptWithChoicesSpaced("Buyer Menu:", mainMenu);
            handleMainMenuInput(input);
        }
    }

    public static void handleMainMenuInput(String input) {
        // Products option selected
        if (input.equals(mainMenu[0])) {
            displayProductsMenu();
        }
        // View cart option selected
        else if (input.equals(mainMenu[1])) {
            displayCartContents();
        }
        // Checkout option selected
        else if (input.equals(mainMenu[2])) {
            displayCheckout();
        }
        // Account options option selected
        else if (input.equals(mainMenu[3])) {
            AccountOptionsMenu.show();
        }
        // logout option selected
        else if (input.equals(mainMenu[4])) {
            showMainMenu = false;
            // todo set current user to null;
        }
    }

    private static void displayProductsMenu() {
        showProductsMenu = true;
        while (showProductsMenu) {
            String input = Console.promptWithChoicesSpaced("Products Menu:", productsMenu);
            handleProductsInput(input);
        }
    }

    public static void handleProductsInput(String input) {
        // Browse option selected
        if (input.equals(productsMenu[0])) {
            displayAllProducts();
        }
        // Search option selected
        else if (input.equals(productsMenu[1])) {
            displaySearchMenu();
        }
        // View details option selected
        else if (input.equals(productsMenu[2])) {
            displayProductDetails();
        }
        // Add to cart option selected
        else if (input.equals(productsMenu[3])) {
            handleAddToCartInput();
        }
        // Back option selected
        else if (input.equals(productsMenu[4])) {
            showProductsMenu = false;
        }
    }

    private static void displayAllProducts() {
    }

    private static void displaySearchMenu() {
        showSearchMenu = true;
        while (showSearchMenu) {
            String input = Console.promptWithChoicesSpaced("Choose search type:", searchMenu);
            handleSearchInput(input);
        }
    }

    private static void handleSearchInput(String input) {
        // by name selected
        if (input.equals(searchMenu[0])) {

        }
        // by category selected
        else if (input.equals(searchMenu[1])) {

        }
        // by seller selected
        else if (input.equals(searchMenu[2])) {

        }
        // back selected
        else if (input.equals(searchMenu[3])) {
            showSearchMenu = false;
        }
    }

    private static void displayProductDetails() {
        // todo ask for product id
        // todo format and print selected product details
    }

    private static void handleAddToCartInput() {
        // todo ask for product id
        // todo add product to cart
    }

    private static void displayCartContents() {
        // todo display contents of cart
    }

    private static void displayCheckout() {
        // todo show cart
        // todo ask to proceed or go back
        // todo ask for billing information
        // todo ask for shipping information
    }


}
