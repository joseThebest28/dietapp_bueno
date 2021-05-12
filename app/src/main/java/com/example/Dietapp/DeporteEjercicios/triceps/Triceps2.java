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

public class Triceps2 extends AppCompatActivity {
    private Toast toast1;
    private Toast toast2; ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abdominales);
        image=findViewById(R.id.imageView24);
        toast1 = Toast.makeText(getApplicationContext(), "Eleccion  de medio ejercicio guardada con exito", Toast.LENGTH_SHORT);
        toast2 = Toast.makeText(getApplicationContext(), "Eleccion  de ejercicio completo guardada con exito", Toast.LENGTH_SHORT);
        image.setImageDrawable(getResources().getDrawable(R.drawable.triceps2));
    }

    public void completad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Triceps2.this);

        float num = myPreferences.getFloat("depor", 0);
        num=num+21.8f;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor",  num);
        myEditor.commit();
        Intent i = new Intent(this, Triceps4.class );
        startActivity(i);toast2.show();
    }

    public void mediocompletad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Triceps2.this);

        float num = myPreferences.getFloat("depor", 0);
        num=num+10.9f;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor",  num);
        myEditor.commit();
        Intent i = new Intent(this, Triceps4.class );
        startActivity(i);toast1.show();
    }



}
