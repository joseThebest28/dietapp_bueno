package com.example.Dietapp.categorias.popup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.example.myapplicationfinal.R;

public class PopupPescado extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popuppescado);
        DisplayMetrics medidas=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidas);

        int ancho= medidas.widthPixels;
        int alto=medidas.heightPixels;

        getWindow().setLayout((int) (ancho*0.9), (int) (alto*0.4));


    }
}
