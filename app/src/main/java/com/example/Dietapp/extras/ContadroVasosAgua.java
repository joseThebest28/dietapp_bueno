package com.example.Dietapp.extras;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Dietapp.Ajustes;
import com.example.Dietapp.Categorias;
import com.example.Dietapp.login.AdminSQLiteOpenHelper;
import com.example.myapplicationfinal.R;

public class ContadroVasosAgua extends AppCompatActivity {
    TextView textoMostrar, textoMostrarvasos;
    ImageView imagenmas, imagenMwnos,imagenLLegada;
    float recuento =0.0f;
    int vasos;

    String nombreUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contadro_vasos_agua);
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ContadroVasosAgua.this);
        String agua = myPreferences.getString("agua", "");

        imagenLLegada = findViewById(R.id.imageView32);
        imagenLLegada.setVisibility(View.INVISIBLE);

        final Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacionagua);

        textoMostrar = findViewById(R.id.textView41);


        textoMostrarvasos = findViewById(R.id.textView50);

        SharedPreferences myPreferencesV = PreferenceManager.getDefaultSharedPreferences(ContadroVasosAgua.this);
        int vasosGuardados=myPreferencesV.getInt("valoragua",0);
        float recuentoM=myPreferencesV.getFloat("valoragua2",0);

        if(vasosGuardados!=0){
            vasos=vasosGuardados;
            recuento=recuentoM;}
        else {
            vasos=0;
        }


        Log.i("valor", String.valueOf(recuento));


        textoMostrarvasos.setText("Total de vasos= " + vasos);

        textoMostrar.setText("Total de agua= " + recuento+ "" + "litros");


        imagenmas = findViewById(R.id.imageView30);
        imagenmas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                    recuento = (float) (recuento + 0.25);
                    vasos = vasos + 1;
                    textoMostrar.setText("Total de agua= " + recuento + "" + "litros");
                    textoMostrarvasos.setText("Total de vasos= " + vasos);


                if (vasos == 8) {
                    SharedPreferences myPreferencesVG = PreferenceManager.getDefaultSharedPreferences(ContadroVasosAgua.this);
                    SharedPreferences.Editor myEditorVG = myPreferencesVG.edit();
                    myEditorVG.putString("agua","se ha completado el reto de agua");


                    myEditorVG.apply();


                    retocompletado();
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

                if (recuento <= 0 && vasos<=0) {
                    Toast.makeText(getApplicationContext(), "no puedes haber tomado menos de 0 vasos de agua", Toast.LENGTH_SHORT).show();
                } else {


                            recuento = (float) (recuento - 0.25);
                            vasos = vasos - 1;
                            textoMostrar.setText("Total de agua= " + recuento + "" + "litros");
                            textoMostrarvasos.setText("Total de vasos= " + vasos);


                    }}



        });
    }

    private void retocompletado() {
        SharedPreferences myPreferencesPA = PreferenceManager.getDefaultSharedPreferences(ContadroVasosAgua.this);
        String nombreUser = myPreferencesPA.getString("nombreUser", "");

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro_user", null, 12);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String sql = "UPDATE usuarios SET retoagua='Se ha completado el objetivo de hoy de  agua' where login='"+nombreUser+"'";
bd.execSQL(sql);
bd.close();
        Log.i("tag", "user"+nombreUser);
    }


    public void volverAjuest(View view) {

        Intent ifds = new Intent(this, Ajustes.class);
        startActivity(ifds);
        SharedPreferences myPreferencesVG = PreferenceManager.getDefaultSharedPreferences(ContadroVasosAgua.this);
        SharedPreferences.Editor myEditorVG = myPreferencesVG.edit();
        myEditorVG.putInt("valoragua",vasos);
        myEditorVG.putFloat("valoragua2", recuento); SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(ContadroVasosAgua.this);




        myEditorVG.apply();
    }

    public void volverMenu(View view) {
        Intent ifds = new Intent(this, Categorias.class);
        startActivity(ifds);
        SharedPreferences myPreferencesVG = PreferenceManager.getDefaultSharedPreferences(ContadroVasosAgua.this);
        SharedPreferences.Editor myEditorVG = myPreferencesVG.edit();
        myEditorVG.putInt("valoragua",vasos);
        myEditorVG.putFloat("valoragua2",recuento);
        myEditorVG.apply();
    }



}
