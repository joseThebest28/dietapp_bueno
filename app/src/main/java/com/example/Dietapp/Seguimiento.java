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
    private TextView total;
    private double suma;
    static double recuperamosCar;
    static double recuperamosFruta;
   static  double recuperamosPez;
    static double recuperamosDepor;
   static  double recuperamosPasta;
    static double recuperamosSalsa;
    static double recuperamosVerdur;
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
            recuperamosCar = datos.getInt("calorias carne");
            texC = findViewById(R.id.textCarne);
            texC.setText("calorias carne" + recuperamosCar);


            Bundle datosP = this.getIntent().getExtras();
            recuperamosPez = datosP.getDouble("calorias pescado");
            texP = findViewById(R.id.textPez);
            texP.setText("calorias pescado" + recuperamosPez);


            Bundle datosD = this.getIntent().getExtras();
            recuperamosDepor = datosD.getDouble("calorias deporte");
            texD = findViewById(R.id.textD);
            texD.setText(" deporte" + recuperamosDepor);

            Bundle Frutas = this.getIntent().getExtras();
            recuperamosFruta = Frutas.getDouble("calorias fruta");
            texFru = findViewById(R.id.textFr);
            texFru.setText(" fruta:" + recuperamosFruta);


            Bundle Pastas = this.getIntent().getExtras();
            recuperamosPasta = Pastas.getDouble("pasta");
            aPasta = findViewById(R.id.textoparapastas);
            aPasta.setText(" pasta:" + recuperamosPasta);




            Bundle Salsas = this.getIntent().getExtras();
            recuperamosSalsa = Salsas.getDouble("salsa");
            salsa = findViewById(R.id.recibirSalsa);
            salsa.setText(" salsa:" + recuperamosSalsa);


            Bundle Erdura = this.getIntent().getExtras();
            recuperamosVerdur = Erdura.getDouble("erdura");
            erdura = findViewById(R.id.textVerdura);
            erdura.setText(" verdura:" + recuperamosVerdur);

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

        double carne = myPreferences.getInt("carne", 0);
        double fruta = myPreferences.getInt("fru", 0);
        double deporte = myPreferences.getInt("depor", 0);
        double pasta = myPreferences.getInt("pasta", 0);
        double pescado = myPreferences.getInt("pescado", 0);
        double salsa = myPreferences.getInt("salsa", 0);
        double verdura = myPreferences.getInt("erdura", 0);
        suma=carne-deporte+fruta+pasta+pescado+salsa+verdura;
        total = findViewById(R.id.totalcaloriasHoy);

        String texto1 = "Hoy has obtenido Kcalorias.";
        String texto2 = " Felicidades, vas por buen camino";
        total.setText(texto1 +suma+ texto2);
        texcv.setText(strDate);



    }

    public void enviarDatosCalendario(View view) {
        Intent i = new Intent(this, Micalendarrrrio.class );

        SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(Seguimiento.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("totalacalendario", (int) suma);
        myEditor.commit();
        startActivity(i);

    }



}
