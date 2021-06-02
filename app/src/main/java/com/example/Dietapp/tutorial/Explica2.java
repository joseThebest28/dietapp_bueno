package com.example.Dietapp.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplicationfinal.R;

public class Explica2 extends AppCompatActivity {
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explica1);
        imagen = findViewById(R.id.imageView);
        imagen.setImageDrawable(getResources().getDrawable(R.drawable.f));
    }

    public void lanzar(View view) {
        Intent lanzar = new Intent(this, Explica3.class);
        startActivity(lanzar);

    }
}
