package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PuntajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);

        // Match de widgets con objetos
        TextView tviPuntaje = (TextView) findViewById(R.id.tviPuntaje);

        // Obtener el intent que condujo aquí
        Intent intent = getIntent();

        // Obtener el puntaje enviado en el intent
        Integer puntaje = intent.getIntExtra("PUNTAJE", 0);

        // Settear el puntaje en el TextView
        tviPuntaje.setText(puntaje.toString());
    }
}
