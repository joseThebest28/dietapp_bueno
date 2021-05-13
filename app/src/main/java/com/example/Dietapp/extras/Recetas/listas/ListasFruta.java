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

public class ListasFruta extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresFruta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
      valoresFruta= new String[]{ "selecciona fruta(nº kcal cada 100 gramos)", "aceitunas: 115kcal",
                "aguacate/palta: 160kcal", "albaricoque/damasco: 48kcal", "ananás/piña: 48kcal", "arandano: 71kcal", "asaí: 70kcal",
              "banana/platano: 46kcal", "caqui/persimón: 127kcal","carambola/fruta estrella: 31kcal","cereza/guinda: 58kcal", "ciruela: 46kcal"
              ,"ciruela verde:41kcal","celmentina: 47kcal","compota/pure de manzana: 68kcal", "coco: 354kcal","dátiles: 282kcal", "melocotón/durazno: 61kcal",
              "frambuesa: 52kcal", "fresa: 32kcal", "granada: 83kcal", "grosella: 56kcal","guayaba: 68kcal", "higo: 37kcal", "kiwi: 61kcal","lichi: 66kcal",
              "lima: 30kcal", "limón: 39kcal","macedonia: 50kcal", "mandarina: 53kcal", "mango: 60kcal", "manzana: 52kcal", "maracuyá;97kcal",
              "melón: 36kcal","melón amarillo: 55kcal","melón catalup: 34kcal","melón de galia. 26kcal", "membrillo: 57kcal",
              "mora/zarzamora: 43kcal", "naranja: 47 kcal","naranja roja/sanguina: 50kcal", "nectarina: 44kcal","nísperos: 47kcal",
              "papaya/mamón: 43kcal","pasas/pasa de uva: 299kcal", "pera: 57kcal","philasis: 49kcal", "plátano macho: 122kcal",
              "pomelo/toronja: 42kcal","rambután: 82kcal","ruibarbo: 21kcal", "sandia: 30kcal","tamarindo: 239kcal", "uva:69kcal","yaca: 95kcal","Paraguayas: 49kcal","melocotones: 61kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresFruta);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +115; }
                if (position == 2) { suma = suma +160; }
                if (position == 3) { suma = suma +48; }
                if (position == 4) { suma = suma +48; }
                if (position == 5) { suma = suma +71; }
                if (position == 6) { suma = suma +70; }
                if (position == 7) { suma = suma +46; }
                if (position == 7) { suma = suma +127; }
                if (position == 8) { suma = suma +31; }
                if (position == 9) { suma = suma +58; }
                if (position == 10) { suma = suma +46; }
                if (position == 11) { suma = suma +41; }
                if (position == 12) { suma = suma +47; }
                if (position == 13) { suma = suma +68; }
                if (position == 14) { suma = suma +354; }
                if (position == 15) { suma = suma +282; }
                if (position == 16) { suma = suma +61; }
                if (position == 17) { suma = suma +52; }
                if (position == 18) { suma = suma +32; }
                if (position == 19) { suma = suma +83; }
                if (position == 20) { suma = suma +56; }
                if (position == 21) { suma = suma +68; }
                if (position == 22) { suma = suma +37; }
                if (position == 23) { suma = suma +61; }
                if (position == 24) { suma = suma +66; }
                if (position == 25) { suma = suma +30; }
                if (position == 26) { suma = suma +39; }
                if (position == 27) { suma = suma +50; }
                if (position == 28) { suma = suma +53; }
                if (position == 29) { suma = suma +60; }
                 if (position == 30) { suma = suma +52; }
                if (position == 31) { suma = suma +97; }
                if (position == 32) { suma = suma +36; }
                if (position == 33) { suma = suma +55; }
                   if (position == 34) { suma = suma +34; }
                 if (position == 35) { suma = suma +26; }
                 if (position == 36) { suma = suma +57; }
                  if (position == 37) { suma = suma +43; }
                  if (position == 38) { suma = suma +47; }
                if (position == 39) { suma = suma +50; }
                 if (position == 40) { suma = suma +44; }
                 if (position == 41) { suma = suma +47; }
                  if (position == 42) { suma = suma +43; }
                if (position == 43) { suma = suma +299; }
                  if (position == 44) { suma = suma +57; }
                if (position == 45) { suma = suma +49; }
                if (position == 46) { suma = suma +122; }
                if (position == 47) { suma = suma +42; }
                if (position == 48) { suma = suma +82; }
                if (position == 49) { suma = suma +21; }
                if (position == 50) { suma = suma +30; }
                if (position == 51) { suma = suma +239; }
                if (position == 52) { suma = suma +69; }
                if (position == 53) { suma = suma +95; }
                if (position == 54) { suma = suma +49; }
                if (position == 55) { suma = suma +61; }

                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasFruta.this);
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
        for(int i=0;i<valoresFruta.length;i++)
            if(valoresFruta[i].contains(textoEditT))
            {
                listaBusca.add(valoresFruta[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}