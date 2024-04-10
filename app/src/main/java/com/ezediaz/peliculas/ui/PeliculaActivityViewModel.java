package com.ezediaz.peliculas.ui;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.ezediaz.peliculas.modelo.Pelicula;

public class PeliculaActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Pelicula> mutablePelicula;
    private Pelicula pelicula;
    public PeliculaActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Pelicula> getMutablePelicula(){
        if(mutablePelicula == null){
            mutablePelicula = new MutableLiveData<>();
        }
        return mutablePelicula;
    }

    public void cargarPelicula(Intent intent){
        pelicula = (Pelicula) intent.getSerializableExtra("pelicula");
        if(pelicula != null) {
            mutablePelicula.setValue(pelicula);
        }
    }
}
