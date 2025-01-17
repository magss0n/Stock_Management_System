package com.example.gui;

import java.util.Date;

public class StockEntry{
    Supplier supplier;
    Double purchaseAmt;
    Product product;
    Integer qtyBought;
    Date date;

    public StockEntry(){

    }

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

    public Double getPurchaseAmt() {
        return purchaseAmt;
    }

    public Date getDate() {
        return date;
    }

    public Integer getQtyBought() {
        return qtyBought;
    }

    public Product getProduct() {
        return product;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQtyBought(Integer qtySold) {
        this.qtyBought = qtySold;
    }

    public void setPurchaseAmt(Double salesAmt) {
        this.purchaseAmt = salesAmt;
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