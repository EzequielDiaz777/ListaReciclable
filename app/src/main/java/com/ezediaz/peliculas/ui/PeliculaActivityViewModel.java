package com.ezediaz.peliculas.ui;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ezediaz.peliculas.modelo.Pelicula;

import java.util.Arrays;

public class PeliculaActivityViewModel extends AndroidViewModel {
    private MutableLiveData<String> mutableTitulo;
    private MutableLiveData<Integer> mutableRuta;
    private MutableLiveData<String> mutableDescripcion;
    private MutableLiveData<String> mutableDirector;
    private MutableLiveData<String> mutableActores;
    private Pelicula pelicula;
    public PeliculaActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMutableTitulo(){
        if(mutableTitulo == null){
            mutableTitulo = new MutableLiveData<>();
        }
        return mutableTitulo;
    }

    public LiveData<Integer> getMutableRuta(){
        if(mutableRuta == null){
            mutableRuta = new MutableLiveData<>();
        }
        return mutableRuta;
    }

    public LiveData<String> getMutableDescripcion(){
        if(mutableDescripcion == null){
            mutableDescripcion = new MutableLiveData<>();
        }
        return mutableDescripcion;
    }

    public LiveData<String> getMutableDirector(){
        if(mutableDirector == null){
            mutableDirector = new MutableLiveData<>();
        }
        return mutableDirector;
    }

    public LiveData<String> getMutableActores() {
        if (mutableActores == null) {
            mutableActores = new MutableLiveData<>();
        }
        return mutableActores;
    }

    public void cargarPelicula(Intent intent){
        mutableTitulo.setValue(intent.getStringExtra("titulo"));
        mutableRuta.setValue(intent.getIntExtra("foto",0));
        mutableDescripcion.setValue("Descripcion: " + intent.getStringExtra("descripcion"));
        mutableDirector.setValue("Director: " + intent.getStringExtra("director"));
        String[] actores = new String[]{Arrays.toString(intent.getStringArrayExtra("actores"))};
        String aux = Arrays.toString(actores);
        aux = aux.substring(2, aux.length()-2);
        System.out.println(aux);
        mutableActores.setValue("Actores: " + aux);
    }
}
