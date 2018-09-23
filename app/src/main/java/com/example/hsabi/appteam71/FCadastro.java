package com.example.hsabi.appteam71;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class FCadastro extends AppCompatActivity {

    private Spinner sp;
    private String[] areasInteresse;
    private String[] competencias;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.f_cadastro);

        sp = (Spinner) findViewById(R.id.spn_areaInteresse);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.list_areaInteresse, android.R.layout.simple_spinner_item);
        sp.setAdapter(adapter);

        AdapterView.OnItemSelectedListener choice = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = sp.getSelectedItem().toString();
                System.out.println("item: " + item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        sp.setOnItemSelectedListener(choice);
    }

    public void OnClick(View view){
        System.out.println("Conta Criada");
    }
}
