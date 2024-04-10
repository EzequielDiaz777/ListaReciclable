package com.ezediaz.peliculas.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ezediaz.peliculas.databinding.ActivityPeliculaBinding;
import com.ezediaz.peliculas.modelo.Pelicula;

public class PeliculaActivity extends AppCompatActivity {
    private ActivityPeliculaBinding binding;
    private PeliculaActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPeliculaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(PeliculaActivityViewModel.class);
        mv.getMutablePelicula().observe(this, new Observer<Pelicula>(){
            @Override
            public void onChanged(Pelicula pelicula) {
                binding.tvTitulo.setText(pelicula.getTitulo());
                binding.ivFoto.setImageResource(pelicula.getFoto());
                binding.tvDescripcion.setText("Descripción: " + pelicula.getDescripcion());
                binding.tvDirector.setText("Director: " + pelicula.getDirector());
                binding.tvListaDeActores.setText("Lista de actores: " + pelicula.getActores());
                binding.btnVolver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });
            }
        });
        mv.cargarPelicula(getIntent());
    }
}