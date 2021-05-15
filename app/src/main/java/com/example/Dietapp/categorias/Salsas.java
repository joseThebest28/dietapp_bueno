package com.example.Dietapp.categorias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.Categorias;
import com.example.Dietapp.Seguimiento;
import com.example.Dietapp.categorias.popup.PopupSalsas;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Salsas extends AppCompatActivity {
    float resultado,resultado2,resultado3,resultado4,resultado5,resultado6;
    float total;
    private Spinner sp;
    private EditText edi;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salsas);
        sp = (Spinner) findViewById(R.id.espinerSAlsa);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add("Selecciona salsa(nº kcal por cucharada)");
        elementos.add("aderezo francés: 6kcal");
        elementos.add("aderezo griego: 46.7kcal");
        elementos.add("aderezo italiano: 29.3kcal");
        elementos.add("aderezo ranchero: 51kcal");
        elementos.add("aliño de miel y mostaza: 46.4kcal");
        elementos.add("aliño ensalada: 44.9kcal");
        elementos.add("aliño de yogur: 4.5kcal");
        elementos.add("alioli: 62.3kcal");
        elementos.add("ajvar: 1.8kcal");
        elementos.add("guacamole: 15.7kcal");
        elementos.add("harissa: 5.2kcal");
        elementos.add("Huancaina:36kcal");
        elementos.add("ketchup: 10kcal");
        elementos.add("mostaza: 6kcal");
        elementos.add("mayonesa:69.2kcal");
        elementos.add("mayonesa de ajo: 58.3kcal");
        elementos.add("pasta de tomate: 8.2kcal");
        elementos.add("pesto: 45.8kcal");
        elementos.add("salsa arrabiata: 3.6kcal");
        elementos.add("salsa agridulce: 17.9kcal");
        elementos.add("salsa argentina/criolla: 33.1kcal");
        elementos.add("salsa barbacoa: 15kcal");
        elementos.add("salsa bearnesa: 41.4kcal");
        elementos.add("salsa bechamel: 22.5kcal");
        elementos.add("salsa boloñesa: 10.6kcal");
        elementos.add("salsa brava: 11.6kcal");
        elementos.add("salsa cazadora: 4.5kcal");
        elementos.add("salsa césar: 42.9kcal");
        elementos.add("salsa cocktail: 32.7kcal");
        elementos.add("salsa de chile: 11.2kcal");
        elementos.add("salsa de curry: 2.6kcal");
        elementos.add("salsa de naranja: 17.9kcal");
        elementos.add("salsa de soja: 6.7kcal");
        elementos.add("salsa de yogur: 17.1kcal");
        elementos.add("salsa holandesa: 53.5kcal");
        elementos.add("salsa inglesa: 7.8kcal");
        elementos.add("salsa roja: 4.1kcal");
        elementos.add("salsa rosa: 8.1kcal");
        elementos.add("salsa remoulade: 63.5kcal");
        elementos.add("salsa teriyaki: 8.9kcal");
        elementos.add("salsa a la pimienta: 4.7kcal");
        elementos.add("salsa verde: 4.1kcal");
        elementos.add("tabasco: 7kcal");
        elementos.add("vinagre balsamico: 29kcal");
















        ArrayAdapter adp = new ArrayAdapter(Salsas.this, android.R.layout.simple_spinner_dropdown_item, elementos);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) sp.getAdapter().getItem(position);
                Toast toast1 = Toast.makeText(getApplicationContext(), "has seleccionado " + elemento, Toast.LENGTH_SHORT);


                edi = findViewById(R.id.meterNSAlsa);

                String res = edi.getText().toString();

                res.trim();

                if (!res.isEmpty()) {
                    int num = Integer.parseInt(res);


                    if(position==1) { resultado= resultado+(num*6); toast1.show();}
                    if(position==2) { resultado= resultado+(num*46.7f); toast1.show();}
                    if(position==3) { resultado= resultado+(num*29.3f); toast1.show();}
                    if(position==4) { resultado= resultado+(num*51); toast1.show();}
                    if(position==5) { resultado= resultado+(num*46.4f); toast1.show();}
                    if(position==6) { resultado= resultado+(num*44.9f); toast1.show();}
                    if(position==7) { resultado= resultado+(num*4.5f); toast1.show();}
                    if(position==8) { resultado= resultado+(num*62.3f); toast1.show();}
                    if(position==9) { resultado= resultado+(num*1.8f); toast1.show();}
                    if(position==10) { resultado= resultado+(num*15.7f); toast1.show();}
                    if(position==11) { resultado= resultado+(num*5.2f); toast1.show();}
                    if(position==12) { resultado= resultado+(num*36); toast1.show();}
                    if(position==13) { resultado= resultado+(num*10); toast1.show();}
                    if(position==14) { resultado= resultado+(num*6); toast1.show();}
                    if(position==15) { resultado= resultado+(num*69.2f); toast1.show();}
                    if(position==16) { resultado= resultado+(num*58.3f); toast1.show();}
                    if(position==17) { resultado= resultado+(num* 8.2f); toast1.show();}
                    if(position==18) { resultado= resultado+(num* 45.8f); toast1.show();}
                    if(position==19) { resultado= resultado+(num* 3.6f); toast1.show();}
                    if(position==20) { resultado= resultado+(num*17.9f); toast1.show();}
                    if(position==21) { resultado= resultado+(num* 33.1f); toast1.show();}
                    if(position==22) { resultado= resultado+(num*15); toast1.show();}
                    if(position==23) { resultado= resultado+(num* 41.4f); toast1.show();}
                    if(position==24) { resultado= resultado+(num*22.5f); toast1.show();}
                    if(position==25) { resultado= resultado+(num*10.6f); toast1.show();}
                    if(position==26) { resultado= resultado+(num*11.6f); toast1.show();}
                    if(position==27) { resultado= resultado+(num*4.5f); toast1.show();}
                    if(position==28) { resultado= resultado+(num*42.9f); toast1.show();}
                    if(position==29) { resultado= resultado+(num*32.7f); toast1.show();}
                    if(position==30) { resultado= resultado+(num*11.2f); toast1.show();}
                    if(position==31) { resultado= resultado+(num*2.6f); toast1.show();}
                    if(position==32) { resultado= resultado+(num*17.9f); toast1.show();}
                    if(position==33) { resultado= resultado+(num*6.7f); toast1.show();}
                    if(position==34) { resultado= resultado+(num*17.1f); toast1.show();}
                    if(position==35) { resultado= resultado+(num*53.5f); toast1.show();}
                    if(position==36) { resultado= resultado+(num*7.8f); toast1.show();}
                    if(position==37) { resultado= resultado+(num*4.1f); toast1.show();}
                    if(position==38) { resultado= resultado+(num*8.1f); toast1.show();}
                    if(position==39) { resultado= resultado+(num*63.5f); toast1.show();}
                    if(position==40) { resultado= resultado+(num*8.9f); toast1.show();}
                    if(position==41) { resultado= resultado+(num*4.7f); toast1.show();}
                    if(position==42) { resultado= resultado+(num*4.1f); toast1.show();}
                    if(position==43) { resultado= resultado+(num*7); toast1.show();}
                    if(position==44) { resultado= resultado+(num*29); toast1.show();}




                }
                text = findViewById(R.id.verTOtalSalsa);
                total = resultado + resultado2 + resultado3 + resultado4 + resultado5+ resultado6;
                text.setText("Total calorias de salsas: " + total);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast toastNada = Toast.makeText(getApplicationContext(), "No has seleccioando nada", Toast.LENGTH_SHORT);

                toastNada.show();
            }
        });
    }


    public void volverMenu(View view) {
        Intent i = new Intent(this, Categorias.class );
        startActivity(i);
    }

    public void transmitirSalsa(View view) {
        Intent intent = new Intent(this, Seguimiento.class);
        intent.putExtra("salsa", total);

        startActivity(intent);
        Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de las salsas correctamente", Toast.LENGTH_SHORT);

        toastNada3.show();
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Salsas.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("salsa",  total);
        myEditor.commit();
    }

    public void ayudaver(View view) { startActivity(new Intent(Salsas.this, PopupSalsas.class));
    }
}
