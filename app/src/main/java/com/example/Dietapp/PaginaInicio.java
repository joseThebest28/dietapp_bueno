package com.example.Dietapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.Dietapp.login.Login;
import com.example.Dietapp.tutorial.Explica1;
import com.example.myapplicationfinal.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class PaginaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       TextView texto = (TextView) findViewById(R.id.textView);
        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.animacion);
       Animation animacionb = AnimationUtils.loadAnimation(this,R.anim.animacionb);
        Button b1=findViewById(R.id.button);
        Button b2=findViewById(R.id.button3);
        TextView texto2 = (TextView) findViewById(R.id.textView3);
        TextView texto3 = (TextView) findViewById(R.id.textView4);

        texto.startAnimation(animacionb);
        texto2.startAnimation(animacionb);
        texto3.startAnimation(animacionb);
       b1.startAnimation(animacion);
        b2.startAnimation(animacion);



        //si son las doce borrar todos los datos introducidos por el usuario, ya que han sido los datos del dia anterior

        //comparar fechas
        Calendar cal = Calendar.getInstance();
        long hoy = cal.getTimeInMillis();
        cal.add(Calendar.DAY_OF_WEEK,1);
        long despues = cal.getTimeInMillis();

        if(despues > hoy){
            //borrar registrocunado llega el dia siguiente

            SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(PaginaInicio.this);
            SharedPreferences.Editor myEditorPA = myPreferencesPA.edit();
            myEditorPA.putString("agua", "");
            myEditorPA.putInt("pasta", 0);
            myEditorPA.putInt("carne", 0);
            myEditorPA.putInt("fru", 0);
            myEditorPA.putInt("depor", 0);
            myEditorPA.putInt("pescado", 0);
            myEditorPA.putInt("salsa", 0);
            myEditorPA.putInt("erdura", 0);
            myEditorPA.commit();

        }
        Log.i("FECHA RESULTADO",new SimpleDateFormat("dd/MM/yyyy").format(hoy));
        Log.i("FECHA RESULTADO", new SimpleDateFormat("dd/MM/yyyy").format(despues));

    }
    public void lanzarapp(View view) {
       // Intent i = new Intent(this, Login.class );
        Intent i = new Intent(this, Login.class );
        startActivity(i);
    }
    public void lanzartuto(View view) {
        Intent i2 = new Intent(this, Explica1.class );
        startActivity(i2);
    }


}