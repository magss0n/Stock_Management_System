package com.example.gui;


public class Product{
    public String name;
    private Integer qty;
    public Double sellPrice;
    public String category;
    private Integer id = 0;
    private Double costPrice;

    public Product(){

    }

    public Product(String name, String category, Double costPrice, Double sellP, Integer ID){
        this.name = name;
        this.category = category;
        this.sellPrice = sellP;
        this.costPrice = costPrice;
        this.qty = 0;
        id = ID;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQty() {
        return qty;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Boolean isAvailable( Integer qty){
        return this.qty >= qty;

    }

    public String getName() {
        return name;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", costPrice=" + costPrice +
                ", sellPrice=" + sellPrice +
                ", qty=" + qty +
                '}';
    }
}
