package com.example.miguelvzz.apppet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.miguelvzz.apppet.Mascota;
import com.example.miguelvzz.apppet.R;

import java.util.ArrayList;

/**
 * Created by Miguel Vzz on 05/07/2016.
 */
public class Queries extends SQLiteOpenHelper{

    private Context context;

    public Queries(Context context) {
        super(context, Configuracion.DATABASE_NAME, null, Configuracion.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota =
                "create table " + Configuracion.TB_MASCOTA + " (" +
                        Configuracion.TB_MASCOTA_ID_MASCOTA + " integer primary key autoincrement, " +
                        Configuracion.TB_MASCOTA_NOMBRE + " text, " +
                        Configuracion.TB_MASCOTA_FOTO + " integer" +
                        ")";

        String queryCrearTableLikeMascota =
                "create table " + Configuracion.TB_LIKES + "(" +
                        Configuracion.TB_LIKES_ID_LIKE + " integer primary key autoincrement, " +
                        Configuracion.TB_LIKES_ID_MASCOTA + " integer, " +
                        Configuracion.TB_LIKES_NUM_LIKE + " integer, " +
                        "foreign key (" + Configuracion.TB_LIKES_ID_MASCOTA + ") " +
                        "references " + Configuracion.TB_MASCOTA + "(" + Configuracion.TB_MASCOTA_ID_MASCOTA + ")" +
                        ")";

        String queryCrearTableCFG =
                "create table " + Configuracion.TB_CGF + "(" +
                        Configuracion.TB_CFG_ESTATUS + " integer)";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTableLikeMascota);
        db.execSQL(queryCrearTableCFG);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist " + Configuracion.TB_MASCOTA);
        db.execSQL("drop table if exist " + Configuracion.TB_LIKES);
        db.execSQL("drop table if exist " + Configuracion.TB_CGF);
        onCreate(db);
    }

    public boolean exitenMascotas() {

        boolean bandera = false;

        String query = "select count(1) from " + Configuracion.TB_MASCOTA;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            bandera = registros.getInt(0) > 0 ? true : false;
        }

        Log.d("Queries", "exitenMascotas() retorna: " + bandera);

        return bandera;
    }

    public ArrayList<Mascota> obtenerMascotas() {
        ArrayList<Mascota> listMascotas = new ArrayList<>();

        String query = "select * from " + Configuracion.TB_MASCOTA;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){

            Mascota mascota = new Mascota();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setFoto(registros.getInt(2));
            mascota.setLike(obtenerLikeMascota(mascota.getId()));
            mascota.setFoto_hueso_bla(R.drawable.hueso);
            mascota.setFoto_hueso_dor(R.drawable.hueso_dorado);
            listMascotas.add(mascota);
        }

        db.close();
        return listMascotas;
    }

    public void insertaMascotas(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Configuracion.TB_MASCOTA, null, values);
        db.close();
    }

    public int obtenerLikeMascota(int id) {

        int likes = 0;

        String query = "select count(1) from " + Configuracion.TB_LIKES +
                " where " + Configuracion.TB_LIKES_ID_MASCOTA + " = " + id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            likes = registros.getInt(0);
        }

        return likes;

    }

    public void insertaLikeMascota(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(Configuracion.TB_LIKES, null, values);
        db.close();
    }

    public int obtenerLikeMascota(Mascota mascota) {

        int likes = 0;

        String query =
                "select count(1) " +
                        "from " + Configuracion.TB_LIKES + " " +
                        "where " + Configuracion.TB_LIKES_ID_MASCOTA + " = " + mascota.getId();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
