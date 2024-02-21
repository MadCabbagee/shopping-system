package me.madcabbage.shopping_system.console_ui;

import me.madcabbage.shopping_system.user.AccountType;
import me.madcabbage.shopping_system.user.BuyerUser;
import me.madcabbage.shopping_system.user.SellerUser;
import me.madcabbage.shopping_system.user.User;
import me.madcabbage.shopping_system.util.Console;
import me.madcabbage.shopping_system.util.Security;

public class ConsoleUI {

    private static boolean run;
    private static final String[] mainMenuOptions = { "Login", "Register", "Reset Password" };
    private static final String[] sellerMenuOptions = { "Add Product", "Remove Product", "Edit Product", "View Products" };

    private static final String[] buyerMenuOptions = { "Browse" };
    private static final String[] buyerProductOptions = { "" };

    public static void run() {
        run = true;
        while (true) {
            String mainMenuInput = Console.promptWithChoicesSpaced("Main Menu:", mainMenuOptions);
            handleMainMenuInput(mainMenuInput);
        }
    }

    private static void handleMainMenuInput(String mainMenuInput) {
        if (mainMenuInput.equals(mainMenuOptions[0])) {
            loginUser();
        } else if (mainMenuInput.equals(mainMenuOptions[1])) {
            registerUser();
        } else if (mainMenuInput.equals(mainMenuOptions[2])) {
            resetUserPassword();
        }
    }

    private static void loginUser() {
        Console.print("Login:");
        String username = Console.promptSpaced("Enter email:");
        String password = Console.promptSpaced("Enter password:");
        // todo check username and password from db with input
    }

    private static void registerUser() {
        Console.print("Register:");
        AccountType accountType = getAccountType();
        String email = getValidEmail();
        String firstName = Console.promptSpaced("Enter username:");
        String lastName = Console.promptSpaced("Enter last name:");
        String phoneNumber = Console.promptSpaced("Enter phone number:");
        String password = getValidPassword();
        String hashedPassword = Security.hashPassword(password);
        User registered = null;
        switch (accountType) {
            case Buyer -> registered = new BuyerUser(email, hashedPassword, firstName, lastName, phoneNumber);
            case Seller -> registered = new SellerUser(email, hashedPassword, firstName, lastName, phoneNumber);
            default -> throw new IllegalArgumentException(); // todo create custom exception for invalid account type
        }
        // todo add this user to userDB
    }

    private static AccountType getAccountType() {
        String[] accTypes = new String[] { "Buyer", "Seller" };
        String accType = Console.promptWithChoicesSpaced("What account type are you registering for:", accTypes);

        if (accType.equals(accTypes[0])) {
            return AccountType.Buyer;
        } else if (accType.equals(accTypes[1])) {
            return AccountType.Seller;
        }
        // todo create custom exception for invalid account type
        throw new IllegalArgumentException();
    }

    private static String getValidEmail() {
        while (true) {
            String email1 = Console.promptSpaced("Enter valid email:");
            String email2 = Console.promptSpaced("Confirm valid email:");
            if (email1.equals(email2)) {
                return email1;
            } else {
                Console.printSpaced("Emails do not match");
            }
        }
    }

    private static String getValidPassword() {
        while (true) {
            String p1 = Console.promptSpaced("Enter desired password:");
            String p2 = Console.promptSpaced("Confirm password:");
            if (p1.equals(p2)) {
                return p1;
            } else {
                Console.printSpaced("Passwords do not match");
            }
        }
    }

    private static void resetUserPassword() {
        // todo reset user password using email
    }

}
