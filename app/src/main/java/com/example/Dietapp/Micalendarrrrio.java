package com.example.Dietapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Micalendarrrrio extends AppCompatActivity {
    float totalacalendario;
    TextView textDAtosTotal;
    TextView texHora;
    EditText textComentario;
    String eventoCalendario, textoObjetivo, nombreUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario);


        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Micalendarrrrio.this);
        totalacalendario = myPreferences.getFloat("totalacalendario", 0);
        textoObjetivo = myPreferences.getString("agua", "");
        nombreUser = myPreferences.getString("nombreUser", "");
        textDAtosTotal = findViewById(R.id.textDAtosTotal);
        textDAtosTotal.setText("total de Kcalorias consumidas hoy: " + totalacalendario + "");


        textComentario = findViewById(R.id.textComentario);
        // textComentario.setText(textoObjetivo);
        SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(Micalendarrrrio.this);


        float recuentomilitros = myPreferencesPA.getFloat("valoragua2", 0);

        textComentario.setText("NOTA1: " + textoObjetivo + " con " + recuentomilitros + " litros de agua" + ".  NOTA 2: ");


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
            myEditorPA.putFloat("valoragua", 0);
            myEditorPA.putFloat("valoragua2", 0);
            myEditorPA.putFloat("receta", 0);
            myEditorPA.putFloat("bebidas", 0);
            myEditorPA.putFloat("totalacalendario", 0);


            myEditorPA.commit();

            //borrar datos de base de datos al guardarlos
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String sql = "UPDATE comida SET total='0.0', carne ='0.0', pescado ='0.0',recetas='0.0', bebidas ='0.0', fruta ='0.0', deporte ='0.0', pastas ='0.0', salsas ='0.0',verdura ='0.0' where login='" + nombreUser + "' ";
            bd.execSQL(sql);
            String sql2 = "UPDATE usuarios SET retoagua='' where login='" + nombreUser + "'";
            bd.execSQL(sql2);
        } else {
            Toast.makeText(Micalendarrrrio.this, "no hay datos disponibles para guardar", Toast.LENGTH_SHORT).show();
        }
    }

}
