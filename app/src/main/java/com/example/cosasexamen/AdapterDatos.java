package com.example.cosasexamen;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cosasexamen.entidades.TODO;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<TODO> listDatos;

    public AdapterDatos(ArrayList<TODO> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.nombre.setText(listDatos.get(position).getNombre());
        holder.creacion.setText(listDatos.get(position).getCreacion());
        holder.finalizacion.setText(listDatos.get(position).getFinalizacion());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }



    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView creacion;
        TextView finalizacion;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.TODOName);
            creacion = itemView.findViewById(R.id.creacion);
            finalizacion = itemView.findViewById(R.id.finalizacion);
        }


    }
}
