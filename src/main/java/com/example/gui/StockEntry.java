package com.example.gui;

import java.util.Date;

public class StockEntry{
    Supplier supplier;
    Double purchaseAmt;
    Product product;
    Integer qtyBought;
    Date date;

    public StockEntry(Supplier s, Double amt, Product p, Integer qty){
        supplier = s;
        purchaseAmt = amt;
        product = p;
        qtyBought = qty;
        date = new Date();
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
                ", date=" + date +
                '}';
    }
}