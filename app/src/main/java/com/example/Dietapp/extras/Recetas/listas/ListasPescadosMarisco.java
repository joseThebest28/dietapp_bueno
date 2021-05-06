package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

public class ListasPescadosMarisco extends AppCompatActivity {
ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresPescadoMarisco= new String[]{ "selecciona tipo de marisco",
                "bogavante","cigalas","gambas","langosta","langostino","cangrejo de mar","buey de mar"," centollo","nécora","percebe",
        "almeja fina/chirla","berberecho","coquina","mejillón","navaja","ostra","vieira","lapa","bígaro","cañailla","busano",
        "calamar","pota","pulpo","sepia"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPescadoMarisco);
        lista.setAdapter(adaptador);
    }
}