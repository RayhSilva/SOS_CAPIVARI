package com.example.tcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TelaInicial extends AppCompatActivity {
    private TextView text_cadastrar;
    Button btnLogin;
    Button btnSemCadastro;
    SQLiteDatabase bancoDados;

    //Firebase autenticação
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        IniciarComponentes();
        text_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TelaInicial.this, CriarConta.class);
                startActivity(intent);
            }
        });

        btnLogin = (Button) findViewById(R.id.btnEntrar);
        btnSemCadastro = (Button) findViewById(R.id.btnSemCadastro);

        btnSemCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SemCadastro();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cadastro_Entrar();
            }
        });



        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            System.out.println("tentando logar");
            reload("teste@teste.com", "123456");
            Toast.makeText(TelaInicial.this, "Authentication OK.",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(TelaInicial.this, "Usuário logado:\n"+
                            mAuth.getCurrentUser().getUid() +"\n" +
                            mAuth.getCurrentUser().getEmail() +"\n"
                    ,
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

    }

    //autentica no firebase
    private void reload(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                           // System.out.println("LOGADO!");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // System.out.println("ID do usuário: " + user);
                            //Toast.makeText(TelaInicial.this, "Authentication OK.\n" + user,
                              //      Toast.LENGTH_SHORT).show();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            System.out.println("Erro: " + task.getException());
                            Toast.makeText(TelaInicial.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }
/*
    public void criarBancoDados () {

        try {
            bancoDados = openOrCreateDatabase("sosCapivari", MODE_PRIVATE, null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS usuario (" +
                    " Email VARCHAR PRIMARY KEY" +
                    " , Senha VARCHAR" +
                    " , Nome VARCHAR" +
                    ", Tipo VARCHAR)"); // 'comum' ou 'adm'
            //bancoDados.execSQL("DELETE FROM animal");
           // bancoDados.execSQL("INSERT INTO usuario (Email,Senha) VALUES('wagner','123','comum') ");
            //bancoDados.execSQL("INSERT INTO usuario (Email,Senha,Tipo) VALUES('ray','12324687651','adm') ");
            bancoDados.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

    public void Cadastro_Entrar() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void SemCadastro() {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }



private void IniciarComponentes(){
    text_cadastrar= findViewById(R.id.text_cadastrar);
}}