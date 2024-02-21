package me.madcabbage.shopping_system.user;

public class BuyerUser extends User {

    public BuyerUser(String email, String hashedPassword, String firstName, String lastName, String phoneNumber) {
        super(email, hashedPassword, firstName, lastName, phoneNumber, AccountType.Buyer);
    }
}
