package me.madcabbage.shopping_system.util;

import me.madcabbage.shopping_system.products.*;
import me.madcabbage.shopping_system.util.FileDatabase;

import java.util.*;

public class Search {

    private Search()
    {
        //hide constructor
    }

    //function to search items with similar
    public static Product findProduct(String productName){
        Product[] allProducts = FileDatabase.getAllProducts();
        for (int i = 0; i < allProducts.length; i++) {
            Product currentProduct = allProducts[i];
            if (currentProduct.getName() == productName){
                return currentProduct;
            }
        }
        return null;
    }
    public static Product findProduct(String productName, Product[] products){
        for (int i = 0; i < products.length; i++) {
            Product currentProduct = products[i];
            if (currentProduct.getName() == productName){
                return currentProduct;
            }
        }
        return null;
    }

    public static Product findProduct(String productName, String filterType, String typeName) {
        try {
            switch (filterType) {
                case "Seller":
                    return sellerFilter(productName,typeName);
                case "Product Type":
                    return productTypeFilter(productName, typeName);
                default:
                    break;
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        return null;
    }

    private static Product productTypeFilter(String productName, String ProductType) {
        //add its implementation
        return null;
    }

    //todo add function to get seller in FileDataBase
    //todo add function to get all sellers in FileDataBase

    private static Product sellerFilter(String productName, String sellerName) {
        //add its implementation
        return null;
    }

    //algorithms I got from ChatGPT don't know how they work
    public static double jaccardSimilarity(String s1, String s2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        // Add characters from string s1 to set1
        for (char c : s1.toCharArray()) {
            set1.add(c);
        }

        // Add characters from string s2 to set2
        for (char c : s2.toCharArray()) {
            set2.add(c);
        }

        // Calculate the intersection size
        Set<Character> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        int intersectionSize = intersection.size();

        // Calculate the union size
        Set<Character> union = new HashSet<>(set1);
        union.addAll(set2);
        int unionSize = union.size();

        // Calculate Jaccard similarity
        return (double) intersectionSize / unionSize;
    }

    public static String[] searchClosestMatch(String query, String[] array) {
        Map<String, Double> similarityMap = new HashMap<>();

        // Calculate Jaccard similarity for each element in the array
        for (String element : array) {
            double similarity = jaccardSimilarity(query, element);
            similarityMap.put(element, similarity);
        }

        // Sort the elements by similarity in descending order
        List<Map.Entry<String, Double>> sortedList = new ArrayList<>(similarityMap.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Get the top 5 matching elements
        List<String> topMatches = new ArrayList<>();
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            topMatches.add(sortedList.get(i).getKey());
        }

        // Convert the list to an array
        String[] topMatchesArray = topMatches.toArray(new String[0]);

        // Return the array if matches are found, otherwise return "No matches"
        return topMatchesArray.length > 0 ? topMatchesArray : new String[]{"No matches"};
    }
    
    public static String[] getAllProductsNames(){
        Product[] allProducts = FileDatabase.getAllProducts();
        String[] allProductsNames = new String[allProducts.length];
        for (int i = 0; i < allProducts.length; i ++){
            String currentProductName = allProducts[i].getName();
            allProductsNames[i] = currentProductName;
        }
        return allProductsNames;
    }
    public static String[] getMatchingProductsNames(Product[] matchingProducts){
        Product[] allProducts = matchingProducts;
        String[] allProductsNames = new String[matchingProducts.length];
        for (int i = 0; i < matchingProducts.length; i ++){
            String currentProductName = matchingProducts[i].getName();
            allProductsNames[i] = currentProductName;
        }
        return allProductsNames;
    }

    //return an array of matched products
    public  static Product[] matchingProducts(String productNameToSearch){
        final int MATCHES = 5;
        String[] matches = searchClosestMatch(productNameToSearch,getAllProductsNames());
        Product[] matchedProducts = new Product[MATCHES];
        for (int i = 0; i < MATCHES; i++) {
            matchedProducts[i] = findProduct(matches[i]);
        }
        return matchedProducts;
    }

}
