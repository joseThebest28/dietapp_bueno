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

import com.example.Dietapp.categorias.Deporte;
import com.example.Dietapp.extras.Recetas.Recetas;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class ListsLacteos extends AppCompatActivity {
    ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresLacteos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresLacteos= new String[]{ "selecciona tipo lacteo(nº kcal por cada 100gr)",
                "arroz con leche: 118kcal","chocolate caliente: 89kcal","crema chantillí: 266kcal","crema para café: 195kcal","crème fraîche: 393kcal",
        "cuajada: 98kcal","horcahta: 85kcal","kéfir:55kcal","lassi: 75kcal","leche condensada: 321kcal:","leche de almendra: 17kcal","leche de arroz: 49kcal","leche de cabra: 69kcal","leche de coco: 230kcal","" +
                "leche de soja: 45kcal","leche desnatada: 35kcal","leche en polvo: 496kcal","leche entera: 61kcal","leche evaporada: 321kcal","leche merengada: 81kcal","leche preparada: 110kcal",
        "leche semidesnatada: 50kcal","leche sin lactosa: 52kcal","mousse de chocolate: 225kcal","nata/crema: 242kcal","nata/crema agria: 181kcal","nata montada/crema batida: 257kcal","pudin de sémola: 67kcal","requesón/cottage/ricota: 98kcal",
        "suero de mantequillas: 62kcal","tzatziki: 117kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresLacteos);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +118; }
                if (position == 2) { suma = suma +89; }
                if (position == 3) { suma = suma +266; }
                if (position == 4) { suma = suma +195; }
                if (position == 5) { suma = suma +393; }
                if (position == 6) { suma = suma +98; }
                if (position == 7) { suma = suma +85; }
                if (position == 8) { suma = suma +55; }
                if (position == 9) { suma = suma +75; }
                if (position == 10) { suma = suma +321; }
                if (position == 11) { suma = suma +17; }
                if (position == 12) { suma = suma +49; }
                if (position == 13) { suma = suma +69; }
                if (position == 14) { suma = suma +230; }
                if (position == 15) { suma = suma +45; }
                if (position == 16) { suma = suma +35; }
                if (position == 17) { suma = suma +496; }
                if (position == 18) { suma = suma +61; }
                if (position == 19) { suma = suma +321; }
                if (position == 20) { suma = suma +81; }
                if (position == 21) { suma = suma +110; }
                if (position == 22) { suma = suma +50; }
                if (position == 23) { suma = suma +52; }
                if (position == 24) { suma = suma +225; }
                if (position == 25) { suma = suma +242; }
                if (position == 26) { suma = suma +181; }
                if (position == 27) { suma = suma +257; }
                if (position == 28) { suma = suma +67; }
                if (position == 29) { suma = suma +98; }
                if (position == 30) { suma = suma +62; }
                if (position == 31) { suma = suma +117; }







                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListsLacteos.this);
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
        for(int i=0;i<valoresLacteos.length;i++)
            if(valoresLacteos[i].contains(textoEditT))
            {
                listaBusca.add(valoresLacteos[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}