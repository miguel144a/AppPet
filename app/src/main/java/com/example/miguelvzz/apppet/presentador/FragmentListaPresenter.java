package com.example.miguelvzz.apppet.presentador;

import android.content.Context;
import android.util.Log;

import com.example.miguelvzz.apppet.Mascota;
import com.example.miguelvzz.apppet.db.ConstructorMascotas;
import com.example.miguelvzz.apppet.fragments.IFrameLista;

import java.util.ArrayList;

/**
 * Created by Miguel Vzz on 05/07/2016.
 */
public class FragmentListaPresenter implements IFragmentListaPresenter {

    private IFrameLista iFrameLista;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FragmentListaPresenter(IFrameLista iFrameLista, Context context) {
        this.iFrameLista = iFrameLista;
        this.context = context;
    }

    @Override
    public void obtenerMascotasDB() {

        Log.d("FragmentListaPresenter", "Entro al metodo obtenerMascotasDB");
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iFrameLista.inicializaAdaptadorRV(iFrameLista.crearAdaptador(mascotas));
        iFrameLista.generaLinearLayoutVertical();
    }
}
