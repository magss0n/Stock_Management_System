package com.example.gui;

public class StockEntry{
    Supplier supplier;
    Double purchaseAmt;
    Product product;
    Integer qtyBought;

    public StockEntry(Supplier s, Double amt, Product p, Integer qty){
        supplier = s;
        purchaseAmt = amt;
        product = p;
        qtyBought = qty;
    }

    public void viewPurchaseDetails(){

    }

    public Boolean execute(Stock st){
        return true;
    }

    @Override
    public String toString() {
        return "StockEntry{" +
                "supplier=" + supplier +
                ", purchaseAmt=" + purchaseAmt +
                ", product=" + product +
                ", qtyBought=" + qtyBought +
                '}';
    }
}