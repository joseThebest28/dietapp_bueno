package com.example.Dietapp.categorias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.Dietapp.Categorias;
import com.example.Dietapp.DeporteEjercicios.AbdominalesEj.ElegirRutinaAbs;
import com.example.Dietapp.DeporteEjercicios.BicepsEj.ElegirBi;
import com.example.Dietapp.DeporteEjercicios.Cardio;
import com.example.Dietapp.DeporteEjercicios.Deporte;
import com.example.Dietapp.DeporteEjercicios.EspaldaEj.ElegirRutinaEs;
import com.example.Dietapp.DeporteEjercicios.Pecho.ElegirRutinaPe;
import com.example.Dietapp.DeporteEjercicios.gluteos.ElegirRutinaGlu;
import com.example.Dietapp.DeporteEjercicios.hombro.ElegirRutinahom;
import com.example.Dietapp.DeporteEjercicios.pierna.ElegirRutinaPi;
import com.example.Dietapp.DeporteEjercicios.triceps.ElegirRutinaTri;
import com.example.myapplicationfinal.R;

public class CategoDeporte extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categodeporte);
    }

    public void irDeporte(View view) {
        Intent i1 = new Intent(this, Deporte.class );
        startActivity(i1);
    }

    public void irCardio(View view) {
        Intent i2 = new Intent(this, Cardio.class );
        startActivity(i2);
    }

    public void iraabdo(View view) {
        Intent i3 = new Intent(this,ElegirRutinaAbs.class );
        startActivity(i3);
    }

    public void volverMenu(View view) {
        Intent i4 = new Intent(this, Categorias.class );
        startActivity(i4);
    }

    public void irBiceps(View view) {
        Intent i5 = new Intent(this, ElegirBi.class );
        startActivity(i5);
    }

    public void irTriceps(View view) {
        Intent i6 = new Intent(this, ElegirRutinaTri.class );
        startActivity(i6);
    }

    public void irHombro(View view) {
        Intent i77 = new Intent(this, ElegirRutinahom.class );
        startActivity(i77);
    }

    public void irPecho(View view) {
        Intent i8 = new Intent(this, ElegirRutinaPe.class );
        startActivity(i8);
    }

    public void irEspalda(View view) {
        Intent i9 = new Intent(this, ElegirRutinaEs.class );
        startActivity(i9);
    }

    public void irPierna(View view) {
        Intent i99 = new Intent(this, ElegirRutinaPi.class );
        startActivity(i99);
    }

    public void irGluteos(View view) {
        Intent i55 = new Intent(this, ElegirRutinaGlu.class );
        startActivity(i55);
    }

    public void lanzarActiDepor(View view) {
        Intent i = new Intent(this, Deporte.class );
        startActivity(i);
    }
}
