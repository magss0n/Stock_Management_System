package com.example.gui;

public class Supplier extends Person{
    private String contributor_id ;
    public String location;

    public Supplier(String name, String contact, String location){
        super(name, contact);
        contributor_id = "QWNSF-838UEJ";
        this.location = location;
    }


    public Supplier(){

    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
    public void setName(String name){
        this.name = name;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public String getContributor_id() {
        return contributor_id;
    }

    public String getLocation() {
        return location;
    }

    public void setContributor_id(String contributor_id) {
        this.contributor_id = contributor_id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getContact() {
        return super.getContact();
    }
}
