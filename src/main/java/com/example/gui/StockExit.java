package com.example.gui;

import java.util.Date;

public class StockExit{
    Customer customer;
    Double salesAmt;
    Product product;
    Integer qtySold;
    Date date;

    public StockExit(Customer c, Product p, Double amt, Integer qty){
        customer = c;
        salesAmt = amt;
        product = p;
        qtySold = qty;
        date = new Date();
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