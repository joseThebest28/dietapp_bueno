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

public class ListasVerdura extends AppCompatActivity {
ListView lista;
   static float suma;
   static  float total;
    EditText textoEdit;
    String textoEditT;
   Intent volverPaginaElegir;
    String[] valoresBuey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        textoEdit=findViewById(R.id.editListas);
        volverPaginaElegir=new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasVerdura.this);
        total=myPreferences.getFloat("caloriasLista",0);
Log.i("tag","calorias inicio"+total);
         valoresBuey= new String[]{ "selecciona verduras(nº calorias cada 100gr)",
                "lechuga: 15 calorias", "patatas: 94 cal", "acelga: 19 cal", "ajo: 1 diente= 4.5cal", "alcachofa: 47 cal",
                "apio: 16 cal", "berenjena: 25cal", "brecol: 34cal", "cebolla: 40cal", "cebolleta: 34cal", "col china: 16cal",
                "coliflor: 25 cal", "escarola: 17 cal", "espinaca: 22 cal", "judias verdes/ejote: 31 cal", "ñame: 118 cal",
                "colinabo/rutaba: 38 cal", "tomate: 18 cal", "zanahoria: 34 cal",
                 "Champiñon: 22kcal", "Niscalos: 25kcal", "Seta de cardo: 92kcal", "Pleurotus/girgolas: 35kcal", "Trufas: 64kcal"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresBuey);
        lista.setAdapter(adaptador);

        final Intent iD = new Intent(this, Recetas.class);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +15; }
                if (position == 2) { suma = suma +94; }
                if (position == 3) { suma = suma +19; }
                if (position == 4) { suma = suma +4.5f; }
                if (position == 5) { suma = suma +47; }
                if (position == 6) { suma = suma +16; }
                if (position == 7) { suma = suma +25; }
                if (position == 8) { suma = suma +34; }
                if (position == 9) { suma = suma +40; }
                if (position == 10) { suma = suma +34; }
                if (position == 11) { suma = suma +16; }
                if (position == 12) { suma = suma +25; }
                if (position == 13) { suma = suma +17; }
                if (position == 14) { suma = suma +22; }
                if (position == 15) { suma = suma +31; }
                if (position == 16) { suma = suma +118; }
                if (position == 17) { suma = suma +38; }
                if (position == 18) { suma = suma +18; }
                if (position == 19) { suma = suma +34; }
                if (position == 20) { suma = suma +22; }
                if (position == 21) { suma = suma +25; }
                if (position == 22) { suma = suma +92; }
                if (position == 23) { suma = suma +35; }
                if (position == 24) { suma = suma +64; }



            total=total+suma;
        Log.i("tag","total"+total);
        Log.i("tag","suma"+suma);
            SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasVerdura.this);
            SharedPreferences.Editor myEditor = myPreferencesG.edit();
        myEditor.putFloat("caloriasLista",total);
        myEditor.commit();
        Log.i("tag","calorias final"+total);
            suma=0;
            startActivity(iD);
        }});




    }
    public void realizarBusqueda(View view) {
        ArrayList<String> listaBusca=new ArrayList<>();
        textoEditT=String.valueOf(textoEdit.getText());
        for(int i=0;i<valoresBuey.length;i++)
            if(valoresBuey[i].contains(textoEditT))
            {
                listaBusca.add(valoresBuey[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}