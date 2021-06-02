package com.example.Dietapp.extras;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class FichaAdapter extends RecyclerView.Adapter<FichaAdapter.FichaViewHolder> {

    private ArrayList<Ficha> listaFichas;


    public class FichaViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre, reto;

        public FichaViewHolder(@NonNull View itemView) {
            super(itemView);

            imagen = itemView.findViewById(R.id.imagen);
            nombre = itemView.findViewById(R.id.nombre);
            reto = itemView.findViewById(R.id.reto);
        }
    }

    public FichaAdapter(ArrayList<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }

    @NonNull
    @Override
    public FichaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha_recycle, null, false);
        return new FichaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FichaViewHolder holder, int position) {
        holder.imagen.setImageResource(listaFichas.get(position).getImagen());
        holder.nombre.setText(listaFichas.get(position).getNombre());
        holder.reto.setText("" + String.valueOf(listaFichas.get(position).getReto()));
    }

    @Override
    public int getItemCount() {
        return listaFichas.size();
    }

    public interface RecyclerViewOnItemClickListener {

        void onClick(View v, int position);
    }
}
