package com.example.Dietapp;

import android.app.Notification;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.Dietapp.login.Login;
import com.example.Dietapp.tutorial.Explica1;
import com.example.myapplicationfinal.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.Calendar.*;


public class PaginaInicio extends AppCompatActivity {
    private final static String Channer_id = "notificacion";
    private static final int idUnico = 51623;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView texto = (TextView) findViewById(R.id.textView);
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        Animation animacionb = AnimationUtils.loadAnimation(this, R.anim.animacionb);
        Button b1 = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button3);
        TextView texto2 = (TextView) findViewById(R.id.textView3);
        TextView texto3 = (TextView) findViewById(R.id.textView4);

        texto.startAnimation(animacionb);
        texto2.startAnimation(animacionb);
        texto3.startAnimation(animacionb);
        b1.startAnimation(animacion);
        b2.startAnimation(animacion);


    }
    /*private void notificarApp() {
        NotificationCompat.Builder notificacio = new NotificationCompat.Builder(getApplicationContext(), Channer_id);
        notificacio.setSmallIcon(R.drawable.ic_launcher_background);
        notificacio.setTicker("nueva notificacion");
        notificacio.setPriority(Notification.PRIORITY_HIGH);
        notificacio.setWhen(System.currentTimeMillis());
        notificacio.setContentTitle("bienvenido a dietapp");
        notificacio.setContentText("Esperemos que disfrutes de la experiencia de dietapp. no olvides visitar nuestra web");
        notificacio.setColor(Color.GREEN);
        notificacio.setLights(Color.MAGENTA, 1000, 1000);
        notificacio.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        notificacio.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notidicacionMangaer = NotificationManagerCompat.from(getApplicationContext());
        notidicacionMangaer.notify(idUnico, notificacio.build());
    }
*/


    public void lanzarapp(View view) {
        // Intent i = new Intent(this, Login.class );
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        overridePendingTransition(R.anim.desplazar_derecha, R.anim.animacion_aumentar);
    }

    public void lanzartuto(View view) {
        Intent i2 = new Intent(this, Explica1.class);
        startActivity(i2);

    }


}