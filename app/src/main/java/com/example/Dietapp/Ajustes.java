package com.example.Dietapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Dietapp.categorias.Deporte;
import com.example.Dietapp.extras.ContadroVasosAgua;
import com.example.Dietapp.extras.Pagina_reto;
import com.example.Dietapp.login.Login;
import com.example.myapplicationfinal.R;

import java.security.AccessController;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ajustes extends AppCompatActivity {
    TextView texto,nombreED,apellidoED,apellido2ED,emailED,retos;
    ImageView imagen;
    Button boton,botonVerMAs;
    private static final int COD_Selecciona=10;
    private static final int COD_Foto=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

         texto = findViewById(R.id.textView23);
        nombreED = findViewById(R.id.textView24);
        apellidoED = findViewById(R.id.textView39);
        apellido2ED = findViewById(R.id.textView40);
        emailED = findViewById(R.id.textView38);
        retos = findViewById(R.id.textView395);

        imagen=findViewById(R.id.imageView29);

        boton=findViewById(R.id.button43);

        botonVerMAs=findViewById(R.id.bRetos);
        botonVerMAs.setVisibility(View.INVISIBLE);

        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Ajustes.this);
         String nombreUser = myPreferences.getString("nombreUser", "");
        String nombre = myPreferences.getString("nombre", "");
        String apellido = myPreferences.getString("apellido", "");
        String apellido2 = myPreferences.getString("apellido2", "");
        String emal = myPreferences.getString("email", "");
        String agua = myPreferences.getString("agua", "");

        texto.setText("Nombre usuario-----> "+nombreUser);
        nombreED.setText("Nombre ---------------->  "+nombre);
        apellidoED.setText("Apellido ---------------->  "+apellido);
        apellido2ED.setText("Apellido2 -------------->  "+apellido2);
        emailED.setText("Email -------------------->  "+emal);
        if(!agua.isEmpty())
        {retos.setText(""+agua);


        }

        //falta cambiar iamgen de galeria a Imegenview







    }





    public void verMAs(View view) {
        botonVerMAs.setVisibility(View.VISIBLE);
    }


    public void iraRetos(View view) {
        Intent ifds = new Intent(this, Pagina_reto.class);
        startActivity(ifds);
    }

    public void cerrarSesio(View view) {
        final Intent ifds = new Intent(this, Login.class);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("¿Estas seguro de cerrar sesión?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Ajustes.this);


                        SharedPreferences.Editor myEditor = myPreferences.edit();
                        myEditor.putString("nombreUser", "");
                        myEditor.putString("nombre", "");
                        myEditor.putString("apellido", "");
                        myEditor.putString("apellido2", "");
                        myEditor.putString("email", "");
                        myEditor.putString("contra", "");
                        myEditor.putString("agua", "");

                        myEditor.commit();


                        startActivity(ifds);
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();



    }

    public void iraContadorAgua(View view) {
        Intent ifds = new Intent(this, ContadroVasosAgua.class);
        startActivity(ifds);
    }
}