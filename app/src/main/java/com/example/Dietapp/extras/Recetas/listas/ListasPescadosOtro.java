package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

public class ListasPescadosOtro extends AppCompatActivity {
ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresPescadoOt= new String[]{ "selecciona tipo de pescado ",
                "dorada,zapatilla","lubina/ródalo","rodavallo","salmón","trucha"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPescadoOt);
        lista.setAdapter(adaptador);
    }
}