package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pe.edu.ulima.pokemonapp.model.Pregunta;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText eteUsuario = (EditText) findViewById(R.id.eteUsuario);
        Button butIngresar = (Button) findViewById(R.id.butIngresar);

        butIngresar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Obtener el usuario ingresado
                String usuario = eteUsuario.getText().toString();

                // Declarar e inicializar el intent
                Intent intent = new Intent();

                /*
                // Almacenar el usuario obtenido en un Bundle
                Bundle parametros = new Bundle();
                parametros.putString("USUARIO", usuario);

                // Almacenar el Bundle en el intent
                intent.putExtras(parametros);
                */

                // Almacenar el usuario en el intent
                intent.putExtra("USUARIO", usuario);

                // Settear los activities origen y destino en el intent
                intent.setClass(LoginActivity.this, PreguntaActivity.class);

                // Realizar el intent
                startActivity(intent);
            }
        });
    }
}
