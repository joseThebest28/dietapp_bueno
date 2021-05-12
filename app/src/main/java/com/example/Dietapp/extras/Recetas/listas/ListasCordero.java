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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Dietapp.extras.Recetas.Recetas;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class ListasCordero extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresCordero;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        textoEdit.setVisibility(View.INVISIBLE);
        boton=findViewById(R.id.button45);
        boton.setVisibility(View.INVISIBLE);
  valoresCordero= new String[]{ "selecciona pieza de cordero lechal ",
                "paletilla de cordero: 314kcal","medallones de lechal: 225kcal","filete de pierna: 185kcal",
                "hamburguesa: 105kcal","carne de cabrito: 114kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresCordero);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +314; }
                if (position == 2) { suma = suma +225; }
                if (position == 3) { suma = suma +185; }
                if (position == 4) { suma = suma +105; }
                if (position == 5) { suma = suma +114; }





                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasCordero.this);
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
        for(int i=0;i<valoresCordero.length;i++)
            if(valoresCordero[i].contains(textoEditT))
            {
                listaBusca.add(valoresCordero[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}