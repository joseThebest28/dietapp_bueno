package com.example.Dietapp.extras.Recetas.listas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Dietapp.extras.Recetas.Recetas;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class ListasConejo extends AppCompatActivity {
ListView lista;
    static float suma;
    static  float total;
    EditText textoEdit;
    String textoEditT;
    Intent volverPaginaElegir;
    String[] valoresConejo;  Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista = findViewById(R.id.lista);
        textoEdit = findViewById(R.id.editListas);
        volverPaginaElegir = new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasConejo.this);
        total = myPreferences.getFloat("caloriasLista", 0);

        textoEdit.setVisibility(View.INVISIBLE);
        boton=findViewById(R.id.button45);
        boton.setVisibility(View.INVISIBLE);
    valoresConejo= new String[]{"selecciona pieza de conejo ",
            "paletilla de conejo: 143kcal","lomo de conejo: 143kcal ",
                "1 costilla de conejo: 66kcal"};



        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresConejo);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +143; }
                if (position == 2) { suma = suma +143; }
                if (position == 3) { suma = suma +66; }




                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasConejo.this);
                SharedPreferences.Editor myEditor = myPreferencesG.edit();
                myEditor.putFloat("caloriasLista",total);
                myEditor.commit();
                Log.i("tag","calorias final"+total);
                suma=0;
                startActivity(iD);
            }});




    }
    public void realizarBusqueda(View view) {

    }
}