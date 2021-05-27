package com.example.Dietapp.extras.Recetas;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.Categorias;
import com.example.Dietapp.extras.Recetas.listas.ListasCasqueria;
import com.example.Dietapp.extras.Recetas.listas.ListasCerdo;
import com.example.Dietapp.extras.Recetas.listas.ListasConejo;
import com.example.Dietapp.extras.Recetas.listas.ListasConservas;
import com.example.Dietapp.extras.Recetas.listas.ListasCordero;
import com.example.Dietapp.extras.Recetas.listas.ListasCorderoCaRoja;
import com.example.Dietapp.extras.Recetas.listas.ListasEmbutidos;
import com.example.Dietapp.extras.Recetas.listas.ListasFruta;
import com.example.Dietapp.extras.Recetas.listas.ListasLegumbres;
import com.example.Dietapp.extras.Recetas.listas.ListasOtroCarne;
import com.example.Dietapp.extras.Recetas.listas.ListasPato;
import com.example.Dietapp.extras.Recetas.listas.ListasPavo;
import com.example.Dietapp.extras.Recetas.listas.ListasPescadosMar;
import com.example.Dietapp.extras.Recetas.listas.ListasPescadosMarisco;
import com.example.Dietapp.extras.Recetas.listas.ListasPescadosOtro;
import com.example.Dietapp.extras.Recetas.listas.ListasPezRio;
import com.example.Dietapp.extras.Recetas.listas.ListasPollo;
import com.example.Dietapp.extras.Recetas.listas.ListasTernera;
import com.example.Dietapp.extras.Recetas.listas.ListasVerdura;
import com.example.Dietapp.extras.Recetas.listas.ListsCereals;
import com.example.Dietapp.extras.Recetas.listas.ListsLacteos;
import com.example.Dietapp.extras.Recetas.listas.ListsSalsas;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

public class Recetas extends AppCompatActivity {
    Spinner spi, spi3, spi4, spi5, spi6, spi7, spi8, spi9, spi10,spi11;
    TextView textovertotal;
    float caloriasListaTotal;
    EditText nombreReceta;
    String nombreRecetaT;
    Intent volverPaginaElegir;
    static double suma = 0;
    static float total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        Log.i("tag", "total2" + caloriasListaTotal);
        spi = findViewById(R.id.spinner2);
        spi3 = findViewById(R.id.spinner4);
        spi4 = findViewById(R.id.spinner5);
        spi5 = findViewById(R.id.spinner6);
        spi6 = findViewById(R.id.spinner7);
        spi7 = findViewById(R.id.spinner8);
        spi8 = findViewById(R.id.spinner9);
        spi9 = findViewById(R.id.spinner10);
        spi10 = findViewById(R.id.spinnerConservas);
        spi11 = findViewById(R.id.spinnerLegumbres);
        nombreReceta = findViewById(R.id.textoNombreReceta);

        textovertotal = findViewById(R.id.totalCalorias);
        textovertotal.setText("el total de Kcalorias de la receta hasta ahora es de: ");

        final Intent myIntent = new Intent(this, ListasPollo.class);
        final Intent myIntent2 = new Intent(this, ListasConejo.class);
        final Intent myIntent3 = new Intent(this, ListasCerdo.class);
        final Intent myIntent4 = new Intent(this, ListasPavo.class);
        final Intent myIntent5 = new Intent(this, ListasCordero.class);
        final Intent myIntent6 = new Intent(this, ListasTernera.class);
        final Intent myIntent9 = new Intent(this, ListasPato.class);

        final Intent myIntent11 = new Intent(this, ListasCorderoCaRoja.class);
        final Intent myIntent12 = new Intent(this, ListasCasqueria.class);
        final Intent myIntent13 = new Intent(this, ListasPescadosMar.class);
        final Intent myIntent14 = new Intent(this, ListasConservas.class);
        final Intent myIntent15 = new Intent(this, ListasPezRio.class);
        final Intent myIntent16 = new Intent(this, ListasPescadosOtro.class);
        final Intent myIntent17 = new Intent(this, ListasPescadosMarisco.class);
        final Intent myIntent18= new Intent(this, ListasVerdura.class);
        final Intent myIntent19= new Intent(this, ListasFruta.class);
        final Intent myIntent20= new Intent(this, ListsSalsas.class);
        final Intent myIntent21= new Intent(this, ListasOtroCarne.class);
        final Intent myIntent22= new Intent(this, ListasLegumbres.class);
        final Intent myIntent23= new Intent(this, ListsCereals.class);
        final Intent myIntent24= new Intent(this, ListsLacteos.class);
        final Intent myIntent25= new Intent(this, ListasEmbutidos.class);


        volverPaginaElegir = new Intent(this, Recetas.class);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Recetas.this);
        total = myPreferences.getFloat("caloriasLista", 0);

        String[] valores = new String[]{"selecciona verduras(nº calorias cada 100gr)", "ir a lista"};
        spi.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (position!=0)
                    startActivity(myIntent18);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

            }
        });


        String[] valores3 = new String[]{"selecciona fruta", "ir alista fruta"};

        spi3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores3));
        spi3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position!=0)
                    startActivity(myIntent19);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

            }
        });


        String[] valoresPollo = new String[]{"selecciona Carne Blanca ", "pollo", "conejo", "cerdo", "pavo", "cordero lechal"};

        spi9.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valoresPollo));
        spi9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String nombreCarneBlan = (String) adapterView.getItemAtPosition(position);
                if (nombreCarneBlan.equals("pollo"))
                    startActivity(myIntent);
                if (nombreCarneBlan.equals("conejo"))
                    startActivity(myIntent2);
                if (nombreCarneBlan.equals("cerdo"))
                    startActivity(myIntent3);
                if (nombreCarneBlan.equals("pavo"))
                    startActivity(myIntent4);
                if (nombreCarneBlan.equals("cordero lechal"))
                    startActivity(myIntent5);


                spi9.setSelection(0);//para que la volver a la pagina vuelva a mponerse la posición inicial

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

            }
        });

        String[] valores8 = new String[]{"selecciona Carne Roja ", "ternera/Vaca", "pato", "carne de cordero"};

        spi8.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores8));
        spi8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String nombreCarneRo = (String) adapterView.getItemAtPosition(position);
                if (nombreCarneRo.equals("ternera/Vaca"))
                    startActivity(myIntent6);
                if (nombreCarneRo.equals("pato"))
                    startActivity(myIntent9);
                if (nombreCarneRo.equals("carne de cordero"))
                    startActivity(myIntent11);

                spi8.setSelection(0);//para que la volver a la pagina vuelva a mponerse la posición inicial
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

            }
        });

        String[] valoresCAsqueria = new String[]{"selecciona Elemento de Casqueria", "ir a lista casqueria"};

        spi4.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valoresCAsqueria));
        spi4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String nombreCarneRo = (String) adapterView.getItemAtPosition(position);
                if (position != 0)
                    startActivity(myIntent12);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

                spi4.setSelection(0);//para que la volver a la pagina vuelva a mponerse la posición inicial
            }
        });

        String[] valores5 = new String[]{"selecciona Pescado", "pescados de mar", "pescados de rio", "marisco", "otros pescados"};

        spi5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores5));
        spi5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String nombrePescado = (String) adapterView.getItemAtPosition(position);
                if (nombrePescado.equals("pescados de mar"))
                    startActivity(myIntent13);
                if (nombrePescado.equals("pescados de rio"))
                    startActivity(myIntent15);
                if (nombrePescado.equals("otros pescados"))
                    startActivity(myIntent16);
                if (nombrePescado.equals("marisco"))
                    startActivity(myIntent17);

                spi5.setSelection(0);//para que la volver a la pagina vuelva a mponerse la posición inicial
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

            }
        });

        String[] valores6 = new String[]{"selecciona salsa", "ir a lista salsas"};

        spi6.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores6));
        spi6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (position != 0)
                    startActivity(myIntent20);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

            }
        });


        String[] valores7 = new String[]{"selecciona Otros", "otros","cereales","lacteos","embutidos"};

        spi7.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores7));
        spi7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String nombreOtros = (String) adapterView.getItemAtPosition(position);
                if (nombreOtros.equals("otros"))
                    startActivity(myIntent21);
                if (nombreOtros.equals("cereales"))
                    startActivity(myIntent23);
                if (nombreOtros.equals("lacteos"))
                    startActivity(myIntent24);
                if (nombreOtros.equals("embutidos"))
                    startActivity(myIntent25);



                spi7.setSelection(0);//para que la volver a la pagina vuelva a mponerse la posición inicial
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

            }
        });

        String[] valoresConservas = new String[]{"selecciona Conservas", "ir a lista conservas"};

        spi10.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valoresConservas));
        spi10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (position != 0)
                    startActivity(myIntent14);

                spi10.setSelection(0);//para que la volver a la pagina vuelva a mponerse la posición inicial
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

            }
        });

        String[] valoresLegumbres = new String[]{"selecciona Legumbres", "ir a lista legumbres"};

        spi11.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valoresConservas));
        spi11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (position != 0)
                    startActivity(myIntent22);

                spi10.setSelection(0);//para que la volver a la pagina vuelva a mponerse la posición inicial
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opcion", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void verTotal(View view) {
        SharedPreferences myPreferencesV = PreferenceManager.getDefaultSharedPreferences(Recetas.this);
        caloriasListaTotal = myPreferencesV.getFloat("caloriasLista", 0);
        textovertotal.setText("el total de calorias de la receta hasta ahora es de: " + caloriasListaTotal);
    }

    public void crerReceta(View view) {
        try {
            nombreRecetaT = String.valueOf(nombreReceta.getText());
            if(nombreRecetaT.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Debes introducir nombre de receta", Toast.LENGTH_SHORT).show();
            }
            else{
                this.verTotal(view);
                float meter_calorias = caloriasListaTotal;
                //metemos datos en base de datos
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 12);
                SQLiteDatabase bd = admin.getWritableDatabase();
                ContentValues registro = new ContentValues();  //es una clase para guardar datos
                registro.put("nombreReceta", nombreRecetaT);
                registro.put("calorias", meter_calorias);
                bd.insert("recetas", null, registro);
                bd.close();

                Intent i = new Intent(this, Categorias.class);
                startActivity(i);
            }

        }
        catch(Exception e)

        {

        }

    }
}

