package com.example.Dietapp.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplicationfinal.R;

public class Explica4 extends AppCompatActivity {
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explica1);
        imagen=findViewById(R.id.imageView);
        imagen.setImageDrawable(getResources().getDrawable(R.drawable.ayuda));
    }
    public void lanzar(View view) {
        Intent i = new Intent(this, Explica5.class );
        startActivity(i);
    }}
