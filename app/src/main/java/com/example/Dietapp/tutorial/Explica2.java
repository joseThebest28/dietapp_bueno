package com.example.Dietapp.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplicationfinal.R;

public class Explica2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explica2);
    }
    public void lanza(View view) {
        Intent lanzar = new Intent(this, Explica3.class );
        startActivity(lanzar);
    }
}
