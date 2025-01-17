package com.example.gui;

public class Customer extends Person{
    public String location;


    public Customer() {

    }

    public Customer(String name, String contact, String location){
        super(name, contact);
        this.location = location;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    @Override
    public String getContact() {
        return super.getContact();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
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
