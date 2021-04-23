package com.example.Dietapp.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplicationfinal.R;

public class Explica1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explica1);
    }
    public void lanzar(View view) {
        Intent i = new Intent(this, Explica2.class );
        startActivity(i);
    }


}
