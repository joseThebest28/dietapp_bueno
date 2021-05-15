package com.example.Dietapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.Dietapp.categorias.Bebidas;
import com.example.Dietapp.categorias.Carne;
import com.example.Dietapp.categorias.CategoDeporte;
import com.example.Dietapp.categorias.Fruta;
import com.example.Dietapp.categorias.Pastas;
import com.example.Dietapp.categorias.Pescado;
import com.example.Dietapp.categorias.Salsas;
import com.example.Dietapp.categorias.VerdurayLegumbres;
import com.example.Dietapp.extras.ElegirReceta;
import com.example.myapplicationfinal.R;

public class Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias);
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

    public void irabebidas(View view) {
        Intent i = new Intent(this, Bebidas.class );
        startActivity(i);
    }

    public void irAjustes(View view) {
        Intent ij= new Intent(this, Ajustes.class );
        startActivity(ij);
    }

    public void salir(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Salir ");
        builder.setMessage("Estas seguro de querer salir de Dietapp");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("Cancelar", null);

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void lanzarSeguimiento(View view) {
        Intent iS = new Intent(this, Seguimiento.class );
        startActivity(iS);
    }

    public void irAyuda(View view) {
        String url="https://developer.android.com/jetpack?gclid=Cj0KCQjw1a6EBhC0ARIsAOiTkrEPool70Ip_4_UB06jjNcg80erT4ciaz0wzxeX-0djyI7Z5gXsnJK4aAu2yEALw_wcB&gclsrc=aw.ds";
        Uri ur= Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW, ur);
        startActivity(intent);
    }
}
