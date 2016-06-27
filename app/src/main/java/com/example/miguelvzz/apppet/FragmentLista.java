package com.example.miguelvzz.apppet;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miguelvzz.apppet.adaptadores.Mascota_adaptador;

import java.util.ArrayList;

public class FragmentLista extends Fragment {

    RecyclerView rv_mascotas;
    static ArrayList<Mascota> mascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_fragment_lista, container, false);

        rv_mascotas = (RecyclerView) v.findViewById(R.id.rv_mascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(llm);

        iniciarListaMascotas();
        iniciaAdaptador();

        return v;
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
        Mascota_adaptador adaptador = new Mascota_adaptador(mascotas, getActivity());
        rv_mascotas.setAdapter(adaptador);
    }
}
