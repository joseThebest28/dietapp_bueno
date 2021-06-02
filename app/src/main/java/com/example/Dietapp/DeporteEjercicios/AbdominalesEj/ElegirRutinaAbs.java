package com.example.Dietapp.DeporteEjercicios.AbdominalesEj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Dietapp.DeporteEjercicios.AbdominalesEj.Abdominales2;
import com.example.myapplicationfinal.R;

public class ElegirRutinaAbs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_rutina);


    }

    public void rutina1(View view) {
        Intent i1 = new Intent(this, Abdominales.class);
        startActivity(i1);
    }

    public void rutina2(View view) {
        Intent i2 = new Intent(this, Abdominales4.class);
        startActivity(i2);
    }
}