package com.example.Dietapp.extras;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.Ajustes;
import com.example.Dietapp.PaginaPrincipal;
import com.example.Dietapp.login.Login;
import com.example.myapplicationfinal.R;

import static com.example.myapplicationfinal.R.drawable.cargando;

public class ContadroVasosAgua extends AppCompatActivity {
    TextView textoMostrar, textoMostrarvasos;
    ImageView imagenmas, imagenMwnos,imagenLLegada;
    int recuento = 0;
    int vasos = 0;
    double recuentoLitors = 0.75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contadro_vasos_agua);
        imagenLLegada = findViewById(R.id.imageView32);
        imagenLLegada.setVisibility(View.INVISIBLE);
        final Animation animacion = AnimationUtils.loadAnimation(this,R.anim.animacionagua);

        textoMostrar = findViewById(R.id.textView41);
        textoMostrar.setText("Total de agua= " + 0 + "" + "mililitros");

        textoMostrarvasos = findViewById(R.id.textView50);
        textoMostrarvasos.setText("Total de vasos= " + 0);

        imagenmas = findViewById(R.id.imageView30);
        imagenmas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (recuento >= 750) {
                    recuento = recuento + 250;
                    recuentoLitors = recuentoLitors + 0.25;
                    vasos = vasos + 1;
                    textoMostrar.setText("Total de agua= " + recuentoLitors + "" + "litros");
                    textoMostrarvasos.setText("Total de vasos= " + vasos);
                } else {
                    recuento = recuento + 250;
                    vasos = vasos + 1;
                    textoMostrar.setText("Total de agua= " + recuento + "" + "mililitros");
                    textoMostrarvasos.setText("Total de vasos= " + vasos);
                }
                if(vasos==8)
                {
                    SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ContadroVasosAgua.this);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putString("agua", "Se ha completado el objetivo de hoy de  agua");
                    myEditor.commit();

                    imagenLLegada.setVisibility(View.VISIBLE);
                    imagenLLegada.startAnimation(animacion);
                    imagenLLegada.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            imagenLLegada.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        });
        imagenMwnos = findViewById(R.id.imageView31);
        imagenMwnos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (recuento <= 0) {
                    Toast.makeText(getApplicationContext(), "no puedes haber tomado menos de 0 vasos de agua", Toast.LENGTH_SHORT).show();
                } else {

                    if (recuento >= 1000) {
                        recuento = recuento - 250;
                        recuentoLitors = recuentoLitors - 0.25;
                        vasos = vasos - 1;
                        textoMostrar.setText("Total de agua= " + recuentoLitors + "" + "litros");
                        textoMostrarvasos.setText("Total de vasos= " + vasos);
                    }
                    else  if (recuento <=750){
                        recuento = recuento - 250;
                        vasos = vasos - 1;
                        textoMostrar.setText("Total de agua= " + recuento + "" + "mililitros");
                        textoMostrarvasos.setText("Total de vasos= " + vasos);
                    }


                }

            }
        });
    }

    public void volverAjuest(View view) {
        Intent ifds = new Intent(this, Ajustes.class);
        startActivity(ifds);
    }

    public void volverMenu(View view) {
        Intent ifds = new Intent(this, PaginaPrincipal.class);
        startActivity(ifds);
    }
}