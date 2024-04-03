package com.softulp.listareciclable.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.listareciclable.R;
import com.softulp.listareciclable.modelo.Inmueble;

import java.util.List;

public class InmuebleAdapter extends RecyclerView.Adapter<InmuebleAdapter.ViewHolderPepe> {
private List<Inmueble> listaDeInmuebles;
private Context context;

private LayoutInflater li;

    public InmuebleAdapter(List<Inmueble> listaDeInmuebles, Context context, LayoutInflater li) {
        this.listaDeInmuebles = listaDeInmuebles;
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

        Inmueble inmueble=listaDeInmuebles.get(position);
        holder.direccion.setText(inmueble.getDireccion());
        holder.precio.setText(inmueble.getPrecio()+"");
        holder.foto.setImageResource(inmueble.getFoto());

    }

    @Override
    public int getItemCount() {
        return listaDeInmuebles.size();
    }

    public class ViewHolderPepe extends RecyclerView.ViewHolder{

        TextView direccion, precio;
        ImageView foto;

        public ViewHolderPepe(@NonNull View itemView) {
            super(itemView);
            direccion=itemView.findViewById(R.id.direccion);
            precio=itemView.findViewById(R.id.precio);
            foto=itemView.findViewById(R.id.foto);


        }
    }
}
