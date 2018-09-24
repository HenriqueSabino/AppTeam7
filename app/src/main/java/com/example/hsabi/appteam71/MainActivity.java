package com.example.hsabi.appteam71;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CriarConta(View view){
        Intent i = new Intent(getApplicationContext(), FCadastro.class);
        startActivity(i);
    }

    public void Entrar (View view){
        try{
            AccountsManager manager = new AccountsManager(getFilesDir(), getApplicationContext());
            String email = ((EditText) findViewById(R.id.txt_email)).getText().toString();
            String senha = ((EditText) findViewById(R.id.txt_senha)).getText().toString();

            User temp = manager.FindByEmail(email);
            if (temp.CheckLogin(email, senha)){
                Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Erouuu!!!", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
