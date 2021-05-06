package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

public class ListasCabra extends AppCompatActivity {
ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);

        String[] valoresCAbra= new String[]{ "selecciona pieza de cabra",
                "lomo de cabrito","cadera","costillar","chuletas de cabrito","pierna","paletillas","falda de cabrito","pecho"
        ,"pescuezo de cabrito"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresCAbra);
        lista.setAdapter(adaptador);
    }
}