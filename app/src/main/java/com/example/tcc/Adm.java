package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Adm extends AppCompatActivity {
    EditText txtRua, txtBairro;
    RadioButton rdLeve, rdModerado, rdSevero;
    Button btnEntrar;


    public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm);

        activity  = this;

        txtRua = (EditText) findViewById(R.id.txtRua);
        txtBairro= (EditText) findViewById(R.id.txtBairro);
        btnEntrar= (Button) findViewById(R.id.btnEnviar);
        rdLeve = (RadioButton) findViewById(R.id.rdLeve);
        rdModerado = (RadioButton) findViewById(R.id.rdModerado);
        rdSevero = (RadioButton) findViewById(R.id.rdSevero);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Entrar();

                String strRua = txtRua.getText().toString();
                String strBairro = txtBairro.getText().toString();
                String strLeve = rdLeve.getText().toString();
                String strModerado = rdModerado.getText().toString();
                String strSevero = rdSevero.getText().toString();

               DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
                helper.alertaAdm(strRua, strBairro, strLeve, strModerado, strSevero);

                System.out.println("oiiiiii");

            }
        });




    }

    //DatabaseHelper helper = new DatabaseHelper(getApplicationContext());

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dados_usuario:
                usuario();
                return true;
            case R.id.administrador:
                adm();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    public void usuario() {
        Intent intent = new Intent(this, DadosUsuario.class);
        startActivity(intent);
    }
    public void adm() {
        Intent intent = new Intent(this, Adm.class);
        startActivity(intent);
    }
}

