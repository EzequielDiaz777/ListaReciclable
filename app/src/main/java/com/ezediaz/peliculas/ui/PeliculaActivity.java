package com.ezediaz.peliculas.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ezediaz.peliculas.databinding.ActivityPeliculaBinding;

public class PeliculaActivity extends AppCompatActivity {
    private ActivityPeliculaBinding binding;
    private PeliculaActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPeliculaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(PeliculaActivityViewModel.class);
        mv.getMutableTitulo().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvTitulo.setText(s);
            }
        });
        mv.getMutableRuta().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.ivFoto.setImageResource(integer);
            }
        });
        mv.getMutableDescripcion().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvDescripcion.setText(s);
            }
        });
        mv.getMutableDirector().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvDirector.setText(s);
            }
        });
        mv.getMutableActores().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvListaDeActores.setText(s);
            }
        });
        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mv.cargarPelicula(getIntent());
    }
}