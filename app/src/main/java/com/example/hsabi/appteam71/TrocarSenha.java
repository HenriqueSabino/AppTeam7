package com.example.hsabi.appteam71;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TrocarSenha extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trocar_senha);
    }

    public void TrocarSenha(View view){
        try {
            String email = ((EditText) findViewById(R.id.txt_email_tsenha)).getText().toString();
            String newPassword = ((EditText) findViewById(R.id.txt_novaSenha)).getText().toString();
            AccountsManager manager = new AccountsManager(getFilesDir(), getApplicationContext());
            User temp = manager.FindByEmail(email);
            temp.TrocarSenha(newPassword);
            manager.SaveAccounts();

            Toast.makeText(getApplicationContext(), "Senha trocada", Toast.LENGTH_LONG).show();

            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(myIntent);
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
