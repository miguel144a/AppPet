package com.example.miguelvzz.apppet;

/**
 * Created by Miguel Vzz on 16/06/2016.
 */
public class Mascota {

    private String nombre;
    private int like;
    private int foto;
    private int foto_hueso_bla;
    private int foto_hueso_dor;

    public Mascota(String nombre, int like, int foto, int foto_hueso_bla, int foto_hueso_dor) {
        this.nombre = nombre;
        this.like = like;
        this.foto = foto;
        this.foto_hueso_bla = foto_hueso_bla;
        this.foto_hueso_dor = foto_hueso_dor;
    }

    public void setFoto_hueso_bla(int foto_hueso_bla) {
        this.foto_hueso_bla = foto_hueso_bla;
    }

    public void setFoto_hueso_dor(int foto_hueso_dor) {
        this.foto_hueso_dor = foto_hueso_dor;
    }

    public int getFoto_hueso_bla() {

        return foto_hueso_bla;
    }

    public int getFoto_hueso_dor() {
        return foto_hueso_dor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {

        return nombre;
    }

    public int getLike() {
        return like;
    }

    public int getFoto() {
        return foto;
    }
}
