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
    float resultado,resultado2,resultado3,resultado4,resultado5;
    float total;
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
        elementos.add("VERDURAS");
        elementos.add("Ensalada Completa: 234kcal");
        elementos.add("lechuga: 15 kcalorias");
        elementos.add("patatas: 94 kcal");
        elementos.add("acelga: 19 kcal");
        elementos.add("ajo: 1 diente= 4.5kcal");
        elementos.add("alcachofa: 47 kcal");
        elementos.add("apio: 16 kcal");
        elementos.add("berenjena: 25kcal");
        elementos.add("brecol: 34kcal");
        elementos.add("cebolla: 40kcal");
        elementos.add("cebolleta: 34kcal");
        elementos.add("col china: 16kcal");
        elementos.add("coliflor: 25 kcal");
        elementos.add("escarola: 17 kcal");
        elementos.add("espinaca: 22 kcal");
        elementos.add("judias verdes/ejote: 31 kcal");
        elementos.add("ñame: 118 kcal");
        elementos.add("colinabo/rutaba: 38 kcal");
        elementos.add("tomate: 18 kcal");
        elementos.add("zanahoria: 34 kcal");
        elementos.add(" Champiñon: 22kcal");
        elementos.add(" Niscalos: 25kcal");
        elementos.add("Seta de cardo: 92kcal");
        elementos.add("Pleurotus/girgolas: 35kcal");
        elementos.add("Trufas: 64kcal");
        elementos.add("LEGUMBRES:");
        elementos.add(" alubias/porotos/habas: 337kcal");
        elementos.add("alubias/habas rojas: 337kcal");
        elementos.add("bisalto/tirabeque/chicharos dulces: 42kcal");
        elementos.add("brotes de bmabú: 27kcal");
        elementos.add("cacahuetes/mani: 567kcal");
        elementos.add("castañas: 210kcal");
        elementos.add("dal: 230kcal");
        elementos.add("frijoles con chile: 97kcal");
        elementos.add("frijoles de soja: 147kcal");
        elementos.add("garvanzos: 364kcal");
        elementos.add("guisantes/arvejas/chicharos: 42kcal");
        elementos.add("soja verde/judía mungo: 12kcal");
        elementos.add("alubias/judias/porotos blancos: 336kcal");
        elementos.add("judias/frijolesnegros: 341kcal");
        elementos.add("judias/frijoles pintos: 347kcal");
        elementos.add("porotos/frijoles/judias rojos: 124kcal");
        elementos.add("judias verdes/chauchas/ejotes: 31kcal");
        elementos.add("lenteja marrón: 353kcal");
        elementos.add("lenteja verde: 257kcal");
        elementos.add("lentejas amarillas: 304kcal");
        elementos.add("lenteja roja: 329kcal");
        elementos.add("arroz blanco: 366kcal");
        elementos.add("miso: 199kcal");
        elementos.add("moyashi/germinado de frijol:30kcal");
        elementos.add("okra: 33kcal");
        elementos.add("queso de soja: 235kcal");
        elementos.add("tempeh: 193kcal");
        elementos.add("tofu: 76kcal");
        elementos.add("tofu extra firme: 91kcal");
        elementos.add("tofu firme: 70kcal");
        elementos.add("tofu frito: 271kcal");
        elementos.add("tofu silken: 55kcal");






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


                    if (position == 1) { resultado =resultado+( num * 234);toast1.show();edi.setText("");}
                    if (position == 2) { resultado = resultado+(num * 15);toast1.show();edi.setText("");}
                    if (position == 3) { resultado = resultado+(num * 94);toast1.show();edi.setText("");}
                    if (position == 4) { resultado = resultado+(num * 19);toast1.show();edi.setText("");}
                    if (position == 5) { resultado = resultado+(num * 4.5f);toast1.show();edi.setText("");}
                    if (position == 6) { resultado = resultado+(num * 47);toast1.show();edi.setText("");}
                    if (position == 7) { resultado = resultado+(num * 16);toast1.show();edi.setText("");}
                    if (position == 8) { resultado = resultado+(num * 25);toast1.show();edi.setText("");}
                    if (position == 9) { resultado = resultado+(num * 34);toast1.show();edi.setText("");}
                    if (position == 10) { resultado = resultado+(num * 40);toast1.show();edi.setText("");}
                    if (position == 11) { resultado = resultado+(num * 34);toast1.show();edi.setText("");}
                    if (position == 12) { resultado = resultado+(num * 16);toast1.show();edi.setText("");}
                    if (position == 13) { resultado =resultado+( num * 25);toast1.show();edi.setText("");}
                    if (position == 14) { resultado = resultado+(num * 17);toast1.show();edi.setText("");}
                    if (position == 15) { resultado = resultado+(num * 22);toast1.show();edi.setText("");}
                    if (position == 16) { resultado = resultado+(num * 31);toast1.show();edi.setText("");}
                    if (position == 17) { resultado = resultado+(num * 118);toast1.show();edi.setText("");}
                    if (position == 18) { resultado = resultado+(num * 38);toast1.show();edi.setText("");}
                    if (position == 19) { resultado = resultado+(num * 18);toast1.show();edi.setText("");}
                    if (position == 20) { resultado = resultado+(num * 34);toast1.show();edi.setText("");}
                    if (position == 21) { resultado = resultado+(num * 22);toast1.show();edi.setText("");}
                    if (position == 22) { resultado = resultado+(num * 25);toast1.show();edi.setText("");}
                    if (position == 23) { resultado = resultado+(num * 92);toast1.show();edi.setText("");}
                    if (position == 24) { resultado = resultado+(num * 35);toast1.show();edi.setText("");}
                    if (position == 25) { resultado = resultado+(num * 64);toast1.show();edi.setText("");}
                    if (position == 26) { resultado = resultado+(num * 337);toast1.show();edi.setText("");}
                    if (position == 27) { resultado = resultado+(num * 337);toast1.show();edi.setText("");}
                    if (position == 28) { resultado = resultado+(num * 42);toast1.show();edi.setText("");}
                    if (position == 29) { resultado = resultado+(num * 27);toast1.show();edi.setText("");}
                    if (position == 30) { resultado = resultado+(num * 567);toast1.show();edi.setText("");}
                    if (position == 31) { resultado = resultado+(num * 210);toast1.show();edi.setText("");}
                    if (position == 32) { resultado =resultado+( num * 230);toast1.show();edi.setText("");}
                    if (position == 33) { resultado = resultado+(num * 97);toast1.show();edi.setText("");}
                    if (position == 34) { resultado =resultado+( num * 147);toast1.show();edi.setText("");}
                    if (position == 35) { resultado = resultado+(num * 364);toast1.show();edi.setText("");}
                    if (position == 36) { resultado = resultado+(num * 42);toast1.show();edi.setText("");}
                    if (position == 37) { resultado = resultado+(num * 12);toast1.show();edi.setText("");}
                    if (position == 38) { resultado = resultado+(num * 336);toast1.show();edi.setText("");}
                    if (position == 39) { resultado = resultado+(num * 341);toast1.show();edi.setText("");}
                    if (position == 40) { resultado = resultado+(num * 347);toast1.show();edi.setText("");}
                    if (position == 41) { resultado = resultado+(num * 124);toast1.show();edi.setText("");}
                    if (position == 42) { resultado = resultado+(num * 31);toast1.show();edi.setText("");}
                    if (position == 43) { resultado = resultado+(num * 353);toast1.show();edi.setText("");}
                    if (position == 44) { resultado = resultado+(num * 257);toast1.show();edi.setText("");}
                    if (position == 45) { resultado = resultado+(num * 304);toast1.show();edi.setText("");}
                    if (position == 46) { resultado = resultado+(num * 329);toast1.show();edi.setText("");}
                    if (position == 47) { resultado = resultado+(num *  366);toast1.show();edi.setText("");}
                    if (position == 48) { resultado =resultado+( num * 199);toast1.show();edi.setText("");}
                    if (position == 49) { resultado = resultado+(num * 30);toast1.show();edi.setText("");}
                    if (position == 50) { resultado = resultado+(num * 691);toast1.show();edi.setText("");}
                    if (position == 51) { resultado = resultado+(num * 235);toast1.show();edi.setText("");}
                    if (position == 52) { resultado = resultado+(num * 91);toast1.show();edi.setText("");}
                    if (position == 53) { resultado = resultado+(num * 70);toast1.show();edi.setText("");}
                    if (position == 54) { resultado = resultado+(num * 271);toast1.show();edi.setText("");}


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
        myEditor.putFloat("erdura",  total);
        myEditor.commit();
    }

    public void ayudaver(View view) {
        startActivity(new Intent(VerdurayLegumbres.this, PopupVerdurea.class));
    }
}
