package com.example.Dietapp.DeporteEjercicios.Pecho;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.Dietapp.DeporteEjercicios.gluteos.Gluteos;
import com.example.Dietapp.DeporteEjercicios.gluteos.Gluteos5;
import com.example.Dietapp.DeporteEjercicios.hombro.Hombro;
import com.example.Dietapp.DeporteEjercicios.hombro.Hombro2;
import com.example.myapplicationfinal.R;

public class ElegirRutinaPe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_rutina);

    }
    public void rutina1(View view) {Intent i1 = new Intent(this, Pecho.class);startActivity(i1);
    }

    public void rutina2(View view) {Intent i2 = new Intent(this, Pecho2.class); startActivity(i2);
    }
}