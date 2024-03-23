package me.madcabbage.shopping_system.console_ui;

import me.madcabbage.shopping_system.console_ui.menus.AdminMenus;
import me.madcabbage.shopping_system.console_ui.menus.BuyerMenus;
import me.madcabbage.shopping_system.console_ui.menus.SellerMenus;
import me.madcabbage.shopping_system.user.User;
import me.madcabbage.shopping_system.util.Console;

public class ConsoleUI {

    private static User currentUser = null;
    private static final String[] mainMenuOptions = { "Login", "Register", "Reset Password", "Exit" };

    private static boolean run;

    private ConsoleUI() {
        // hide implicit constructor
    }

    public static void show() {
        run = true;
        while (run) {
            String mainMenuInput = Console.promptWithChoicesSpaced("Main Menu:", mainMenuOptions);
            handleMainMenuInput(mainMenuInput);
        }
    }

    // Main Menu
    public static void handleMainMenuInput(String mainMenuInput) {
        // login option selected
        if (mainMenuInput.equals(mainMenuOptions[0])) {
            // todo store current user somewhere globally
            currentUser = LoginUI.handleLogin();
            if (currentUser == null) {
                Console.printSpaced("Invalid login information.");
            }
            else {
                Console.printSpaced("Login Successful");
                displayMainUserMenu();
            }
        }
        // register option selected
        else if (mainMenuInput.equals(mainMenuOptions[1])) {
            RegistrationUI.registerUser();
        }
        // reset password option selected
        else if (mainMenuInput.equals(mainMenuOptions[2])) {
            LoginUI.resetUserPassword();
        }
        // exit option selected
        else if (mainMenuInput.equals(mainMenuOptions[3])) {
            exit();
        }
    }

    private static void displayMainUserMenu() {
        switch (currentUser.getAccountType()) {
            case Buyer -> BuyerMenus.show();
            case Seller -> SellerMenus.show();
            case Admin -> AdminMenus.show();
            default -> throw new IllegalArgumentException("Invalid account type");
        }
    }

    private static void exit() {
        System.out.println("Goodbye");
        System.exit(0);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    // Buyer Menus


    // Seller Menus



}
