package com.example.tcc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Alerta extends AppCompatActivity {

    ListView lista;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerta);

        lista = (ListView) findViewById(R.id.lista);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarAlerta();


            }
        });

        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        helper.ListarAlertas(new listarAlertasCallback(){


            @Override
            public void listarAlertasOnCallback(ArrayList<MovimentoOBJ> listaMovimentos) {
               System.out.println(listaMovimentos.size());
                //setar o adapter do rw
                /*
               rcwAlerta.setAdapter(new AdapterAlertas(listaMovimentos));
               RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                       LinearLayoutManager.VERTICAL, false);
               rcwAlerta.setLayoutManager(layoutManager); */

          preencherLista(listaMovimentos);

            }
        });
    }

        public void preencherLista(ArrayList<MovimentoOBJ> listaMovimentos){
            ArrayList<String> linhas = new ArrayList<String>();
            ArrayAdapter meuAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                    android.R.id.text1, linhas);

            lista.setAdapter(meuAdapter);
            for (int i=0; i<listaMovimentos.size(); i++){
                MovimentoOBJ mv= listaMovimentos.get(i);
                linhas.add(mv.getRua()+ "," + mv.getNumero() + "," + mv.getBairro() + "," + mv.getComplemento() + ","
                        + mv.getCEP() + "," + mv.getPontoRef() + ",");

            }

        }

        public interface listarAlertasCallback {
            void listarAlertasOnCallback(ArrayList<MovimentoOBJ> listaMovimentos);
            // PAREI NO MINUTO 23:36
        }
/*
        public class AdapterAlertas extends RecyclerView.Adapter{
                 ArrayList<MovimentoOBJ> movimentoOBJ;

                 public AdapterAlertas (ArrayList<MovimentoOBJ> movimentoOBJ){
                     this.movimentoOBJ = movimentoOBJ;
                 }

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        }
*/

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

    public void cadastrarAlerta() {
        Intent intent = new Intent(this, CadastroAlerta.class);
        startActivity(intent);
    }
}
