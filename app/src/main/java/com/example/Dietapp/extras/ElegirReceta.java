package com.example.Dietapp.extras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.Dietapp.extras.Recetas.Recetas;
import com.example.Dietapp.extras.Recetas.ListasRecetas;
import com.example.myapplicationfinal.R;

public class ElegirReceta extends AppCompatActivity {
Button boton1,boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_rutina);
        boton1=findViewById(R.id.button33);
        boton1.setText("crear receta");
        boton2=findViewById(R.id.button35);
        boton2.setText("ver receta");
    }
    public void rutina1(View view)
    {
        Intent i = new Intent(this, Recetas.class );
        startActivity(i);
    }
    public void rutina2(View view)
    {
        Intent i = new Intent(this, ListasRecetas.class );
        startActivity(i);
    }
}
