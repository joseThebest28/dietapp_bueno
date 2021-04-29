package com.example.Dietapp.DeporteEjercicios.BicepsEj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.Dietapp.DeporteEjercicios.AbdominalesEj.Abdominales;
import com.example.Dietapp.DeporteEjercicios.AbdominalesEj.Abdominales4;
import com.example.myapplicationfinal.R;

public class ElegirBi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_rutina);

    }
    public void rutina1(View view) {
        Intent i1 = new Intent(this, BIceps.class);startActivity(i1);
    }

    public void rutina2(View view) {Intent i2 = new Intent(this, BIceps4.class); startActivity(i2);
    }}