package pe.edu.ulima.pokemonapp.model;

import java.util.ArrayList;
import java.util.List;

import pe.edu.ulima.pokemonapp.R;

public class GestorPokemonApp {
    private static GestorPokemonApp ourInstance = new GestorPokemonApp();

    public static GestorPokemonApp getInstance() {
        return ourInstance;
    }

    private GestorPokemonApp() {
    }

    public List<Pregunta> obtenerPreguntas(){
        List<Pregunta> preguntas = new ArrayList<>();

        preguntas.add(new Pregunta(1, "¿Cuántos kilos pesa Pinsir? (kilos)", "54", R.drawable.bulbasaur));
        preguntas.add(new Pregunta(2, "¿Cuánto mide Magmar? (metros)", "1.24", R.drawable.ivysaur));
        preguntas.add(new Pregunta(3, "¿Cuál es la evolución de Gloom?", "Vileplume", R.drawable.venusaur));
        preguntas.add(new Pregunta(4, "¿Qué número es Snorlax?", "143", R.drawable.charmander));
        preguntas.add(new Pregunta(5, "¿Cuánto pesa Kabuto? (kilos)", "11", R.drawable.charmeleon));

        return preguntas;
    }
}

