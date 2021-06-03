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

public class ListasCasqueria extends AppCompatActivity {
    ListView lista;
    EditText textoEdit;
    String textoEditT;
    String[] valoresCasuqe;
    Intent volverPaginaElegir;
    static float suma;
    static float total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista = findViewById(R.id.lista);
        textoEdit = findViewById(R.id.editListas);
        volverPaginaElegir = new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasCasqueria.this);
        total = myPreferences.getFloat("caloriasLista", 0);
        valoresCasuqe = new String[]{"selecciona Elemento de Casqueria(nº kcal cada 100gr)",
                "tuenano: 786kcal", "mollejas de pollo: 118kcal", "higado de pollo: 172kcal",
                "chinchulín: 220kcal", "corazón de cerdo: 148kcal",
                "corazón de pavo: 174kcal", "corazón de pollo: 185kcal", "corazón de ternera lechal: 186kcal",
                "criadillas: 135kcal", "estómago de cerdo: 157kcal", "estómago de pavo: 148kcal",
                "estómago de pollo: 148kcal", "gallinejas: 233kcal", "hígado de cerdo: 165kcal",
                "hígado de ganso: 133kcal", "hígado de novillo: 192kcal", "hígado de pato: 136kcal",
                "hígado de pavo: 189kcal", "hígado de ternera: 191kcal", "lengua de cerdo: 271kcal",
                "lengua de ternera: 284kcal", "lengua de ternera lechal: 202kcal", "menudillo/menudos de pavo: 173kcal",
                "menudillo de pollo: 277kcal", "mollejas de cerdo: 159kcal", "mollejas de pato: 120kcal",
                "mollejas de pavo: 118kcal", "mollejas de ternera: 154kcal", "oreja de cerdo: 273kcal",
                "panza de borrego: 229kcal", "pierna de res: 152kcal", "pulmón de cerdo: 99kcal", "pulmón de ternera: 120kcal",
                "rabo de toro: 184kcal", "rñón de ternera: 120kcal", "riñón de cerdo: 151kcal", "riñón de ternera: 158kcal",
                "rñón de ternera lechal: 163kcal", "sangre: 73kcal", "sesos de becerro: 136kcal", "sesos de cerdo: 138kcal",
                "sesos de ternera: 196kcal"

        };
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, valoresCasuqe);
        lista.setAdapter(adaptador);
        final Intent iD = new Intent(this, Recetas.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String nombreV = (String) lista.getItemAtPosition(position);

                if (position != 0) {
                    Toast.makeText(getApplicationContext(), "has pulsado " + nombreV, Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    suma = suma + 786;
                }
                if (position == 2) {
                    suma = suma + 118;
                }
                if (position == 3) {
                    suma = suma + 172;
                }
                if (position == 4) {
                    suma = suma + 220;
                }
                if (position == 5) {
                    suma = suma + 148;
                }
                if (position == 6) {
                    suma = suma + 174;
                }
                if (position == 7) {
                    suma = suma + 185;
                }
                if (position == 8) {
                    suma = suma + 186;
                }
                if (position == 9) {
                    suma = suma + 135;
                }
                if (position == 10) {
                    suma = suma + 157;
                }
                if (position == 11) {
                    suma = suma + 148;
                }
                if (position == 12) {
                    suma = suma + 148;
                }
                if (position == 13) {
                    suma = suma + 233;
                }
                if (position == 14) {
                    suma = suma + 165;
                }
                if (position == 15) {
                    suma = suma + 133;
                }
                if (position == 16) {
                    suma = suma + 192;
                }
                if (position == 17) {
                    suma = suma + 136;
                }
                if (position == 18) {
                    suma = suma + 189;
                }
                if (position == 19) {
                    suma = suma + 191;
                }
                if (position == 20) {
                    suma = suma + 271;
                }
                if (position == 21) {
                    suma = suma + 284;
                }
                if (position == 22) {
                    suma = suma + 202;
                }
                if (position == 23) {
                    suma = suma + 173;
                }
                if (position == 24) {
                    suma = suma + 277;
                }
                if (position == 25) {
                    suma = suma + 159;
                }
                if (position == 26) {
                    suma = suma + 120;
                }
                if (position == 27) {
                    suma = suma + 118;
                }
                if (position == 28) {
                    suma = suma + 154;
                }
                if (position == 29) {
                    suma = suma + 273;
                }
                if (position == 30) {
                    suma = suma + 229;
                }
                if (position == 31) {
                    suma = suma + 152;
                }
                if (position == 32) {
                    suma = suma + 99;
                }
                if (position == 33) {
                    suma = suma + 120;
                }
                if (position == 34) {
                    suma = suma + 184;
                }
                if (position == 35) {
                    suma = suma + 120;
                }
                if (position == 36) {
                    suma = suma + 151;
                }
                if (position == 37) {
                    suma = suma + 158;
                }
                if (position == 38) {
                    suma = suma + 163;
                }
                if (position == 39) {
                    suma = suma + 73;
                }
                if (position == 40) {
                    suma = suma + 136;
                }
                if (position == 41) {
                    suma = suma + 138;
                }
                if (position == 42) {
                    suma = suma + 196;
                }


                total = total + suma;
                Log.i("tag", "total" + total);
                Log.i("tag", "suma" + suma);
                SharedPreferences myPreferencesG = PreferenceManager.getDefaultSharedPreferences(ListasCasqueria.this);
                SharedPreferences.Editor myEditor = myPreferencesG.edit();
                myEditor.putFloat("caloriasLista", total);
                myEditor.commit();
                Log.i("tag", "calorias final" + total);
                suma = 0;
                startActivity(iD);
            }
        });

    }

    public void realizarBusqueda(View view) {
        ArrayList<String> listaBusca = new ArrayList<>();
        textoEditT = String.valueOf(textoEdit.getText());
        for (int i = 0; i < valoresCasuqe.length; i++)
            if (valoresCasuqe[i].contains(textoEditT)) {
                listaBusca.add(valoresCasuqe[i]);
            }
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listaBusca);
        lista.setAdapter(adaptador2);
    }
}