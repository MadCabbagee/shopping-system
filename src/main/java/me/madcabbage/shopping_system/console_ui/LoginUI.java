package me.madcabbage.shopping_system.console_ui;

import me.madcabbage.shopping_system.auth.Auth;
import me.madcabbage.shopping_system.user.User;
import me.madcabbage.shopping_system.util.Console;
import me.madcabbage.shopping_system.util.FileDatabase;
import me.madcabbage.shopping_system.util.Security;

public class LoginUI {

    private LoginUI() {
        // disable instantiation because static class.
    }

    public static User handleLogin() {
        Console.print("Login:");
        String email = Console.prompt("Enter email:");
        String password = Console.promptSpaced("Enter password:");

        return Auth.authenticate(email, password);
    }

    public static void resetUserPassword() {
        // todo reset user password using email
    }
}
