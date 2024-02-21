package me.madcabbage.shopping_system.seller;

import java.util.ArrayList;

public class Seller {
    //String id; make an ID for every thing e.g. Shipper ID would start SHP-001
    String name;
    String description;
    ArrayList<Product> productArrayList; //Array list to add the sellers products

    Seller(){

    }

    //Getter Methods
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }


    //Setter Methods
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }

    //Prompt Setter Methods

}
