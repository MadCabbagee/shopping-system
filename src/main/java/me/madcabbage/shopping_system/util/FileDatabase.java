package me.madcabbage.shopping_system.util;

import me.madcabbage.shopping_system.products.Product;
import me.madcabbage.shopping_system.products.Seller;
import me.madcabbage.shopping_system.user.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDatabase {

    private static final String applicationFolder = ".shoppingSystem";
    private static final String databaseFolder = "database";
    private static final String usersFolder = "users";
    private static final String productsFolder = "products";
    private static final Path dbPath = Path.of(System.getProperty("user.home")).resolve(applicationFolder).resolve(databaseFolder);
    private static final Path userDbPath = dbPath.resolve(usersFolder);
    private static final Path productsDbPath = dbPath.resolve(productsFolder);

    private FileDatabase() {
        // hide implicit constructor
    }

    public static void initializeDirectories() {
        try {
            Files.createDirectories(dbPath);
            Files.createDirectory(userDbPath);
            Files.createDirectory(productsDbPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User getUser(String email) {
        try (FileInputStream fis = new FileInputStream(String.valueOf(userDbPath.resolve(email + ".ser")));
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (User) ois.readObject();
        } catch (IOException | ClassNotFoundException ignored) {
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

    // todo put each sellers products in separate folder
    public static Product getProduct(int id) {
        File productsDb = new File(productsDbPath.toString());
        File[] sellerDirs = productsDb.listFiles();
        if (sellerDirs == null) {
            return null;
        }
        for (File sellerDir : sellerDirs) {
            File productFile = new File(sellerDir, id + ".ser");
            if (productFile.exists()) {
                try (FileInputStream fis = new FileInputStream(productFile);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    return (Product) ois.readObject();
                } catch (IOException | ClassNotFoundException ignored) {
                    // intentionally left empty
                }
            }
        }

        return null;
    }

    public static boolean saveProduct(Product product) {
        // todo: save product in sellers folder
        try (FileOutputStream fos = new FileOutputStream(productsDbPath.resolve(product.getSeller().getName()).resolve(product.getId() + ".ser").toString());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(product);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // todo: cache results of this method
    public static Product[] getAllProducts() {
        // todo Loop thru each seller folder
        File[] productFiles = new File(String.valueOf(productsDbPath)).listFiles();
        int offset = 0;

        Product[] products = new Product[productFiles.length];
        for (int i = 0; i < productFiles.length; i++) {
            try {
                int id = Integer.parseInt(productFiles[i].getName());
                products[i - offset] = getProduct(id);
            } catch (NumberFormatException ignored) {
                offset++;
            }
        }

        return products;
    }

    public static Product[] getProductsBySeller(Seller seller) {
        // todo get products from each sellers folder
        Product[] allProducts = getAllProducts();

        int offset = 0;
        Product[] fromSeller = new Product[15];
        for (int i = 0; i < allProducts.length; i++) {
            Product p = allProducts[i];
            if (p.getSeller().equals(seller)) {
                fromSeller[i - offset] = p;
            } else {
                offset++;
            }
        }
        return fromSeller;
    }



}
