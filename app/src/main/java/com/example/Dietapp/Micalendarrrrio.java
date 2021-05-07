package com.example.Dietapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationfinal.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Micalendarrrrio extends AppCompatActivity {
    float totalacalendario;
    TextView textDAtosTotal;
    TextView texHora;
    EditText textComentario;
    String eventoCalendario, textoObjetivo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario);


        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Micalendarrrrio.this);
        totalacalendario = myPreferences.getFloat("totalacalendario", 0);
        textoObjetivo = myPreferences.getString("agua", "");
        textDAtosTotal = findViewById(R.id.textDAtosTotal);
        textDAtosTotal.setText("total de Kcalorias consumidas hoy: " + totalacalendario + "");


        textComentario = findViewById(R.id.textComentario);
        textComentario.setText(textoObjetivo);
        SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(Micalendarrrrio.this);

        int vasosGuardados=myPreferencesPA.getInt("valoragua",0);
        float recuentomilitros=myPreferencesPA.getFloat("valoragua2",0);

        textComentario.setText("NOTA1: has conseguido  "+vasosGuardados+"vasos de agua"+recuentomilitros+"litros de agua"+".  NOTA 2: ");


        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm");
        String strDate = sdf.format(c.getTime());
        texHora = findViewById(R.id.hora);
        texHora.setText(strDate);

    }


    public void guardarCalendario(View view) {
        if (!textDAtosTotal.getText().toString().isEmpty()) {
            if (!textComentario.getText().toString().isEmpty()) {
                eventoCalendario = textDAtosTotal.getText().toString() + "___NOTA:" + textComentario.getText().toString();
            } else {
                eventoCalendario = textDAtosTotal.getText().toString();
            }
            String titulo = "DIETAPP";
            Intent in = new Intent(Intent.ACTION_INSERT);
            in.setData(CalendarContract.Events.CONTENT_URI);
            in.putExtra(CalendarContract.Events.TITLE, titulo);
            in.putExtra(CalendarContract.Events.DESCRIPTION, eventoCalendario);
            in.putExtra(CalendarContract.Events.ALL_DAY, "true");
            startActivity(in);

            //debido a que el usaurio guarda sus datos, en caso de querer sumar mas datos, no seria comodo tener los datos ya guardados de forma que s e borran
            SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(Micalendarrrrio.this);
            SharedPreferences.Editor myEditorPA = myPreferencesPA.edit();
            //ponemos a cero todos los datos realizados.
            myEditorPA.putFloat("pasta", 0);
            myEditorPA.putFloat("carne", 0);
            myEditorPA.putFloat("fru", 0);
            myEditorPA.putFloat("depor", 0);
            myEditorPA.putFloat("pescado", 0);
            myEditorPA.putFloat("salsa", 0);
            myEditorPA.putFloat("erdura", 0);
            myEditorPA.putFloat("valoragua",0);
            myEditorPA.putFloat("valoragua2",0);
            myEditorPA.putFloat("receta",0);

            myEditorPA.commit();

        } else {
            Toast.makeText(Micalendarrrrio.this, "no hay datos disponibles para guardar", Toast.LENGTH_SHORT).show();
        }
    }

}
