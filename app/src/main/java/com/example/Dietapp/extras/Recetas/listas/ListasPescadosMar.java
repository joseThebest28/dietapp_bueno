package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

public class ListasPescadosMar extends AppCompatActivity {
ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        String[] valoresPescadoKM= new String[]{ "selecciona tipo de pescado de mar ",
                "atun","bacaladilla/lirio/perlita","bacalao","besugo","bonito","boqerón/anchoa","caballa/verdel","cabracho","congrio"
        ,"fletán/halibut","gallo","jurel/chicharro","lenguado","liba/eglefino/merlán","merluza","mero/cherna","palometa/japuta","pez espada/emperador"
        ,"rape","raya","salmonete","sardina","tuburón"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresPescadoKM);
        lista.setAdapter(adaptador);
    }
}