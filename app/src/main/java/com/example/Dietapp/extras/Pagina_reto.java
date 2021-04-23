package com.example.Dietapp.extras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class Pagina_reto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle1);

        RecyclerView recycler = findViewById(R.id.reciclador);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);

        ArrayList<Ficha> listaFichas = new ArrayList();

        listaFichas.add(new Ficha(R.drawable.chocolate,"Reto Chocolate", "Estar 21 dias sin comer chocolate"));
        listaFichas.add(new Ficha(R.drawable.azucar,"Reto Azucar", "Estar 21 dias sin comer azucar"));
        listaFichas.add(new Ficha(R.drawable.cafe,"Reto Cafe", "Estar 21 dias sin tomar cafe"));
        listaFichas.add(new Ficha(R.drawable.alcohol,"Reto Acohol", "Estar 21 dias sin tomar alcohol"));
        listaFichas.add(new Ficha(R.drawable.pizza,"Reto Pizza", "Estar 21 dias sin comer pizza"));
        listaFichas.add(new Ficha(R.drawable.tabaco,"Reto Tabaco", "Estar 21 dias sin fumar tabaco"));
        listaFichas.add(new Ficha(R.drawable.carne,"Reto Carne", "Estar 21 dias sin comer carne"));
        listaFichas.add(new Ficha(R.drawable.pescado,"Reto Pescado", "Estar 21 dias sin comer pescado"));
        listaFichas.add(new Ficha(R.drawable.comida_rapida,"Reto Comida rapida", "Estar 21 dias sin comer comida rapida"));


        FichaAdapter adapter = new FichaAdapter(listaFichas);
        recycler.setAdapter(adapter);

    }
}