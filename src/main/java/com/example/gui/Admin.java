package com.example.gui;

import java.util.Objects;

public class Admin extends Person{
    private String id;
    private String password;

    public Admin(){
        super("Moutcheu", "670955565");
        id = "qwertyuiop";
        password = "zxcvbnm";
    }

    public Boolean authenticate(String id, String pass){
        return Objects.equals(this.password, pass) && Objects.equals(this.id, id);
    }

    public String getName(){
        return this.name;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
