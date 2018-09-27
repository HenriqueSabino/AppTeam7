package com.example.hsabi.appteam71;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.f_cadastro);
        Resources res = getResources();

        Spinner sp = (Spinner)findViewById(R.id.spn_areaInteresse);
        String[] array = res.getStringArray(R.array.list_areaInteresse);
        SetSpinnerHint(sp, array);

        sp = (Spinner)findViewById(R.id.spn_competencias);
        array = res.getStringArray(R.array.list_competencia);
        SetSpinnerHint(sp, array);
    }

    public void OnClick(View view) {
        try {
            AccountsManager manager = new AccountsManager(getFilesDir(), getApplicationContext());
            String userName = ((EditText) findViewById(R.id.nomeCompleto)).getText().toString();
            String email = ((EditText) findViewById(R.id.email)).getText().toString();
            String senha = ((EditText) findViewById(R.id.senha)).getText().toString();
            String cSenha = ((EditText) findViewById(R.id.confirmar_senha)).getText().toString();
            Spinner area = (Spinner) findViewById(R.id.spn_areaInteresse);
            Spinner competencia = (Spinner) findViewById(R.id.spn_competencias);

            Test(userName, senha, cSenha, email, area, competencia, manager);
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    void Test (String userName, String senha, String cSenha, String email, Spinner area, Spinner competencia, AccountsManager manager){
        if (userName.isEmpty() || senha.isEmpty() || cSenha.isEmpty() || email.isEmpty() || area.getSelectedItemPosition() == 0 || competencia.getSelectedItemPosition() == 0){
            Toast.makeText(getApplicationContext(), "Preencha todas as entradas", Toast.LENGTH_LONG).show();
        }
        else if (!cSenha.equals(senha.toString())){
            Toast.makeText(getApplicationContext(), "As senhas precisam coincidir", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),manager.Cadastrar(userName, senha, email, area.getSelectedItem().toString(), competencia.getSelectedItem().toString()).toString(), Toast.LENGTH_LONG).show();
        }
    }

    void SetSpinnerHint(Spinner sp, String[] array){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, array){
            @Override
            public boolean isEnabled (int position){
                if (position == 0)
                    return false;
                else
                    return true;
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
    }
}
