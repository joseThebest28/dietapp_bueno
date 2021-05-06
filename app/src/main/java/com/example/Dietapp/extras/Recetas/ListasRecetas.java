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

import com.example.Dietapp.extras.Recetas.Recetas;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

import java.sql.Array;
import java.util.ArrayList;

public class ListasRecetas extends AppCompatActivity {
ListView lista;
EditText hint;
    ArrayList<String> valoresRecetas=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        hint=findViewById(R.id.editListas);
        hint.setHint("Ej:Receta1");






    ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresRecetas);
        lista.setAdapter(adaptador);




    }

    @Override
    protected void onStart() {
        super.onStart();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 11);
        SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.
String sql= "select * from recetas";
        Cursor curso = bd.rawQuery(sql, null);

        curso.moveToFirst();

        while (curso.isAfterLast() == false) {

            String nombre =curso.getString(0);
            String calorias =curso.getString(1);
            Log.i("tag","nomber"+nombre); curso.moveToNext();
            valoresRecetas.add(nombre+": "+ calorias);
        }


        bd.close();
    }
}