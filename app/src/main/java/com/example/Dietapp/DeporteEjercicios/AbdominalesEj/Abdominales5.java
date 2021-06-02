package com.example.Dietapp.DeporteEjercicios.AbdominalesEj;

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

public class Abdominales5 extends AppCompatActivity {
    private Toast toast1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abdominales5);


        toast1 =
                Toast.makeText(getApplicationContext(),
                        "Eleccion guardada con exito", Toast.LENGTH_SHORT);


    }

    public void completad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Abdominales5.this);

        double num = myPreferences.getFloat("depor", 0);
        num = num + 32;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", (int) num);
        myEditor.commit();
        toast1.show();
        Intent i = new Intent(this, CategoDeporte.class);
        startActivity(i);
        overridePendingTransition(R.anim.animacion_aumentar, R.anim.animacion_disminuir);

    }

    public void mediocompletad(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Abdominales5.this);

        double num = myPreferences.getFloat("depor", 0);
        num = num + 16;

        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("depor", (int) num);
        myEditor.commit();
        toast1.show();
        Intent i = new Intent(this, CategoDeporte.class);
        startActivity(i);

    }


}
