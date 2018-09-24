package com.example.hsabi.appteam71;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

public class FCadastro extends AppCompatActivity {

    private Spinner sp_area;
    private Spinner sp_competencia;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.f_cadastro);

        sp_area = (Spinner) findViewById(R.id.spn_areaInteresse);
        sp_competencia = (Spinner) findViewById(R.id.spn_competencias);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.list_areaInteresse, android.R.layout.simple_spinner_item);
        sp_area.setAdapter(adapter);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.list_competencia, android.R.layout.simple_spinner_item);
        sp_competencia.setAdapter(adapter2);

        AdapterView.OnItemSelectedListener choice = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        sp_area.setOnItemSelectedListener(choice);

        AdapterView.OnItemSelectedListener choice2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        sp_competencia.setOnItemSelectedListener(choice2);
    }

    public void OnClick(View view){
        boolean test = false;
        try {
            AccountsManager manager = new AccountsManager(getFilesDir(), getApplicationContext());
            String userName = ((EditText)findViewById(R.id.nomeCompleto)).getText().toString();
            String email = ((EditText)findViewById(R.id.email)).getText().toString();
            String senha = ((EditText)findViewById(R.id.senha)).getText().toString();
            String area = ((Spinner)findViewById(R.id.spn_areaInteresse)).getSelectedItem().toString();
            String competencia = ((Spinner)findViewById(R.id.spn_competencias)).getSelectedItem().toString();

            manager.Cadastrar(userName, senha, email, area, competencia);
        }
        catch (IOException e){
            Toast.makeText(getApplicationContext(),"IOException: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        catch (ClassNotFoundException e){
            Toast.makeText(getApplicationContext(),"ClassNotFoundException: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
