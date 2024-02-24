package me.madcabbage.shopping_system.util;

import me.madcabbage.shopping_system.user.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDatabase {

    private static final String applicationFolder = ".shoppingSystem";
    private static final String databaseFolder = "database";
    private static final String usersFolder = "users";
    private static final Path dbPath = Path.of(System.getProperty("user.home")).resolve(applicationFolder).resolve(databaseFolder);
    private static final Path userDbPath = dbPath.resolve(usersFolder);

    private FileDatabase() {
        // hide implicit constructor
    }

    public static void initializeDirectories() {
        try {
            Files.createDirectories(userDbPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String email) {
        try (FileInputStream fis = new FileInputStream(String.valueOf(userDbPath.resolve(email + ".ser")));
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (User) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            // intentionally left empty
            // if exception is thrown method will return null
        }
        return null;
    }

    public static boolean saveUser(User user) {
        try (FileOutputStream fos = new FileOutputStream(String.valueOf(String.valueOf(userDbPath.resolve(user.getEmail() + ".ser"))));
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
