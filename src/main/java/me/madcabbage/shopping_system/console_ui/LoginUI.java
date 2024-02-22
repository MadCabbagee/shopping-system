package me.madcabbage.shopping_system.console_ui;

import me.madcabbage.shopping_system.user.User;
import me.madcabbage.shopping_system.util.Console;
import me.madcabbage.shopping_system.util.FileDatabase;
import me.madcabbage.shopping_system.util.Security;

public class LoginUI {

    private LoginUI() {
        // disable instantiation because static class.
    }

    public static User loginUser() {
        Console.print("Login:");
        String email = Console.prompt("Enter email:");
        String password = Console.promptSpaced("Enter password:");
        // todo check username and password from db with input
        // if valid login then return true
        User user = FileDatabase.getUser(email);
        try {
            Security.hashPassword(password).equals(user.getHashedPassword());
        } catch (NullPointerException e) {
            Console.printSpaced("Invalid login information.");
        } finally {
            return user;
        }
    }

    public static void resetUserPassword() {
        // todo reset user password using email
    }
}
