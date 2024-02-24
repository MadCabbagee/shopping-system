package me.madcabbage.shopping_system.auth;

import me.madcabbage.shopping_system.user.User;
import me.madcabbage.shopping_system.util.Console;
import me.madcabbage.shopping_system.util.FileDatabase;
import me.madcabbage.shopping_system.util.Security;

public class Auth {

    private Auth() {
        // hide implicit constructor
    }

    public static User authenticate(String email, String rawPass) {
        User user = FileDatabase.getUser(email);
        try {
            Security.hashPassword(rawPass).equals(user.getHashedPassword());
        } catch (NullPointerException e) {
            Console.printSpaced("Invalid login information.");
        } finally {
            return user;
        }
    }

}
