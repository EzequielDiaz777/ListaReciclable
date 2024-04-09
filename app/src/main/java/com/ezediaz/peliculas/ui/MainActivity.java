package com.ezediaz.peliculas.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ezediaz.peliculas.databinding.ActivityMainBinding;
import com.ezediaz.peliculas.modelo.Pelicula;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getMutableLiveDataPeliculas().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                PeliculaAdapter pa = new PeliculaAdapter(peliculas,MainActivity.this, getLayoutInflater());
                GridLayoutManager glm = new GridLayoutManager(MainActivity.this, 1, GridLayoutManager.VERTICAL, false);
                RecyclerView rc = binding.listaDePeliculas;
                rc.setLayoutManager(glm);
                rc.setAdapter(pa);
            }
        });
        mv.crearLista();
    }
}