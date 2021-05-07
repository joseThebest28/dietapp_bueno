package com.example.Dietapp.extras.Recetas.listas;

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

import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class ListasEmbutidos extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresEmbutido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        textoEdit=findViewById(R.id.editListas);
         valoresEmbutido= new String[]{ "selecciona embutido(nº cal cada 100gr)",
                "andouille: 232kcal","bacon/panceta/tocino: 407kcal","bockwust: 301kcal","bratwurst: 297kcal","chorizo: 455kcal","corned beef: 153kcal",
         "fuet:422kcal","jamón cocida: 133kcal","kielbasa: 309kcal","knackwurst: 307kcal","landjäger/salchicha cazador: 352kcal",
         "leberwurst: 326kcal","lomo embutido: 200kcal","lyoner: 247kcal","mettwurst: 310kcal","mortadela: 311kcal","pastrami: 133kcal",
         "prociutto: 195kcal","salami/salame:336kcal","salchicha/chorizo: 230kcal","salchicha/chorizo picante: 259kcal",
         "salchicha/chorizo ahumado: 301kcal","salchicha italiana/chorizo criollo: 149kcal","salchicha parrillera: 840kcal","frankfurt/salchicha de viena: 305kcal",
         "salchichón: 247kcal","sobrasada: 598kcal","weisswurst/salchicha blanca: 313kcal"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresEmbutido);
        lista.setAdapter(adaptador);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +232; }
                if (position == 2) { suma = suma +407; }
                if (position == 3) { suma = suma +301; }
                if (position == 4) { suma = suma +297; }
                if (position == 5) { suma = suma +455; }
                if (position == 6) { suma = suma +153; }
                if (position == 7) { suma = suma +422; }
                if (position == 8) { suma = suma +133; }
                if (position == 9) { suma = suma +309; }
                if (position == 10) { suma = suma +307; }
                if (position == 11) { suma = suma +352; }
                if (position == 12) { suma = suma +326; }
                if (position == 13) { suma = suma +200; }
                if (position == 14) { suma = suma +247; }
                if (position == 15) { suma = suma +310; }
                if (position == 16) { suma = suma +311; }
                if (position == 17) { suma = suma +133; }
                if (position == 18) { suma = suma +195; }
                if (position == 19) { suma = suma +336; }
                if (position == 20) { suma = suma +230; }
                if (position == 21) { suma = suma +259; }
                if (position == 22) { suma = suma +301; }
                if (position == 23) { suma = suma +149; }
                if (position == 24) { suma = suma +840; }
                if (position == 25) { suma = suma +305; }
                if (position == 26) { suma = suma +247; }
                if (position == 27) { suma = suma +598; }
                if (position == 28) { suma = suma +313; }

                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasEmbutidos.this);
                SharedPreferences.Editor myEditor = myPreferencesG.edit();
                myEditor.putFloat("caloriasLista",total);
                myEditor.commit();
                Log.i("tag","calorias final"+total);
                suma=0;
            }});

    }
    public void realizarBusqueda(View view) {
        ArrayList<String> listaBusca=new ArrayList<>();
        textoEditT=String.valueOf(textoEdit.getText());
        for(int i=0;i<valoresEmbutido.length;i++)
            if(valoresEmbutido[i].contains(textoEditT))
            {
                listaBusca.add(valoresEmbutido[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}