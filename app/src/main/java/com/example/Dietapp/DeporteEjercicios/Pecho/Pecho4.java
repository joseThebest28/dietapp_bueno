package com.example.Dietapp.DeporteEjercicios.Pecho;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplicationfinal.R;

public class Pecho4 extends AppCompatActivity {
    private Toast toast1;
    private Toast toast2;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abdominales);
        imagen=findViewById(R.id.imageView24);
        toast1 = Toast.makeText(getApplicationContext(), "Eleccion  de medio ejercicio guardada con exito", Toast.LENGTH_SHORT);
        toast2 = Toast.makeText(getApplicationContext(), "Eleccion  de ejercicio completo guardada con exito", Toast.LENGTH_SHORT);
        imagen.setImageDrawable(getResources().getDrawable(R.drawable.pecho4));
    }

    public void completad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pecho4.this);

        double num = myPreferences.getFloat("depor", 0);
        num=num+24;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", (int) num);
        myEditor.commit();
        Intent i = new Intent(this, Pecho5.class );
        startActivity(i); overridePendingTransition(R.anim.desplazar_derecha,R.anim.desplazar_derecha2);toast2.show();
    }


    public void mediocompletad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pecho4.this);

        double num = myPreferences.getFloat("depor", 0);
        num=num+12;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", (int) num);
        myEditor.commit();
        Intent i = new Intent(this, Pecho5.class );
        startActivity(i); overridePendingTransition(R.anim.desplazar_izquierda,R.anim.desplazar_izquierda2);toast1.show();
    }



}
