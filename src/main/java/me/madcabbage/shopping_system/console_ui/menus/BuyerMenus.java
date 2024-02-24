package me.madcabbage.shopping_system.console_ui.menus;

import me.madcabbage.shopping_system.console_ui.ConsoleUI;
import me.madcabbage.shopping_system.util.Console;

public class BuyerMenus {

    private static final String[] buyerMenuOptions = { "Products", "Account Options","Logout"};
    private static final String[] buyerProductsMenu = { "Browse", "Search", "Back"};
    private static final String[] buyerProductActions = { "" };

    private static boolean show;
    private BuyerMenus() {
        // Hide implicit constructor
    }

    public static void show() {
        show = true;
        while (show) {
            String input = Console.promptWithChoicesSpaced("Buyer Menu:", buyerMenuOptions);
            handleBuyerMenu(input);
        }
    }

    public static void handleBuyerMenu(String input) {
        if (input.equals(buyerMenuOptions[0])) {
            showProductsMenu();
        }
        else if (input.equals(buyerMenuOptions[1])) {
            AccountOptionsMenu.show();
        }
        else if (input.equals(buyerMenuOptions[2])) {
            show = false;
        }
    }

    private static void showProductsMenu() {

    }

    public static void handleBuyerProductsMenu() {

    }
}
