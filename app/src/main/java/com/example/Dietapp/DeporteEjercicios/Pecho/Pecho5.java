package com.example.Dietapp.DeporteEjercicios.Pecho;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.Dietapp.DeporteEjercicios.EspaldaEj.Espalda5;
import com.example.Dietapp.DeporteEjercicios.EspaldaEj.Espalda6;
import com.example.Dietapp.DeporteEjercicios.EspaldaEj.Espalda7;
import com.example.Dietapp.categorias.CategoDeporte;
import com.example.myapplicationfinal.R;

public class Pecho5 extends AppCompatActivity {
    private Toast toast1; ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abdominales5);
        imagen=findViewById(R.id.imageView27);
        toast1 = Toast.makeText(getApplicationContext(), "Eleccion  de medio ejercicio guardada con exito", Toast.LENGTH_SHORT);

        imagen.setImageDrawable(getResources().getDrawable(R.drawable.pecho5));
        toast1 =
                Toast.makeText(getApplicationContext(),
                        "Eleccion guardada con exito", Toast.LENGTH_SHORT);
    }

    public void completad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pecho5.this);

        double num = myPreferences.getFloat("depor", 0);
        num=num+24;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", (int) num);
        myEditor.commit();toast1.show();Intent i = new Intent(this, CategoDeporte.class );
        startActivity(i);

    }

    public void mediocompletad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pecho5.this);

        double num = myPreferences.getFloat("depor", 0);
        num=num+12;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", (int) num);toast1.show();
        myEditor.commit();Intent i = new Intent(this, CategoDeporte.class );
        startActivity(i);

    }



}
