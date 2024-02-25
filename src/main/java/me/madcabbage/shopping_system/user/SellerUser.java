package me.madcabbage.shopping_system.user;

public class SellerUser extends User {

    public SellerUser(String email, String hashedPassword, String firstName, String lastName, String phoneNumber) {
        super(email, hashedPassword, firstName, lastName, phoneNumber, AccountType.Seller);
    }
}
