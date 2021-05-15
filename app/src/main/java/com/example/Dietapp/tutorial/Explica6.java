package com.example.Dietapp.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.Dietapp.login.Login;
import com.example.myapplicationfinal.R;

public class Explica6  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explica6);
    }
    public void lanzar(View view) {
        Intent i = new Intent(this, Login.class );
        startActivity(i);
        overridePendingTransition(R.anim.desplazar_derecha,R.anim.animacion_aumentar);
    }}
