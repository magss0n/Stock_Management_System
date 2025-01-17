package com.example.gui;

abstract class Person {
    protected String name;
    protected String contact;

    public Person(){

    }

    public Person(String name, String contact){
        this.contact = contact;
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public String getName() {
        return name;
    }
}
