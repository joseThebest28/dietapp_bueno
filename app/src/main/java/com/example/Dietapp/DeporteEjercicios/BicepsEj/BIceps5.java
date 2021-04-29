package com.example.Dietapp.DeporteEjercicios.BicepsEj;

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

public class BIceps5 extends AppCompatActivity {
    private Toast toast1;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abdominales5);
        imagen=findViewById(R.id.imageView27);
        toast1 = Toast.makeText(getApplicationContext(), "Eleccion  de medio ejercicio guardada con exito", Toast.LENGTH_SHORT);

        imagen.setImageDrawable(getResources().getDrawable(R.drawable.biceps5));

    }

    public void completad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(BIceps5.this);

        double num = myPreferences.getInt("depor", 0);
       num=num+35;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("depor", (int) num);
        myEditor.commit();toast1.show();Intent i = new Intent(this, CategoDeporte.class );
        startActivity(i);

    }

    public void mediocompletad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(BIceps5.this);

        double num = myPreferences.getInt("depor", 0);
        num=num+17;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("depor", (int) num);
        myEditor.commit();toast1.show();Intent i = new Intent(this, CategoDeporte.class );
        startActivity(i);

    }



}
