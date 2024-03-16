package me.madcabbage.shopping_system.util;

import me.madcabbage.shopping_system.products.*;
import me.madcabbage.shopping_system.util.FileDatabase;

import java.util.*;

public class Search {

    /*okay need to search items from the dataBase.
    * first I got to know how are the items stored
    * then search for items
    * this is a static class
    */

    private Search()
    {
        //hide constructor
    }

    //function to search items with similar names

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

    //todo implement algorithm to find closest input matches
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

    public static String[] search(String query, String[] array) {
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

}
