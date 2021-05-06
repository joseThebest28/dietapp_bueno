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
import android.widget.ListView;
import android.widget.Toast;

import com.example.Dietapp.extras.ContadroVasosAgua;
import com.example.Dietapp.extras.Recetas.Recetas;
import com.example.myapplicationfinal.R;

public class ListasBuey extends AppCompatActivity {
ListView lista;
   static float suma=0;
   static  float total;
   Intent volverPaginaElegir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        volverPaginaElegir=new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasBuey.this);
        total=myPreferences.getFloat("caloriasLista",0);

        String[] valoresBuey= new String[]{ "selecciona pieza de buey",
                "filete de ternera con hueso: 159 calorias","fielte de ternera","solomillo de ternera","tapilla","babilla","redondo","rebillo","pez",
                        "aguja","brozuelo","espaldilla", "aleta","llana","morcillo","rabo","pescuezo","pecho","morrillo","falda","costillas","carne picada"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresBuey);
        lista.setAdapter(adaptador);



        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nombreCarne = (String) lista.getItemAtPosition(position);


                   Toast.makeText(getApplicationContext(), "has pulsado " +nombreCarne , Toast.LENGTH_SHORT).show();



                if(position==2) {
                    suma=suma+159;
                    Toast.makeText(getApplicationContext(), "has pulsado " +nombreCarne , Toast.LENGTH_SHORT).show();

                }



                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasBuey.this);
                SharedPreferences.Editor myEditor = myPreferencesG.edit();
                myEditor.putFloat("caloriasLista",total);
                myEditor.commit();

                suma=0;


        }});




    }
}