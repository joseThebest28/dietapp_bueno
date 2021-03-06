package com.example.Dietapp.DeporteEjercicios.triceps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplicationfinal.R;

public class Triceps4 extends AppCompatActivity {
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
        image.setImageDrawable(getResources().getDrawable(R.drawable.triceps4));
    }

    public void completad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Triceps4.this);

        float num = myPreferences.getFloat("depor", 0);
        num = num + 21.8f;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", num);
        myEditor.commit();
        Intent i = new Intent(this, Triceps5.class);
        startActivity(i);
        overridePendingTransition(R.anim.desplazar_derecha, R.anim.desplazar_derecha2);
        toast2.show();
    }


    public void mediocompletad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Triceps4.this);

        float num = myPreferences.getFloat("depor", 0);
        num = num + 10.9f;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", num);
        myEditor.commit();
        Intent i = new Intent(this, Triceps5.class);
        startActivity(i);
        overridePendingTransition(R.anim.desplazar_izquierda, R.anim.desplazar_izquierda2);
        toast1.show();
    }


}
