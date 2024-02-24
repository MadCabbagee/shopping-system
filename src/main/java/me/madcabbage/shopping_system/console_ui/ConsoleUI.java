package me.madcabbage.shopping_system.console_ui;

import me.madcabbage.shopping_system.console_ui.menus.AdminMenus;
import me.madcabbage.shopping_system.console_ui.menus.BuyerMenus;
import me.madcabbage.shopping_system.console_ui.menus.SellerMenus;
import me.madcabbage.shopping_system.user.AccountType;
import me.madcabbage.shopping_system.user.User;
import me.madcabbage.shopping_system.util.Console;

public class ConsoleUI {
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
        if (mainMenuInput.equals(mainMenuOptions[0])) {
            // todo store current user somewhere globally
            User loggedIn = LoginUI.handleLogin();
            if (loggedIn != null) {
                Console.printSpaced("Logged in successfully");
            }
            handleAccType(loggedIn);
        }
        else if (mainMenuInput.equals(mainMenuOptions[1])) {
            RegistrationUI.registerUser();
        }
        else if (mainMenuInput.equals(mainMenuOptions[2])) {
            LoginUI.resetUserPassword();
        }
        else if (mainMenuInput.equals(mainMenuOptions[3])) {
            exit();
        }
    }

    private static void handleAccType(User loggedIn) {
        if (loggedIn == null) {
            return;
        }
        switch (loggedIn.getAccountType()) {
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

    // Buyer Menus


    // Seller Menus



}
