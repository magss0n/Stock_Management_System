package com.example.gui;

import java.sql.Time;

public class Product{
    public String name;
    public Integer qty;
    public Double sellPrice;

    private Integer id = 0;
    private Double costPrice;

    public Product(String name, Double costPrice, Double sellP, Integer ID){
        this.name = name;
        this.sellPrice = sellP;
        this.costPrice = costPrice;
        this.qty = 0;
        id = ID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", costPrice=" + costPrice +
                ", sellPrice=" + sellPrice +
                ", qty=" + qty +
                '}';
    }
}
