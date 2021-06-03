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

public class ListasPescadosMarisco extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresPescadoMarisco;Intent volverPaginaElegir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista = findViewById(R.id.lista);
        textoEdit = findViewById(R.id.editListas);
        volverPaginaElegir = new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasPescadosMarisco.this);
        total = myPreferences.getFloat("caloriasLista", 0);
       valoresPescadoMarisco= new String[]{ "selecciona tipo de marisco",
                "almeja: 148kcal", "bogavante: 90kcal", "cañailla: 91kcal",
                "langostinos tigre: 90kcal", "boca: 86kcal","cigalas: 69kcal","gambas: 75kcal","langosta: 89kcal",
                "langostino: 75kcal", "cangrejo de rio: 82kcal ", "cangrejo de mar: 124kcal", "buey de mar: 130kcal", " centollo: 127kcal",
                "nécora: 125kal", "percebe: 66kcal", "almeja fina/chirla: 76.6 kcal","berberecho: 76kcal", "coquina: 75kcal",
                "mejillón: 172kcal", "navaja: 92.5kcal", "ostra: 41kcal", "vieira: 111kcal", "lapa: 86kcal", "bígaro: 94kcal",
                "cañailla: 80kcal", "busano: 79kcal", "calamar: 175kcal", "camarón: 82kcal", "pota: 120kcal", "pulpo: 164kcal",
                "pecho: 86kcal",
                "sepia: 75.3kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPescadoMarisco);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +148; }
                if (position == 2) { suma = suma +90; }
                if (position == 3) { suma = suma +91; }
                if (position == 4) { suma = suma +90; }
                if (position == 5) { suma = suma +86; }
                if (position == 6) { suma = suma +69; }
                if (position == 7) { suma = suma +75; }
                if (position == 8) { suma = suma +89; }
                if (position == 9) { suma = suma +75; }
                if (position == 10) { suma = suma +82; }
                if (position == 11) { suma = suma +124; }
                if (position == 12) { suma = suma +130; }
                if (position == 13) { suma = suma +127; }
                if (position == 14) { suma = suma +125; }
                if (position == 15) { suma = suma +66; }
                if (position == 16) { suma = suma +76.6f; }
                if (position == 17) { suma = suma +76; }
                if (position == 18) { suma = suma +75; }
                if (position == 19) { suma = suma +172; }
                if (position == 20) { suma = suma +92.5f; }
                if (position == 21) { suma = suma +41; }
                if (position == 22) { suma = suma +111; }
                if (position == 23) { suma = suma +86; }
                if (position == 24) { suma = suma +94; }
                if (position == 25) { suma = suma +80; }
                if (position == 26) { suma = suma +79; }
                if (position == 27) { suma = suma +175; }
                if (position == 28) { suma = suma +82; }
                if (position == 29) { suma = suma +120; }
                if (position == 30) { suma = suma +164; }
                if (position == 31) { suma = suma +86; }
                if (position == 32) { suma = suma +75.3f; }



                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasPescadosMarisco.this);
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
        for(int i=0;i<valoresPescadoMarisco.length;i++)
            if(valoresPescadoMarisco[i].contains(textoEditT))
            {
                listaBusca.add(valoresPescadoMarisco[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}