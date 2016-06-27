package com.example.miguelvzz.apppet.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miguelvzz.apppet.Mascota;
import com.example.miguelvzz.apppet.R;

import java.util.ArrayList;

/**
 * Created by Miguel Vzz on 27/06/2016.
 */
public class Mascota_adaptador1 extends  RecyclerView.Adapter<Mascota_adaptador1.MascotaViewHolder1>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public Mascota_adaptador1(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_mascota1, parent, false);
        return new MascotaViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder1 holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.iv_foto_mascota.setImageResource(mascota.getFoto());
        holder.iv_hueso_dor.setImageResource(mascota.getFoto_hueso_dor());
        //holder.tv_nombre.setText(mascota.getNombre());
        holder.tv_like.setText(String.valueOf( mascota.getLike()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder1 extends RecyclerView.ViewHolder {

        private ImageView iv_foto_mascota;
        private ImageView iv_hueso_dor;
        //private TextView tv_nombre;
        private TextView tv_like;

        public MascotaViewHolder1(View itemView) {
            super(itemView);

            iv_foto_mascota = (ImageView) itemView.findViewById(R.id.iv_foto_mascota1);
            iv_hueso_dor = (ImageView) itemView.findViewById(R.id.iv_hueso_dor1);
            //tv_nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            tv_like = (TextView) itemView.findViewById(R.id.tv_like1);

        }
    }
}
