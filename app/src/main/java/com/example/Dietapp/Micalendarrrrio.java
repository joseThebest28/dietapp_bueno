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
        double totalacalendario;
        TextView textDAtosTotal;
        TextView texHora;
        EditText textComentario;
        String eventoCalendario;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario);



            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Micalendarrrrio.this);
            totalacalendario = myPreferences.getInt("totalacalendario", 0);
            textDAtosTotal=findViewById(R.id.textDAtosTotal);
            textDAtosTotal.setText("total de calorias consumidas hoy: " + totalacalendario+"");




                textComentario = findViewById(R.id.textComentario);




                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat(" HH:mm");
                String strDate = sdf.format(c.getTime());
                texHora=findViewById(R.id.hora);
                texHora.setText(strDate);

}




        public void guardarCalendario(View view) {
                if(!textDAtosTotal.getText().toString().isEmpty()) {
                    if(!textComentario.getText().toString().isEmpty())
                    {eventoCalendario =textDAtosTotal.getText().toString()+"___NOTA:"+ textComentario.getText().toString();}
                    else
                    {
                        eventoCalendario =textDAtosTotal.getText().toString();
                    }
                        String titulo="DIETAPP";
                        Intent in=new Intent(Intent.ACTION_INSERT);
                        in.setData(CalendarContract.Events.CONTENT_URI);
                        in.putExtra(CalendarContract.Events.TITLE,titulo);
                        in.putExtra(CalendarContract.Events.DESCRIPTION,eventoCalendario);
                        in.putExtra(CalendarContract.Events.ALL_DAY,"true");
                        startActivity(in);
                        SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(Micalendarrrrio.this);
                        SharedPreferences.Editor myEditorPA = myPreferencesPA.edit();
                        myEditorPA.putInt("pasta", 0);
                        myEditorPA.putInt("carne", 0);
                        myEditorPA.putInt("fru", 0);
                        myEditorPA.putInt("depor", 0);
                        myEditorPA.putInt("pescado", 0);
                    myEditorPA.putInt("salsa", 0);
                    myEditorPA.putInt("erdura", 0);
                        myEditorPA.commit();

                }
                else{
                        Toast.makeText(Micalendarrrrio.this, "no hay datos disponibles para guardar", Toast.LENGTH_SHORT).show();
                }
        }

}
