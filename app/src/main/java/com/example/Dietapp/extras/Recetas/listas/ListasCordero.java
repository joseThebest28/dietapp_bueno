package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

public class ListasCordero extends AppCompatActivity {
ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresCordero= new String[]{ "selecciona pieza de cordero lechal ",
                "paletilla de cordero","medallones de lechal","filete de pierna","tournedó","pincho moruno",
                "brocheta","hamburguesa","churrasquitos","churrasco","filete de carrillón"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresCordero);
        lista.setAdapter(adaptador);
    }
}