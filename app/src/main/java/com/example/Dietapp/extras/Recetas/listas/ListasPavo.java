package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

public class ListasPavo extends AppCompatActivity {
ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresPavo= new String[]{ "selecciona pieza de pavo ",
                "pechuga de pavo","lomo de pavo","muslitos de pavo","pierna de pavo","cuartos traseros de pavo","alitas de pavo","jamon de pavo","roule","salchichas de pavo"
        ,"hamburguesas de pavo","fiambre de pavo"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPavo);
        lista.setAdapter(adaptador);
    }
}