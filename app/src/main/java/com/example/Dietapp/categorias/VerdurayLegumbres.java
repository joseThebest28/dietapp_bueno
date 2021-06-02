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
import com.example.Dietapp.categorias.popup.PopupVerdurea;
import com.example.Dietapp.Seguimiento;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class VerdurayLegumbres extends AppCompatActivity {
    float resultado, resultado2, resultado3, resultado4, resultado5;
    float total;
    private Spinner sp;
    private EditText edi;
    TextView text;
    private final String texto1 = "Total calorias de verduras: ";
    private final String texto2 = "No has seleccioando nada";
    private final String texto3 = "Se han guardado los datos de las verduras y hortalizas correctamente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verduras);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(VerdurayLegumbres.this);
        float num = myPreferences.getFloat("erdura", 0);
        Log.i("tag", "valor de carne en carne " + num);

        total = total + num;
        sp = findViewById(R.id.espinerverdu);

        ArrayList<String> elementos = new ArrayList<>();
        elementos.add(" Selecciona el tipo de verdura o legumbre");
        elementos.add(" VERDURAS");
        elementos.add(" Ensalada Completa");
        elementos.add(" Acelga: 19 kcal");
        elementos.add(" Ajo: 1 diente");
        elementos.add(" Alcachofa");
        elementos.add(" Apio");
        elementos.add(" Berenjena");
        elementos.add(" Brecol");
        elementos.add(" Cebolla");
        elementos.add(" Cebolleta");
        elementos.add(" Col china");
        elementos.add(" Coliflor");
        elementos.add(" Colinabo/rutaba");
        elementos.add(" Champiñon");
        elementos.add(" Escarola");
        elementos.add(" Espinaca");
        elementos.add(" Judias verdes/ejote");
        elementos.add(" Lechuga");
        elementos.add(" Niscalos");
        elementos.add(" Ñame");
        elementos.add(" Patatas");
        elementos.add(" Pleurotus/girgolas");
        elementos.add(" Seta de cardo");
        elementos.add(" Tomate");
        elementos.add(" Trufas");
        elementos.add(" Zanahoria");
        elementos.add(" LEGUMBRES:");
        elementos.add(" Alubias/porotos/habas");
        elementos.add(" Alubias/habas rojas");
        elementos.add(" Arroz blanco");
        elementos.add(" Alubias/judias/porotos blancos");
        elementos.add(" Bisalto/tirabeque/chicharos dulces");
        elementos.add(" Brotes de bmabú");
        elementos.add(" Cacahuetes/mani");
        elementos.add(" Castañas");
        elementos.add(" Dal");
        elementos.add(" Frijoles con chile");
        elementos.add(" Frijoles de soja");
        elementos.add(" Garvanzos");
        elementos.add(" Guisantes/arvejas/chicharos");
        elementos.add(" Judias/frijoles negros");
        elementos.add(" Judias/frijoles pintos");
        elementos.add(" Judias verdes/chauchas/ejotes");
        elementos.add(" Lenteja marrón");
        elementos.add(" Lenteja verde");
        elementos.add(" Lentejas amarillas");
        elementos.add(" Lenteja roja");
        elementos.add(" Miso");
        elementos.add(" Moyashi/germinado de frijol");
        elementos.add(" Okra");
        elementos.add(" Porotos/frijoles/judias rojos");
        elementos.add(" Queso de soja");
        elementos.add(" Soja verde/judía mungo");
        elementos.add(" Tempeh");
        elementos.add(" Tofu");
        elementos.add(" Tofu extra firme");
        elementos.add(" Tofu firme");
        elementos.add(" Tofu frito");
        elementos.add(" Tofu silken");


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


                    if (position == 2) {
                        resultado = resultado + (num * 234);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 3) {
                        resultado = resultado + (num * 19);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 4) {
                        resultado = resultado + (num * 4.5f);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 5) {
                        resultado = resultado + (num * 47);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 6) {
                        resultado = resultado + (num * 16);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 7) {
                        resultado = resultado + (num * 25);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 8) {
                        resultado = resultado + (num * 34);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 9) {
                        resultado = resultado + (num * 40);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 10) {
                        resultado = resultado + (num * 34);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 11) {
                        resultado = resultado + (num * 16);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 12) {
                        resultado = resultado + (num * 25);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 13) {
                        resultado = resultado + (num * 38);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 14) {
                        resultado = resultado + (num * 22);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 15) {
                        resultado = resultado + (num * 17);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 16) {
                        resultado = resultado + (num * 22);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 17) {
                        resultado = resultado + (num * 31);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 18) {
                        resultado = resultado + (num * 15);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 19) {
                        resultado = resultado + (num * 25);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 20) {
                        resultado = resultado + (num * 118);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 21) {
                        resultado = resultado + (num * 94);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 22) {
                        resultado = resultado + (num * 35);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 23) {
                        resultado = resultado + (num * 92);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 24) {
                        resultado = resultado + (num * 18);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 25) {
                        resultado = resultado + (num * 64);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 26) {
                        resultado = resultado + (num * 34);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 28) {
                        resultado = resultado + (num * 337);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 29) {
                        resultado = resultado + (num * 337);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 30) {
                        resultado = resultado + (num * 366);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 31) {
                        resultado = resultado + (num * 336);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 32) {
                        resultado = resultado + (num * 42);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 33) {
                        resultado = resultado + (num * 27);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 34) {
                        resultado = resultado + (num * 567);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 35) {
                        resultado = resultado + (num * 210);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 36) {
                        resultado = resultado + (num * 230);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 37) {
                        resultado = resultado + (num * 97);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 38) {
                        resultado = resultado + (num * 147);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 39) {
                        resultado = resultado + (num * 364);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 40) {
                        resultado = resultado + (num * 42);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 41) {
                        resultado = resultado + (num * 341);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 42) {
                        resultado = resultado + (num * 347);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 43) {
                        resultado = resultado + (num * 31);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 44) {
                        resultado = resultado + (num * 353);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 45) {
                        resultado = resultado + (num * 257);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 46) {
                        resultado = resultado + (num * 304);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 47) {
                        resultado = resultado + (num * 329);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 48) {
                        resultado = resultado + (num * 199);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 49) {
                        resultado = resultado + (num * 30);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 50) {
                        resultado = resultado + (num * 33);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 51) {
                        resultado = resultado + (num * 124);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 52) {
                        resultado = resultado + (num * 235);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 53) {
                        resultado = resultado + (num * 12);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 54) {
                        resultado = resultado + (num * 193);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 55) {
                        resultado = resultado + (num * 76);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 56) {
                        resultado = resultado + (num * 91);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 57) {
                        resultado = resultado + (num * 70);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 58) {
                        resultado = resultado + (num * 271);
                        toast1.show();
                        edi.setText("");
                    }
                    if (position == 59) {
                        resultado = resultado + (num * 55);
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


    public void volverMenu(View view) {
        Intent i = new Intent(this, Categorias.class);
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
        myEditor.putFloat("erdura", total);
        myEditor.commit();
        this.guardarenbaseDAtos();
    }

    public void guardarenbaseDAtos() {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(VerdurayLegumbres.this);

        String nombreGur = myPreferences.getString("nombreUser", "");
        Log.i("tag", "valor de carne en guardar" + total);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 17);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String sql = "UPDATE comida SET verdura='" + total + "' where  login='" + nombreGur + "'";
        bd.execSQL(sql);
        bd.close();
    }

    public void ayudaver(View view) {
        startActivity(new Intent(VerdurayLegumbres.this, PopupVerdurea.class));
    }
}
