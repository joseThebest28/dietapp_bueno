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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Dietapp.extras.Recetas.Recetas;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class ListasTernera extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresTernera;Intent volverPaginaElegir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista = findViewById(R.id.lista);
        textoEdit = findViewById(R.id.editListas);
        volverPaginaElegir = new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasTernera.this);
        total = myPreferences.getFloat("caloriasLista", 0);
         valoresTernera= new String[]{ "selecciona pieza de ternera(nº cal cada 100gr)",
                "filete de ternera con hueso: 189kcal","fielte de ternera: 133kcal","solomillo de ternera: 182kcal","filete de tapilla: 117kcal",
                "rosbif: 187kcal","redondo: 107kcal","rabillo: 131kcal","sebo de ternera: 902kcal","pierna: 211kcal","lomo: 117kcal",
        "rabo: 131kcal","filete miñon: 207kcal","hamburguesas: 247kcal","goulash: 123kcal","fielte de falda: 205kcal","costillas: 217kcal",
                "carne picada: 241kcal"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresTernera);
        lista.setAdapter(adaptador);


        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +189; }
                if (position == 2) { suma = suma +133; }
                if (position == 3) { suma = suma +182; }
                if (position == 4) { suma = suma +117; }
                if (position == 5) { suma = suma +187; }
                if (position == 6) { suma = suma +107; }
                if (position == 7) { suma = suma +131; }
                if (position == 8) { suma = suma +902; }
                if (position == 9) { suma = suma +211; }
                if (position == 10) { suma = suma +117; }
                if (position == 11) { suma = suma +131; }
                if (position == 12) { suma = suma +207; }
                if (position == 13) { suma = suma +247; }
                if (position == 14) { suma = suma +123; }
                if (position == 15) { suma = suma +205; }
                if (position == 16) { suma = suma +217; }
                if (position == 17) { suma = suma +241; }



                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasTernera.this);
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
        for (int i = 0; i < valoresTernera.length; i++)
            if (valoresTernera[i].contains(textoEditT)) {
                listaBusca.add(valoresTernera[i]);
            }
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listaBusca);
        lista.setAdapter(adaptador2);
    }
}