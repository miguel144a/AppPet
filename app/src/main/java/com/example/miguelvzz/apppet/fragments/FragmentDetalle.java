package com.example.miguelvzz.apppet.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miguelvzz.apppet.Mascota;
import com.example.miguelvzz.apppet.R;
import com.example.miguelvzz.apppet.adaptadores.Mascota_adaptador;
import com.example.miguelvzz.apppet.adaptadores.Mascota_adaptador1;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class FragmentDetalle extends Fragment {

    RecyclerView rv_detalle_mascotas;
    static ArrayList<Mascota> mascotas;
    private CircularImageView circularImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_fragment_detalle, container, false);

        rv_detalle_mascotas = (RecyclerView) v.findViewById(R.id.rv_detalle_mascotas);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);

        rv_detalle_mascotas.setLayoutManager(glm);

        iniciarListaMascotas();
        iniciaAdaptador();

        return v;
    }

    public void iniciaAdaptador() {
        Mascota_adaptador1 adaptador = new Mascota_adaptador1(mascotas, getActivity());
        rv_detalle_mascotas.setAdapter(adaptador);
    }

    public void iniciarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Perro", 10, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Perro", 2, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Perro", 24, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Perro", 12, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Perro", 1, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Perro", 24, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Perro", 15, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Perro", 2, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Perro", 18, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Perro", 30, R.drawable.dog_haski_icon, R.drawable.hueso_dorado));

        /*mascotas.add(new Mascota("Gato", 7, R.drawable.gato, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Gato", 7, R.drawable.gato, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Gato", 7, R.drawable.gato, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Gato", 7, R.drawable.gato, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Gato", 7, R.drawable.gato, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Ave", 5, R.drawable.ave, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Ave", 5, R.drawable.ave, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Ave", 5, R.drawable.ave, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Ave", 5, R.drawable.ave, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Ave", 5, R.drawable.ave, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Ave", 5, R.drawable.ave, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Iguana", 1, R.drawable.iguana, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Iguana", 1, R.drawable.iguana, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Iguana", 1, R.drawable.iguana, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Iguana", 1, R.drawable.iguana, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Iguana", 1, R.drawable.iguana, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Pez", 4, R.drawable.pez, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Pez", 4, R.drawable.pez, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Pez", 4, R.drawable.pez, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Pez", 4, R.drawable.pez, R.drawable.hueso_dorado));
        mascotas.add(new Mascota("Pez", 4, R.drawable.pez, R.drawable.hueso_dorado));*/
    }
}
