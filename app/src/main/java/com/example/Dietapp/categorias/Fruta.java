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
import com.example.Dietapp.categorias.popup.Popupfruta;
import com.example.Dietapp.Seguimiento;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Fruta extends AppCompatActivity {
    float resultado, resultado2, resultado3, resultado4, resultado5, resultado6;
    float total;
    private Spinner sp;
    private EditText edi;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruta);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Fruta.this);
        float num = myPreferences.getFloat("fru", 0);
        Log.i("tag", "valor de carne en carne " + num);

        total = total + num;
        sp = (Spinner) findViewById(R.id.espiner3);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add(" Selecciona el tipo de fruta(nº kcal cada 100 gramos)");
        elementos.add(" Manzanas");
        elementos.add(" Peras");
        elementos.add(" Paraguayas");
        elementos.add(" Bananas");
        elementos.add(" Fresas");
        elementos.add(" Melocotones");
        elementos.add(" Aceitunas");
        elementos.add(" Aguacate/Palta");
        elementos.add(" Albaricoque/Damasco");
        elementos.add(" Ananás/Piña");
        elementos.add(" Arandano");
        elementos.add(" Asaí");
        elementos.add(" Caqui/Persimón");
        elementos.add(" Carambola/fruta estrella");
        elementos.add(" Cereza/guinda");
        elementos.add(" Ciruela");
        elementos.add(" Ciruela verde");
        elementos.add(" Celmentina");
        elementos.add(" Compota/pure de manzana");
        elementos.add(" Coco");
        elementos.add(" Dátiles");
        elementos.add(" Granada");
        elementos.add(" Frambuesa");
        elementos.add(" Grosella");
        elementos.add(" Guayaba");
        elementos.add(" Higo");
        elementos.add(" Kiwi");
        elementos.add(" Lichi");
        elementos.add(" Lima");
        elementos.add(" Limón");
        elementos.add(" Macedonia");
        elementos.add(" Mandarina");
        elementos.add(" Mango");
        elementos.add(" Maracuyá");
        elementos.add(" Melón");
        elementos.add(" Melón amarillo");
        elementos.add(" Melón catalup");
        elementos.add(" Melón de galia");
        elementos.add(" Membrillo");
        elementos.add(" Mora/Zarzamora");
        elementos.add(" Naranja");
        elementos.add(" Naranja roja/sanguina");
        elementos.add(" Nectarina");
        elementos.add(" Nísperos");
        elementos.add(" Papaya/mamón");
        elementos.add(" Pasas/pasa de uva");
        elementos.add(" Philasis");
        elementos.add(" Plátano macho");
        elementos.add(" Pomelo/toronja");
        elementos.add(" Rambután");
        elementos.add(" Ruibarbo");
        elementos.add(" Sandia");
        elementos.add(" Tamarindo");
        elementos.add(" Uva");
        elementos.add(" Vaca");


        ArrayAdapter adp = new ArrayAdapter(Fruta.this, android.R.layout.simple_spinner_dropdown_item, elementos);
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


                    if (position == 1) {//Manzanas

                        resultado = num * 52;
                        toast1.show();
                        edi.setText("");
                    }

                    if (position == 2) {//Peras

                        resultado2 = num * 57;
                        toast1.show();
                        edi.setText("");
                    }

                    if (position == 3) {
                        resultado3 = num * 49;
                        toast1.show();
                        edi.setText("");
                    } //Paraguayas

                    if (position == 4) {//Bananas

                        resultado4 = num * 46;
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 5) {
                        resultado5 = num * 32;
                        toast1.show();
                        edi.setText("");
                    }//Fresas

                    if (position == 6) {
                        resultado6 = resultado6 + (num * 61);
                        toast1.show();
                        edi.setText("");
                    }//Melocotones
                    if (position == 7) {
                        resultado6 = resultado6 + (num * 115);
                        toast1.show();
                        edi.setText("");
                    }//aceitunas
                    if (position == 8) {
                        resultado6 = resultado6 + (num * 160);
                        toast1.show();
                        edi.setText("");
                    }// aguacate/palta
                    if (position == 9) {
                        resultado6 = resultado6 + (num * 48);
                        toast1.show();
                        edi.setText("");
                    }//albaricoque/damasco
                    if (position == 10) {
                        resultado6 = resultado6 + (num * 48);
                        toast1.show();
                        edi.setText("");
                    }// ananás/piña
                    if (position == 11) {
                        resultado6 = resultado6 + (num * 71);
                        toast1.show();
                        edi.setText("");
                    }//arandano
                    if (position == 12) {
                        resultado6 = resultado6 + (num * 70);
                        toast1.show();
                        edi.setText("");
                    }//asaí
                    if (position == 13) {
                        resultado6 = resultado6 + (num * 127);
                        toast1.show();
                        edi.setText("");
                    }//caqui/persimón
                    if (position == 14) {
                        resultado6 = resultado6 + (num * 31);
                        toast1.show();
                        edi.setText("");
                    }//carambola/fruta estrella
                    if (position == 15) {
                        resultado6 = resultado6 + (num * 58);
                        toast1.show();
                        edi.setText("");
                    }// cereza/guinda
                    if (position == 16) {
                        resultado6 = resultado6 + (num * 46);
                        toast1.show();
                        edi.setText("");
                    }//ciruela
                    if (position == 17) {
                        resultado6 = resultado6 + (num * 41);
                        toast1.show();
                        edi.setText("");
                    }//ciruela verde
                    if (position == 18) {
                        resultado6 = resultado6 + (num * 47);
                        toast1.show();
                        edi.setText("");
                    }//celmentina
                    if (position == 19) {
                        resultado6 = resultado6 + (num * 68);
                        toast1.show();
                        edi.setText("");
                    }//compota/pure de manzana
                    if (position == 20) {
                        resultado6 = resultado6 + (num * 354);
                        toast1.show();
                        edi.setText("");
                    }//coco
                    if (position == 21) {
                        resultado6 = resultado6 + (num * 282);
                        toast1.show();
                        edi.setText("");
                    }//dátiles
                    if (position == 22) {
                        resultado6 = resultado6 + (num * 83);
                        toast1.show();
                        edi.setText("");
                    }//granada
                    if (position == 23) {
                        resultado6 = resultado6 + (num * 52);
                        toast1.show();
                        edi.setText("");
                    }//frambuesa
                    if (position == 24) {
                        resultado6 = resultado6 + (num * 56);
                        toast1.show();
                        edi.setText("");
                    }//grosella
                    if (position == 25) {
                        resultado6 = resultado6 + (num * 68);
                        toast1.show();
                        edi.setText("");
                    }//guayaba
                    if (position == 26) {
                        resultado6 = resultado6 + (num * 37);
                        toast1.show();
                        edi.setText("");
                    }//higo
                    if (position == 27) {
                        resultado6 = resultado6 + (num * 61);
                        toast1.show();
                        edi.setText("");
                    }//kiwi
                    if (position == 28) {
                        resultado6 = resultado6 + (num * 30);
                        toast1.show();
                        edi.setText("");
                    }//lima
                    if (position == 29) {
                        resultado6 = resultado6 + (num * 39);
                        toast1.show();
                        edi.setText("");
                    }//limón
                    if (position == 30) {
                        resultado6 = resultado6 + (num * 50);
                        toast1.show();
                        edi.setText("");
                    }// macedonia
                    if (position == 31) {
                        resultado6 = resultado6 + (num * 53);
                        toast1.show();
                        edi.setText("");
                    }//mandarina
                    if (position == 32) {
                        resultado6 = resultado6 + (num * 60);
                        toast1.show();
                        edi.setText("");
                    }// mango
                    if (position == 33) {
                        resultado6 = resultado6 + (num * 71);
                        toast1.show();
                        edi.setText("");
                    }//arandano
                    if (position == 34) {
                        resultado6 = resultado6 + (num * 70);
                        toast1.show();
                        edi.setText("");
                    }//asaí
                    if (position == 35) {
                        resultado6 = resultado6 + (num * 97);
                        toast1.show();
                        edi.setText("");
                    }//maracuyá
                    if (position == 36) {
                        resultado6 = resultado6 + (num * 36);
                        toast1.show();
                        edi.setText("");
                    }//melón
                    if (position == 37) {
                        resultado6 = resultado6 + (num * 55);
                        toast1.show();
                        edi.setText("");
                    }//  melón amarillo
                    if (position == 38) {
                        resultado6 = resultado6 + (num * 34);
                        toast1.show();
                        edi.setText("");
                    }//melón catalup
                    if (position == 39) {
                        resultado6 = resultado6 + (num * 26);
                        toast1.show();
                        edi.setText("");
                    }//  melón de galia
                    if (position == 40) {
                        resultado6 = resultado6 + (num * 57);
                        toast1.show();
                        edi.setText("");
                    }//membrillo
                    if (position == 41) {
                        resultado6 = resultado6 + (num * 43);
                        toast1.show();
                        edi.setText("");
                    }// mora/zarzamora
                    if (position == 42) {
                        resultado6 = resultado6 + (num * 47);
                        toast1.show();
                        edi.setText("");
                    }//naranja
                    if (position == 43) {
                        resultado6 = resultado6 + (num * 50);
                        toast1.show();
                        edi.setText("");
                    }//  naranja roja/sanguina
                    if (position == 44) {
                        resultado6 = resultado6 + (num * 44);
                        toast1.show();
                        edi.setText("");
                    }//nectarina
                    if (position == 45) {
                        resultado6 = resultado6 + (num * 47);
                        toast1.show();
                        edi.setText("");
                    }// nísperos
                    if (position == 46) {
                        resultado6 = resultado6 + (num * 43);
                        toast1.show();
                        edi.setText("");
                    }// papaya/mamón
                    if (position == 47) {
                        resultado6 = resultado6 + (num * 299);
                        toast1.show();
                        edi.setText("");
                    }// pasas/pasa de uva
                    if (position == 48) {
                        resultado6 = resultado6 + (num * 49);
                        toast1.show();
                        edi.setText("");
                    }//philasis
                    if (position == 49) {
                        resultado6 = resultado6 + (num * 122);
                        toast1.show();
                        edi.setText("");
                    }//  plátano macho
                    if (position == 50) {
                        resultado6 = resultado6 + (num * 42);
                        toast1.show();
                        edi.setText("");
                    }//pomelo/toronja
                    if (position == 51) {
                        resultado6 = resultado6 + (num * 82);
                        toast1.show();
                        edi.setText("");
                    }// rambután
                    if (position == 53) {
                        resultado6 = resultado6 + (num * 239);
                        toast1.show();
                        edi.setText("");
                    }//tamarindo
                    if (position == 54) {
                        resultado6 = resultado6 + (num * 69);
                        toast1.show();
                        edi.setText("");
                    }//uva
                    if (position == 55) {
                        resultado6 = resultado6 + (num * 95);
                        toast1.show();
                        edi.setText("");
                    }// yaca


                }
                text = findViewById(R.id.textVerF);
                total = resultado + resultado2 + resultado3 + resultado4 + resultado5 + resultado6;
                text.setText("Total calorias consumidas moviendote: " + total);

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


    public void guaradr(View view) {
        Intent intent = new Intent(this, Seguimiento.class);
        intent.putExtra("calorias fruta", total);

        startActivity(intent);
        Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de fruta correctamente", Toast.LENGTH_SHORT);

        toastNada3.show();
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Fruta.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("fru", (int) total);
        myEditor.commit();
        this.guardarenbaseDAtos();
    }

    public void guardarenbaseDAtos() {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Fruta.this);

        String nombreGur = myPreferences.getString("nombreUser", "");
        Log.i("tag", "valor de carne en guardar" + total);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String sql = "UPDATE comida SET fruta='" + total + "' where  login='" + nombreGur + "'";
        bd.execSQL(sql);
        bd.close();
    }

    public void ayudafru(View view) {
        startActivity(new Intent(Fruta.this, Popupfruta.class));
    }
}
