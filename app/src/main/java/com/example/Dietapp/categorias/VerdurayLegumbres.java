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
import com.example.Dietapp.categorias.popup.PopupVerdurea;
import com.example.Dietapp.Seguimiento;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class VerdurayLegumbres extends AppCompatActivity {
    double resultado,resultado2,resultado3,resultado4,resultado5;
    double total;
    private Spinner sp;
    private EditText edi;
    TextView text;
    private final String texto1="Total calorias de verduras: ";
    private final String texto2="No has seleccioando nada";
    private final String texto3="Se han guardado los datos de las verduras y hortalizas correctamente";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verduras);
        sp = findViewById(R.id.espinerverdu);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add("Selecciona el tipo de verdura o legumbre");
        elementos.add("Zanahoria");
        elementos.add("Ensalada Completa");
        elementos.add("Plato de lentejas");
        elementos.add("Plato de Judias");
        elementos.add("Plato de Guisantes");
        elementos.add("Ensalada de pollo");



        ArrayAdapter adp = new ArrayAdapter(VerdurayLegumbres.this, android.R.layout.simple_spinner_dropdown_item, elementos);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) sp.getAdapter().getItem(position);
                Toast toast1 = Toast.makeText(getApplicationContext(), "has seleccionado " + elemento, Toast.LENGTH_SHORT);


                edi = findViewById(R.id.meterVerduria);

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

                        resultado5 = num * 81;
                        toast1.show();
                        edi.setText("");
                    }



                }
                text = findViewById(R.id.verTOtalLechuguita);
                total = resultado + resultado2 + resultado3 + resultado4 + resultado5;
                text.setText(texto1 + total);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast toastNada = Toast.makeText(getApplicationContext(), texto2, Toast.LENGTH_SHORT);

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

    public void envairlegumbre(View view) {

            Intent intent = new Intent(this, Seguimiento.class);
            intent.putExtra("erdura", total);

            startActivity(intent);
            Toast toastNada3 = Toast.makeText(getApplicationContext(), texto3, Toast.LENGTH_SHORT);

            toastNada3.show();
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(VerdurayLegumbres.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("erdura", (int) total);
        myEditor.commit();
    }

    public void ayudaver(View view) {
        startActivity(new Intent(VerdurayLegumbres.this, PopupVerdurea.class));
    }
}
