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

public class ListasPato extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresPa;Intent volverPaginaElegir;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista = findViewById(R.id.lista);
        textoEdit = findViewById(R.id.editListas);
        volverPaginaElegir = new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasPato.this);
        total = myPreferences.getFloat("caloriasLista", 0);
        textoEdit.setVisibility(View.INVISIBLE);
        boton=findViewById(R.id.button45);
        boton.setVisibility(View.INVISIBLE);
        valoresPa= new String[]{ "selecciona pieza de pato",
                "pechuga de pato: 202kcal","piernas de pato: 277kcal","chuletas de pato: 132kcal","pato a la naranja: 377.5kcal","cuello de pato: 84kcal",
             "magret: 190kcal","pato pekinés: 265kcal" };

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPa);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +202; }
                if (position == 2) { suma = suma +277; }
                if (position == 3) { suma = suma +132; }
                if (position == 4) { suma = suma +377.5f; }
                if (position == 5) { suma = suma +84; }
                if (position == 6) { suma = suma +190; }
                if (position == 7) { suma = suma +265; }







                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasPato.this);
                SharedPreferences.Editor myEditor = myPreferencesG.edit();
                myEditor.putFloat("caloriasLista",total);
                myEditor.commit();
                Log.i("tag","calorias final"+total);
                suma=0;
                startActivity(iD);
            }});

    }
    public void realizarBusqueda(View view) {
        ArrayList<String> listaBusca = new ArrayList<>();
        textoEditT = String.valueOf(textoEdit.getText());
        for (int i = 0; i < valoresPa.length; i++)
            if (valoresPa[i].contains(textoEditT)) {
                listaBusca.add(valoresPa[i]);
            }
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listaBusca);
        lista.setAdapter(adaptador2);
    }
}