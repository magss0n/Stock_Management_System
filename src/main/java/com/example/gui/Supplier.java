package com.example.gui;

public class Supplier extends Person{
    private String contributor_id;
    public String location;

    public Supplier(String name, String contact, String location){
        super(name, contact);
        contributor_id = "QWNSF-838UEJ";
        this.location = location;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
