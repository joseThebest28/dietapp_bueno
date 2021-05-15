package com.example.Dietapp.categorias.popup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.example.myapplicationfinal.R;

public class PopupSalsas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupsalsas);
        DisplayMetrics medidas=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);


        int ancho= medidas.widthPixels;
        int alto=medidas.heightPixels;

        getWindow().setLayout((int) (ancho), (int) (alto*0.4));


    }
}
