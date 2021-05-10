package com.example.Dietapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.Dietapp.categorias.Categorias;
import com.example.myapplicationfinal.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Seguimiento extends AppCompatActivity {
    private TextView texC;
    private TextView texP;
    private TextView texD;
    private TextView texFru;
    private TextView aPasta;
    private TextView salsa;
    private TextView erdura;
    private TextView lista;
    private TextView total;
    private float suma;
    static float recuperamosCar;
    static float recuperamosFruta;
   static  float recuperamosPez;
    static float recuperamosDepor;
   static  float recuperamosPasta;
    static float recuperamosSalsa;
    static float recuperamosVerdur;
    static float recuperarLista;
    TextView texcv;
    String strDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seguimiento);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       strDate = sdf.format(c.getTime());
        texcv=findViewById(R.id.textView20);

        texcv.setText(strDate);
        try {
            Bundle datos = this.getIntent().getExtras();
            recuperamosCar = datos.getFloat("calorias carne");
            texC = findViewById(R.id.textCarne);
            texC.setText("calorias carne" + recuperamosCar);


            Bundle datosP = this.getIntent().getExtras();
            recuperamosPez = datosP.getFloat("calorias pescado");
            texP = findViewById(R.id.textPez);
            texP.setText("calorias pescado" + recuperamosPez);


            Bundle datosD = this.getIntent().getExtras();
            recuperamosDepor = datosD.getFloat("calorias deporte");
            texD = findViewById(R.id.textD);
            texD.setText(" deporte" + recuperamosDepor);

            Bundle Frutas = this.getIntent().getExtras();
            recuperamosFruta = Frutas.getFloat("calorias fruta");
            texFru = findViewById(R.id.textFr);
            texFru.setText(" fruta:" + recuperamosFruta);


            Bundle Pastas = this.getIntent().getExtras();
            recuperamosPasta = Pastas.getFloat("pasta");
            aPasta = findViewById(R.id.textoparapastas);
            aPasta.setText(" pasta:" + recuperamosPasta);




            Bundle Salsas = this.getIntent().getExtras();
            recuperamosSalsa = Salsas.getFloat("salsa");
            salsa = findViewById(R.id.recibirSalsa);
            salsa.setText(" salsa:" + recuperamosSalsa);


            Bundle Erdura = this.getIntent().getExtras();
            recuperamosVerdur = Erdura.getFloat("erdura");
            erdura = findViewById(R.id.textVerdura);
            erdura.setText(" verdura:" + recuperamosVerdur);

            Bundle Lista = this.getIntent().getExtras();
            recuperarLista = Lista.getFloat("calorias listaReceta");
            lista = findViewById(R.id.recibirlistaReceta);
            lista.setText(" recetas:" + recuperarLista);

            //guaradr datos y mostrar el total





        }catch(Exception e){e.getMessage();}

    }
    public void volverMenu(View view) {
        Intent i2 = new Intent(this,PaginaPrincipal.class );
        startActivity(i2);
    }

    public void volverCategorias(View view) {
        Intent i = new Intent(this, Categorias.class );
        startActivity(i);
    }


    public void recuperar(View view) {
        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Seguimiento.this);

        float carne = myPreferences.getFloat("carne", 0);
        float fruta = myPreferences.getFloat("fru", 0);
     float deporte = myPreferences.getFloat("depor", 0);
        float pasta = myPreferences.getFloat("pasta", 0);
        float pescado = myPreferences.getFloat("pescado", 0);
        float salsa = myPreferences.getFloat("salsa", 0);
        float verdura = myPreferences.getFloat("erdura", 0);
        float receta = myPreferences.getFloat("receta", 0);
        if(deporte!=0)//si deporte es 0 sale un erro, por ello si es ceroq ue no reste nada
        {
            suma=carne+fruta+pasta+pescado+salsa+verdura+receta-deporte;
        }
        else{
            suma=carne+fruta+pasta+pescado+salsa+verdura+receta;
        }


        total = findViewById(R.id.totalcaloriasHoy);

        String texto1 = "Hoy has obtenido Kcalorias.";
        String texto2 = " Felicidades, vas por buen camino";
        if(suma>0)
        {total.setText(texto1 +suma+ texto2);
       } if(suma<=0){//en caso de salgan por alguna razón datos negativos, que al usuario no le aparezcan datos negativos, le salga 0
            total.setText(texto1 +0.0);
        }

        texcv.setText(strDate);

    }

    public void enviarDatosCalendario(View view) {
        Intent i = new Intent(this, Micalendarrrrio.class );

        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Seguimiento.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putFloat("totalacalendario", suma);
        myEditor.commit();
        startActivity(i);

    }



}
