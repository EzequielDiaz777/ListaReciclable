package com.ezediaz.peliculas.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ezediaz.peliculas.R;
import com.ezediaz.peliculas.modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pelicula>> mutableLiveDataPeliculas;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<List<Pelicula>> getMutableLiveDataPeliculas(){
        if(mutableLiveDataPeliculas == null){
            mutableLiveDataPeliculas = new MutableLiveData<>();
        }
        return mutableLiveDataPeliculas;
    }

    public void crearLista(){
        List<Pelicula> lista = new ArrayList<>();
        lista.add(new Pelicula("Cars", "De camino al prestigiado campeonato Copa Pistón, un automóvil de carreras que sólo se preocupa por ganar aprende sobre lo que realmente es importante en la vida de varios vehículos que viven en un pueblo a lo largo de la histórica Ruta 66.", R.drawable.cars, "John Lasseter", "Owen Wilson, Bonnie Hunt, Paul Newman, Larry the Cable Guy"));
        lista.add(new Pelicula("Los Increibles","Un superhéroe retirado lucha contra el aburrimiento y, junto a su familia, tiene la oportunidad de salvar al mundo.", R.drawable.increibles, "Brad Bird", "Brad Bird, Holly Hunter, Craig Nelson, Sarah Vowell"));
        lista.add(new Pelicula("Ratatouille","Remy es un residente de París que aprecia la buena comida y tiene un paladar bastante sofisticado. Él desea convertirse en un chef para crear y disfrutar de diversas obras de arte culinarias. El único problema es que Remy es una rata. Y cuando termina en las alcantarillas debajo de uno de los restaurantes más finos de París, el roedor se siente en el lugar perfecto para convertir su sueño en una realidad.", R.drawable.ratatouille, "Brad Bird", "Lou Romano, Patton Oswalt, Peter Sohn, Brad Bird"));
        lista.add(new Pelicula("Minions","Los minions, ingenuos y torpes, buscan un verdadero villano al que servir. A lo largo de una evolución de millones de años, los minions se han puesto al servicio de los amos más despreciables. Kevin, acompañado por el rebelde Stuart y el adorable Bob, emprende un emocionante viaje para conseguir una jefa a quien servir, la terrible Scarlet Overkill.", R.drawable.minions, "Peter Coffin y Kyle Balda", "Steve Carell, Pierre Coffin, Steve Coogan, Sandra Bullock"));
        lista.add(new Pelicula("Toy Story 3","Woody (Tom Hanks), Buzz (Tim Allen) y el resto de los juguetes terminan en una guardería luego de que Andy se va al colegio.", R.drawable.toystory3, "Lee Unkrich", "Lee Unkrich, Tom Hanks, Tim Allen, Michael Keaton"));
        mutableLiveDataPeliculas.setValue(lista);
    }
}
