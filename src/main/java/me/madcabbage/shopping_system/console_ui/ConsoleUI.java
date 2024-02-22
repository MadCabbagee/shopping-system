package me.madcabbage.shopping_system.console_ui;

import me.madcabbage.shopping_system.console_ui.menus.AdminMenus;
import me.madcabbage.shopping_system.console_ui.menus.BuyerMenus;
import me.madcabbage.shopping_system.console_ui.menus.SellerMenus;
import me.madcabbage.shopping_system.user.User;
import me.madcabbage.shopping_system.util.Console;

public class ConsoleUI {
    private static final String[] mainMenuOptions = { "Login", "Register", "Reset Password" };

    private static boolean run;

    private ConsoleUI() {
        // hide implicit constructor
    }

    public static void show() {
        run = true;
        while (true) {
            String mainMenuInput = Console.promptWithChoicesSpaced("Main Menu:", mainMenuOptions);
            handleMainMenuInput(mainMenuInput);
        }
    }

    // Main Menu
    public static void handleMainMenuInput(String mainMenuInput) {
        if (mainMenuInput.equals(mainMenuOptions[0])) {
            // todo store current user somewhere globally
            User loggedIn = LoginUI.loginUser();
            if (loggedIn == null) {
                return;
            }
            switch (loggedIn.getAccountType()) {
                case Buyer -> BuyerMenus.show();
                case Seller -> SellerMenus.show();
                case Admin -> AdminMenus.show();
                default -> throw new IllegalArgumentException("Invalid account type");
            }
        } else if (mainMenuInput.equals(mainMenuOptions[1])) {
            RegistrationUI.registerUser();
        } else if (mainMenuInput.equals(mainMenuOptions[2])) {
            LoginUI.resetUserPassword();
        }
    }

    // Buyer Menus
    public static void handleBuyerMenu() {

    }

    public static void handleBuyerProductsMenu() {

    }

    // Seller Menus
    public static void handleSellerMenuOptions() {

    }


}
