package com.example.Dietapp.DeporteEjercicios.triceps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplicationfinal.R;

public class ElegirRutinaTri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_rutina);


    }

    public void rutina1(View view) {
        Intent i1 = new Intent(this, Triceps3.class);
        startActivity(i1);
    }

    public void rutina2(View view) {
        Intent i2 = new Intent(this, Triceps.class);
        startActivity(i2);
    }
}