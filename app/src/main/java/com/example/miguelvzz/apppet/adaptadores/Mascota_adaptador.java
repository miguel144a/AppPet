package com.example.miguelvzz.apppet.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miguelvzz.apppet.Mascota;
import com.example.miguelvzz.apppet.R;

import java.util.ArrayList;

/**
 * Created by Miguel Vzz on 16/06/2016.
 */
public class Mascota_adaptador extends  RecyclerView.Adapter<Mascota_adaptador.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public Mascota_adaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota_rv, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.iv_foto_mascota.setImageResource(mascota.getFoto());
        holder.iv_hueso_bla.setImageResource(mascota.getFoto_hueso_bla());
        holder.iv_hueso_dor.setImageResource(mascota.getFoto_hueso_dor());
        holder.tv_nombre.setText(mascota.getNombre());
        holder.tv_like.setText(String.valueOf( mascota.getLike()));

        holder.iv_hueso_bla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.setLike(mascota.getLike() + 1);
                holder.tv_like.setText(String.valueOf(mascota.getLike()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_foto_mascota;
        private ImageView iv_hueso_bla;
        private ImageView iv_hueso_dor;
        private TextView tv_nombre;
        private TextView tv_like;


        public MascotaViewHolder(View itemView) {
            super(itemView);

            iv_foto_mascota = (ImageView) itemView.findViewById(R.id.iv_foto_mascota);
            iv_hueso_bla = (ImageView) itemView.findViewById(R.id.iv_hueso_bla);
            iv_hueso_dor = (ImageView) itemView.findViewById(R.id.iv_hueso_dor);
            tv_nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            tv_like = (TextView) itemView.findViewById(R.id.tv_like);

        }
    }

}
