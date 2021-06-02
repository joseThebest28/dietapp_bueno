package com.example.Dietapp;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.Dietapp.categorias.Bebidas;
import com.example.Dietapp.categorias.Carne;
import com.example.Dietapp.categorias.CategoDeporte;
import com.example.Dietapp.categorias.Fruta;
import com.example.Dietapp.categorias.Pastas;
import com.example.Dietapp.categorias.Pescado;
import com.example.Dietapp.categorias.Salsas;
import com.example.Dietapp.categorias.VerdurayLegumbres;
import com.example.Dietapp.extras.ElegirReceta;
import com.example.Dietapp.extras.Valorar;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.Dietapp.login.Login;
import com.example.myapplicationfinal.R;

import static android.app.PendingIntent.*;

public class Categorias extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias);


    }


    public void irACarne(View view) {
        Intent i = new Intent(this, Carne.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void irAFruta(View view) {
        Intent i = new Intent(this, Fruta.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void irAPastas(View view) {
        Intent i = new Intent(this, Pastas.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void irAPescado(View view) {
        Intent i = new Intent(this, Pescado.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void irASalsas(View view) {
        Intent i = new Intent(this, Salsas.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void irAVerduras(View view) {
        Intent i = new Intent(this, VerdurayLegumbres.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void irDeporte(View view) {
        Intent i = new Intent(this, CategoDeporte.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void iraRecetas(View view) {
        Intent i = new Intent(this, ElegirReceta.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void irabebidas(View view) {
        Intent i = new Intent(this, Bebidas.class);
        startActivity(i);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void irAjustes(View view) {
        Intent ij = new Intent(this, Ajustes.class);
        startActivity(ij);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
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
        Intent iS = new Intent(this, Seguimiento.class);
        startActivity(iS);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }

    public void irAyuda(View view) {
        String url = "https://dietappapp.000webhostapp.com/contacta.html";
        Uri ur = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, ur);
        startActivity(intent);
    }

    public void iravalorar(View view) {
        Intent iS = new Intent(this, Valorar.class);
        startActivity(iS);
        overridePendingTransition(R.anim.anim_categorias2, R.anim.anim_categorias);
    }


}



