package com.example.Dietapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplicationfinal.R;

import java.security.AccessController;

public class Ajustes extends AppCompatActivity {
    TextView texto,nombreED,apellidoED,apellido2ED,emailED;
    ImageView imagen;
    Button boton;
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
imagen=findViewById(R.id.imageView29);
boton=findViewById(R.id.button43);


        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Ajustes.this);

       String nombreUser = myPreferences.getString("nombreUser", "");
        String nombre = myPreferences.getString("nombre", "");
        String apellido = myPreferences.getString("apellido", "");
        String apellido2 = myPreferences.getString("apellido2", "");
        String emal = myPreferences.getString("email", "");
        texto.setText("Nombre usuario-----> "+nombreUser);
        nombreED.setText("Nombre ---------------->  "+nombre);
        apellidoED.setText("Apellido ---------------->  "+apellido);
        apellido2ED.setText("Apellido2 -------------->  "+apellido2);
        emailED.setText("Email -------------------->  "+emal);

        //para cambiar la imagen
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subirFoto();
            }
        });

    }

    private void subirFoto() {//cambiar variable opciones,builder
        final CharSequence [] opciones={"Tomar Foto", "Elegir de Galeria", "Cancelar"};
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Elige una opción");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(opciones[i].equals("Tomar Foto"))
                {

                }else{
                    if(opciones[i].equals("elegir de Galeria"))
                    {
                        Intent intent=new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        //startActivityForResult(intent, PHOTO_SELECTED);
                    }
                }
            }
        });

    }
}