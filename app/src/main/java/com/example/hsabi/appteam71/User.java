package com.example.hsabi.appteam71;

import java.io.Serializable;

public class User implements Serializable{

    public String userName;
    private String password;
    public String email;
    private String area;
    private String competencia;

    User(String userName, String password, String email, String area, String competencia){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.area = area;
        this.competencia = competencia;
    }

    User(String user){
        String[] userInfo = user.split("/");
        this.userName = userInfo[0];
        this.password = userInfo[1];
        this.email = userInfo[2];
        this.area = userInfo[3];
        this.competencia = userInfo[4];
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

    @Override
    public  String toString(){
        return userName + "/" + password + "/" + email + "/" + area + "/" + competencia;
    }
}