package com.example.miguelvzz.apppet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Lista_Favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotas1;
    RecyclerView rv_mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista__favoritos);

        Toolbar action_bar = (Toolbar) findViewById(R.id.barra_herramintas);
        setSupportActionBar(action_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mascotas = MainActivity.mascotas;
        //iniciarListaMascotas();

        rv_mascotas = (RecyclerView) findViewById(R.id.rv_mascotas_favoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(llm);

        iniciaAdaptador();

    }

    public void iniciaAdaptador() {

        Collections.sort(mascotas, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota mas1, Mascota mas2) {
                return new Integer(mas2.getLike()).compareTo(new Integer(mas1.getLike()));
            }
        });


        Mascota_adaptador adaptador = new Mascota_adaptador( mascotas,this);
        rv_mascotas.setAdapter(adaptador);
    }

}
