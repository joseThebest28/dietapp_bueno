package com.example.Dietapp;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
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
    public void lanzarapp(View view) {
       // Intent i = new Intent(this, Login.class );
        Intent i = new Intent(this, Login.class );
        startActivity(i);
        overridePendingTransition(R.anim.desplazar_derecha,R.anim.animacion_aumentar);
    }
    public void lanzartuto(View view) {
        Intent i2 = new Intent(this, Explica1.class );
        startActivity(i2);

    }


}