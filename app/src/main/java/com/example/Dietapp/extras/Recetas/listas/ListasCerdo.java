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

public class ListasCerdo extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresCerdo;    Intent volverPaginaElegir;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista = findViewById(R.id.lista);
        textoEdit = findViewById(R.id.editListas);
        volverPaginaElegir = new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasCerdo.this);
        total = myPreferences.getFloat("caloriasLista", 0);
        valoresCerdo= new String[]{ "selecciona pieza de carne de cerdo(nº calorias cada 100gr)",
                "solomillo: 158kcal","cinta de lomo: 136kcal",
                "chuletas de lomo(de palo) : 27.1kcal","cadera/babilla: 271kcal","paletilla: 169kcal",
                "aguja: 151kcal","costillas: 292kcal","codillo: 171kcal","magro: 156kcal","panceta: 467kcal","tocino: 665kcal","papada: 673kcal","morro: 201kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresCerdo);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +158; }
                if (position == 2) { suma = suma +136; }
                if (position == 3) { suma = suma +27.1f; }
                if (position == 4) { suma = suma +271; }
                if (position == 5) { suma = suma +169; }
                if (position == 6) { suma = suma +151; }
                if (position == 7) { suma = suma +292; }
                if (position == 8) { suma = suma +171; }
                if (position == 9) { suma = suma +156; }
                if (position == 10) { suma = suma +467; }
                if (position == 11) { suma = suma +665; }
                if (position == 12) { suma = suma +673; }
                if (position == 13) { suma = suma +201; }





                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasCerdo.this);
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
        for (int i = 0; i < valoresCerdo.length; i++)
            if (valoresCerdo[i].contains(textoEditT)) {
                listaBusca.add(valoresCerdo[i]);
            }
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listaBusca);
        lista.setAdapter(adaptador2);
    }
}