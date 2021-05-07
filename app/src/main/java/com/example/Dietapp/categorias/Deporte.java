package com.example.Dietapp.categorias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.Seguimiento;
import com.example.myapplicationfinal.R;

public class Deporte extends AppCompatActivity {
    private TextView total;
    double carne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deporte);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Deporte.this);

        carne = myPreferences.getFloat("depor", 0);
        total = findViewById(R.id.textR);
        total.setText(""+carne);

    }
    public void volverMenu(View view) {
        Intent i = new Intent(this, CategoDeporte.class );
        startActivity(i);

    }




    public void enviarDatos(View view) {
        Intent intent = new Intent(this, Seguimiento.class);
       intent.putExtra("calorias deporte", carne);

       startActivity(intent);
       Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de deporte correctamente", Toast.LENGTH_SHORT);

      toastNada3.show();

       SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Deporte.this);
       SharedPreferences.Editor myEditor = myPreferences.edit();
       myEditor.putFloat("depor", (float) carne);
       myEditor.commit();
    }
}
