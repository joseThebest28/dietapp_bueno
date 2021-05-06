package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

public class ListasCerdo extends AppCompatActivity {
ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresCerdo= new String[]{ "selecciona pieza de carne de cerdo","solomillo","cinta de lomo",
                "chuletas de lomo(de palo) y de riñon","cadera/babilla","paletilla",
                "aguja","costillas","codillo","magro","panceta","tocino","papada","patas","manos","oreja","morro"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresCerdo);
        lista.setAdapter(adaptador);
    }
}