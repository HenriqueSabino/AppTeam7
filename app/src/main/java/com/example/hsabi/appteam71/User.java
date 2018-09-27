package com.example.hsabi.appteam71;

import java.io.Serializable;

public class User implements Serializable{

    public String userName;
    private String password;
    public String email;
    public String area;
    public String competencia;

    User(String userName, String password, String email, String area, String competencia){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.area = area;
        this.competencia = competencia;
    }

    public boolean CheckLogin(String entry, String password){
        if (entry.equals(this.email) || entry.equals(this.userName)){
            if (password.equals(this.password))
                return true;
        }
        else
            return false;
        return false;
    }

    public void TrocarSenha(String newPassword){
        password = newPassword;
    }

    @Override
    public  String toString(){
        return userName + "/" + password + "/" + email + "/" + area + "/" + competencia;
    }
}