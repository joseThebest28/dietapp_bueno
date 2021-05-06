package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

public class ListasPato extends AppCompatActivity {
ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);

        String[] valoresPa= new String[]{ "selecciona pieza de pato",
                "pechuga de pato","piernas de pato","chuletas de pato","aiguilletes de pato","cuello de pato",
                "piel de pato","piernas de pato","abrigo de apto","manchones de pato","cuerpo de pato deshuesado"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPa);
        lista.setAdapter(adaptador);
    }
}