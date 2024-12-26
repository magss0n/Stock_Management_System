package com.example.gui;

public class StockExit{
    Customer customer;
    Double salesAmt;
    Product product;
    Integer qtySold;

    public StockExit(Customer c, Product p, Double amt, Integer qty){
        customer = c;
        salesAmt = amt;
        product = p;
        qtySold = qty;
    }

    public void printPaymentReceipt(){

    }

    public Boolean execute(Stock st){
        return true;
    }

    @Override
    public String toString() {
        return "StockExit{" +
                "customer=" + customer +
                ", salesAmt=" + salesAmt +
                ", product=" + product +
                ", qtySold=" + qtySold +
                '}';
    }
}