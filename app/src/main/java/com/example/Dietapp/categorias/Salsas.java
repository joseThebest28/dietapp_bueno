package com.example.Dietapp.categorias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Salsas extends AppCompatActivity {
    float resultado, resultado2, resultado3, resultado4, resultado5, resultado6;
    float total;
    private Spinner sp;
    private EditText edi;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salsas);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Salsas.this);
        float num = myPreferences.getFloat("salsa", 0);
        Log.i("tag", "valor de carne en carne " + num);

        total = total + num;
        sp = (Spinner) findViewById(R.id.espinerSAlsa);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add(" Selecciona salsa(nº kcal por cucharada)");
        elementos.add(" Aderezo francés");
        elementos.add(" Aderezo griego");
        elementos.add(" Aderezo italiano");
        elementos.add(" Aderezo ranchero");
        elementos.add(" Aliño de miel y mostaza");
        elementos.add(" Aliño ensalada");
        elementos.add(" Aliño de yogur");
        elementos.add(" Alioli");
        elementos.add(" Ajvar");
        elementos.add(" Arrabiata");
        elementos.add(" Agridulce");
        elementos.add(" Argentina/criolla");
        elementos.add(" Barbacoa");
        elementos.add(" Bearnesa");
        elementos.add(" Bechamel");
        elementos.add(" Boloñesa");
        elementos.add(" Brava");
        elementos.add(" Cazadora");
        elementos.add(" César");
        elementos.add(" Cocktail");
        elementos.add(" Guacamole");
        elementos.add(" Harissa");
        elementos.add(" Huancaina");
        elementos.add(" Ketchup");
        elementos.add(" Mostaza");
        elementos.add(" Mayonesa");
        elementos.add(" Mayonesa de ajo");
        elementos.add(" Pasta de tomate");
        elementos.add(" Pesto");
        elementos.add(" Salsa de chile");
        elementos.add(" Salsa de curry");
        elementos.add(" Salsa de naranja");
        elementos.add(" Salsa de soja");
        elementos.add(" Salsa de yogur");
        elementos.add(" Salsa holandesa");
        elementos.add(" Salsa inglesa");
        elementos.add(" Salsa roja");
        elementos.add(" Salsa rosa");
        elementos.add(" Salsa remoulade");
        elementos.add(" Salsa teriyaki");
        elementos.add(" Salsa a la pimienta");
        elementos.add(" Salsa verde");
        elementos.add(" Tabasco");
        elementos.add(" Vinagre balsamico");


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
                        resultado = resultado + (num * 6);
                        toast1.show();
                    }
                    if (position == 2) {
                        resultado = resultado + (num * 46.7f);
                        toast1.show();
                    }
                    if (position == 3) {
                        resultado = resultado + (num * 29.3f);
                        toast1.show();
                    }
                    if (position == 4) {
                        resultado = resultado + (num * 51);
                        toast1.show();
                    }
                    if (position == 5) {
                        resultado = resultado + (num * 46.4f);
                        toast1.show();
                    }
                    if (position == 6) {
                        resultado = resultado + (num * 44.9f);
                        toast1.show();
                    }
                    if (position == 7) {
                        resultado = resultado + (num * 4.5f);
                        toast1.show();
                    }
                    if (position == 8) {
                        resultado = resultado + (num * 62.3f);
                        toast1.show();
                    }
                    if (position == 9) {
                        resultado = resultado + (num * 1.8f);
                        toast1.show();
                    }
                    if (position == 10) {
                        resultado = resultado + (num * 3.6f);
                        toast1.show();
                    }
                    if (position == 11) {
                        resultado = resultado + (num * 17.9f);
                        toast1.show();
                    }
                    if (position == 12) {
                        resultado = resultado + (num * 33.1f);
                        toast1.show();
                    }
                    if (position == 13) {
                        resultado = resultado + (num * 15);
                        toast1.show();
                    }
                    if (position == 14) {
                        resultado = resultado + (num * 41.4f);
                        toast1.show();
                    }
                    if (position == 15) {
                        resultado = resultado + (num * 22.5f);
                        toast1.show();
                    }
                    if (position == 16) {
                        resultado = resultado + (num * 10.6f);
                        toast1.show();
                    }
                    if (position == 17) {
                        resultado = resultado + (num * 11.6f);
                        toast1.show();
                    }
                    if (position == 18) {
                        resultado = resultado + (num * 4.5f);
                        toast1.show();
                    }
                    if (position == 19) {
                        resultado = resultado + (num * 42.9f);
                        toast1.show();
                    }
                    if (position == 20) {
                        resultado = resultado + (num * 32.7f);
                        toast1.show();
                    }
                    if (position == 21) {
                        resultado = resultado + (num * 15.7f);
                        toast1.show();
                    }
                    if (position == 22) {
                        resultado = resultado + (num * 5.2f);
                        toast1.show();
                    }
                    if (position == 23) {
                        resultado = resultado + (num * 36);
                        toast1.show();
                    }
                    if (position == 24) {
                        resultado = resultado + (num * 10);
                        toast1.show();
                    }
                    if (position == 25) {
                        resultado = resultado + (num * 6);
                        toast1.show();
                    }
                    if (position == 26) {
                        resultado = resultado + (num * 69.2f);
                        toast1.show();
                    }
                    if (position == 27) {
                        resultado = resultado + (num * 58.3f);
                        toast1.show();
                    }
                    if (position == 28) {
                        resultado = resultado + (num * 8.2f);
                        toast1.show();
                    }
                    if (position == 29) {
                        resultado = resultado + (num * 45.8f);
                        toast1.show();
                    }
                    if (position == 30) {
                        resultado = resultado + (num * 11.2f);
                        toast1.show();
                    }
                    if (position == 31) {
                        resultado = resultado + (num * 2.6f);
                        toast1.show();
                    }
                    if (position == 32) {
                        resultado = resultado + (num * 17.9f);
                        toast1.show();
                    }
                    if (position == 33) {
                        resultado = resultado + (num * 6.7f);
                        toast1.show();
                    }
                    if (position == 34) {
                        resultado = resultado + (num * 17.1f);
                        toast1.show();
                    }
                    if (position == 35) {
                        resultado = resultado + (num * 53.5f);
                        toast1.show();
                    }
                    if (position == 36) {
                        resultado = resultado + (num * 7.8f);
                        toast1.show();
                    }
                    if (position == 37) {
                        resultado = resultado + (num * 4.1f);
                        toast1.show();
                    }
                    if (position == 38) {
                        resultado = resultado + (num * 8.1f);
                        toast1.show();
                    }
                    if (position == 39) {
                        resultado = resultado + (num * 63.5f);
                        toast1.show();
                    }
                    if (position == 40) {
                        resultado = resultado + (num * 8.9f);
                        toast1.show();
                    }
                    if (position == 41) {
                        resultado = resultado + (num * 4.7f);
                        toast1.show();
                    }
                    if (position == 42) {
                        resultado = resultado + (num * 4.1f);
                        toast1.show();
                    }
                    if (position == 43) {
                        resultado = resultado + (num * 7);
                        toast1.show();
                    }
                    if (position == 44) {
                        resultado = resultado + (num * 29);
                        toast1.show();
                    }


                }
                text = findViewById(R.id.verTOtalSalsa);
                total = resultado + resultado2 + resultado3 + resultado4 + resultado5 + resultado6;
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
        Intent i = new Intent(this, Categorias.class);
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
        myEditor.putFloat("salsa", total);
        myEditor.commit();
        this.guardarenbaseDAtos();
    }

    public void guardarenbaseDAtos() {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Salsas.this);

        String nombreGur = myPreferences.getString("nombreUser", "");
        Log.i("tag", "valor de carne en guardar" + total);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String sql = "UPDATE comida SET salsas='" + total + "' where  login='" + nombreGur + "'";
        bd.execSQL(sql);
        bd.close();
    }

    public void ayudaver(View view) {
        startActivity(new Intent(Salsas.this, PopupSalsas.class));
    }
}
