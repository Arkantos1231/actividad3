package com.example.proyecto2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Context context;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Context context) {
        this.mascotas = mascotas;
        this.context = context;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgFotoMascota.setImageResource(mascota.getFoto());
        holder.tvNombreMascota.setText(mascota.getNombre());
        holder.tvRatingMascota.setText(String.valueOf(mascota.getRating()));

        holder.imgBoneWhite.setOnClickListener(v -> {
            mascota.setRating(mascota.getRating() + 1);
            holder.tvRatingMascota.setText(String.valueOf(mascota.getRating()));
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    // Clase interna ViewHolder
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoMascota;
        private TextView tvNombreMascota;
        private TextView tvRatingMascota;
        private ImageView imgBoneWhite; // Hueso blanco a la izquierda
        private ImageView imgBoneYellow; // Hueso dorado a la derecha

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoMascota = itemView.findViewById(R.id.imgFotoMascota);
            tvNombreMascota = itemView.findViewById(R.id.tvNombreMascota);
            tvRatingMascota = itemView.findViewById(R.id.tvRatingMascota);
            imgBoneWhite = itemView.findViewById(R.id.imgBoneWhite);
            imgBoneYellow = itemView.findViewById(R.id.imgBoneYellow);
        }
    }
}

