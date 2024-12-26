package com.example.gui;

public class Customer extends Person{
    public String location;

    public Customer(String name, String contact, String location){
        super(name, contact);
        this.location = location;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
