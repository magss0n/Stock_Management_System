package com.example.gui;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;

import java.util.ArrayList;


public class Stock {
    static final ObjectMapper objectMapper = new ObjectMapper();

    private static final String STOCK = "C:\\Users\\Time_for_Business\\Documents\\INGE 3 ISI\\OOP\\StockManagement\\json_files\\products.json";

    private List<Product> products = new ArrayList<>();
    public static List<Product> readProducts() throws IOException {
        Product[] products = objectMapper.readValue(new File(STOCK), Product[].class);
        return new ArrayList<>(Arrays.asList(products));
    }

    public Stock(){

    }

    public static void writeProducts(List<Product> products) throws IOException {
        try {
            objectMapper.writeValue(new File(STOCK), products);
            System.out.println("Added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing users to file: " + e.getMessage());
            throw e; // Re-throw the exception after logging
        }
    }

    public static String getSTOCK() {
        return STOCK;
    }

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

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Boolean editProductQty(Product p, Integer qty) throws IOException {
        if(!products.contains(p)){
            AlertBox.display("Error","Product not found");
            return false;
        }
        else {
            setProducts(readProducts());
            System.out.println("Product to find " + p);
            System.out.println("Products" + products);
//            products.stream().filter(product -> Objects.equals(product.name, p.name)).toList().getFirst();
            Product a = products.stream().filter(product -> Objects.equals(product.name, p.name)).toList().getFirst();
            System.out.println("prod" + a);
            Integer i = products.indexOf(a);
            if (products.get(i).isAvailable(qty)) {
                products.get(i).setQty(products.get(i).getQty() - qty);
                writeProducts(getProducts());
                return true;
            }
            else{
                AlertBox.display("Error", "Insufficient quantity");
                return false;
            }
        }
    }

    public void editProduct(Product p){
        Product pro = products.stream().filter(product -> Objects.equals(product.name, p.name)).toList().getFirst();
        Integer i = products.indexOf(pro);
        EditEntity.product(products.get(i), this);
    }

    public void deleteProduct(Product p) throws IOException {
        products = readProducts();

        if(products.remove(p)){
            writeProducts(products);
            AlertBox.display("Deletion Complete", "Product deleted Successfully!!");
        }
        else AlertBox.display("Error", "Product not found!!");
    }
}
