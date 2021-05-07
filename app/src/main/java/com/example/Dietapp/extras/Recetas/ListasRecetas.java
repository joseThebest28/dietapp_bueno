package com.example.Dietapp.extras.Recetas;


import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.Dietapp.PaginaPrincipal;
import com.example.Dietapp.Seguimiento;
import com.example.Dietapp.categorias.Carne;
import com.example.Dietapp.extras.Recetas.Recetas;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.sql.Array;
import java.util.ArrayList;

public class ListasRecetas extends AppCompatActivity {
    ListView lista;
    EditText hint;
  float amount=0;
    ArrayList<String> valoresRecetas = new ArrayList<>();
    ArrayList<String> valoresRecetas2 = new ArrayList<>();
    String calorias;
    String nombre;
    AdminSQLiteOpenHelper admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista = findViewById(R.id.lista);
        hint = findViewById(R.id.editListas);
        hint.setHint("Ej:Receta1");


        final Intent i = new Intent(this, PaginaPrincipal.class);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,valoresRecetas);
        lista.setAdapter(adaptador);

         admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 11);


       final Intent intent = new Intent(this, Seguimiento.class);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombreV = (String) lista.getItemAtPosition(position);
                String[] parts = nombreV.split(":");
                String part2 = parts[1]; // me quedo con el numeor apra guardarlo y sumarlo al total
                String numero=String.valueOf(part2);


                amount=Float.parseFloat(numero);
                Log.i("tag","numeroBien"+amount);


                intent.putExtra("calorias listaReceta", amount);

                startActivity(intent);
                Toast toastNada3 = Toast.makeText(getApplicationContext(), "Se han guardado los datos de carne correctamente", Toast.LENGTH_SHORT);

                toastNada3.show();
                SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ListasRecetas.this);
                SharedPreferences.Editor myEditor = myPreferences.edit();
                myEditor.putFloat("receta", amount);
                myEditor.commit();

        }});


    }

    @Override
    protected void onStart() {
        super.onStart();
        AdminSQLiteOpenHelper admin2 = new AdminSQLiteOpenHelper(this, "registro_user", null, 11);
        SQLiteDatabase bd = admin2.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.
        String sql = "select * from recetas";
        Cursor curso = bd.rawQuery(sql, null);

        curso.moveToFirst();

        while (curso.isAfterLast() == false) {

             nombre = curso.getString(0);
             calorias = curso.getString(1);

            curso.moveToNext();
            valoresRecetas.add(nombre + ": " + calorias);
        }


        bd.close();
    }
}