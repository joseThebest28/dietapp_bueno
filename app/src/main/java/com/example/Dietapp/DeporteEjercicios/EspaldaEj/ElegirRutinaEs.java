package com.example.Dietapp.DeporteEjercicios.EspaldaEj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.Dietapp.DeporteEjercicios.BicepsEj.BIceps;
import com.example.Dietapp.DeporteEjercicios.BicepsEj.BIceps4;
import com.example.myapplicationfinal.R;

public class ElegirRutinaEs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_rutina);

}

    public void rutina1(View view) {Intent i1 = new Intent(this,Espalda.class);startActivity(i1);
    }

    public void rutina2(View view) {Intent i2 = new Intent(this,Espalda7.class); startActivity(i2);
    }
}

