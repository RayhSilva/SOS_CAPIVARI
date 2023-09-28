package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class TelaPrincipal extends AppCompatActivity {
    ImageView noticia;
    ImageView alerta;
    ImageView previsao;
    ImageView prevencao;
    FloatingActionButton floatingActionButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        noticia = (ImageView) findViewById(R.id.noticia);
        noticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noticia();
            }
        });

        alerta = (ImageView) findViewById(R.id.alerta);
        alerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta();
            }
        });

        previsao = (ImageView) findViewById(R.id.previsao);
        previsao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previsao();
            }
        });

        prevencao = (ImageView) findViewById(R.id.prevencao);
        prevencao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevencao();
            }
        });

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botaomais();
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



   // public void bateOSino(){
      //  Toast.makeText(this, "Bate o Sino Pequenino de Belém", Toast.LENGTH_SHORT).show();
    //}


    public void noticia() {
        Intent intent = new Intent(this, Noticia.class);
        startActivity(intent);
    }

    public void alerta() {
        Intent intent = new Intent(this, Alerta.class);
        startActivity(intent);
    }
        public void prevencao() {
            Intent intent = new Intent(this, Prevencao.class);
            startActivity(intent);
        }

    public void previsao() {
        Intent intent = new Intent(this, Previsao.class);
        startActivity(intent);}


        public void usuario() {
            Intent intent = new Intent(this, DadosUsuario.class);
            startActivity(intent);
        }
    public void adm() {
        Intent intent = new Intent(this, Adm.class);
        startActivity(intent);
    }

    public void botaomais() {
        Intent intent = new Intent(this, CadastroAlerta.class);
        startActivity(intent);
    }


    }
