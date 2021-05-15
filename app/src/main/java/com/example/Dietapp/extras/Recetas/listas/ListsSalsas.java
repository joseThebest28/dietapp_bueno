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

public class ListsSalsas extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresSalsa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        textoEdit=findViewById(R.id.editListas);
         valoresSalsa= new String[]{ "selecciona salsa(nº kcal por cucharada)", "ketchup: 10kcal",
                 "mostaza: 6kcal", "ajvar: 1.8kcal","alioli: 62.3kcal","aliño ensalada: 44.9kcal",
         "aliño de miel y mostaza: 46.4kcal","vinagre balsamico: 29kcal","aliño de yogur: 4.5kcal",
         "aderezo francés: 6kcal","aderezo griego: 46.7kcal","aderezo italiano: 29.3kcal","aderezo ranchero: 51kcal" ,
                 "guacamoles: 15.7kcal","harissa: 5.2kcal","mayones:69.2kcal","mayonesa de ajo: 58.3kcal",
         "pasta de tomate: 8.2kcal","pesto: 45.8kcal","salsa césar: 42.9kcal","salsa a la pimienta: 4.7kcal",
         "salsa agridulce: 17.9kcal","salsa argentina/criolla: 33.1kcal","salsa arrabiata: 3.6kcal",
         "salsa barbacoa: 15kcal","salsa bearnesa: 41.4kcal","salsa bechamel: 22.5kcal","salsa boloñesa: 10.6kcal",
         "salsa brava: 11.6kcal","salsa cazadora: 4.5kcal","salsa cocktail: 32.7kcal","salsa de chile: 11.2kcal",
         "salsa de curry: 2.6kcal","salsa de naranja: 17.9kcal","salsa de soja: 6.7kcal","salsa de yogur: 17.1kcal",
         "salsa holandesa: 53.5kcal","salsa inglesa: 7.8kcal","salsa remoulade: 63.5kcal","salsa roja: 4.1kcal",
         "salsa rosa: 8.1kcal","salsa teriyaki: 8.9kcal","salsa verde: 4.1kcal","tabasco: 7kcal"
         };

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresSalsa);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +10; }
                if (position == 2) { suma = suma +6; }
                if (position == 3) { suma = suma +1.8f; }
                if (position == 4) { suma = suma +62.3f; }
                if (position == 5) { suma = suma +44.9f; }
                if (position == 6) { suma = suma +46.4f; }
                if (position == 7) { suma = suma +29; }
                if (position == 8) { suma = suma +4.5f; }
                if (position == 9) { suma = suma +6; }
                if (position == 10) { suma = suma +46.7f; }
                if (position == 11) { suma = suma +29.3f; }
                if (position == 12) { suma = suma +51; }
                if (position == 13) { suma = suma +15.7f; }
                if (position == 14) { suma = suma +5.2f; }
                if (position == 15) { suma = suma +69.2f; }
                if (position == 16) { suma = suma +58.3f; }
                if (position == 17) { suma = suma +8.2f; }
                if (position == 18) { suma = suma +45.8f; }
                if (position == 19) { suma = suma +42.9f; }
                if (position == 20) { suma = suma +4.7f; }
                if (position == 21) { suma = suma +17.9f; }
                if (position == 22) { suma = suma +33.1f; }
                if (position == 23) { suma = suma +3.6f; }
                if (position == 24) { suma = suma +15; }
                if (position == 25) { suma = suma +41.4f; }
                if (position == 26) { suma = suma +22.5f; }
                if (position == 27) { suma = suma +10.6f; }
                if (position == 28) { suma = suma +11.6f; }
                if (position == 29) { suma = suma +4.5f; }
                if (position == 30) { suma = suma +32.7f; }
                if (position == 31) { suma = suma +11.2f; }
                if (position == 32) { suma = suma +2.6f; }
                if (position == 33) { suma = suma +17.9f; }
                if (position == 34) { suma = suma +6.7f; }
                if (position == 35) { suma = suma +17.1f; }
                if (position == 36) { suma = suma +53.5f; }
                if (position == 37) { suma = suma +7.8f; }
                if (position == 38) { suma = suma +63.5f; }
                if (position == 39) { suma = suma +4.1f; }
                if (position == 40) { suma = suma +8.1f; }
                if (position == 41) { suma = suma +8.9f; }
                if (position == 42) { suma = suma +4.1f; }
                if (position == 43) { suma = suma +7; }

                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListsSalsas.this);
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
        for(int i=0;i<valoresSalsa.length;i++)
            if(valoresSalsa[i].contains(textoEditT))
            {
                listaBusca.add(valoresSalsa[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}