package com.softulp.listareciclable.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.listareciclable.R;
import com.softulp.listareciclable.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Inmueble>> listaMutable;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Inmueble>> getListaMutable(){
        if(listaMutable==null){
            listaMutable=new MutableLiveData<>();
        }
        return listaMutable;
    }

    public void crearLista(){
      ArrayList<Inmueble> lista=new ArrayList<>();
      lista.add(new Inmueble("colon 323",909099,R.drawable.casa1));
      lista.add(new Inmueble("mitre  423",9099,R.drawable.casa2));
        listaMutable.setValue(lista);

    }
}
