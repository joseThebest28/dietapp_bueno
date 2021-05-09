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

public class ListsCereals extends AppCompatActivity {
    ListView lista;
    EditText textoEdit;
    String textoEditT;
    static float suma;
    static  float total;
    String[] valoresCereales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresCereales= new String[]{ "selecciona tipo cereal(nº kcal cada 100 gr)","de trigo y chocolate: 385kcal",
        "de arroz y chocolate: 388kcal","de arroz y miel: 385kcal","de arroz, trigo y fruta: 356kcal",
        "de miel y maiz: 394kcal","de maiz y trigo: 381kcal","de maiz, trigo y avena: 416kcal",
        "de trigo azucarado: 385kcal", "barrita de chocolate: 397kcal","barrita de cereales con fruta: 395kcal",
        "barrita de cereales con maiz y trigo: 431kcal","barrita de cerales con trigo y chocolate: 437kcal",
        "harina de avena: 353kcal","harina de cebada: 361kcal","harina de centeno: 359kcal","harina de maiz: 326kcal","harina de trigo: 333kcal","harina de trigo integral: 322kcal",
        "trigo sarraceno: 343kcal","almidón de trigo: 351kcal","almidón de arroz: 350kcal","almidón de maiz: 374kcal","amaranto: 371kcal","avena: 401kcal","cebada: 323kcal","centeno: 408kcal",
        "gofio: 399kcal","mijo: 345kcal","miso: 209kcal","quinoa: 306kcal","semilla de lino: 567kcal","sémola de trigo: 350kcal"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresCereales);
        lista.setAdapter(adaptador);

        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) { suma = suma +385; }
                if (position == 2) { suma = suma +388; }
                if (position == 3) { suma = suma +385; }
                if (position == 4) { suma = suma +356; }
                if (position == 5) { suma = suma +394; }
                if (position == 6) { suma = suma +381; }
                if (position == 7) { suma = suma +416; }
                if (position == 8) { suma = suma +385; }
                if (position == 9) { suma = suma +397; }
                if (position == 10) { suma = suma +395; }
                if (position == 11) { suma = suma +431; }
                if (position == 12) { suma = suma +437; }
                if (position == 13) { suma = suma +353; }
                if (position == 14) { suma = suma +361; }
                if (position == 15) { suma = suma +359; }
                if (position == 16) { suma = suma +326; }
                if (position == 17) { suma = suma +333; }
                if (position == 18) { suma = suma +322; }
                if (position == 19) { suma = suma +343; }
                if (position == 20) { suma = suma +351; }
                if (position == 21) { suma = suma +350; }
                if (position == 22) { suma = suma +374; }
                if (position == 23) { suma = suma +371; }
                if (position == 24) { suma = suma +401; }
                if (position == 25) { suma = suma +323; }
                if (position == 26) { suma = suma +408; }
                if (position == 27) { suma = suma +399; }
                if (position == 28) { suma = suma +345; }
                if (position == 29) { suma = suma +209; }
                if (position == 30) { suma = suma +306; }
                if (position == 31) { suma = suma +567; }
                if (position == 32) { suma = suma +350; }







                total=total+suma;
                Log.i("tag","total"+total);
                Log.i("tag","suma"+suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListsCereals.this);
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
        for(int i=0;i<valoresCereales.length;i++)
            if(valoresCereales[i].contains(textoEditT))
            {
                listaBusca.add(valoresCereales[i]);
            }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}