package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class ListasConejo extends AppCompatActivity {
ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);

        ArrayList<String> listaConejo=new ArrayList<>();
        listaConejo.add("selecciona pieza de conejo ");
        listaConejo.add("paletilla de conejo ");
        listaConejo.add("lomo de conejo ");
        listaConejo.add("filetes de lomo de conejo ");
        listaConejo.add("costillar de conejo ");
        listaConejo.add("cabeza de conejo ");

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaConejo);
        lista.setAdapter(adaptador);
    }
}