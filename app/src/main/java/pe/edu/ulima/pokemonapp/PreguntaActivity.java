package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.edu.ulima.pokemonapp.model.GestorPokemonApp;
import pe.edu.ulima.pokemonapp.model.Pregunta;

public class PreguntaActivity extends AppCompatActivity {
    // Lista de preguntas del gestor
    private final List<Pregunta> preguntas = GestorPokemonApp.getInstance().obtenerPreguntas();
    // Objeto Pregunta
    private Pregunta pregunta;
    // Posicion de la pregunta actual
    private int posicion = -1;
    // Puntaje acumulado del jugador
    private int puntaje = 0;
    // Flag que indica si cambió la imagen de la Pokeball (no se me ocurrió otra cosa)
    private boolean imagenCambio = false;
    // Flag que indica si la respuesta fue correcta
    private boolean respuestaCorrecta = false;
    // Averiguar una mejor práctica que sacarlos del onCreate()
    TextView tviPreguntaId;
    TextView tviPreguntaTexto;
    ImageView iviPokeball;
    EditText eteRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        /******** Views ********/
        iviPokeball = (ImageView) findViewById(R.id.iviPokeball);
        eteRespuesta = (EditText) findViewById(R.id.eteRespuesta);
        tviPreguntaId = (TextView) findViewById(R.id.tviPregunta_id);
        tviPreguntaTexto = (TextView) findViewById(R.id.tviPregunta_texto);
        ImageButton ibuSend = (ImageButton) findViewById(R.id.ibuSend);
        ImageButton ibuNext = (ImageButton) findViewById(R.id.ibuNext);

        // int cantidadPreguntas = preguntas.size();

        cargarSiguientePregunta();

        /******** Listeners ********/

        // Cuando se haga click en el botón check
        ibuSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Si es respuesta correcta
                if (eteRespuesta.getText().toString().equals(pregunta.getRespuesta())) {
                    // Se muestra la imagen del pokemon
                    iviPokeball.setImageResource(pregunta.getImagen());
                    imagenCambio = true;

                    // Toast indicando que la respuesta es correcta
                    Toast.makeText(getBaseContext(), "La respuesta es correcta", Toast.LENGTH_SHORT).show();

                    // Aumentar puntaje en 10 puntos
                    if (!respuestaCorrecta) {
                        puntaje = puntaje + 10;
                    }

                    // Actualizar flag
                    respuestaCorrecta = true;
                } else /* Si es respuesta incorrecta */ {
                    // Toast indicando que la respuesta es incorrecta
                    Toast.makeText(getBaseContext(), "La respuesta es incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Cuando se haga click en el botón next
        ibuNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Si aún quedan preguntas por mostrar
                if (pregunta.getId() < preguntas.size()) {
                    // Si la imagen del pokemon fue cargada
                    if (imagenCambio) {
                        // Volver a la imagen de la Pokeball
                        iviPokeball.setImageResource(R.drawable.pokeball);
                        // Actualizar flag
                        imagenCambio = false;
                    }
                    // Vaciar EditText
                    eteRespuesta.setText("");

                    cargarSiguientePregunta();
                } else /* Si ya no quedan más preguntas */ {
                    // Declarar e inicializar el intent
                    Intent intent = new Intent();

                    // Almacenar el puntaje en el intent
                    intent.putExtra("PUNTAJE", puntaje);

                    // Settear los activities origen y destino en el intent
                    intent.setClass(PreguntaActivity.this, PuntajeActivity.class);

                    // Realizar el intent
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("PUNTAJE", puntaje);
        outState.putInt("POSICION", posicion - 1);
        if (imagenCambio) {
            outState.putInt("IMAGEN", pregunta.getImagen());
        } else {
            outState.putInt("IMAGEN", R.drawable.pokeball);
        }
        outState.putBoolean("IMAGEN_CAMBIO", imagenCambio);
        outState.putString("RESPUESTA", eteRespuesta.getText().toString());
        outState.putBoolean("RESPUESTA_CORRECTA", respuestaCorrecta);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        puntaje = savedInstanceState.getInt("PUNTAJE");
        posicion = savedInstanceState.getInt("POSICION");
        iviPokeball.setImageResource(savedInstanceState.getInt("IMAGEN"));
        imagenCambio = savedInstanceState.getBoolean("IMAGEN_CAMBIO");
        cargarSiguientePregunta();
        eteRespuesta.setText(savedInstanceState.getString("RESPUESTA"));
        respuestaCorrecta = savedInstanceState.getBoolean("RESPUESTA_CORRECTA");
    }

    private void cargarSiguientePregunta(){
        posicion++;
        // Settear la pregunta actual
        pregunta = preguntas.get(posicion);

        // Settear el id de la pregunta en el TextView
        tviPreguntaId.setText(String.format("Pregunta %s", pregunta.getId()));

        // Settear el texto de la pregunta en el TextView
        tviPreguntaTexto.setText(pregunta.getPregunta());

        // Actualizar flag
        respuestaCorrecta = false;
    }
}
