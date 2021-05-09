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

public class ListasPescadosMar extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresPescadoKM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresPescadoKM= new String[]{ "selecciona tipo de pescado de mar ",
                "abadejo: 111kcal","boquerón/anchoa: 131kcal","anchoa de banco: 159kcal","anguila:236kcal"
                ,"arenque: 203kcal","atun: 132kcal","bacalao: 105kcal","balistes:93kcal",
                "boga: 149kcal","brema: 135kcal","bacaladilla/lirio/perlita: 84kcal",
                "besugo: 88kcal", "caballa/verdel:212kcal",
               "capellán: 124kcal","carpa: 162kcal","corvina: 81kcal", "cabracho: 91kcal","congrio: 107kcal",
                "dorado: 85kcal","esglefino: 90kcal","esturión: 135kcal","fletán/halibut: 111kcal", "gallineta nórdica: 94kcal","lenguado: 86kcal","lisa: 150kcal",
                "lubina: 124kcal","lucio: 113kcal",
                "lucioperca: 84kcal","maruca: 128kcal", "merluza: 71kcal" ,"mero/cherna: 118kcal"
                ,"palometa/japuta: 187kcal","panga: 67kcal","pargo rojo: 87kcal","pejerrey: 106kcal",
                "pescadilla: 116kcal","peto: 109kcal","pez espada/emperador: 172kcal","platija: 86kcal",
                "rape: 97kcal","rodaballo: 122kcal","sabalote: 190kcal","salmón: 206kcal",
                "sardina: 208kcal","solla: 91kcal","surubí: 110kcal","sábalo: 252kcal",
                "tuburón: 130kcal","trucha: 190kcal", "gallo: 81kcal",
                "jurel/chicharro: 117kcal","liba/eglefino/merlán: 84kcal"
               ,"raya: 97kcal","salmonete: 109kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPescadoKM);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +111; }
                if (position == 2) { suma = suma +131; }
                if (position == 3) { suma = suma +159; }
                if (position == 4) { suma = suma +236; }
                if (position == 5) { suma = suma +203; }
                if (position == 6) { suma = suma +132; }
                if (position == 7) { suma = suma +105; }
                if (position == 8) { suma = suma +93; }
                if (position == 9) { suma = suma +149; }
                if (position == 10) { suma = suma +135; }
                if (position == 11) { suma = suma +84; }
                if (position == 12) { suma = suma +88; }
                if (position == 13) { suma = suma +212; }
                if (position == 14) { suma = suma +124; }
                if (position == 15) { suma = suma +162; }
                if (position == 16) { suma = suma +81; }
                if (position == 17) { suma = suma +91; }
                if (position == 18) { suma = suma +107; }
                if (position == 19) { suma = suma +85; }
                if (position == 20) { suma = suma +90; }
                if (position == 21) { suma = suma +135; }
                if (position == 22) { suma = suma +111; }
                if (position == 23) { suma = suma +94; }
                if (position == 24) { suma = suma +86; }
                if (position == 25) { suma = suma +150; }
                if (position == 26) { suma = suma +124; }
                if (position == 27) { suma = suma +113; }
                if (position == 28) { suma = suma +84; }
                if (position == 29) { suma = suma +128; }
                if (position == 30) { suma = suma +71; }
                if (position == 31) { suma = suma +118; }
                if (position == 32) { suma = suma +187; }
                if (position == 33) { suma = suma +67; }
                if (position == 34) { suma = suma +87; }
                if (position == 35) { suma = suma +106; }
                if (position == 36) { suma = suma +116; }
                if (position == 37) { suma = suma +109; }
                if (position == 38) { suma = suma +172; }
                if (position == 39) { suma = suma +86; }
                if (position == 40) { suma = suma +97; }
                if (position == 41) { suma = suma +122; }
                if (position == 42) { suma = suma +190; }
                if (position == 43) { suma = suma +206; }
                if (position == 44) { suma = suma +208; }
                if (position == 45) { suma = suma +91; }
                if (position == 46) { suma = suma +110; }
                if (position == 47) { suma = suma +252; }
                if (position == 48) { suma = suma +130; }
                if (position == 49) { suma = suma +190; }
                if (position == 50) { suma = suma +81; }
                if (position == 51) { suma = suma +117; }
                if (position == 52) { suma = suma +84; }
                if (position == 53) { suma = suma +97; }
                if (position == 54) { suma = suma +109; }



                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasPescadosMar.this);
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
        for(int i=0;i<valoresPescadoKM.length;i++)
            if(valoresPescadoKM[i].contains(textoEditT))
            {
                listaBusca.add(valoresPescadoKM[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}