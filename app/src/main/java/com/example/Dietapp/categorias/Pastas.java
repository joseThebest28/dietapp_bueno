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
import com.example.Dietapp.categorias.popup.PopunPasta;
import com.example.Dietapp.Seguimiento;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Pastas extends AppCompatActivity {
    float resultado, resultado2, resultado3, resultado4, resultado5;
    float total;
    private Spinner sp;
    private EditText edi;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pastas);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pastas.this);
        float num = myPreferences.getFloat("pasta", 0);
        Log.i("tag", "valor de carne en carne " + num);

        total = total + num;
        sp = (Spinner) findViewById(R.id.spiPasta);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add(" Selecciona el tipo de palto que has comido");
        elementos.add(" Plato de arroz");
        elementos.add(" Canelones");
        elementos.add(" Capellini/Cabello de ángel");
        elementos.add(" Cappelletti/Capeletinis");
        elementos.add(" Conchas");
        elementos.add(" Dampfnudel(pasta al vapor)");
        elementos.add(" Espagueti");
        elementos.add(" Espaguetis integrales");
        elementos.add(" Farfalle/Pajaritas/Mariposas");
        elementos.add(" Fettuccine/Fetuccinni");
        elementos.add(" Fideo celofán/chino");
        elementos.add(" Fideos de soja/soya");
        elementos.add(" Fideos_shirataki");
        elementos.add(" Fusilli");
        elementos.add(" Linguine");
        elementos.add(" Láminas de lasaña");
        elementos.add(" Macaroni/Fideos/Macarrones");
        elementos.add(" Masa de dumpling");
        elementos.add(" Mostaccioli");
        elementos.add(" Orecchiette");
        elementos.add(" Orzo");
        elementos.add(" Pasta baja en carbohidratos");
        elementos.add(" Pasta de grano entero");
        elementos.add(" Pasta_de_huevo");
        elementos.add(" Penne");
        elementos.add(" Penne_Rigate");
        elementos.add(" Pierogi");
        elementos.add(" Ravioles de verdura");
        elementos.add(" Ravioli/Ravioles");
        elementos.add(" Ravioli/Ravioles de carne");
        elementos.add(" Ravioli/Ravioles de pollo");
        elementos.add(" Ravioli/Ravioles de queso");
        elementos.add(" Rigatoni");
        elementos.add(" Spirelli");
        elementos.add(" Spätzle");
        elementos.add(" Sémola de trigo duro");
        elementos.add(" Tallarines");
        elementos.add(" Tortellini");
        elementos.add(" Tortellini de carne");
        elementos.add(" Tortellini de espinacas");
        elementos.add(" Tortellini de pollo");
        elementos.add(" Tortellini de queso");
        elementos.add(" Tortellini vegetal");
        elementos.add(" Vermicelli");
        elementos.add(" Plato de boloñesa");
        elementos.add(" Plato de Carbonara");
        elementos.add(" Plato de arroz con frijoles");
        elementos.add(" Plato de spaghetis con queso");


        ArrayAdapter adp = new ArrayAdapter(Pastas.this, android.R.layout.simple_spinner_dropdown_item, elementos);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) sp.getAdapter().getItem(position);
                Toast toast1 = Toast.makeText(getApplicationContext(), "has seleccionado " + elemento, Toast.LENGTH_SHORT);


                edi = findViewById(R.id.numPasta);

                String res = edi.getText().toString();

                res.trim();

                if (!res.isEmpty()) {
                    int num = Integer.parseInt(res);


                    if (position == 1) {
                        resultado = resultado + (num * 146);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 2) {
                        resultado = resultado + (num * 353);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 3) {
                        resultado = resultado + (num * 164);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 4) {
                        resultado = resultado + (num * 353);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 5) {
                        resultado = resultado + (num * 274);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 6) {
                        resultado = resultado + (num * 370);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 7) {
                        resultado = resultado + (num * 351);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 8) {
                        resultado = resultado + (num * 358);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 9) {
                        resultado = resultado + (num * 353);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 10) {
                        resultado = resultado + (num * 192);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 11) {
                        resultado = resultado + (num * 216);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 12) {
                        resultado = resultado + (num * 18);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 13) {
                        resultado = resultado + (num * 352);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 14) {
                        resultado = resultado + (num * 357);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 15) {
                        resultado = resultado + (num * 271);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 16) {
                        resultado = resultado + (num * 370);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 17) {
                        resultado = resultado + (num * 99);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 18) {
                        resultado = resultado + (num * 184);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 19) {
                        resultado = resultado + (num * 370);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 20) {
                        resultado = resultado + (num * 357);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 21) {
                        resultado = resultado + (num * 282);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 22) {
                        resultado = resultado + (num * 347);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 23) {
                        resultado = resultado + (num * 384);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 24) {
                        resultado = resultado + (num * 351);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 25) {
                        resultado = resultado + (num * 370);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 26) {
                        resultado = resultado + (num * 200);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 27) {
                        resultado = resultado + (num * 84);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 28) {
                        resultado = resultado + (num * 77);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 29) {
                        resultado = resultado + (num * 90);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 30) {
                        resultado = resultado + (num * 88);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 31) {
                        resultado = resultado + (num * 193);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 32) {
                        resultado = resultado + (num * 353);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 33) {
                        resultado = resultado + (num * 367);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 34) {
                        resultado = resultado + (num * 368);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 35) {
                        resultado = resultado + (num * 397);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 36) {
                        resultado = resultado + (num * 370);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 37) {
                        resultado = resultado + (num * 291);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 38) {
                        resultado = resultado + (num * 302);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 39) {
                        resultado = resultado + (num * 314);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 40) {
                        resultado = resultado + (num * 301);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 41) {
                        resultado = resultado + (num * 291);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 42) {
                        resultado = resultado + (num * 289);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 43) {
                        resultado = resultado + (num * 368);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 44) {
                        resultado = resultado + (num * 359);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 45) {
                        resultado = resultado + (num * 359);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 46) {
                        resultado = resultado + (num * 151);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 47) {
                        resultado = resultado + (num * 361);
                        toast1.show();
                        edi.setText("");
                    }


                }
                text = findViewById(R.id.ttoatalPasta);
                total = resultado + resultado2 + resultado3 + resultado4 + resultado5;
                text.setText("Total calorias de pasta: " + total);

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

    public void guadarDatosPasta(View view) {
        Intent intent = new Intent(this, Seguimiento.class);
        intent.putExtra("pasta", total);

        startActivity(intent);
        Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de pasta correctamente", Toast.LENGTH_SHORT);

        toastNada3.show();
        SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(Pastas.this);
        SharedPreferences.Editor myEditorPA = myPreferencesPA.edit();
        myEditorPA.putFloat("pasta", (int) total);
        myEditorPA.commit();
        this.guardarenbaseDAtos();
    }

    public void guardarenbaseDAtos() {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pastas.this);

        String nombreGur = myPreferences.getString("nombreUser", "");
        Log.i("tag", "valor de carne en guardar" + total);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String sql = "UPDATE comida SET pastas='" + total + "' where  login='" + nombreGur + "'";
        bd.execSQL(sql);
        bd.close();
    }

    public void ayudapasta(View view) {
        startActivity(new Intent(Pastas.this, PopunPasta.class));
    }


}
