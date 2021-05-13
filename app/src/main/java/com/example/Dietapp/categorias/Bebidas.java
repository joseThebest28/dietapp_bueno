package com.example.Dietapp.categorias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.PaginaPrincipal;
import com.example.Dietapp.Seguimiento;
import com.example.Dietapp.categorias.popup.PopupBebidas;
import com.example.Dietapp.categorias.popup.PopupCarne;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Bebidas extends AppCompatActivity {
    float resultado, resultado2, resultado3, resultado4, resultado5, resultado6;
    float total;
    private Spinner sp;
    private EditText edi;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        sp = (Spinner) findViewById(R.id.espiner3);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add("Selecciona el tipo de bebida(nº kcal cada 100mliitros)");
        elementos.add("atole: 84kcal");
        elementos.add("betido/malteada(en polvo): 329kcal");
        elementos.add("betido/malteada de chocolate: 125kcal");
        elementos.add("betido/malteada de freasa: 113kcal");
        elementos.add("betido de vainilla: 149kcal");
        elementos.add("bitter kas: 32kcal");
        elementos.add("cacaolat: 78kcal");
        elementos.add("cafe: 1kcal");
        elementos.add("cerveza de malta: 37kcal");
        elementos.add("cerveza sin alcohol: 37kcal");
        elementos.add("chocolate caliente: 89kcal");
        elementos.add("club mate: 30kcal");
        elementos.add("coca-cola: 42kcal");
        elementos.add("coca-cola light: 1kcal");
        elementos.add("coca-cola zero: 0kcal");
        elementos.add("cola: 42kcal");
        elementos.add("cola-cao: 80kcal");
        elementos.add("evian: 0kcal");
        elementos.add("fanta de limón: 46kcal");
        elementos.add("fanta de naranja: 38kcal");
        elementos.add("frappé: 141kcal");
        elementos.add("gatorade: 23kcal");
        elementos.add("horchata: 54kcal");
        elementos.add("karamatz: 37kcal");
        elementos.add("kas limón: 33kcal");
        elementos.add("kas naranja: 34kcal");
        elementos.add("kombucha: 13kcal");
        elementos.add("lassi: 104kcal");
        elementos.add("latte machiato: 57kcal");
        elementos.add("leche: 61kcal");
        elementos.add("leche chocolatada/leche con chocolate: 89kcal");
        elementos.add("leche de almendras: 45kcal");
        elementos.add("leche de soja: 45kcal");
        elementos.add("licuados de frutas: 261kcal");
        elementos.add("limonada: 42kcal");
        elementos.add("mate cocido con leche: 41kcal");
        elementos.add("milo: 409kcal");
        elementos.add("mosto sin alcohol: 61kcal");
        elementos.add("nesquik: 79kcal");
        elementos.add("nestea: 36kcal");
        elementos.add("néctar: 53kcal");
        elementos.add("pepsi: 44kcal");
        elementos.add("pepsi light: 0kcal");
        elementos.add("pepsi max: 0kcal");
        elementos.add("ponche de huevo: 88kcal");
        elementos.add("powerade: 16kcal");
        elementos.add("slush: 50kcal");
        elementos.add("smoothie: 37kcal");
        elementos.add("tang: 381kcal");
        elementos.add("té: 1kcal");
        elementos.add("té chai: 0kcal");
        elementos.add("té de jengibre: 0kcal");
        elementos.add("té frio/helado: 27kcal");
        elementos.add("tónica: 34kcal");
        elementos.add("volvic: 0kcal");




        ArrayAdapter adp = new ArrayAdapter(Bebidas.this, android.R.layout.simple_spinner_dropdown_item, elementos);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) sp.getAdapter().getItem(position);
                Toast toast1 = Toast.makeText(getApplicationContext(), "has seleccionado " + elemento, Toast.LENGTH_SHORT);


                edi = findViewById(R.id.numero);

                String res = edi.getText().toString();

                res.trim();

                if (!res.isEmpty()) {
                    int num = Integer.parseInt(res);


                    if (position == 1) { resultado = resultado+(num * 84);toast1.show();edi.setText(""); }
                    if (position == 2) { resultado = resultado+(num * 329);toast1.show();edi.setText(""); }
                    if (position == 3) { resultado = resultado+(num * 125);toast1.show();edi.setText(""); }
                    if (position == 4) { resultado = resultado+(num * 113);toast1.show();edi.setText(""); }
                    if (position == 5) { resultado = resultado+(num * 149);toast1.show();edi.setText(""); }
                    if (position == 6) { resultado = resultado+(num * 32);toast1.show();edi.setText(""); }
                    if (position == 7) { resultado = resultado+(num * 78);toast1.show();edi.setText(""); }
                    if (position == 8) { resultado = resultado+(num * 1);toast1.show();edi.setText(""); }
                    if (position == 9) { resultado = resultado+(num * 37);toast1.show();edi.setText(""); }
                    if (position == 10) { resultado = resultado+(num * 37);toast1.show();edi.setText(""); }
                    if (position == 11) { resultado = resultado+(num * 89);toast1.show();edi.setText(""); }
                    if (position == 12) { resultado = resultado+(num * 30);toast1.show();edi.setText(""); }
                    if (position == 13) { resultado = resultado+(num * 42);toast1.show();edi.setText(""); }
                    if (position == 14) { resultado = resultado+(num * 1);toast1.show();edi.setText(""); }
                    if (position == 15) { resultado = resultado+(num * 0);toast1.show();edi.setText(""); }
                    if (position == 16) { resultado = resultado+(num * 42);toast1.show();edi.setText(""); }
                    if (position == 17) { resultado = resultado+(num * 80);toast1.show();edi.setText(""); }
                    if (position == 18) { resultado = resultado+(num * 0);toast1.show();edi.setText(""); }
                    if (position == 19) { resultado = resultado+(num * 46);toast1.show();edi.setText(""); }
                    if (position == 20) { resultado = resultado+(num * 38);toast1.show();edi.setText(""); }
                    if (position == 21) { resultado = resultado+(num * 141);toast1.show();edi.setText(""); }
                    if (position == 22) { resultado = resultado+(num * 23);toast1.show();edi.setText(""); }
                    if (position == 23) { resultado = resultado+(num * 54);toast1.show();edi.setText(""); }
                    if (position == 24) { resultado = resultado+(num * 37);toast1.show();edi.setText(""); }
                    if (position == 25) { resultado = resultado+(num * 33);toast1.show();edi.setText(""); }
                    if (position == 26) { resultado = resultado+(num * 34);toast1.show();edi.setText(""); }
                    if (position == 27) { resultado = resultado+(num * 13);toast1.show();edi.setText(""); }
                    if (position == 28) { resultado = resultado+(num * 104);toast1.show();edi.setText(""); }
                    if (position == 29) { resultado = resultado+(num * 57);toast1.show();edi.setText(""); }
                    if (position == 30) { resultado = resultado+(num * 61);toast1.show();edi.setText(""); }
                    if (position == 31) { resultado = resultado+(num * 89);toast1.show();edi.setText(""); }
                    if (position == 32) { resultado = resultado+(num * 45);toast1.show();edi.setText(""); }
                    if (position == 33) { resultado = resultado+(num * 45);toast1.show();edi.setText(""); }
                    if (position == 34) { resultado = resultado+(num * 261);toast1.show();edi.setText(""); }
                    if (position == 35) { resultado = resultado+(num * 42);toast1.show();edi.setText(""); }
                    if (position == 36) { resultado = resultado+(num * 41);toast1.show();edi.setText(""); }
                    if (position == 37) { resultado = resultado+(num * 409);toast1.show();edi.setText(""); }
                    if (position == 38) { resultado = resultado+(num * 61);toast1.show();edi.setText(""); }
                    if (position == 39) { resultado = resultado+(num * 79);toast1.show();edi.setText(""); }
                    if (position == 40) { resultado = resultado+(num * 36);toast1.show();edi.setText(""); }
                    if (position == 41) { resultado = resultado+(num * 53);toast1.show();edi.setText(""); }
                    if (position == 42) { resultado = resultado+(num * 44);toast1.show();edi.setText(""); }
                    if (position == 43) { resultado = resultado+(num * 0);toast1.show();edi.setText(""); }
                    if (position == 44) { resultado = resultado+(num * 0);toast1.show();edi.setText(""); }
                    if (position == 45) { resultado = resultado+(num * 88);toast1.show();edi.setText(""); }
                    if (position == 46) { resultado = resultado+(num * 16);toast1.show();edi.setText(""); }
                    if (position == 47) { resultado = resultado+(num * 50);toast1.show();edi.setText(""); }
                    if (position == 48) { resultado = resultado+(num * 37);toast1.show();edi.setText(""); }
                    if (position == 49) { resultado = resultado+(num * 381);toast1.show();edi.setText(""); }
                    if (position == 50) { resultado = resultado+(num * 1);toast1.show();edi.setText(""); }
                    if (position == 51) { resultado = resultado+(num * 0);toast1.show();edi.setText(""); }
                    if (position == 52) { resultado = resultado+(num * 0);toast1.show();edi.setText(""); }
                    if (position == 53) { resultado = resultado+(num * 27);toast1.show();edi.setText(""); }
                    if (position == 54) { resultado = resultado+(num * 34);toast1.show();edi.setText(""); }
                    if (position == 55) { resultado = resultado+(num * 0);toast1.show();edi.setText(""); }





                }
                text = findViewById(R.id.textVerF);
                total = resultado ;
                text.setText("Total calorias consumidas moviendote: " + total);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast toastNada = Toast.makeText(getApplicationContext(), "No has seleccioando nada", Toast.LENGTH_SHORT);

                toastNada.show();
            }
        });


    }

    public void volverCategorias(View view) {
        Intent i = new Intent(this, Categorias.class);
        startActivity(i);
    }

    public void volverMenu(View view) {
        Intent i = new Intent(this, PaginaPrincipal.class);
        startActivity(i);
    }


    public void guaradr(View view) {
        Intent intent = new Intent(this, Seguimiento.class);
        intent.putExtra("calorias bebidas", total);

        startActivity(intent);
        Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de bebidas correctamente", Toast.LENGTH_SHORT);

        toastNada3.show();
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Bebidas.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("bebida",  total);
        myEditor.commit();
    }

    public void ayudabbeidas(View view) {
        startActivity(new Intent(Bebidas.this, PopupBebidas.class));
    }
}

