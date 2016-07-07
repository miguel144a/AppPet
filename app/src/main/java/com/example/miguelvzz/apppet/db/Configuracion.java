package com.example.miguelvzz.apppet.db;

/**
 * Created by Miguel Vzz on 05/07/2016.
 */
public class Configuracion {

    public static final String DATABASE_NAME = "db_mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TB_MASCOTA = "mascotas";
    public static final String TB_MASCOTA_ID_MASCOTA = "id_mascota";
    public static final String TB_MASCOTA_NOMBRE = "nombre";
    public static final String TB_MASCOTA_FOTO = "foto";

    public static final String TB_LIKES = "mascota_likes";
    public static final String TB_LIKES_ID_LIKE = "id_like";
    public static final String TB_LIKES_ID_MASCOTA = "id_mascota";
    public static final String TB_LIKES_NUM_LIKE = "num_like";

    public static final String TB_CGF = "config";
    public static final String TB_CFG_ESTATUS = "estatus";

}
