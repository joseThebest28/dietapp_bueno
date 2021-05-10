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

public class ListasCorderoCaRoja extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresCordero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
      valoresCordero= new String[]{ "selecciona pieza de cordero ",
                "paletilla de cordero: 240kcal","medallones: 255kcal","tournedó: 43.47kcal","pincho moruno: 202kcal",
                "brocheta: 134kcal","hamburguesa: 342.11kcal","churrasquitos: 250kcal","churrasco: 266kcal","filete de carrillón"};
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
                if (position == 1) { suma = suma +240; }
                if (position == 2) { suma = suma +255; }
                if (position == 3) { suma = suma +43.47f; }
                if (position == 4) { suma = suma +202; }
                if (position == 5) { suma = suma +134; }
                if (position == 6) { suma = suma +342.11f; }
                if (position == 7) { suma = suma +250; }
                if (position == 8) { suma = suma +266; }

                if (position == 9) { suma = suma +156; }
                if (position == 10) { suma = suma +467; }
                if (position == 11) { suma = suma +665; }
                if (position == 12) { suma = suma +673; }
                if (position == 13) { suma = suma +201; }





                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasCorderoCaRoja.this);
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