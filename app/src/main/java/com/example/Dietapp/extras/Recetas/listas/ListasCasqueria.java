package com.example.Dietapp.extras.Recetas.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplicationfinal.R;

import java.util.ArrayList;

public class ListasCasqueria extends AppCompatActivity {
ListView lista;
EditText textoEdit;
String textoEditT;
    String[] valoresCasuqe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_recetas);
        lista=findViewById(R.id.lista);
        textoEdit=findViewById(R.id.editListas);
         valoresCasuqe= new String[]{ "selecciona Elemento de Casqueria",
                "tuenano de cabra","tuetano de buey","tuetano de cerdo","tuetano de conejo","tuetano de cordero","tuetano de pato","tuetano de pavo","tuetano de pollo","tuetano de ternera","tuetano de toro"
                ,"criadillas de cabra","criadillas de buey","criadillas de cerdo","criadillas de conejo","criadillas de cordero","criadillas de pato","criadillas de pavo","criadillas de pollo","criadillas de ternera","criadillas de toro"
                ,"sesos de cabra","sesos de buey","sesos de cerdo","sesos de conejo","sesos de cordero","sesos de pato","sesos de pavo","sesos de pollo","sesos de ternera","sesos de toro"
                ,"tripas de cabra","tripas de buey","tripas de cerdo","tripas de conejo","tripas de cordero","tripas de pato","tripas de pavo","tripas de pollo","tripas de ternera","tripas de toro"
                , "pies de cabra","pies de buey","pies de cerdo","pies de conejo","pies de cordero","pies de pato","pies de pavo","pies de pollo","pies de ternera","pies de toro"
                , "mollejas de cabra","mollejas de buey","mollejas de cerdo","mollejas de conejo","mollejas de cordero","mollejas de pato","mollejas de pavo","mollejas de pollo","mollejas de ternera","mollejas de toro"
                , "cabeza de cabra","cabeza de buey","cabeza de cerdo","cabeza de conejo","cabeza de cordero","cabeza de pato","cabeza de pavo","cabeza de pollo","cabeza de ternera","cabeza de toro"
                , "corazón de cabra","corazón de buey","corazón de cerdo","corazón de conejo","corazón de cordero","corazón de pato","corazón de pavo","corazón de pollo","corazón de ternera","corazón de toro"
                , "higado de cabra","higado de buey","higado de cerdo","higado de conejo","higado de cordero","higado de pato","higado de pavo","higado de pollo","higado de ternera","higado de toro"
                , "lengua de cabra","lengua de buey","lengua de cerdo","lengua de conejo","lengua de cordero","lengua de pato","lengua de pavo","lengua de pollo","lengua de ternera","lengua de toro"
                ,"pulmones de cabra","pulmones de buey","pulmones de cerdo","pulmones de conejo","pulmones de cordero","pulmones de pato","pulmones de pavo","pulmones de pollo","pulmones de ternera","pulmones de toro"
                ,"bazo de cabra","bazo de buey","bazo de cerdo","bazo de conejo","bazo de cordero","bazo de pato","bazo de pavo","bazo de pollo","bazo de ternera","bazo de toro"
                ,"riñones de cabra","riñones de buey","riñones de cerdo","riñones de conejo","riñones de cordero","riñones de pato","riñones de pavo","riñones de pollo","riñones de ternera","riñones de toro"
        };
        ArrayAdapter<String> adaptador=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,valoresCasuqe);
        lista.setAdapter(adaptador);
    }
    public void realizarBusqueda(View view) {
        ArrayList <String> listaBusca=new ArrayList<>();
        textoEditT=String.valueOf(textoEdit.getText());
        for(int i=0;i<valoresCasuqe.length;i++)
        if(valoresCasuqe[i].contains(textoEditT))
        {
            listaBusca.add(valoresCasuqe[i]);
        }
        ArrayAdapter<String> adaptador2=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listaBusca);
        lista.setAdapter(adaptador2);
    }
}