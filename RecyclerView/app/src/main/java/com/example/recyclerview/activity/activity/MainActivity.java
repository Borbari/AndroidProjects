package com.example.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter( listaFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(getApplicationContext(),"Item pressionado: " + filme.getTituloFilme(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Filme filme = listaFilmes.get(position);
                Toast.makeText(getApplicationContext(),"Click longo: " + filme.getTituloFilme(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    public void criarFilmes() {
        Filme filme = new Filme("Feel the Beat", "Dança", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("365 Dias", "Romance", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("Bala Perdida", "Suspense", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Missy Errada", "Ação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Destacamento Blood", "genero", "2015");
        this.listaFilmes.add(filme);

        filme = new Filme("O Silêncio do Pântano", "Terror", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Terra e o Sangue", "Ação", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("Legado nos Ossos", "Suspense", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Os Vingadores - The Avengers", "Aventura", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem de Ferro", "Aventura", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Aventura", "2019");
        this.listaFilmes.add(filme);

        filme = new Filme("Thor", "Aventura", "2019");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem Aranha", "Aventura", "2019");
        this.listaFilmes.add(filme);
    }
}
