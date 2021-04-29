package com.example.Dietapp.DeporteEjercicios.pierna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.Dietapp.DeporteEjercicios.Pecho.Pecho;
import com.example.Dietapp.DeporteEjercicios.Pecho.Pecho2;
import com.example.Dietapp.DeporteEjercicios.gluteos.Gluteos;
import com.example.Dietapp.DeporteEjercicios.gluteos.Gluteos5;
import com.example.myapplicationfinal.R;

public class ElegirRutinaPi extends AppCompatActivity {
Button boton,bootn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_rutina);

    }  public void rutina1(View view) {Intent i1 = new Intent(this, Pierna.class);startActivity(i1);
    }

    public void rutina2(View view) {Intent i2 = new Intent(this, Pierna2.class); startActivity(i2);
    }
}