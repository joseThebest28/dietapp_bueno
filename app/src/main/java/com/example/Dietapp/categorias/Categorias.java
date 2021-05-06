package com.example.Dietapp.categorias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.Dietapp.PaginaPrincipal;
import com.example.Dietapp.extras.ElegirReceta;
import com.example.myapplicationfinal.R;

public class Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias);
    }
    public void volverMenu(View view) {
        Intent i = new Intent(this, PaginaPrincipal.class );
        startActivity(i);
    }
    public void irACarne(View view) {
        Intent i = new Intent(this, Carne.class );
        startActivity(i);
    }
    public void irAFruta(View view) {
        Intent i = new Intent(this, Fruta.class );
        startActivity(i);
    }
    public void irAPastas(View view) {
        Intent i = new Intent(this, Pastas.class );
        startActivity(i);
    }
    public void irAPescado(View view) {
        Intent i = new Intent(this, Pescado.class );
        startActivity(i);
    }
    public void irASalsas(View view) {
        Intent i = new Intent(this, Salsas.class );
        startActivity(i);
    }
    public void irAVerduras(View view) {
        Intent i = new Intent(this, VerdurayLegumbres.class );
        startActivity(i);
    }

    public void irDeporte(View view) {
        Intent i = new Intent(this, CategoDeporte.class );
        startActivity(i);
    }

    public void iraRecetas(View view) {
        Intent i = new Intent(this, ElegirReceta.class );
        startActivity(i);

    }
}
