package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText txtEmailL, txtSenhaL;
    Button btnEntrar;
    ProgressBar progressbar;
    public static Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login = this;

        txtEmailL = (EditText) findViewById(R.id.txtEmailL);
        txtSenhaL = (EditText) findViewById(R.id.txtSenhaL);
        btnEntrar= (Button) findViewById(R.id.btnEntrar);
        progressbar= (ProgressBar) findViewById(R.id.progressbar);
        progressbar.setVisibility(View.GONE);
        //verificarLoginSenha();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Entrar();


                String strEmail = txtEmailL.getText().toString();
                String strSenha = txtSenhaL.getText().toString();

                progressbar.setVisibility(View.VISIBLE);
                DatabaseHelper helper= new DatabaseHelper(getApplicationContext());
                helper.autenticaUsuario(strEmail,strSenha);

            }
        });


        }




    public void Entrar() {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }}