package com.example.miguelvzz.apppet.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.miguelvzz.apppet.Mascota;
import com.example.miguelvzz.apppet.R;
import com.example.miguelvzz.apppet.mail.Config;

import java.util.ArrayList;

/**
 * Created by Miguel Vzz on 05/07/2016.
 */
public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotas() {

        Log.d("ConstructorMascota", "obtenerMascotas()");
        Queries q = new Queries(context);

        if (!existenMascotas()) {
            insertaMascotas(q);
        }

        return q.obtenerMascotas();
    }

    public boolean existenMascotas() {

        boolean bandera = false;

        Queries q = new Queries(context);

        bandera = q.exitenMascotas();

        System.out.print("Existe mascotas: " + bandera);

        Log.d("ConstructorMascota", "existenMascotas() retorna: " + bandera);
        return bandera;
    }

    public void insertaMascotas(Queries q) {

        ContentValues values = new ContentValues();
        values.put(Configuracion.TB_MASCOTA_NOMBRE, "Perro");
        values.put(Configuracion.TB_MASCOTA_FOTO, R.drawable.dog_haski_icon);
        q.insertaMascotas(values);

        values.put(Configuracion.TB_MASCOTA_NOMBRE, "Gato");
        values.put(Configuracion.TB_MASCOTA_FOTO, R.drawable.gato);
        q.insertaMascotas(values);

        values.put(Configuracion.TB_MASCOTA_NOMBRE, "Ave");
        values.put(Configuracion.TB_MASCOTA_FOTO, R.drawable.ave);
        q.insertaMascotas(values);

        values.put(Configuracion.TB_MASCOTA_NOMBRE, "Iguana");
        values.put(Configuracion.TB_MASCOTA_FOTO, R.drawable.iguana);
        q.insertaMascotas(values);

        values.put(Configuracion.TB_MASCOTA_NOMBRE, "Pez");
        values.put(Configuracion.TB_MASCOTA_FOTO, R.drawable.pez);
        q.insertaMascotas(values);

    }

    public void darLikeMascota(Mascota mascota) {

        Queries db = new Queries(context);
        ContentValues values = new ContentValues();
        values.put(Configuracion.TB_LIKES_ID_MASCOTA, mascota.getId());
        values.put(Configuracion.TB_LIKES_NUM_LIKE, LIKE);
        db.insertaLikeMascota(values);
        db.close();

    }

    public int obtenerLikeMascota(Mascota mascota) {
        Queries db = new Queries(context);

        return db.obtenerLikeMascota(mascota);
    }
}
