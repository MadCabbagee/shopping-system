package me.madcabbage.shopping_system.user;

import java.io.Serializable;

public abstract class User implements Serializable {

    protected final String email;
    protected final String hashedPassword;
    protected final String firstName;
    protected final String lastName;
    protected final String phoneNumber;
    protected final AccountType accountType;

    protected User(String email, String hashedPassword, String firstName, String lastName, String phoneNumber, AccountType accountType) {
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
