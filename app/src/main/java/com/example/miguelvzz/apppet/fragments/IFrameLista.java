package com.example.miguelvzz.apppet.fragments;

import com.example.miguelvzz.apppet.Mascota;
import com.example.miguelvzz.apppet.adaptadores.Mascota_adaptador;

import java.util.ArrayList;

/**
 * Created by Miguel Vzz on 05/07/2016.
 */
public interface IFrameLista {

    public void generaLinearLayoutVertical();
    public Mascota_adaptador crearAdaptador(ArrayList<Mascota> contactos);
    public void inicializaAdaptadorRV(Mascota_adaptador adaptador);
}
