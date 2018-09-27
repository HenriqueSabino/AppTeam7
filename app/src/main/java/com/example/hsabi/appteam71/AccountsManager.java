package com.example.hsabi.appteam71;

import android.content.Context;
import android.os.Message;
import android.widget.Toast;

import java.util.ArrayList;
import java.io.*;

public class AccountsManager {

    private ArrayList<User> users;
    File directory;
    Context context;
    AccountsManager (File directory, Context context) throws IOException, ClassNotFoundException{
        this.directory = directory;
        this.context = context;
        File accounts = new File(this.directory + "/accounts.acc");
        if (accounts.exists()){
            FileInputStream fis = new FileInputStream(accounts);
            ObjectInputStream ois = new ObjectInputStream(fis);

            users = (ArrayList<User>) ois.readObject();
        }
        else{
            accounts.createNewFile();
            users = new ArrayList<>();
            SaveAccounts();
        }
    }

    public void SaveAccounts() throws IOException{
        File accounts = new File(this.directory + "/accounts.acc");
        accounts.delete();
        accounts.createNewFile();
        FileOutputStream fos = new FileOutputStream(accounts);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
    }

    User Cadastrar (String userName, String senha, String email, String area, String competencia){
        User temp = new User (userName,senha,email,area,competencia);
        users.add(temp);
        try {
            SaveAccounts();
            return temp;
        }
        catch(Exception e){
            Toast.makeText(this.context, "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    User FindByEmail (String email){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).email.equals(email.toString())){
                return users.get(i);
            }
        }
        return null;
    }
}
