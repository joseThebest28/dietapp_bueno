package com.example.Dietapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.Dietapp.extras.ContadroVasosAgua;
import com.example.Dietapp.extras.Pagina_reto;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.Dietapp.login.Login;
import com.example.myapplicationfinal.R;

import java.util.Calendar;

import yuku.ambilwarna.AmbilWarnaDialog;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.getInstance;

public class Ajustes extends AppCompatActivity {
    TextView texto,nombreED,apellidoED,apellido2ED,emailED,retos;
    ImageView imagen;
    Button boton,botonRetos,botonAgua, botonColor;
    ScrollView mlay;
int mDefaultColor;

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

        botonRetos=findViewById(R.id.bRetos);
        botonRetos.setVisibility(View.INVISIBLE);

        botonAgua=findViewById(R.id.bcontadorAgua);
        botonAgua.setVisibility(View.INVISIBLE);

        mlay=findViewById(R.id.layoutAjustes);
        mDefaultColor= ContextCompat.getColor(com.example.Dietapp.Ajustes.this,R.color.colorPrimary);
        botonColor=findViewById(R.id.bcolor);
        botonColor.setVisibility(View.INVISIBLE);




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
        retos.setText(agua);





this.borrarDAtosDiario();


    }








    public void verMAs(View view) {
        botonRetos.setVisibility(View.VISIBLE);
        botonAgua.setVisibility(View.VISIBLE);
        botonColor.setVisibility(View.VISIBLE);
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
                        myEditor.putInt("valoragua",0);
                        myEditor.putFloat("valoragua2",0);

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

    public void borrarDAtosDiario()
    {
        //si son las 23 borrar todos los datos introducidos por el usuario, ya que han sido los datos del dia anterior.

        //obtener la hora actual
        Calendar calendario = getInstance();
        int hora, minutos, segundos;
        hora =calendario.get(HOUR_OF_DAY);
        minutos = calendario.get(MINUTE);
        segundos = calendario.get(SECOND);


        //comparar los minutos segundo y horas a las 23  se reseten los datos
        while((hora==23 && minutos==00&&segundos==00))
        {
            //borrar registrocunado llegadas las doce de la noche

            SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(Ajustes.this);
            SharedPreferences.Editor myEditorPA = myPreferencesPA.edit();
            myEditorPA.putInt("pasta", 0);
            myEditorPA.putInt("carne", 0);
            myEditorPA.putInt("fru", 0);
            myEditorPA.putInt("depor", 0);
            myEditorPA.putInt("pescado", 0);
            myEditorPA.putInt("salsa", 0);
            myEditorPA.putInt("erdura", 0);
            myEditorPA.putInt("valoragua",0);
            myEditorPA.putFloat("valoragua2",0);
            myEditorPA.commit();
//cambio el valor actual del reto, y lo pongo vacio, ya que el reto se debe cumplir una vez ald ia, por lo que a las once se pone vacio
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 10);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String sql = "UPDATE usuarios SET retoagua=''";
            bd.execSQL(sql);
            bd.close();
        }

        Log.i("taf", ""+hora);
        Log.i("taf", ""+minutos);

    }


    public void iraColor(View view) {
        Intent ifds = new Intent(this, Color.class);
        startActivity(ifds);
    }


    public void openColorPicker(View view) {
        AmbilWarnaDialog coloPicker= new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor=color;
                mlay.setBackgroundColor(mDefaultColor);
            }
        });coloPicker.show();
    }
}