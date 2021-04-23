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

import com.example.Dietapp.PaginaPrincipal;
import com.example.Dietapp.Seguimiento;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Salsas extends AppCompatActivity {
    double resultado,resultado2,resultado3,resultado4,resultado5,resultado6;
    double total;
    private Spinner sp;
    private EditText edi;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salsas);
        sp = (Spinner) findViewById(R.id.espinerSAlsa);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add("Selecciona el tipo de salsa");
        elementos.add("Ketchup");
        elementos.add("Mayonesa");
        elementos.add("Barbacoa");
        elementos.add("Huancaina");
        elementos.add("Mostaza");
        elementos.add("Guacamole");


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


                    if (position == 1) {

                        resultado = num * 20;
                        toast1.show();
                        edi.setText("");
                    }

                    if (position == 2) {

                        resultado2 = num * 16;
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 3) {

                        resultado3 = num * 30;
                        toast1.show();
                        edi.setText("");
                    }

                    if (position == 4) {

                        resultado4 = num * 25;
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 5) {

                        resultado5 = num * 11;
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 6) {

                        resultado6 = num * 11;
                        toast1.show();
                        edi.setText("");
                    }


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
        public void volverCategorias(View view) {
        Intent i = new Intent(this, Categorias.class );
        startActivity(i);
    }

    public void volverMenu(View view) {
        Intent i = new Intent(this, PaginaPrincipal.class );
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
        myEditor.putInt("salsa", (int) total);
        myEditor.commit();
    }
}
