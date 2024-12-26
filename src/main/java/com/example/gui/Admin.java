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
}
