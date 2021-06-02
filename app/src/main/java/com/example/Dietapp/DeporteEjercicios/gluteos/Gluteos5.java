package com.example.Dietapp.DeporteEjercicios.gluteos;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplicationfinal.R;

public class Gluteos5 extends AppCompatActivity {
    private Toast toast1;
    private Toast toast2;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abdominales);
        image = findViewById(R.id.imageView24);
        toast1 = Toast.makeText(getApplicationContext(), "Eleccion  de medio ejercicio guardada con exito", Toast.LENGTH_SHORT);
        toast2 = Toast.makeText(getApplicationContext(), "Eleccion  de ejercicio completo guardada con exito", Toast.LENGTH_SHORT);
        image.setImageDrawable(getResources().getDrawable(R.drawable.gluteos5));
    }

    public void completad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Gluteos5.this);

        double num = myPreferences.getFloat("depor", 0);
        num = num + 20;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", (int) num);
        myEditor.commit();
        Intent i = new Intent(this, Gluteos2.class);
        startActivity(i);
        overridePendingTransition(R.anim.desplazar_derecha, R.anim.desplazar_derecha2);
        toast2.show();
    }

    public void mediocompletad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Gluteos5.this);

        float num = myPreferences.getInt("depor", 0);
        num = num + 10;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", (int) num);
        myEditor.commit();
        Intent i = new Intent(this, Gluteos2.class);
        startActivity(i);
        overridePendingTransition(R.anim.desplazar_izquierda, R.anim.desplazar_izquierda2);
        toast1.show();
    }


}
