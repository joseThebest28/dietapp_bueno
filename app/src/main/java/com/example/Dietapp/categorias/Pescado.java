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
import com.example.Dietapp.categorias.popup.PopupPescado;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Pescado extends AppCompatActivity {
    private Spinner sp;
    private Spinner sp2;

    private EditText edi;
    private EditText edi2;

    private TextView fina;
    private float resultado;
    private float resultado2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pescado);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pescado.this);
        float num = myPreferences.getFloat("pescado", 0);
        Log.i("tag", "valor de carne en carne " + num);

        totalSuma = totalSuma + num;
        sp = (Spinner) findViewById(R.id.Sp1);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add(" Selecciona el tipo de pescado que has comido");
        elementos.add(" Abadejo");
        elementos.add(" Anchoa de banco");
        elementos.add(" Anguila");
        elementos.add(" Arenque");
        elementos.add(" Atun");
        elementos.add(" Boquerón/anchoa");
        elementos.add(" Bacalao");
        elementos.add(" Balistes");
        elementos.add(" Boga");
        elementos.add(" Brema");
        elementos.add(" Besugo");
        elementos.add(" Caballa/verdel");
        elementos.add(" Capellán");
        elementos.add(" Carpa");
        elementos.add(" Caviar");
        elementos.add(" Corvina");
        elementos.add(" Cabracho");
        elementos.add(" Congrio");
        elementos.add(" Dorada");
        elementos.add(" Dorado");
        elementos.add(" Esglefino");
        elementos.add(" Esturión");
        elementos.add(" Fletán/halibut");
        elementos.add(" Gallineta nórdica");
        elementos.add(" Lenguado");
        elementos.add(" Lisa");
        elementos.add(" Lubina/ródalo");
        elementos.add(" Lucio");
        elementos.add(" Lucioperca");
        elementos.add(" Maruca");
        elementos.add(" Merluza");
        elementos.add(" Mero/Cherna");
        elementos.add(" Palitos de pescado");
        elementos.add(" Palometa/japuta");
        elementos.add(" Panga");
        elementos.add(" Pargo rojo");
        elementos.add(" Pejerrey");
        elementos.add(" Pescadilla");
        elementos.add(" Peto");
        elementos.add(" Pez espada/Emperador");
        elementos.add(" Platija");
        elementos.add(" Rape");
        elementos.add(" Rodaballo");
        elementos.add(" Sabalote");
        elementos.add(" Salmón");
        elementos.add(" Sardina");
        elementos.add(" Solla");
        elementos.add(" Surubí");
        elementos.add(" Sábalo");
        elementos.add(" Tiburón");
        elementos.add(" Trucha");
        elementos.add(" Gallo");
        elementos.add(" Jurel/ Chicharro");
        elementos.add(" Liba/eglefino/merlán");
        elementos.add(" Raya");
        elementos.add(" Salmón");
        elementos.add(" Salmonete");
        elementos.add(" Sushi");
        elementos.add(" Zapatilla");


        ArrayAdapter adp = new ArrayAdapter(Pescado.this, android.R.layout.simple_spinner_dropdown_item, elementos);
        sp.setAdapter(adp);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) sp.getAdapter().getItem(position);
                Toast toast1 = Toast.makeText(getApplicationContext(), "has seleccionado " + elemento, Toast.LENGTH_SHORT);


                edi = findViewById(R.id.numP1);
                String res = edi.getText().toString();
                res.trim();
                if (!res.isEmpty()) {
                    int num = Integer.parseInt(res);

                    if (position == 1) {
                        resultado = resultado + (num * 111);
                        toast1.show();
                    }
                    if (position == 2) {
                        resultado = resultado + (num * 159);
                        toast1.show();
                    }
                    if (position == 3) {
                        resultado = resultado + (num * 236);
                        toast1.show();
                    }
                    if (position == 4) {
                        resultado = resultado + (num * 203);
                        toast1.show();
                    }
                    if (position == 5) {
                        resultado = resultado + (num * 132);
                        toast1.show();
                    }
                    if (position == 6) {
                        resultado = resultado + (num * 131);
                        toast1.show();
                    }
                    if (position == 7) {
                        resultado = resultado + (num * 105);
                        toast1.show();
                    }
                    if (position == 8) {
                        resultado = resultado + (num * 93);
                        toast1.show();
                    }
                    if (position == 9) {
                        resultado = resultado + (num * 149);
                        toast1.show();
                    }
                    if (position == 10) {
                        resultado = resultado + (num * 135);
                        toast1.show();
                    }
                    if (position == 11) {
                        resultado = resultado + (num * 84);
                        toast1.show();
                    }
                    if (position == 12) {
                        resultado = resultado + (num * 88);
                        toast1.show();
                    }
                    if (position == 13) {
                        resultado = resultado + (num * 212);
                        toast1.show();
                    }
                    if (position == 14) {
                        resultado = resultado + (num * 124);
                        toast1.show();
                    }
                    if (position == 15) {
                        resultado = resultado + (num * 162);
                        toast1.show();
                    }
                    if (position == 16) {
                        resultado = resultado + (num * 264);
                        toast1.show();
                    }
                    if (position == 17) {
                        resultado = resultado + (num * 81);
                        toast1.show();
                    }
                    if (position == 18) {
                        resultado = resultado + (num * 91);
                        toast1.show();
                    }
                    if (position == 19) {
                        resultado = resultado + (num * 107);
                        toast1.show();
                    }
                    if (position == 20) {
                        resultado = resultado + (num * 77);
                        toast1.show();
                    }
                    if (position == 21) {
                        resultado = resultado + (num * 85);
                        toast1.show();
                    }
                    if (position == 22) {
                        resultado = resultado + (num * 90);
                        toast1.show();
                    }
                    if (position == 23) {
                        resultado = resultado + (num * 135);
                        toast1.show();
                    }
                    if (position == 24) {
                        resultado = resultado + (num * 111);
                        toast1.show();
                    }
                    if (position == 25) {
                        resultado = resultado + (num * 94);
                        toast1.show();
                    }
                    if (position == 26) {
                        resultado = resultado + (num * 86);
                        toast1.show();
                    }
                    if (position == 27) {
                        resultado = resultado + (num * 150);
                        toast1.show();
                    }
                    if (position == 28) {
                        resultado = resultado + (num * 124);
                        toast1.show();
                    }
                    if (position == 29) {
                        resultado = resultado + (num * 113);
                        toast1.show();
                    }
                    if (position == 30) {
                        resultado = resultado + (num * 84);
                        toast1.show();
                    }
                    if (position == 31) {
                        resultado = resultado + (num * 128);
                        toast1.show();
                    }
                    if (position == 32) {
                        resultado = resultado + (num * 71);
                        toast1.show();
                    }
                    if (position == 33) {
                        resultado = resultado + (num * 118);
                        toast1.show();
                    }
                    if (position == 34) {
                        resultado = resultado + (num * 290);
                        toast1.show();
                    }
                    if (position == 35) {
                        resultado = resultado + (num * 187);
                        toast1.show();
                    }
                    if (position == 36) {
                        resultado = resultado + (num * 67);
                        toast1.show();
                    }
                    if (position == 37) {
                        resultado = resultado + (num * 87);
                        toast1.show();
                    }
                    if (position == 38) {
                        resultado = resultado + (num * 106);
                        toast1.show();
                    }
                    if (position == 39) {
                        resultado = resultado + (num * 116);
                        toast1.show();
                    }
                    if (position == 40) {
                        resultado = resultado + (num * 109);
                        toast1.show();
                    }
                    if (position == 41) {
                        resultado = resultado + (num * 172);
                        toast1.show();
                    }
                    if (position == 42) {
                        resultado = resultado + (num * 86);
                        toast1.show();
                    }
                    if (position == 43) {
                        resultado = resultado + (num * 97);
                        toast1.show();
                    }
                    if (position == 44) {
                        resultado = resultado + (num * 122);
                        toast1.show();
                    }
                    if (position == 45) {
                        resultado = resultado + (num * 190);
                        toast1.show();
                    }
                    if (position == 46) {
                        resultado = resultado + (num * 206);
                        toast1.show();
                    }
                    if (position == 47) {
                        resultado = resultado + (num * 208);
                        toast1.show();
                    }
                    if (position == 48) {
                        resultado = resultado + (num * 91);
                        toast1.show();
                    }
                    if (position == 49) {
                        resultado = resultado + (num * 110);
                        toast1.show();
                    }
                    if (position == 50) {
                        resultado = resultado + (num * 252);
                        toast1.show();
                    }
                    if (position == 51) {
                        resultado = resultado + (num * 130);
                        toast1.show();
                    }
                    if (position == 52) {
                        resultado = resultado + (num * 190);
                        toast1.show();
                    }
                    if (position == 53) {
                        resultado = resultado + (num * 81);
                        toast1.show();
                    }
                    if (position == 54) {
                        resultado = resultado + (num * 117);
                        toast1.show();
                    }
                    if (position == 55) {
                        resultado = resultado + (num * 84);
                        toast1.show();
                    }
                    if (position == 56) {
                        resultado = resultado + (num * 97);
                        toast1.show();
                    }
                    if (position == 57) {
                        resultado = resultado + (num * 206);
                        toast1.show();
                    }
                    if (position == 58) {
                        resultado = resultado + (num * 109);
                        toast1.show();
                    }
                    if (position == 59) {
                        resultado = resultado + (num * 85.4f);
                        toast1.show();
                    }
                    if (position == 60) {
                        resultado = resultado + (num * 77);
                        toast1.show();
                    }


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast toastNada = Toast.makeText(getApplicationContext(), "No has seleccioando nada", Toast.LENGTH_SHORT);

                toastNada.show();
            }
        });
        sp2 = (Spinner) findViewById(R.id.spP2);

        ArrayList<String> elementos2 = new ArrayList<>();
        elementos2.add("Selecciona el molusco que has comido");

        elementos2.add(" Almeja");
        elementos2.add(" Almeja fina/chirla");
        elementos2.add(" Berberecho");
        elementos2.add(" Bígaro");
        elementos2.add(" Boca");
        elementos2.add(" Bogavante");
        elementos2.add(" Buey de mar");
        elementos2.add(" Busano");
        elementos2.add(" Calamar");
        elementos2.add(" Camarón");
        elementos2.add(" Cangrejo de mar");
        elementos2.add(" Cangrejo de rio");
        elementos2.add(" Cañailla");
        elementos2.add(" Caracol");
        elementos2.add(" Centollo");
        elementos2.add(" Cigalas");
        elementos2.add(" Coquina");
        elementos2.add(" Gambas");
        elementos2.add(" Langosta");
        elementos2.add(" Langostino");
        elementos2.add(" Langostinos tigre");
        elementos2.add(" Lapa");
        elementos2.add(" Mejillón");
        elementos2.add(" Navaja");
        elementos2.add(" Nécora");
        elementos2.add(" Ostra");
        elementos2.add(" Pecho");
        elementos2.add(" Percebe");
        elementos2.add(" Pota");
        elementos2.add(" Pulpo");
        elementos2.add(" Sepia");
        elementos2.add(" Vieira");


        ArrayAdapter adp2 = new ArrayAdapter(Pescado.this, android.R.layout.simple_spinner_dropdown_item, elementos2);
        sp2.setAdapter(adp2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento2 = (String) sp2.getAdapter().getItem(position);
                Toast toastMP = Toast.makeText(getApplicationContext(), "has seleccionado " + elemento2, Toast.LENGTH_SHORT);


                edi2 = findViewById(R.id.numP2);
                String res2 = edi2.getText().toString();
                res2.trim();
                if (!res2.isEmpty()) {
                    int num2 = Integer.parseInt(res2);

                    if (position == 1) {
                        resultado2 = resultado2 + (num2 * 148);
                        toastMP.show();
                    }
                    if (position == 2) {
                        resultado2 = resultado2 + (num2 * 76.6f);
                        toastMP.show();
                    }
                    if (position == 3) {
                        resultado2 = resultado2 + (num2 * 76);
                        toastMP.show();
                    }
                    if (position == 4) {
                        resultado2 = resultado2 + (num2 * 94);
                        toastMP.show();
                    }
                    if (position == 5) {
                        resultado2 = resultado2 + (num2 * 86);
                        toastMP.show();
                    }
                    if (position == 6) {
                        resultado2 = resultado2 + (num2 * 90);
                        toastMP.show();
                    }
                    if (position == 7) {
                        resultado2 = resultado2 + (num2 * 130);
                        toastMP.show();
                    }
                    if (position == 8) {
                        resultado2 = resultado2 + (num2 * 79);
                        toastMP.show();
                    }
                    if (position == 9) {
                        resultado2 = resultado2 + (num2 * 175);
                        toastMP.show();
                    }
                    if (position == 10) {
                        resultado2 = resultado2 + (num2 * 82);
                        toastMP.show();
                    }
                    if (position == 11) {
                        resultado2 = resultado2 + (num2 * 124);
                        toastMP.show();
                    }
                    if (position == 12) {
                        resultado2 = resultado2 + (num2 * 82);
                        toastMP.show();
                    }
                    if (position == 13) {
                        resultado2 = resultado2 + (num2 * 91);
                        toastMP.show();
                    }
                    if (position == 14) {
                        resultado2 = resultado2 + (num2 * 80);
                        toastMP.show();
                    }
                    if (position == 15) {
                        resultado2 = resultado2 + (num2 * 127);
                        toastMP.show();
                    }
                    if (position == 16) {
                        resultado2 = resultado2 + (num2 * 69);
                        toastMP.show();
                    }
                    if (position == 17) {
                        resultado2 = resultado2 + (num2 * 75);
                        toastMP.show();
                    }
                    if (position == 18) {
                        resultado2 = resultado2 + (num2 * 75);
                        toastMP.show();
                    }
                    if (position == 19) {
                        resultado2 = resultado2 + (num2 * 89);
                        toastMP.show();
                    }
                    if (position == 20) {
                        resultado2 = resultado2 + (num2 * 75);
                        toastMP.show();
                    }
                    if (position == 21) {
                        resultado2 = resultado2 + (num2 * 90);
                        toastMP.show();
                    }
                    if (position == 22) {
                        resultado2 = resultado2 + (num2 * 86);
                        toastMP.show();
                    }
                    if (position == 23) {
                        resultado2 = resultado2 + (num2 * 172);
                        toastMP.show();
                    }
                    if (position == 24) {
                        resultado2 = resultado2 + (num2 * 92.5f);
                        toastMP.show();
                    }
                    if (position == 25) {
                        resultado2 = resultado2 + (num2 * 125);
                        toastMP.show();
                    }
                    if (position == 26) {
                        resultado2 = resultado2 + (num2 * 41);
                        toastMP.show();
                    }
                    if (position == 27) {
                        resultado2 = resultado2 + (num2 * 86);
                        toastMP.show();
                    }
                    if (position == 28) {
                        resultado2 = resultado2 + (num2 * 66);
                        toastMP.show();
                    }
                    if (position == 29) {
                        resultado2 = resultado2 + (num2 * 120);
                        toastMP.show();
                    }
                    if (position == 30) {
                        resultado2 = resultado2 + (num2 * 164);
                        toastMP.show();
                    }
                    if (position == 31) {
                        resultado2 = resultado2 + (num2 * 75.3f);
                        toastMP.show();
                    }
                    if (position == 32) {
                        resultado2 = resultado2 + (num2 * 111);
                        toastMP.show();
                    }


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void volverMenu(View view) {
        Intent i = new Intent(this, Categorias.class);
        startActivity(i);

    }

    float totalSuma;

    public void enviar(View view) {
        Intent intent = new Intent(this, Seguimiento.class);
        intent.putExtra("calorias pescado", totalSuma);

        startActivity(intent);
        Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de pescado correctamente", Toast.LENGTH_SHORT);

        toastNada3.show();
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pescado.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("pescado", totalSuma);
        myEditor.commit();
        this.guardarenbaseDAtos();
    }

    public void ver(View view) {
        fina = findViewById(R.id.totalP);
        totalSuma = resultado + resultado2;
        fina.setText("total calorias pescado: " + totalSuma);
        if (totalSuma == 0) {
            Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se estan cargando los datos,pruebe otra vez en unos instantes, gracias por su espera.", Toast.LENGTH_SHORT);

            toastNada3.show();
        }
    }

    public void guardarenbaseDAtos() {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Pescado.this);

        String nombreGur = myPreferences.getString("nombreUser", "");
        Log.i("tag", "valor de carne en guardar" + totalSuma);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String sql = "UPDATE comida SET pescado='" + totalSuma + "' where  login='" + nombreGur + "'";
        bd.execSQL(sql);
        bd.close();
    }

    public void ayudapez(View view) {
        startActivity(new Intent(Pescado.this, PopupPescado.class));
    }
}
