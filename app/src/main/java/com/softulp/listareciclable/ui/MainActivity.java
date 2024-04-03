package com.softulp.listareciclable.ui;

import android.os.Bundle;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.listareciclable.R;
import com.softulp.listareciclable.databinding.ActivityMainBinding;
import com.softulp.listareciclable.modelo.Inmueble;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getListaMutable().observe(this, new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                InmuebleAdapter ia=new InmuebleAdapter(inmuebles,MainActivity.this,getLayoutInflater());
                GridLayoutManager glm=new GridLayoutManager(MainActivity.this,2,GridLayoutManager.VERTICAL,false);
                RecyclerView rc=binding.lista;
                rc.setLayoutManager(glm);
                rc.setAdapter(ia);


            }
        });
        mv.crearLista();
    }
}