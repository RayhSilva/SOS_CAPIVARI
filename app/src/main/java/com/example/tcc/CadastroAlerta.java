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
import android.widget.ProgressBar;
import android.widget.Toast;

public class CadastroAlerta extends AppCompatActivity {
    EditText txtRua, txtNumero, txtBairro, txtCEP, txtPontoRef, txtComplemento;
   Button btnCadastrarAlerta;
    ProgressBar progressBar;


public static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alerta);

        activity = this;

        txtRua = (EditText) findViewById(R.id.txtRua);
        txtNumero = (EditText) findViewById(R.id.txtNumero);
        txtBairro = (EditText) findViewById(R.id.txtBairro);
        txtCEP = (EditText) findViewById(R.id.txtCEP);
        txtPontoRef = (EditText) findViewById(R.id.txtPontoRef);
        txtComplemento = (EditText) findViewById(R.id.txtComplemento);
        btnCadastrarAlerta = (Button) findViewById(R.id.btnCadastrarAlerta);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);


        btnCadastrarAlerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strRua = txtRua.getText().toString();
                String strNumero = txtNumero.getText().toString();
                String strBairro = txtBairro.getText().toString();
                String strCEP = txtCEP.getText().toString();
                String strPontoRef = txtPontoRef.getText().toString();
                String strComplemento = txtComplemento.getText().toString();

                if(strBairro.equals("") || strCEP.equals("") || strComplemento.equals("") ||
                        strRua.equals("") || strNumero.equals("")  || strPontoRef.equals("") );{
                    Toast.makeText(CadastroAlerta.this, "Preencha os Campos para salvar", Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.VISIBLE);

                DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
                helper.inseriralerta(strRua,strNumero,strBairro, strCEP, strPontoRef, strComplemento );

            }
        });
    }



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

