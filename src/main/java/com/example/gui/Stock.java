package com.example.gui;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<Product> products = new ArrayList<>();


    public void addProduct(Product p){
        products.add(p);
    }

    public void viewStock(){
        products.forEach(product -> {
            System.out.println(product.toString());
        });
    }

    public void setQty(Product p, Integer qty){
        if(!products.contains(p)){
            AlertBox.display("Error","Product not found");
        }
        else {
            Integer i = products.indexOf(p);
            products.get(i).setQty(products.get(i).getQty()+qty);
        }
    }

    public List<Product> getProducts(){
        return products;
    }

    public Boolean editProductQty(Product p, Integer qty){
        if(!products.contains(p)){
            AlertBox.display("Error","Product not found");
            return false;
        }
        else {
            Integer i = products.indexOf(p);
            if (products.get(i).isAvailable(qty)) {
                products.get(i).setQty(products.get(i).getQty() - qty);
                return true;
            }
            else{
                AlertBox.display("Error", "Insufficient quantity");
                return false;
            }
        }
    }

    public void editProduct(Product p){
        Integer i = products.indexOf(p);
        EditEntity.product(products.get(i), this);
    }

    public void deleteProduct(Product p){
        if(products.remove(p)){
            AlertBox.display("Deletion Complete", "Product deleted Successfully!!");
        }
        else AlertBox.display("Error", "Product not found!!");
    }
}
