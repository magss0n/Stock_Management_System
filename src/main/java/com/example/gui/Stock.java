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
            System.out.println("Product not found");
        }
        else {
            Integer i = products.indexOf(p);
            products.get(i).qty = qty;
        }
    }

    public List<Product> getProducts(){
        return products;
    }

    public Boolean isAvailable(Product p, Integer qty){
        Integer i = products.indexOf(p);
        return products.get(i).qty >= qty;

    }

    public Boolean editProduct(Product p, Integer qty){
        if(!products.contains(p)){
            AlertBox.display("Error","Product not found");
            return false;
        }
        else {
            Integer i = products.indexOf(p);
            if (isAvailable(products.get(i), qty)) {
                products.get(i).qty -= qty;
                return true;
            }
            else{
                AlertBox.display("Error", "Insufficient quantity");
                return false;
            }
        }
    }
}
