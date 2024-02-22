package me.madcabbage.shopping_system.seller;
import me.madcabbage.shopping_system.product.Product;
import java.util.ArrayList;


public class Seller {
    //String id; make an ID for every thing e.g. Shipper ID would start SHP-001
    private String name;
    private String description;
    private ArrayList<Product> productArrayList; //Array list to add the sellers products

    //create new seller
   public Seller(String name, String description, ArrayList<Product> productArrayList){

       this.name = name;
       this.description = description;
       this.productArrayList = productArrayList;
    }

    //seller but no product given
    public Seller(String name, String description){
       this(name,description,new ArrayList<Product>());
    }

    //seller initialization but one product is given
    public Seller(String name, String description, Product product){
        //Not sure yet if this works maybe create a function for it
        this.name = name;
        this.description = description;
        this.productArrayList = new ArrayList<Product>();
        productArrayList.add(product);
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

    //adder Methods
    public void addProduct(Product product){
       productArrayList.add(product);
    }
    public void addProduct(ArrayList<Product> productArrayList){

        for (int i = 0; i < productArrayList.size(); i++) {
            Product product = productArrayList.get(i);
            addProduct(product);
        }
    }
    public void removeProduct(Product productToBeDeleted)
    {
       productArrayList.remove(productToBeDeleted);
    }
    public void removeProduct(ArrayList<Product> productArrayList){

       for (Product product : productArrayList)
       {
           removeProduct(product);
       }
    }
}

