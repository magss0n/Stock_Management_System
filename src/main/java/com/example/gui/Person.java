package com.example.gui;

abstract class Person {
    protected String name;
    protected String contact;

    public Person(String name, String contact){
        this.contact = contact;
        this.name = name;
    }
}
