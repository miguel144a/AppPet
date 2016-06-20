package com.example.miguelvzz.apppet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView rv_mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarListaMascotas();

        rv_mascotas = (RecyclerView) findViewById(R.id.rv_mascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(llm);

        iniciaAdaptador();
    }

    public void iniciarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Perro", 10, R.drawable.dog_haski_icon, R.drawable.hueso, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Gato", 7, R.drawable.gato, R.drawable.hueso, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Ave", 5, R.drawable.ave, R.drawable.hueso, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Iguana", 1, R.drawable.iguana, R.drawable.hueso, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Pez", 4, R.drawable.pez, R.drawable.hueso, R.drawable.hueso_dorado));
    }

    public void iniciaAdaptador() {
        Mascota_adaptador adaptador = new Mascota_adaptador(mascotas,this);
        rv_mascotas.setAdapter(adaptador);
    }
}
