package com.example.gui;

import java.util.Date;

public class StockExit{
    Customer customer;
    Double salesAmt;
    Product product;
    Integer qtySold;
    Date date;

    public StockExit(){

    }

    public StockExit(Customer c, Product p, Double amt, Integer qty){
        customer = c;
        salesAmt = amt;
        product = p;
        qtySold = qty;
        date = new Date();
    }

    public Boolean execute(Stock st){
        return true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }

    public Double getSalesAmt() {
        return salesAmt;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQtySold() {
        return qtySold;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQtySold(Integer qtySold) {
        this.qtySold = qtySold;
    }

    public void setSalesAmt(Double salesAmt) {
        this.salesAmt = salesAmt;
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