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

public class ListasLegumbres extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresLegumbre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresLegumbre= new String[]{ "selecciona tipo de legumbre ",
                "alubias/porotos/habas: 337kcal","alubias/habas rojas: 337kcal","bisalto/tirabeque/chicharos dulces: 42kcal"
        ,"brotes de bmabú: 27kcal","cacahuetes/mani: 567kcal","castañas: 210kcal", "dal: 230kcal"
        ,"frijoles con chile: 97kcal","frijoles de soja: 147kcal","garvanzos: 364kcal",
        "guisantes/arvejas/chicharos: 42kcal","soja verde/judía mungo: 12kcal","alubias/judias/porotos blancos: 336kcal," +
                "judias/frijolesnegros: 341kcal","judias/frijoles pintos: 347kcal","porotos/frijoles/judias rojos: 124kcal",
        "judias verdes/chauchas/ejotes: 31kcal","lenteja marrón: 353kcal","lenteja verde: 257kcal",
        "lentejas amarillas: 304kcal","lenteja roja: 329kcal","arroz blanco: 366kcal ",
                "miso: 199kcal","moyashi/germinado de frijol:30kcal","nueces de pecán: 691kcal","nueces de soja: 235kcal","okra: 33kcal","queso de soja: 235kcal","tempeh: 193kcal","tofu: 76kcal","tofu extra firme: 91kcal" ,
                "tofu firme: 70kcal","tofu frito: 271kcal","tofu silken: 55kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresLegumbre);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +337; }
                if (position == 2) { suma = suma +337; }
                if (position == 3) { suma = suma +42; }
                if (position == 4) { suma = suma +27; }
                if (position == 5) { suma = suma +567; }
                if (position == 6) { suma = suma +210; }
                if (position == 7) { suma = suma +230; }
                if (position == 8) { suma = suma +97; }
                if (position == 9) { suma = suma +147; }
                if (position == 10) { suma = suma +364; }
                if (position == 11) { suma = suma +42; }
                if (position == 12) { suma = suma +12; }
                if (position == 13) { suma = suma +336; }
                if (position == 14) { suma = suma +341; }
                if (position == 15) { suma = suma +347; }
                if (position == 16) { suma = suma +124; }
                if (position == 17) { suma = suma +31; }
                if (position == 18) { suma = suma +353; }
                if (position == 19) { suma = suma +257; }
                if (position == 20) { suma = suma +304; }
                if (position == 21) { suma = suma +329; }
                if (position == 22) { suma = suma +366; }
                if (position == 23) { suma = suma +199; }
                if (position == 24) { suma = suma +30; }
                if (position == 25) { suma = suma +691; }
                if (position == 26) { suma = suma +471; }
                if (position == 27) { suma = suma +33; }
                if (position == 28) { suma = suma +235; }
                if (position == 29) { suma = suma +193; }
                if (position == 30) { suma = suma +76; }
                if (position == 31) { suma = suma +91; }
                if (position == 32) { suma = suma +70; }
                if (position == 33) { suma = suma +271; }
                if (position == 34) { suma = suma +55; }







                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasLegumbres.this);
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
        for(int i=0;i<valoresLegumbre.length;i++)
            if(valoresLegumbre[i].contains(textoEditT))
            {
                listaBusca.add(valoresLegumbre[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}