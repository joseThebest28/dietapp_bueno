package com.example.Dietapp.DeporteEjercicios.pierna;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.Dietapp.categorias.CategoDeporte;
import com.example.myapplicationfinal.R;

public class Pierna5 extends AppCompatActivity {
    ImageView imagen;
    private Toast toast1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abdominales5);
        imagen = findViewById(R.id.imageView27);
        toast1 = Toast.makeText(getApplicationContext(), "Eleccion  de medio ejercicio guardada con exito", Toast.LENGTH_SHORT);

        imagen.setImageDrawable(getResources().getDrawable(R.drawable.pierna5));

    }

    public void completad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pierna5.this);


        float num = myPreferences.getFloat("depor", 0);
        num = num + 20.44f;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", (int) num);
        myEditor.commit();
        Intent i = new Intent(this, CategoDeporte.class);
        startActivity(i);

    }

    public void mediocompletad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pierna5.this);

        float num = myPreferences.getFloat("depor", 0);
        num = num + 10.12f;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", num);
        myEditor.commit();
        Intent i = new Intent(this, CategoDeporte.class);
        startActivity(i);

    }


}
