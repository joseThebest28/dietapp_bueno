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

public class ListasPescadosOtro extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresPescadoOt;Intent volverPaginaElegir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista = findViewById(R.id.lista);
        textoEdit = findViewById(R.id.editListas);
        volverPaginaElegir = new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasPescadosOtro.this);
        total = myPreferences.getFloat("caloriasLista", 0);
        valoresPescadoOt= new String[]{ "selecciona tipo de pescado ",
                "dorada: 77kcal","zapatilla: 77kcal","lubina/ródalo: 124kcal",
                "rodaballo: 122kcal","salmón: 206kcal","trucha: 91kcal","caviar: 264kcal","palitos de pescado: 290kcal","sushi: 150kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPescadoOt);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +77; }
                if (position == 2) { suma = suma +77; }
                if (position == 3) { suma = suma +124; }
                if (position == 4) { suma = suma +122; }
                if (position == 5) { suma = suma +206; }
                if (position == 6) { suma = suma +91; }
                if (position == 7) { suma = suma +264; }
                if (position == 8) { suma = suma +290; }
                if (position == 9) { suma = suma +150; }





                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasPescadosOtro.this);
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
        for (int i = 0; i < valoresPescadoOt.length; i++)
            if (valoresPescadoOt[i].contains(textoEditT)) {
                listaBusca.add(valoresPescadoOt[i]);
            }
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listaBusca);
        lista.setAdapter(adaptador2);
    }
}