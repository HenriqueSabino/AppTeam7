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

    public void TrocarSenha(View view){
        Intent myIntent = new Intent(getApplicationContext(), TrocarSenha.class);
        startActivity(myIntent);
    }

    public void Entrar (View view){
        try{
            AccountsManager manager = new AccountsManager(getFilesDir(), getApplicationContext());
            String email = ((EditText) findViewById(R.id.txt_email)).getText().toString();
            String senha = ((EditText) findViewById(R.id.txt_senha)).getText().toString();

            User temp = manager.FindByEmail(email);

            if (temp == null){
                Toast.makeText(getApplicationContext(), "Usuário não encontrado", Toast.LENGTH_LONG).show();
            }
            else if (temp.CheckLogin(email, senha)){
                Toast.makeText(getApplicationContext(), "Logado", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(getApplicationContext(), Inicial.class);
                startActivity(myIntent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Senha incorreta", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
