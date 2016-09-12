package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    //https://amatellanes.wordpress.com/2013/08/27/android-crear-un-splash-screen-en-android/

    // Constante con la duración del splash screen
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Fija la orientación en modo portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Esconde el action bar
        getSupportActionBar().hide();
        // No funciona:
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Pasar al siguiente activity
                Intent loginIntent = new Intent().setClass(SplashScreenActivity.this, LoginActivity.class);
                startActivity(loginIntent);

                // Cierre de este activity para que el usuario
                // no regrese aquí presionando el botón atrás
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
