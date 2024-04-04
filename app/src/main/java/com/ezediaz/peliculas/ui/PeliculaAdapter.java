package com.ezediaz.peliculas.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ezediaz.peliculas.R;
import com.ezediaz.peliculas.modelo.Pelicula;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolderPepe> {
    private List<Pelicula> listaDePeliculas;
    private Context context;

    private LayoutInflater li;

    public PeliculaAdapter(List<Pelicula> listaDePeliculas, Context context, LayoutInflater li) {
        this.listaDePeliculas = listaDePeliculas;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderPepe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.item,parent,false);
        return new ViewHolderPepe(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPepe holder, int position) {
        Pelicula pelicula = listaDePeliculas.get(position);
        holder.titulo.setText(pelicula.getTitulo());
        holder.descripcion.setText(pelicula.getDescripcion());
        holder.foto.setImageResource(pelicula.getFoto());
    }

    @Override
    public int getItemCount() {
        return listaDePeliculas.size();
    }

    public class ViewHolderPepe extends RecyclerView.ViewHolder{

        TextView titulo, descripcion;
        ImageView foto;

        public ViewHolderPepe(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tvTitulo);
            descripcion = itemView.findViewById(R.id.tvDescripcion);
            foto = itemView.findViewById(R.id.ivFoto);
        }
    }
}
