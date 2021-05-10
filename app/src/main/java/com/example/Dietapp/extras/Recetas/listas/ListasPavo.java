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

public class ListasPavo extends AppCompatActivity {
ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresPavo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresPavo= new String[]{ "selecciona pieza de pavo(nº calorias cada 100gr) ",
                "pechuga de pavo: 109.5kcal","lomo de pavo: 215kcal","muslitos de pavo: 114kcal",
                "pierna de pavo: 125kcal","cuartos traseros de pavo: 114kcal","alitas de pavo: 229kcal","jamon de pavo:: 128.57kcal",
               "salchichas de pavo: 88kcal"
        ,"1 hamburguesas de pavo: 217kcal","fiambre de pavo: 61.2kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPavo);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +109.5f; }
                if (position == 2) { suma = suma +215; }
                if (position == 3) { suma = suma +114; }
                if (position == 4) { suma = suma +125; }
                if (position == 5) { suma = suma +114; }
                if (position == 6) { suma = suma +229; }
                if (position == 7) { suma = suma +128.57f; }
                if (position == 8) { suma = suma +88; }
                if (position == 9) { suma = suma +217; }
                if (position == 10) { suma = suma +61.2f; }





                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasPavo.this);
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
        for(int i=0;i<valoresPavo.length;i++)
            if(valoresPavo[i].contains(textoEditT))
            {
                listaBusca.add(valoresPavo[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}