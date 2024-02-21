package me.madcabbage.shopping_system.user;

public class AdminUser extends User {

    public AdminUser(String email, String hashedPassword, String firstName, String lastName, String phoneNumber) {
        super(email, hashedPassword, firstName, lastName, phoneNumber, AccountType.Admin);
    }
}
